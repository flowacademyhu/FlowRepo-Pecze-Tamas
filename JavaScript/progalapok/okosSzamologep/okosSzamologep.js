let read = require('read-file');
let writeFile = require('write');
// let dataStr = read.sync('data.json', 'utf8');
// let data = JSON.parse(dataStr);
let readlineSync = require('readline-sync');
let options = ['Összeadás', 'Kivonás', 'Szorzás', 'Osztás', 'Negyzetgyok', 'Négyzetre emelés'];
let index = readlineSync.keyInSelect(options, 'Milyen matematikai műveletet kívánsz elvégezni?');
let q = true;
let szamlalo = 0;
while (q) {
  let program = (index) => {
    const sum = (a, b) => {
      return a + b;
    };
    const sub = (a, b) => {
      return a + b;
    };
    const mul = (a, b) => {
      return a * b;
    };
    const div = (a, b) => {
      return a / b;
    };
    const calculator = (a, b, c) => {
      return c(a, b);
    };
    let kolbasz = [];
    const visszaadas = (ertek) => {
      szamlalo++;
      kolbasz.push(ertek);
      if (kolbasz >= 10) {
        writeFile('result.json', JSON.parse(ertek));
        q = false;
      }
    };
    switch (index) {
      case 0:
        let szam1 = readlineSync.question('Add meg a két összeadni kívánt érték első számát: ');
        let szam2 = readlineSync.question('Add meg a két összeadni kívánt érték második számát: ');
        let ertek = calculator(+szam1, +szam2, sum);
        visszaadas(ertek);
        break;
      case 1:
        let szam3 = readlineSync.question('Add meg a két kivonni kívánt érték első számát: ');
        let szam4 = readlineSync.question('Add meg a két kivonni kívánt érték második számát: ');
        let valasz2 = +szam3 - +szam4;
        console.log('Az eredmény a következő: ' + valasz2);
        break;
      case 2:
        let szam5 = readlineSync.question('Add meg a két összeszorozni kívánt érték első számát: ');
        let szam6 = readlineSync.question('Add meg a két összeszorozni kívánt érték második számát: ');
        let valasz3 = +szam5 * +szam6;
        console.log('Az eredmény a következő: ' + valasz3);
        break;
      case 3:
        let szam7 = readlineSync.question('Add meg a két elosztani kívánt érték első számát: ');
        let szam8 = readlineSync.question('Add meg a két elosztani kívánt érték második számát: ');
        let valasz4 = +szam7 / +szam8;
        console.log('Az eredmény a következő: ' + valasz4);
        break;
      case 4:
        let szam9 = readlineSync.question('Add meg a számot melyen el kívánod végezni a műveletet: ');
        let valasz5 = Math.sqrt(szam9);
        console.log('Az eredmény a következő: ' + valasz5);
        break;
      case 5:
        let szam10 = readlineSync.question('Add meg a számot melyen el kívánod végezni a műveletet: ');
        let szam11 = readlineSync.question('Add meg a számot melyen el kívánod végezni a műveletet: ');
        let valasz6 = Math.pow(szam10, szam11);
        console.log('Az eredmény a következő: ' + valasz6);
        break;
    }
  };
  program(index);
}
