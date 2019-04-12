// 1 1 2 3 5 8 13 21 34 mi az erteke a fibanacci szamnak
let szamitas1 = (szam1, szam2) => {
  let eredmeny = szam1 + szam2;
  elsoSZAM = masodikSZAM;
  return eredmeny; // ez a 2. szam
};
let szamitas2 = (szam1, szam2) => {
  let eredmeny = szam1 + szam2;
  szamlalo++;
  masodikSZAM += elsoSZAM;
  return eredmeny; // ez a 2. szam
};
let elsoSZAM = 1;
let masodikSZAM = 1;
let kertSZAM = 5;
let szamlalo = 0;
for (let i = 0; i < kertSZAM; i++) {
  console.log(szamlalo + ': ');
  elsoSZAM = szamitas1(elsoSZAM, masodikSZAM);
  masodikSZAM = szamitas2(elsoSZAM, masodikSZAM);
  console.log(elsoSZAM);
  console.log(masodikSZAM);
}
// console.log(szamlalo);
