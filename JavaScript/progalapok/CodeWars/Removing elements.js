function removeEveryOther (arr) {
  let arr2 = [];
  console.log(arr.length);
  for (let i = 1; i < arr.length; i + 2) {
    arr2.pop(arr[i]);
  }
  return arr;
}
console.log(removeEveryOther(['Kaktusz', 'kola', 'krumpli']));
