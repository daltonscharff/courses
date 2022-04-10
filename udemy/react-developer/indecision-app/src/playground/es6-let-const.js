var nameVar = 'Dalton';
var nameVar = 'Mike';

document.write('nameVar ', nameVar);

let nameLet = 'Jen';
document.write('<br>nameLet ', nameLet);

const nameConst = 'Frank';
document.write('<br>nameConst ', nameConst);

// Block scoping

var fullName = 'Dalton Scharff';

if (fullName) {
    let firstName = fullName.split(' ')[0];
    document.write("<br>", firstName);
}

document.write("<br>", firstName);

