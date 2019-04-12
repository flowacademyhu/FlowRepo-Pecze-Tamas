function abbrevName (name) {
  let szar = name.search(/\s/);
  return (name[0].toUpperCase() + '.' + name[szar + 1].toUpperCase());
}
console.log(abbrevName('pecze Tamas'));
