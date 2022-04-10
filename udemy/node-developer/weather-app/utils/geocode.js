const request = require('request');
const config = require('../config');

const geocode = (address, callback) => {
    const url = `https://api.mapbox.com/geocoding/v5/mapbox.places/${encodeURIComponent(address)}.json?access_token=${config.mapbox.token}&limit=1`;

    request({url, json: true}, (error, { body:response }) => {
        if (error) {
            callback('Unable to connect to location service.', undefined);
            return;
        } else if (response.features.length === 0) {
            callback('Location service did not return any results.', undefined);
            return;
        }

        callback(undefined, {
            latitude: response.features[0].center[1],
            longitude: response.features[0].center[0],
            location: response.features[0].place_name
        });
    });
};

module.exports = geocode;