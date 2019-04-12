function noBoringZeros (n) {
  let arr = n.toString().split('');
  for (let i = arr.length - 1; i > 0; i--) {
    if (arr[i] === '0') arr.pop();
    else break;
  }
  return (+(arr.join('')));
}
noBoringZeros(8565900);
