const delimiter = 'z';
const shuffleDelimiter = 'y';
const iterations = 10;
const shufflePrefixMultiplier = 200;

function encrypt(str, key) {
  let resultSet = new Array();
  let shuffled = shuffle(str, iterations);
  console.log(shuffled);
  let shufflePrefix = new Array();
  for (i = 0; i < shuffled.length; i++) {
    numericEncrypted = encrpytByChar(str.charCodeAt(shuffled[i]), key, i + 2);
    strEncrypted = numericEncrypted.toString(22);
    resultSet.push(strEncrypted);
    numericShufflePrefix = shuffled[i] * shufflePrefixMultiplier;
    shufflePrefix.push(numericShufflePrefix.toString(16));
  }
  return (
      shufflePrefix.join(delimiter) + shuffleDelimiter +
      resultSet.join(delimiter));
}

function encrpytByChar(num, key, index) {
  return num * Math.pow(key, index);
}

function decrpyt(str, key) {
  let parts = str.split(shuffleDelimiter);
  let shuffledEncrypted = parts[0].split(delimiter);
  let shuffled = new Array();
  for (i = 0; i < shuffledEncrypted.length; i++) {
    shuffled.push(parseInt(shuffledEncrypted[i], 16) / shufflePrefixMultiplier);
  }
  let shuffledReverse = new Array();
  console.log(shuffled);
  for (i = 0; i < shuffled.length; i++) {
    shuffledReverse.push(shuffled.indexOf(i));
  }
  console.log(shuffledReverse);
  let chunks = parts[1].split(delimiter);
  let result = '';

  for (i = 0; i < shuffled.length; i++) {
    numericDecrypted = parseInt(chunks[i], 22);
    aChar = decryptByChar(numericDecrypted, key, i + 2);
    result += String.fromCharCode(aChar);
  }
  return result;
}

function decryptByChar(chunk, key, index) {
  return chunk / Math.pow(key, index);
}

function shuffle(arr, iter) {
  let indexAt = new Array();
  for (i = 0; i < arr.length; i++) {
    indexAt.push(i);
  }
  for (i = 0; i < iter; i++) {
    randIndex1 = generateRandomNumber(0, arr.length - 1);
    randIndex2 = generateRandomNumber(0, arr.length - 1);
    temp = indexAt[randIndex1];
    indexAt[randIndex1] = indexAt[randIndex2];
    indexAt[randIndex2] = temp;
  }
  return indexAt;
}

function generateRandomNumber(min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}

key = 12;
str = 'aaaavvv';
result = encrypt(str, key);
/*expected =
  "3e8zc8z0z320z190z258z4b0y1d28zfg6kz8cjgkz5f7be8z2c498ekz18e92g2kzk7b19648";
if (result != expected) {
  console.log("Result isn't the expected");
  console.log("Result: " + result);
  console.log("Expected: " + expected);
}*/

result = decrpyt(result, key);
if (result != str) {
  console.log('Result isn\'t the expected');
  console.log('Result: ' + result);
  console.log('Expected: ' + str);
}

shuffle([3, 4, 2, 5, 7, 3], 10);
