const chalk = require('chalk');
const fs = require('fs');

const addNote = (title, body) => {
    const notes = loadNotes();
    const duplicateNote = notes.find((note) => note.title === title);

    if (!duplicateNote) {
        notes.push({
            title,
            body
        });
        saveNotes(notes);
        console.log(chalk.green.inverse('New note added!'));
    } else {
        console.log(chalk.red.inverse('Note title taken!'));
    }

};

const saveNotes = (array) => {
    const dataJSON = JSON.stringify(array);
    fs.writeFileSync('notes.json', dataJSON);
};

const loadNotes = () => {
    try {
        const dataBuffer = fs.readFileSync('notes.json');
        const dataJSON = dataBuffer.toString();
        return JSON.parse(dataJSON);
    } catch (e) {
        return [];
    }
};

const removeNote = (title) => {
    const notes = loadNotes();
    const notesToKeep = notes.filter((note) => title !== note.title);
    
    if (notesToKeep.length < notes.length) {
        saveNotes(notesToKeep);
        console.log(chalk.green.inverse('Note removed!'));
    } else {
        console.log(chalk.red.inverse('No note found!'));
    }
};

const listNotes = () => {
    const notes = loadNotes();
    console.log(chalk.blue('Your notes:'));
    notes.forEach((note) => console.log(note.title));
};

const readNote = (title) => {
    const notes = loadNotes();
    const note = notes.find((note) => title === note.title);

    if (note) {
        console.log(chalk.inverse(note.title));
        console.log(note.body);
    } else {
        console.log(chalk.red(`No note with title '${title}' found!`));
    }
}

module.exports = {
    addNote,
    removeNote,
    listNotes,
    readNote
};