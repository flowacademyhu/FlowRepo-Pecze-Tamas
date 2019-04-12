let osszesLoszeruk = (DeanLoszere, SamLoszere) => {
  let sum = DeanLoszere + SamLoszere;
  return sum;
};
console.log('Dean-nek es Sam-nek osszesen ' + osszesLoszeruk(40, 24) + ' loszere van.');

let OVSZD = (noiDMG, himDMG, alphaDMG) => { // osszes vampirokhoz szukseges damage
  let sum = alphaDMG + noiDMG + himDMG;
  return sum;
};
console.log(OVSZD((1 * 12), (8 * 4), (3 * 2)) + ' osszesen ennyi loszer szukseges kinyirni minden vampirt!');
OVSZD((1 * 12), (8 * 4), (3 * 2));
if (OVSZD.sum > osszesLoszeruk(40, 24)) {
  console.log('Nincs elegendo loszeruk leloni a vampirokat!');
} else {
  console.log('Minden vampir sikeresen kinyirva.');
}
