function printerError (s) {
  let regex1 = /[n-z]/;
  let counter = 0;
  let holder = [];
  for (let i = 0; i < s.length; i++) {
    if (regex1.test(s[i]) === true) {
      counter++;
    }
  }
  return counter + '/' + s.length;
}
console.log(printerError('aaaxbbbbyyhwawiwjjjwwm'));
