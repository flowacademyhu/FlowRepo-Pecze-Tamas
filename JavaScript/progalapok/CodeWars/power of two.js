function isPowerOfTwo (n) {
  if ((Math.pow(n, 2) % 2 === 0) && (Math.pow(n, 2) === (Math.log(2) / Math.log(n)))) {
    return true;
  } else {
    return false;
  }
}
console.log(isPowerOfTwo(4096));
