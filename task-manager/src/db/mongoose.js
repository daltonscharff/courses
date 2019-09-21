const mongoose = require('mongoose');
const validator = require('validator');
const config = require('../../config');

const databaseName = 'task-manager-api';
const connectionURL = `mongodb+srv://${config.mongodb.username}:${config.mongodb.password}@cluster0-qpyfg.mongodb.net/${databaseName}?retryWrites=true&w=majority`;

mongoose.connect(connectionURL, {
    useNewUrlParser: true,
    useCreateIndex: true
});

const User = mongoose.model('User', {
    name: {
        type: String,
        required: true,
        trim: true
    },
    email: {
        type: String,
        required: true,
        trim: true,
        lowercase: true,
        validate(value) {
            if (!validator.isEmail(value)) {
                throw new Error('Email is invalid');
            }
        }
    },
    password: {
        type: String,
        required: true,
        minlength: 7,
        trim: true,
        validate(value) {
            if (value.toLowerCase().includes('password')) {
                throw new Error('Password cannot contain "password"')
            }
        }
    },
    age: {
        type: Number,
        default: 0,
        validate(value) {
            if (value < 0) {
                throw new Error('Age must be a positive number');
            }
        }
    }
});

const me = new User({
    name: '   Dalton    ',
    email: 'dalton.SCHARFF@gmail.com',
    password: '       phone098     '
});

// me.save().then(() => {
//     console.log(me);
// }).catch((error) => {
//     console.log('error:', error);
// });

const Task = mongoose.model('Task', {
    description: {
        type: String,
        required: true,
        trim: true
    },
    completed: {
        type: Boolean,
        default: false
    }
})

const task = new Task({
    description: ' Eat lunch   '
});

task.save().then((result) => {
    console.log(result);
}).catch((error) => {
    console.log(error);
})



