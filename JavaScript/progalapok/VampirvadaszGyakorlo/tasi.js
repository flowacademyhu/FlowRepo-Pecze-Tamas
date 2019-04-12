let hetkoznapi = 5;
let hetvegi = 10;
let osszesresz = 167;
let szamitas1hetre = (k1, k2) => {
  let guriga = ((5 * k1) + (2 * k2));
  return guriga;
};
let egyhet = szamitas1hetre(hetkoznapi, hetvegi);
let teljesTasi = (o1, o2) => {
  let ibolya = o1 / egyhet;
  return ibolya;
};
let vegeredmeny = teljesTasi(osszesresz, egyhet);
console.log(vegeredmeny);
