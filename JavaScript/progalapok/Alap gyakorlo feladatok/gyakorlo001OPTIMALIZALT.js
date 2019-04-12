const a = [2, 5, 10];
let b = 26;

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
