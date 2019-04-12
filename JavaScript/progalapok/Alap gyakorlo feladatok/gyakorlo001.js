// funkcio var bemenetnek egy szamot es egy tombot[]
// vissza is tombot adjon
const a = [1, 5, 10];
const b = 19;

let funkcio = (a, b) => {
  let ertek = [];
  let valasz1 = true;
  let valasz2 = true;
  let valasz3 = true;
  while (valasz1) {
    if (a[2] <= b) {
      b -= a[2];
      ertek.push(10);
    } else {
      valasz1 = false;
    }
  }
  while (valasz2) {
    if (a[1] <= b) {
      b -= a[1];
      ertek.push(5);
    } else {
      valasz2 = false;
    }
  }
  while (valasz3) {
    if (a[0] <= b) {
      b -= a[0];
      ertek.push(1);
    } else {
      valasz3 = false;
    }
  }
  return ertek;
};
console.log(funkcio(a, b));
