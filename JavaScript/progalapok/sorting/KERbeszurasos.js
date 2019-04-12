const insertionsort = (tomb) => {
  let szamlalo = 0;
  let szamlaloFOR = 0;
  for (let i = 1; i < tomb.length; i++) {
    let temp = tomb[i];
    let j = i - 1;
    szamlaloFOR++;
    console.log('for:' + szamlaloFOR);
    while (j >= 0 && tomb[j] > temp) {
      tomb[j + 1] = tomb[j];
      j--;
      szamlalo++;
      console.log('while:' + szamlalo);
    }
    tomb[j + 1] = temp;
    console.log('j+1 : ' + tomb[j + 1]);
    console.log('j   : ' + tomb[j]);
    console.log(tomb);
  }
  return tomb;
};

console.log(insertionsort([3, 1, 2, 1, 3, 4]));
