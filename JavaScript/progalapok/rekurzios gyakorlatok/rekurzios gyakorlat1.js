let arr1 = [1, 2, 3, 4, 5];

let funkcio = (szam) => {
  let arr2 = [];
  for (let i = 0; i < szam.length - 1; i++) {
    arr2.push(szam[i] + szam[i + 1]);
  }
  if (arr2.length > 1) {
    funkcio(arr2);
  }
  console.log(arr2);
};
funkcio(arr1);
