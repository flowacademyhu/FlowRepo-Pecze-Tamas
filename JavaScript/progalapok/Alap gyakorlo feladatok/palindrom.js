let PotencialisPalidrom = 'wewe';
let szamlalo = 0;
for (let i = 0; i < PotencialisPalidrom.length; i++) {
  let ElsoBetu = PotencialisPalidrom[i];
  // console.log(i);
  let UtolsoBetu = PotencialisPalidrom[((PotencialisPalidrom.length - i) - 1)];
  if (ElsoBetu !== UtolsoBetu) {
    szamlalo++;
  }
}
if (szamlalo === 0) {
  console.log('A ' + PotencialisPalidrom + ' palidrom.');
} else {
  console.log('A ' + PotencialisPalidrom + ' nem palidrom.');
}
