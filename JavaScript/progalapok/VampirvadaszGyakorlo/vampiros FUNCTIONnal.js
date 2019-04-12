let DLoszere = 1000; // deannek 10 loszere van
const golyoperNOkilled = 2;
const golyoperHIMkilled = 4;
const golyoperALPHAkilled = 12;
let nokSzama = 3;
let himSzama = 8;
let alphaSzama = 1;
while (DLoszere >= golyoperNOkilled && nokSzama > 0) {
  DLoszere -= 2;
  nokSzama -= 1;
  console.log(`2 golyo elhasznalva[noi Vampir], Dean loszerenek a szama: ${DLoszere}`);
}
while (DLoszere >= golyoperHIMkilled && himSzama > 0) {
  DLoszere -= 4;
  himSzama -= 1;
  console.log(`4 golyo elhasznalva[him Vampir], Dean loszerenek a szama: ${DLoszere}`);
}
while (DLoszere >= golyoperALPHAkilled && alphaSzama > 0) {
  DLoszere -= 12;
  alphaSzama -= 1;
  console.log(`12 golyo elhasznalva[alpha Vampir], Dean loszerenek a szama: ${DLoszere}`);
}
console.log(``);
console.log(`Deannek ennyi loszere marad a maximalisan megolheto vampirok utan ${DLoszere}.`);
