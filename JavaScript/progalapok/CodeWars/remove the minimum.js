
function removeByIndex(numbers, minimum) {
  return numbers.filter(function (el, i) {
    return minimum !== i;
  });
};
console.log(removeByIndex([21, 3, 7, 2],2));
