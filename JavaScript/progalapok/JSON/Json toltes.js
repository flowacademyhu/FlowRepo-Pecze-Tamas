var fs = require('fs');

var data = { 'scoreboard:': [
  {
    jatekos: 'karalabqw',
    eredmeny: '222'
  }
] };
fs.appendFile('gameStorage.json', JSON.stringify(data), function (err) {
  if (err) throw err;
}
);
let obj = JSON.parse(fs.readFileSync('gameStorage.json', 'utf8'));
console.log(obj);
