console.log("App.js is running!");

// JSX - JavaScript XML
var template = (
    <div>
        <h1>Indecision App</h1>
        <p>This is some info</p>
        <ol>
            <li>Item one</li>
            <li>Item two</li>
        </ol>
    </div>
);

var templateTwo = (
    <div>
        <h1>Dalton Scharff</h1>
        <p>Age: 23</p>
        <p>Location: Dallas</p>
    </div>
);

var appRoute = document.querySelector('#app');

ReactDOM.render(templateTwo, appRoute);