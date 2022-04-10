const square = function (x) {
    return x * x;
};

const squareArrow = x => x * x;



document.write(squareArrow(4));

const getFirstName = (fullName) => fullName.split(' ')[0];