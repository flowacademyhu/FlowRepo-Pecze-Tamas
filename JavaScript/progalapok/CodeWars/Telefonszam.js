let szamok = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
function createPhoneNumber (numbers) {
  let St = '';
  for (let i = 0; i < 10; i++) {
    St += numbers.shift();
  }
  let output = [St.slice(0, 0), '(', St.slice(0)].join('');
  let outputW = [output.slice(0, 4), ') ', output.slice(4)].join('');
  let outputQ = [outputW.slice(0, 9), '-', outputW.slice(9)].join('');
  return outputQ;
}
/* Legjobb megoldas:
function createPhoneNumber(numbers){
  numbers = numbers.join('');
  return '(' + numbers.substring(0, 3) + ') ' 
      + numbers.substring(3, 6) 
      + '-' 
      + numbers.substring(6);
}
*/
console.log(createPhoneNumber(szamok));
