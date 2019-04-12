const readlineSync = require('readline-sync');
const fibonacci = require('./fibonacci');
console.log('Hello, mi a bajod, mid faj?');
let answer = ['Fej', 'Jobb kez', 'Bal kez', 'torzs', 'bal lab', 'jobb lab'];
let index = readlineSync.keyInSelect(answer, 'Melyik szam?');
let minGeneratedData = 1;
let maxGeneratedData = 120;
let isPrime = (number) => {
  let start = 2;
  const limit = Math.sqrt(number);
  while (start <= limit) {
    if (number % start++ < 1) return false;
  }
  return number > 1;
};
let getRandom = (min, max) => {
  return Math.floor(Math.random() * max) + min;
};
let valasz = getRandom(minGeneratedData, maxGeneratedData);
switch (index) {
  case 0:
    while (((valasz / 3 % 1 === 0) === false)) {
      valasz = getRandom(minGeneratedData, maxGeneratedData);
      while ((valasz / 4 % 1 === 0) === true) {
        valasz = getRandom(minGeneratedData, maxGeneratedData);
      }
    }
    console.log(valasz);
    break;
  case 1:
    while (((valasz / 5 % 1 === 0) === false)) {
      valasz = getRandom(minGeneratedData, maxGeneratedData);
      while ((valasz / 7 % 1 === 0) === true) {
        valasz = getRandom(minGeneratedData, maxGeneratedData);
      }
    }
    console.log(valasz);
    break;
  case 2:
    let ellen = false;
    do {
      let szam = getRandom(minGeneratedData, maxGeneratedData);
      if (isPrime(szam) === true) {
        ellen = true;
        console.log(szam);
      }
    } while (ellen === false);
    break;
  case 3:
    console.log(fibonacci.ertekKivitel(getRandom(10, 60)));
}
