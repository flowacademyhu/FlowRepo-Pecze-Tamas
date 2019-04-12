function isOpposite (s1, s2) {
  if (s1 !== '' || s2 !== '') {
    if (s1.toLowerCase() === s2.toLowerCase()) {
      let kaposzta = '';
      let krumpliszsak = '';
      for (let i = 0; i < s1.length; i++) {
        kaposzta = s1[i];
        if (kaposzta === kaposzta.toUpperCase()) {
          krumpliszsak += kaposzta.toLowerCase();
        } else if (kaposzta === kaposzta.toLowerCase()) {
          krumpliszsak += kaposzta.toUpperCase();
        } else if (kaposzta === '') {
          return false;
        }
      }
      if (krumpliszsak === s2) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  } else {
    return false;
  }
}
let w = 'abw';
let q = 'AB';
console.log(isOpposite(w, q));
