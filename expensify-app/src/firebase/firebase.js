import * as firebase from 'firebase';

const firebaseConfig = {
    apiKey: "AIzaSyDjkeNt7ZHBtGXGBsIQUhSNSjt0BHRd10s",
    authDomain: "expensify-9876.firebaseapp.com",
    databaseURL: "https://expensify-9876.firebaseio.com",
    projectId: "expensify-9876",
    storageBucket: "expensify-9876.appspot.com",
    messagingSenderId: "834818710542",
    appId: "1:834818710542:web:c36ba577cc0bc2be6ef05f"
};

firebase.initializeApp(firebaseConfig);

const database = firebase.database();

const onValueChange = database.ref().on('value', (snapshot) => {
    const val = snapshot.val();
    console.log(`${val.name} is a ${val.job.title} at ${val.job.company}`);
});

// const onValueChange = database.ref().on('value', (snapshot) => {
//     console.log(snapshot.val());
// });

setTimeout(() => {
    database.ref('age').set(23);
}, 3500);

setTimeout(() => {
    database.ref('job/company').set('Steam');
}, 7000);



// database.ref('location/city').once('value').then((snapshot) => {
//     const val = snapshot.val();
//     console.log(val);
// }).catch((e) => {
//     console.log('Error fetching data', e);
// });

// database.ref().set({
//     name: 'Dalton Scharff',
//     age: 23,
//     stressLevel: 5,
//     job: {
//         title: 'Software Developer',
//         company: 'AT&T'
//     },
//     location: {
//         city: 'Dallas',
//         country: 'United States'
//     }
// }).then(() => {
//     console.log('Data is saved.');
// }).catch((error) => {
//     console.log("This failed.", error);
// });

// database.ref().update({
//     'stressLevel': 9,
//     'job/company': 'Amazon',
//     'location/city': 'Seattle'
// });

// database.ref('isAlive').remove().then(() => {
//     console.log('Data was removed');
// }).catch((error) => {
//     console.log('Data was not removed', error);
// });
