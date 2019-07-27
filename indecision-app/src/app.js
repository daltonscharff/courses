console.log("App.js is running!");

// JSX - JavaScript XML
var app = {
    title: "Title",
    subtitle: "Subtitle", 
    options: ["One", "Two"]
};

var template = (
    <div>
        <h1>{app.title}</h1>
        {app.subtitle && <p>{app.subtitle}</p>}
        <p>{app.options.length > 0 ? "Here are your options" : "No options"}</p>
        <ol>
            <li>Item one</li>
            <li>Item two</li>
        </ol>
    </div>
);

var user = {
    name: 'Dalton',
    age: '23',
    location: 'Dallas'
};

function getLocation(location) {
    return location ? <p>Location: {location}</p> : undefined;
}

var template2 = (
    <div>
        <h1>{user.name ? user.name : "Anonymous"}</h1>
        {(user.age && user.age >= 18) && <p>Age: {user.age}</p>}
        {getLocation(user.location)}
    </div>
);

var appRoute = document.querySelector('#app');

ReactDOM.render(template, appRoute);