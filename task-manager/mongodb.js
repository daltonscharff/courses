const config = require('./config');
const { MongoClient, ObjectID } = require('mongodb');

const connectionURL = `mongodb+srv://${config.mongodb.username}:${config.mongodb.password}@cluster0-qpyfg.mongodb.net/test?retryWrites=true&w=majority`;
const databaseName = 'task-manager';

MongoClient.connect(connectionURL, { useNewUrlParser: true }, (error, client) => {
    if (error) return console.log('Unable to connect to database');

    const db = client.db(databaseName);

    db.collection('tasks').deleteOne({
        description: 'Clean the house'
    }).then((result) => {
        console.log(result);
    }).catch((error) => {
        console.log(error);
    })
});