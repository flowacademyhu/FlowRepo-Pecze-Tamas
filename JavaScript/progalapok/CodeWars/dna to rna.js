function DNAtoRNA (dna) {
  let ujErt = '';
  for (let i = 0; i < dna.length; i++) {
    if (dna[i] === 'T') {
      ujErt += 'U';
    } else {
      ujErt += dna[i];
    }
  }
  return ujErt;
}
console.log(DNAtoRNA('KEKT'));
