let la = ['sheep', 'sheep', 'sheep', 'sheep', 'sheep', 'wolf', 'sheep', 'sheep'];
console.log(warnTheSheep(la));

function warnTheSheep (queue) {
  if (queue[queue.length - 1] === 'wolf') {
    return 'Pls go away and stop eating my sheep';
  }
  for (let i = 0; i < queue.length - 1; i++) {
    if (queue[i] === 'wolf') {
      return 'Oi! Sheep number ' + ((queue.length - 1) - i) + '! You are about to be eaten by a wolf!';
    }
  }
}
