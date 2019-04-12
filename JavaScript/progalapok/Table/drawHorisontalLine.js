const { table } = require('table'); // ctrl bal klikk

let data,
  output,
  options;

data = [
  ['0A', '0B', '0C'],
  ['1A', '1B', '1C'],
  ['2A', '2B', '2C'],
  ['3A', '3B', '3C'],
  ['4A', '4B', '4C']
];

options = {
  /**
     * @typedef {function} drawHorizontalLine
     * @param {number} index
     * @param {number} size
     * @return {boolean}
     */
  drawHorizontalLine: (index, size) => {
    return index === 0 || index === 1 || index === size - 1 || index === size;
  }
};

output = table(data, options);

console.log(output);
