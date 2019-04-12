function noBoringZeros (n) {
  let counter = true;
  while (counter === true) {
    if (n % 10 === 0) {
      n = n / 10;
    } else {
      counter = false;
    } 
  }
  return n;
}
console.log(noBoringZeros(960000));
