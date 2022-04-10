import { GraphQLServer } from "graphql-yoga";

const users = [
  {
    id: 1,
    name: "Dalton",
    email: "dalton@example.com",
    age: 25,
  },
  {
    id: 2,
    name: "Sarah",
    email: "sarah@example.com",
  },
  {
    id: 3,
    name: "Mike",
    email: "mike@example.com",
  },
];

const posts = [
  {
    id: 10,
    title: "GraphQL 101",
    body: "This is how to use GraphQL...",
    published: true,
    author: 1,
  },
  {
    id: 11,
    title: "GraphQL 201",
    body: "This is advanced GraphQL post...",
    published: false,
    author: 1,
  },
  {
    id: 12,
    title: "Programming music",
    body: "",
    published: false,
    author: 2,
  },
];

const comments = [
  { id: 20, text: "This is comment 20", author: 1, post: 10 },
  { id: 21, text: "This is comment 21", author: 2, post: 11 },
  { id: 22, text: "This is comment 22", author: 3, post: 12 },
  { id: 23, text: "This is comment 23", author: 2, post: 11 },
];

// Type definitions
const typeDefs = `
  type Query {
    users(query: String): [User!]!
    posts(search: String): [Post!]!
    comments: [Comment!]!
    me: User!
  }

  type User {
    id: ID!
    name: String!
    email: String!
    age: Int
    posts: [Post!]!
    comments: [Comment!]!
  }

  type Post {
    id: ID!
    title: String!
    body: String!
    published: Boolean!
    author: User!
    comments: [Comment!]!
  }

  type Comment {
    id: ID!
    text: String!
    author: User!
    post: Post!
  }
`;

// Resolvers
const resolvers = {
  Query: {
    users(parent, { query }, ctx, info) {
      if (!query) return users;
      return users.filter((user) =>
        user.name.toLowerCase().includes(query.toLowerCase())
      );
    },
    me() {
      return {
        id: "123098",
        name: "Dalton",
        email: "dalton@example.com",
        age: 25,
      };
    },
    posts(parent, { search }, ctx, info) {
      if (!search) return posts;
      return posts.filter(
        (post) =>
          post.title.toLowerCase().includes(search.toLowerCase) ||
          post.body.toLowerCase().includes(search.toLowerCase())
      );
    },
    comments(parent, args, ctx, info) {
      return comments;
    },
  },
  Post: {
    author({ author }, args, ctx, info) {
      return users.find((user) => user.id === author);
    },
    comments({ id }, args, ctx, info) {
      return comments.filter((comment) => comment.post === id);
    },
  },
  User: {
    posts({ id }, args, ctx, info) {
      return posts.filter((post) => post.author === id);
    },
    comments({ id }, args, ctx, info) {
      return comments.filter((comment) => comment.author === id);
    },
  },
  Comment: {
    author({ author }, args, ctx, info) {
      return users.find((user) => user.id === author);
    },
    post(parent, args, ctx, info) {
      return posts.find((post) => post.id === parent.post);
    },
  },
};

const server = new GraphQLServer({
  typeDefs,
  resolvers,
});

server.start(() => {
  console.log("Server is running on http://localhost:4000");
});
