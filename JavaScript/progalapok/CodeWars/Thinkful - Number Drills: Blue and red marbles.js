function guessBlue (blueStart, redStart, bluePulled, redPulled) {
  let blueLeft = blueStart - bluePulled;
  let redLeft = redStart - redPulled;
  let ret = blueLeft / redLeft;
  console.log(ret);
  return Math.floor(ret * 10) / 10;
}
console.log(guessBlue(12, 18, 4, 6));
// Math round-al felfele kerekitesz.
