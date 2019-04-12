// Ha megjelenik a csetepaté végén Crowley, a keresztúti démon, marad-e elég golyó a számára?
// 5x annyi kell neki mint az alfának.
let osszesLoszer = 64;
let loszerSzukseges = 50;
let maradekLoszer = (ka1, ka2) => {
  let sum = ka1 - ka2;
  return sum;
};
let k22 = maradekLoszer(osszesLoszer, loszerSzukseges); // feltoltve a maradek loszerekkel.
console.log(maradekLoszer(osszesLoszer, loszerSzukseges) + ' ennyi loszeruk marad a fight vegen.');
let CrowleyHP = 5 * 12;
let CrowleyKill = (faradtsag1, faradtsag2) => {
  let kokusz = faradtsag1 - faradtsag2;
  return kokusz;
};
console.log(CrowleyKill(k22, CrowleyHP) + ' ennyi loszer hianyzik Crowley megolesehez');
