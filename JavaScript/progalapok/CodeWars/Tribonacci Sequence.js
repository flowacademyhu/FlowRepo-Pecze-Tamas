function tribonacci (signature, n) {
  let returnErtek = [];
  if (n < 1) {
    return returnErtek;
  }
  console.log();
  for (let i = 0; i <= n; i++) {
    signature.push(signature[i] + signature[i + 1] + signature[i + 2]);
  }
  signature.pop();
  signature.pop();
  signature.pop();
  return signature;
}
let value = [3, 2, 1];
console.log(tribonacci(value, 5));
