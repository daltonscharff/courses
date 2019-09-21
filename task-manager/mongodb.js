const config = require('./config');
const { MongoClient, ObjectID } = require('mongodb');

const connectionURL = `mongodb+srv://${config.mongodb.username}:${config.mongodb.password}@cluster0-qpyfg.mongodb.net/test?retryWrites=true&w=majority`;
const databaseName = 'task-manager';

MongoClient.connect(connectionURL, { useNewUrlParser: true }, (error, client) => {
    if (error) return console.log('Unable to connect to database');

    const db = client.db(databaseName);

    // db.collection('users').findOne({
    //     _id: new ObjectID('5d857770776d632fe87f0458')
    // },(error, user) => {
    //     if (error) return console.log('Unable to fetch');

    //     console.log(user);
    // });

    // db.collection('users').find({ name: "Dalton" }).toArray((error, users) => {
    //     console.log(users);
    // });

    db.collection('tasks').findOne({
        _id: new ObjectID('5d85780441d11b196c712f7d')
    }, (error, task) => {
        console.log(task);
    });

    db.collection('tasks').find({ completed: false }).toArray((error, tasks) => {
        console.log(tasks);
    })
});