const https = require('https');
const config = require('../weather-app/config');

const url = `https://api.darksky.net/forecast/${config.darkSky.secretKey}/40,-75?`;

const request = https.request(url, (response) => {
    let data = '';

    response.on('data', (chunk) => {
        data += chunk.toString();
    });

    response.on('end', () => {
        const body = JSON.parse(data);
        console.log(body);
    });
});

request.on('error', (error) => {
    console.log('An error', error);
})

request.end();