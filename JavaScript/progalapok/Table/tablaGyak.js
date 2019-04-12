const { table } = require('table'); // ctrl bal klikk

let data;
let output;

data = [
  ['0qwqwqewqweqwewqwqweqwA', '0B', '0C'],
  ['1A', '1B', '1C'],
  ['2A', '2B', '2C']
];

let config = {
  columns: {
    0: {
      alignment: 'left',
      width: 10
    },
    1: {
      alignment: 'center',
      width: 10
    },
    2: {
      alignment: 'right',
      width: 10
    }
  }
};
let config1 = {
  border: {
    topBody: `─`,
    topJoin: `┬`,
    topLeft: `┌`,
    topRight: `┐`,

    bottomBody: `─`,
    bottomJoin: `┴`,
    bottomLeft: `└`,
    bottomRight: `┘`,

    bodyLeft: `│`,
    bodyRight: `│`,
    bodyJoin: `│`,

    joinBody: `─`,
    joinLeft: `├`,
    joinRight: `┤`,
    joinJoin: `w`
  }
};
output = table(data, config1);

console.log(output);
