function squareDigits (num) {
  let kokusz = '';
  let szalami = '';
  kokusz = num.toString();
  for (let i = 0; i < kokusz.length; i++) {
    szalami += Math.pow(kokusz.slice(i, i + 1), 2);
  }
  szalami = szalami.parseInt();
  return +szalami;
}
console.log(squareDigits(9119));
