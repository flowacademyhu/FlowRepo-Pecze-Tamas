let i;
let j;
let k;
let forrasTomb1 = [1, 2, 3, 4];
let n = forrasTomb1.length;
let forrasTomb2 = [1, 2, 3, 5, 6, 7];
let m = forrasTomb2.length;
let unioTomb = [];
for (i = 0; i <= n - 1; i++) {
  unioTomb[i] = forrasTomb1[i];
}
k = n;
for (j = 0; j <= m - 1; j++) {
  i = 0;
  while (i < n && forrasTomb2[j !== forrasTomb1[i]]) {
    i++;
  }
  if (i > n) {
    unioTomb[k] = forrasTomb2[j];
    k++;
  }
}
console.log(unioTomb);
