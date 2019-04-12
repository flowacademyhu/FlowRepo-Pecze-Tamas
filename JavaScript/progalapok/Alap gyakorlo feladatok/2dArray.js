function sleep (miliseconds) {

  var currentTime = new Date().getTime();



  while (currentTime + miliseconds >= new Date().getTime()) {

  }

}

let dinoArray = (ertek) => {

  let bigArray = [];



  for (let i = 0; i < 10; i++) {

    let smallArray = [];

    for (let j = 1; j < 31; j++) {

      smallArray.push(' ');

    }

    smallArray[0] = ertek;

    bigArray.push(smallArray.join(' '));

  }

  console.log(bigArray);

  sleep(1000);

};

let ertek = 0;

while (ertek < 3000) {

  console.clear();

  ertek++;

  dinoArray(ertek);

}