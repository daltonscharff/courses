import { render, screen, fireEvent } from "@testing-library/react";
import { App, replaceCamelWithSpaces } from "./App";

test("button has correct initial color", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
  expect(colorButton).toHaveStyle({
    backgroundColor: "MediumVioletRed",
  });
  fireEvent.click(colorButton);
  expect(colorButton).toHaveStyle({
    backgroundColor: "MidnightBlue",
  });
  expect(colorButton).toHaveTextContent("Change to Medium Violet Red");
});

test("initial conditions", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
  expect(colorButton).toBeEnabled();

  const checkbox = screen.getByRole("checkbox");
  expect(checkbox).not.toBeChecked();
});

test("checkbox disabled button on first click and enabled on second click", () => {
  render(<App />);
  const colorButton = screen.getByRole("button");
  const checkbox = screen.getByRole("checkbox", {
    name: "Disable button",
  });
  fireEvent.click(checkbox);
  expect(colorButton).toBeDisabled();
  fireEvent.click(checkbox);
  expect(colorButton).toBeEnabled();
});

test("disabled button has gray background and reverts to red", () => {
  render(<App />);
  const colorButton = screen.getByRole("button");
  const checkbox = screen.getByRole("checkbox", {
    name: "Disable button",
  });

  fireEvent.click(checkbox);
  expect(colorButton).toHaveStyle("background-color: gray");

  fireEvent.click(checkbox);
  expect(colorButton).toHaveStyle("background-color: MediumVioletRed");
});

test("clicked button has gray background and reverts to blue", () => {
  render(<App />);
  const colorButton = screen.getByRole("button");
  const checkbox = screen.getByRole("checkbox", {
    name: "Disable button",
  });

  fireEvent.click(colorButton);

  fireEvent.click(checkbox);
  expect(colorButton).toHaveStyle("background-color: gray");

  fireEvent.click(checkbox);
  expect(colorButton).toHaveStyle("background-color: MidnightBlue");
});

describe("spaces before camel-case capital letters", () => {
  test("works for no inner capital letters", () => {
    expect(replaceCamelWithSpaces("Red")).toBe("Red");
  });
  test("works for one inner capital letter", () => {
    expect(replaceCamelWithSpaces("MidnightBlue")).toBe("Midnight Blue");
  });
  test("works for multiple capital letters", () => {
    expect(replaceCamelWithSpaces("MediumVioletRed")).toBe("Medium Violet Red");
  });
});
