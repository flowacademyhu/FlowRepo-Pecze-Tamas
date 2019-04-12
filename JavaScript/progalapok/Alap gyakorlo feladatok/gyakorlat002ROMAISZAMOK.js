const a = [1, 2, 5, 10];
let b = 18;

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
let ujTomb = [];
let romai = OptFunkcio(a, b);
console.log(romai);
for (let i = 0; i <= romai.length - 1; i++) {
  if (romai[i] === 1) {
    ujTomb.push('I');
  } else if (romai[i] === 2) {
    ujTomb.push('II');
  } else if (romai[i] === 3) {
    ujTomb.push('III');
  } else if (romai[i] === 4) {
    ujTomb.push('IV');
  } else if (romai[i] === 5) {
    ujTomb.push('V');
  } else if (romai[i] === 10) {
    ujTomb.push('X');
  } else if (romai[i] === 20) {
    ujTomb.push('XX');
  } else if (romai[i] === 50) {
    ujTomb.push('L');
  } else if (romai[i] === 100) {
    ujTomb.push('C');
  } else if (romai[i] === 200) {
    ujTomb.push('CC');
  } else if (romai[i] === 500) {
    ujTomb.push('D');
  }
}
console.log(ujTomb);
