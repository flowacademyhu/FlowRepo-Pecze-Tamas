let regex1 = /^[0-9]{4}$/;
let regex2 = /^[0-9]{6}$/;
function validatePIN (pin) {
  if (regex1.test(pin) || regex2.test(pin)) {
    return true;
  } else {
    return false;
  }
}
console.log(validatePIN(1));
