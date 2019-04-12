let csusztatas = 2;
let szoveg = 'blabla';
let abc = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
  'sz', 't', 'ty', 'u', 'v', 'w', 'x', 'y', 'z', 'zs'];
for (let i = 0; i < szoveg.length; i++) {
  for (let j = 0; j < abc.length; j++) {
    if (szoveg[i] === abc[j]) {
      process.stdout.write(abc[j + csusztatas]); // nem tori meg a sort.
    }
  }
}
