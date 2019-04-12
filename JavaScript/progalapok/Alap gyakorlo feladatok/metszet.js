let i = 0;
let j;
let k = 0;
let forrasTomb1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 0];
let forrasTomb2 = [1, 2, 3, 5, 6, 7, 8, 9, 12, 13];
let metszetTomb = [];
for (i; i < forrasTomb1.length; i++) {
  j = 0;
  while (j < forrasTomb2.length && forrasTomb1[i] !== forrasTomb2[j]) {
    j += 1;
    console.log('beleptem a whileba j:' + j);
  }
  if (j < forrasTomb2.length) {
    metszetTomb[k] = forrasTomb1[i];
    k++;
    console.log('i' + i);
    console.log(metszetTomb);
    console.log();
  }
}
console.log(metszetTomb);
