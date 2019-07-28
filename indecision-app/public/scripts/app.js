'use strict';

// argument object - no longer bound with arrow funcitons

var add = function add(a, b) {
    return a + b;
};

document.writeln(add(55, 1));

// this keyword - no longer bound

var user = {
    name: 'Dalton',
    cities: ['Dallas', 'Pittsburgh', 'Reading'],
    printPlacesLived: function printPlacesLived() {
        var _this = this;

        return this.cities.map(function (city) {
            return _this.name + " has lived in " + city;
        });
    }
};

document.writeln(user.printPlacesLived());

// Challenge area

var multiplier = {
    numbers: [1, 2, 3],
    multiplyBy: 2,
    multiply: function multiply() {
        var _this2 = this;

        return this.numbers.map(function (number) {
            return number * _this2.multiplyBy;
        });
    }
};

document.writeln("<br><br>", multiplier.multiply());
