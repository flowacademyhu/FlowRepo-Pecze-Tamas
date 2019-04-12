function findUniq (arr) {
  arr.sort();
  console.log(arr);
  for (let i = 0; i <= arr.length; i += 2) {
    console.log(arr[i] + '' + arr[i + 1]);
    if (arr[i] !== arr[i + 1]) {
      if (arr[i] !== arr[i - 1]) {
        return arr[i];
      } else {
        return arr[i + 1];
      }
    }
  }
}
console.log(findUniq([1, 1, 1, 2, 1, 1]));
