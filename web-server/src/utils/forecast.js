const request = require('request');
const config = require('../../config');

const forecast = (latitude, longitude, callback) => {
    const url = `https://api.darksky.net/forecast/${config.darkSky.secretKey}/${latitude},${longitude}?`;

    request({url, json: true}, (error, { body:response }) => {
        if (error) {
            callback('Unable to connect to weather service.', undefined);
            return;
        } else if (response.error) {
            callback('Weather service is unable to find location.', undefined);
            return;
        }

        callback(undefined, {
            summary: response.daily.data[0].summary,
            temperature: response.currently.temperature,
            precipProb: response.currently.precipProbability,
            string: `${response.daily.data[0].summary}. It is currently ${response.currently.temperature} degrees. There is a ${response.currently.precipProbability}% chance of rain.`
        });
    });
};

module.exports = forecast;