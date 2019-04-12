function hero (bullets, dragons) {
  let ka = false;
  if ((dragons * 2) <= bullets) {
    ka = true;
  }
  return ka;
}
console.log(hero(4, 5));
