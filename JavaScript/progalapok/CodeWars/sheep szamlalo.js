var countSheep = function (num) {
  let returnos = '';
  for (let i = 1; i <= num; i++) {
    returnos += i + ' sheep...';
  }
  return returnos;
};
console.log(countSheep(1));
