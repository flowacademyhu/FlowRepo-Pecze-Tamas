// Return an array
function fizzbuzz (n) {
  let k = 0;
  let osztoHAROM = 3;
  let osztoOT = 5;
  let arr = [];
  let HAROMot = (szam1) => {
    if ((szam1 / 3) % 1 === 0 && ((szam1 / 5) % 1 === 0)) {
      return true;
    } else {
      return false;
    }
  };
  for (let i = 1; i <= n; i++) {
    k++;
    if (HAROMot(k) === true) {
      arr.push('FizzBuzz');
      osztoHAROM += 3;
      osztoOT += 5;
    } else if (k / osztoHAROM === 1) {
      arr.push('Fizz');
      osztoHAROM += 3;
    } else if (k / osztoOT === 1) {
      arr.push('Buzz');
      osztoOT += 5;
    } else {
      arr.push(k);
    }
  }
  return arr;
}
console.log(fizzbuzz(3));
