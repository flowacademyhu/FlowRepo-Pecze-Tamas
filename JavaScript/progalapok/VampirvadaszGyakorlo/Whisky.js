// Sam vagy Dean lőtt le több vámpírt, ha Deannek minden harmadik lövése félrement a sok wiskeytől?
let SL = 24; // Sam loszere
let DL = 40; // Dean loszere es talata
const Pia = 0.66; // Minden harmadik loves miss
let Whiskey = () => {
  let sum = DL * Pia;
  return sum;
};
console.log(Whiskey() + ' szemelyt tud eltalalni bepialva Dean.');

if (Whiskey() > SL) {
  console.log(`Dean bepialva is tobbet lott le mint Sam.`);
} else {
  console.log(`Dean bepialva is kevesebbet lott le mint Sam.`);
}
