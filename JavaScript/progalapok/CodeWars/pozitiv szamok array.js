function positiveSum (arr) {
  if (arr[0] !== 0) {
    let num = 0;
    for (let i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        num += arr[i];
      }
    }
    return num;
  }
}
let pozitivok = [2, 5, 7];
console.log(positiveSum(pozitivok));
