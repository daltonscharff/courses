const name = 'Andrew';
const userAge = 27

const user = {
    name,
    age: userAge,
    location: 'Philadelphia'
};

console.log(user);

const product = {
    label: 'Red notebook',
    price: 3,
    stock: 201,
    salePrice: undefined
};

const { label:productLabel, price, stock, rating=5 } = product;
console.log(productLabel, price, stock, rating);


const transaction = (type, { label, stock }) => {
    console.log(type, label, stock);
};

transaction('order', product);