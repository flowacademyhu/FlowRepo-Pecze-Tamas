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
let szamlalo = 0;
let ertekKivitel = (ertek) => {
  for (let i = 0; i < ertek; i++) {
    console.log(szamlalo + ': ');
    elsoSZAM = szamitas1(ertek, (ertek + 1));
    masodikSZAM = szamitas2(ertek, (ertek + 1));
  }
  return elsoSZAM;
};
module.exports = { ertekKivitel };
