function scramble (str, arr) {
  let toltes = '';
  for (let i = 0; i < arr.length; i++) {
    toltes += str.splice(i, 1, arr[i]);
  }
  return toltes;
}

console.log(scramble('skt', [2, 1, 0]));
