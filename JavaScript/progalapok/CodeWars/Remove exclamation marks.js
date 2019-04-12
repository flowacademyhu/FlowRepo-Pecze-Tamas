function removeExclamationMarks (s) {
  let k = s.replace(/!/g, '');
  return k;
}
console.log(removeExclamationMarks('hello vilag!!!'));
