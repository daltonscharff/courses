const mongoose = require('mongoose');
const config = require('../../config');

const databaseName = 'task-manager-api';
const connectionURL = `mongodb+srv://${config.mongodb.username}:${config.mongodb.password}@cluster0-qpyfg.mongodb.net/${databaseName}?retryWrites=true&w=majority`;

mongoose.connect(connectionURL, {
    useNewUrlParser: true,
    useCreateIndex: true
});