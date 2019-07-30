const app = {
    header: "Visibility Toggle",
    buttonText: ["Show details", "Hide details"],
    isVisible: false
}

const changeState = () => {
    app.isVisible = !app.isVisible;
    render();
};

const appRoot = document.querySelector('#app');

const render = () => {
    const template = (
        <div>
            <h1>{app.header}</h1>
            <button onClick={changeState}>
                {app.isVisible ? "Hide details" : "Show details"}
            </button>
            {app.isVisible && (
            <p>
                Hey. There are some details you can now see!
            </p>
            )}
        </div>
    );
    ReactDOM.render(template, appRoot);
};

render();