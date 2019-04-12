let tomb = [];

function hozzaad (a, b, c, d, e, f, g, h, i) {
  tomb.push(a, b, c, d, e, f, g, h, i);
  return tomb;
}
// 9 elem hozzáadása a tömbhöz funkcióval

hozzaad(1, 2, 3, 4, 5, 6, 7, 8, 9);
// funkció hívás, elemek értékeadása - lehetne ugye kiscica, nagykutya, bármi...

console.log(tomb[0], tomb[1], tomb[2]);
console.log(tomb[3], tomb[4], tomb[5]);
console.log(tomb[6], tomb[7], tomb[8]);
// 3 sorba kiír, hivatkozás a tömb indexekre

console.log(tomb);
// ellenőrzés - milyen elemek vannak a tömbben :)
