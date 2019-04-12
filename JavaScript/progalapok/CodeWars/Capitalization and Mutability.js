function capitalizeWord (word) {
  let temp = word[0].toUpperCase();
  temp = temp + word.slice(1);
  return temp;
}
console.log(capitalizeWord('wawa'));
