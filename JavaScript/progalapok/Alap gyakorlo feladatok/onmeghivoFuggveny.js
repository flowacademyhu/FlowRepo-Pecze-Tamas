function countSheeps (arrayOfSheep) {
  let counter = 0;
  console.log(arrayOfSheep);
  for (let i = 0; i < arrayOfSheep.length; i++) {
    console.log(counter);
    if (arrayOfSheep[i] === true) {
      counter++;
      console.log(counter);
    }
  }
  return ('There are ' + counter + ' sheeps in total');
}
console.log(countSheeps([true, true]));
