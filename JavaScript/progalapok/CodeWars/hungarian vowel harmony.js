function dative (word) {
  let zero = 1;
  for (let i = word.length; i > 0; i--) {
    let kap = word[word.length - (word.length - i + 1)];
    word.slice(zero);
    console.log('BAZD' + String.fromCharCode(243));
    if (kap === String.fromCharCode(97) ){return (word + 'nak');} //a
    else if (kap === String.fromCharCode(225) ){return (word + 'nak');} //á
    else if ( kap === String.fromCharCode(243) ){return (word + 'nak');} //ó
    else if ( kap === String.fromCharCode(117) ){return (word + 'nak');} //u
    else if ( kap === String.fromCharCode(111) ){return (word + 'nak');} //o
    else if ( kap === String.fromCharCode(250)) {return (word + 'nak');} //ú
    else {
    } zero++;
    } return (word + 'nek'); 
    } 
console.log(dative('ablak'));
console.log(String.fromCharCode(97) + String.fromCharCode(225) + String.fromCharCode(111) + String.fromCharCode(250) + String.fromCharCode(111) + String.fromCharCode(250) + String.fromCharCode(97) + 'e' + String.fromCharCode(237) + String.fromCharCode(246) + String.fromCharCode(337) + String.fromCharCode(252) + String.fromCharCode(369));
