function points (games) {
  let kaposzta = 0;
  for (let i = 0; i < games.length; i++) {
    if (games[i][0] > games[i][2]) {
      kaposzta += 3;
    } else if (games[i][0] < games[i][2]) {
      kaposzta += 0;
    } else {
      kaposzta += 1;
    }
  }
  return kaposzta;
}

let ertek = Array.from(['1:0', '2:0', '3:0', '4:0', '2:1', '3:1', '4:1', '3:2', '4:2', '4:3']);
console.log(points(ertek));
