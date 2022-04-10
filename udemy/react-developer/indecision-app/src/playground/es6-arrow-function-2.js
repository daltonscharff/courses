// argument object - no longer bound with arrow funcitons

const add = (a, b) => {
    return a + b;
}

document.writeln(add(55, 1));

// this keyword - no longer bound

const user = {
    name: 'Dalton',
    cities: ['Dallas', 'Pittsburgh', 'Reading'],
    printPlacesLived() {
        return this.cities.map((city) => this.name + " has lived in " + city);
    }
};

document.writeln(user.printPlacesLived());

// Challenge area

const multiplier = {
    numbers: [1,2,3],
    multiplyBy: 2,
    multiply() {
        return this.numbers.map((number) => number * this.multiplyBy)
    }
}

document.writeln("<br><br>", multiplier.multiply())