let arr = [1, 5, 150, 41, 2, 8];
const funkcio = (arr) => {
  for (let i = 0; i <= arr.length; i++) {
    // arr lenght ugye 6 lenne, de nekunk 0-5 ig mennek az indexek. 5x fut le igy ez
    for (let j = 0; j < arr.length - i - 1; j++) {
      if (arr[j] < arr[j + 1]) { // 111 > 5
        let temp = arr[j]; // temp felveszi az arr[j] erteket (temp = 111);
        arr[j] = arr[j + 1]; // arr[j] felveszi az arr[j+1] erteket : 111 helyett az a[j] = 5 lesz.
        arr[j + 1] = temp; // az arr[j+1] pedig felveszi a temp erteket ami a 111.
        console.log(arr);
        /* temp leadja az erteket az arr[j]-nek, majd az arr[j] felveszi az arr[j+1] erteket
        es vegul az arr[j+1] felveszi a temp erteket.
        Eloszor ellenorzi az elso 4 szamot (plussz az otodiket is az j+1 nek koszonhetoen)
        Majd masodjara 3+1 szamot, majd 2+1 szamot majd 1+1 szamot majd 0+1 szamot es minden
        alkalommal csereli oket ha kell a temp ideiglenes "bogre" segitsegevel */
      }
    }
    console.log(arr);
  }
  return arr;
};
console.log(funkcio(arr));
