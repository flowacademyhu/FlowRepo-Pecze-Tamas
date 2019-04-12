function areYouPlayingBanjo (name) {
  let regex1 = RegExp('^R|^r');
  if (regex1.test(name) === true) {
    return name + ' plays banjo';
  } else {
    return name + ' does not play banjo';
  }
}
console.log(areYouPlayingBanjo('Martin'));
