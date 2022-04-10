import * as firebase from 'firebase';

const firebaseConfig = {
    apiKey: process.env.FIREBASE_API_KEY,
    authDomain: process.env.FIREBASE_AUTH_DOMAIN,
    databaseURL: process.env.FIREBASE_DATABASE_URL,
    projectId: process.env.FIREBASE_PROJECT_ID,
    storageBucket: process.env.FIREBASE_STORAGE_BUCKET,
    messagingSenderId: process.env.FIREBASE_MESSAGING_SENDER_ID,
    appId: process.env.FIREBASE_APP_ID
};

firebase.initializeApp(firebaseConfig);

const database = firebase.database();
const googleAuthProvider = new firebase.auth.GoogleAuthProvider();


export { firebase, googleAuthProvider, database as default };

// // child_removed
// database.ref('expenses').on('child_removed', (snapshot) => {
//     console.log(snapshot.key, snapshot.val())
// });

// // child_changed
// database.ref('expenses').on('child_changed', (snapshot) => {
//     console.log(snapshot.key, snapshot.val())
// });

// // child_added
// database.ref('expenses').on('child_added', (snapshot) => {
//     console.log(snapshot.key, snapshot.val())
// });

// // database.ref('expenses').on('value', (snapshot) => {
// //     const expenses = [];
// //         snapshot.forEach((childSnapshot) => {
// //             expenses.push({
// //                 id: childSnapshot.key,
// //                 ...childSnapshot.val()
// //             });
// //         });
// //         console.log(expenses);
// // });

// // database.ref('expenses')
// //     .once('value')
// //     .then((snapshot) => {
// //         const expenses = [];
// //         snapshot.forEach((childSnapshot) => {
// //             expenses.push({
// //                 id: childSnapshot.key,
// //                 ...childSnapshot.val()
// //             });
// //         });
// //         console.log(expenses);
// //     });

// // database.ref('notes/-LoaX6YDgaMwWf2d41JG').update({
// //     body: 'Buy food'
// // })

// // database.ref('notes').push({
// //     title: "course topics",
// //     body: "React Native, Angular, Python"
// // });

// // const onValueChange = database.ref().on('value', (snapshot) => {
// //     const val = snapshot.val();
// //     console.log(`${val.name} is a ${val.job.title} at ${val.job.company}`);
// // });

// // const onValueChange = database.ref().on('value', (snapshot) => {
// //     console.log(snapshot.val());
// // });

// // setTimeout(() => {
// //     database.ref('age').set(23);
// // }, 3500);

// // setTimeout(() => {
// //     database.ref('job/company').set('Steam');
// // }, 7000);

// // database.ref('location/city').once('value').then((snapshot) => {
// //     const val = snapshot.val();
// //     console.log(val);
// // }).catch((e) => {
// //     console.log('Error fetching data', e);
// // });

// // database.ref().set({
// //     name: 'Dalton Scharff',
// //     age: 23,
// //     stressLevel: 5,
// //     job: {
// //         title: 'Software Developer',
// //         company: 'AT&T'
// //     },
// //     location: {
// //         city: 'Dallas',
// //         country: 'United States'
// //     }
// // }).then(() => {
// //     console.log('Data is saved.');
// // }).catch((error) => {
// //     console.log("This failed.", error);
// // });

// // database.ref().update({
// //     'stressLevel': 9,
// //     'job/company': 'Amazon',
// //     'location/city': 'Seattle'
// // });

// // database.ref('isAlive').remove().then(() => {
// //     console.log('Data was removed');
// // }).catch((error) => {
// //     console.log('Data was not removed', error);
// // });
