/* "Írj egy programot, ami 1-től 100-ig kiírja a számokat. Ha a szám osztható hárommal,
akkor írja ki a szám helyett, hogy Fizz, ha osztható öttel, akkor Buzz, ha mind a kettővel osztható,
akkor FizzBuzz." */
let k = 0;
let osztoHAROM = 3;
let osztoOT = 5;
let HAROMot = (szam1) => {
  if ((szam1 / 3) % 1 === 0 && ((szam1 / 5) % 1 === 0)) {
    return true;
  } else {
    return false;
  }
};
for (let i = 1; i <= 100; i++) {
  k++;
  if (HAROMot(k) === true) {
    console.log('FizzBuzz');
    osztoHAROM += 3;
    osztoOT += 5;
  } else if (k / osztoHAROM === 1) {
    console.log('Fizz');
    osztoHAROM += 3;
  } else if (k / osztoOT === 1) {
    console.log('Buzz');
    osztoOT += 5;
  } else {
    console.log(k);
  }
}
