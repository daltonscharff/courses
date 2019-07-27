"use strict";

console.log("App.js is running!");

// JSX - JavaScript XML
var app = {
    title: "Title",
    subtitle: "Subtitle",
    options: ["One", "Two"]
};

var template = React.createElement(
    "div",
    null,
    React.createElement(
        "h1",
        null,
        app.title
    ),
    app.subtitle && React.createElement(
        "p",
        null,
        app.subtitle
    ),
    React.createElement(
        "p",
        null,
        app.options.length > 0 ? "Here are your options" : "No options"
    ),
    React.createElement(
        "ol",
        null,
        React.createElement(
            "li",
            null,
            "Item one"
        ),
        React.createElement(
            "li",
            null,
            "Item two"
        )
    )
);

var user = {
    name: 'Dalton',
    age: '23',
    location: 'Dallas'
};

function getLocation(location) {
    return location ? React.createElement(
        "p",
        null,
        "Location: ",
        location
    ) : undefined;
}

var template2 = React.createElement(
    "div",
    null,
    React.createElement(
        "h1",
        null,
        user.name ? user.name : "Anonymous"
    ),
    user.age && user.age >= 18 && React.createElement(
        "p",
        null,
        "Age: ",
        user.age
    ),
    getLocation(user.location)
);

var appRoute = document.querySelector('#app');

ReactDOM.render(template, appRoute);
