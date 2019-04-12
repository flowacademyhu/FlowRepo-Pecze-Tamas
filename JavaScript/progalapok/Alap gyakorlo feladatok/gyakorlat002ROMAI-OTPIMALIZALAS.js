const a = [1, 100, 200, 500, 1000, 2000];
let b = 9003;

let OptFunkcio = () => {
  let ertek = [];
  for (let krumpli = a.length; krumpli >= 0; krumpli--) {
    while (a[krumpli] <= b) {
      if (a[krumpli] <= b) {
        b -= a[krumpli];
        ertek.push(a[krumpli]);
      }
    }
  }
  return ertek;
};
console.log(OptFunkcio(a, b));
let logikaI = (number) => {
  if (number === 1) {
    number = 'I';
  } else if (number === 2) {
    number = 'II';
  } else if (number === 3) {
    number = 'III';
  } else if (number === 4) {
    number = 'IV';
  } else if (number === 5) {
    number = 'V';
  } else if (number === 6) {
    number = 'VI';
  } else if (number === 7) {
    number = 'VII';
  } else if (number === 8) {
    number = 'VIII';
  } else if (number === 9) {
    number = 'IX';
  }
};

let numb = 91;

numb.toString();

console.log(logikaI(numb.str.substring(1, 1)));
