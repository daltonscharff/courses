console.log("App.js is running!");

const app = {
    title: "Title",
    subtitle: "Subtitle", 
    options: ["One", "Two"]
};

const template = (
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

const user = {
    name: 'Dalton',
    age: '23',
    location: 'Dallas'
};

function getLocation(location) {
    return location ? <p>Location: {location}</p> : undefined;
}

const template2 = (
    <div>
        <h1>{user.name ? user.name : "Anonymous"}</h1>
        {(user.age && user.age >= 18) && <p>Age: {user.age}</p>}
        {getLocation(user.location)}
    </div>
);

const appRoute = document.querySelector('#app');

ReactDOM.render(template, appRoute);