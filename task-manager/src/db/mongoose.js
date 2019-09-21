const mongoose = require('mongoose');
const config = require('../../config');

const databaseName = 'task-manager-api';
const connectionURL = `mongodb+srv://${config.mongodb.username}:${config.mongodb.password}@cluster0-qpyfg.mongodb.net/${databaseName}?retryWrites=true&w=majority`;

mongoose.connect(connectionURL, {
    useNewUrlParser: true,
    useCreateIndex: true
});

const User = mongoose.model('User', {
    name: {
        type: String
    },
    age: {
        type: Number
    }
});

const Task = mongoose.model('Task', {
    description: {
        type: String
    },
    completed: {
        type: Boolean
    }
})

const task = new Task({
    description: 'Learn the Mongoose library',
    completed: false
});

task.save().then((result) => {
    console.log(result);
}).catch((error) => {
    console.log(error);
})

// const me = new User({
//     name: 'Dalton',
//     age: 23
// });

// me.save().then(() => {
//     console.log(me);
// }).catch((error) => {
//     console.log('error:', error);
// });


