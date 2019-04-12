function elevator (left, right, call) {
  if (call === 0) {
    if (right <= left) {
      return 'right';
    } else {
      return 'left';
    }
  } else if (call === 1) {
    if (left === 1 && right !== 1) {
      return 'left';
    } else {
      return 'right';
    }
  } else {
    if ((left - 2) <= (right - 2)) {
      return 'right';
    } else {
      return 'left';
    }
  }
}
console.log(elevator(1, 0, 0));
