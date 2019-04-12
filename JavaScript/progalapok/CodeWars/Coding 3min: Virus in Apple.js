function sc (apple, n) {
  let v1 = 0;
  let v2 = 0;
  for (let i = 0; i < apple.length; i++) {
    for (let j = 0; j < apple.length; j++) {
      if (apple[i][j] === 'V') {
        v1 = i;
        v2 = j;
      }
    }
  }
  for (let q = 1; q <= n; q++) {
    if ((v1 + q) <= 4) {
      apple[v1 + q][v2] = 'V';
      if (q >= 2) {
        console.log(v1-q+'elso');
        if ((v1 - q) >= 0) {
          console.log('csirke');
          apple[v1 + q][v2 + q] = 'V';
        }
      }
    }
    if ((v1 - q) >= 0) {
      if ((v2 + q) <= 4) {
        apple[v1 - q][v2] = 'V';
      }
      if (q >= 2) {
        console.log(v1+q+'masodik');
        if ((v1 + q) <= 4) {
          console.log('csirke');
        apple[v1 + q][v2 - q] = 'V';
        }
      }
    }
    if ((v2 + q) <= 4) {
      apple[v1][v2 + q] = 'V';
      if (q >= 2) {
        console.log(v2+q+'harmadik');
        if ((v2 - q) >= 0) {
          console.log('csirke');
        apple[v1 - q][v2 + q] = 'V';
        }
      }
    }
    if ((v2 - q) >= 0) {
      apple[v1][v2 - q] = 'V';
      if (q >= 2) {
        console.log(v2 + q+'negyedik');
        if ((v2 + q) <= 4) {
          console.log('csirke');
        apple[v1 - q][v2 - q] = 'V';
        }
      }
    }
  } 
  return apple;
}
let apple = [
  ['A', 'A', 'A', 'A', 'A'],
  ['A', 'A', 'A', 'A', 'V'],
  ['A', 'A', 'A', 'A', 'A'],
  ['A', 'A', 'A', 'A', 'A'],
  ['A', 'A', 'A', 'A', 'A']
];
let n = 4;
console.log(sc(apple, n));
/*
 [['V', 'V', 'A', 'A', 'A'], 
 ['V', 'V', 'V', 'A', 'A'], 
 ['V', 'V', 'A', 'A', 'A'], 
 ['V', 'A', 'A', 'A', 'A'], 
 ['A', 'A', 'A', 'A', 'A']], instead got: 
 [['V', 'A', 'A', 'A', 'A'], 
 ['V', 'V', 'V', 'A', 'A'], 
 ['V', 'A', 'A', 'A', 'A'], 
 ['V', 'A', 'A', 'A', 'A'], 
 ['A', 'A', 'A', 'A', 'A']]
 */
