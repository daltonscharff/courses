const express = require('express');
require('./db/mongoose');
const Task = require('./models/task');
const User = require('./models/user');

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());

app.post('/users', (req, res) => {
    const user = new User(req.body);
    user.save().then(() => {
        res.status(201).send(user);
    }).catch((error) => {
        res.status(400).send(error);
    });
});

app.get('/users', (req, res) => {
    User.find({}).then((users) => {
        res.send(users)
    }).catch((error) => {
        res.status(500).send(error);
    });
});

app.get('/users/:id', (req, res) => {
    User.findById(req.params.id).then((users) => {
        if (!users) return res.status(404).send();
        res.send(users)
    }).catch((error) => {
        res.status(500).send(error);
    });
});

app.post('/tasks', (req, res) => {
    const task = new Task(req.body);
    task.save().then(() => {
        res.status(201).send(task);
    }).catch((error) => {
        res.status(400).send(error);
    });
});

app.get('/tasks', (req, res) => {
    Task.find({}).then((tasks) => {
        res.send(tasks)
    }).catch((error) => {
        res.status(500).send(error);
    })
});

app.get('/tasks/:id', (req, res) => {
    Task.findById(req.params.id).then((tasks) => {
        if (!tasks) return res.status(404).send();
        res.send(tasks)
    }).catch((error) => {
        res.status(500).send(error);
    });
});

app.listen(port, () => {
    console.log(`Server is listening on port ${port}`);
});