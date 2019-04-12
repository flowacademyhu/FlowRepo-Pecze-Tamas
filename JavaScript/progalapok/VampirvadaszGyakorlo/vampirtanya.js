//  Ha minden golyó betalál, Samnek hány tölténye marad az egy tárral maximálisan lelőhető vámpírok után?
let noiVampir = 2;
let noiVampirSzam = 3;
let himVampir = 4;
let himVampirSzam = 8;
let alphaVampir = 12;
let alphaVampirSzam = 1;
let samLoszere = 8;

if  (samLoszere > 2 && noiVampirSzam > 0){
  samLoszere = samLoszere-2;
  noiVampirSzam = noiVampirSzam-1;
    // van 6 loszer es 2 no
    if(samLoszere>2 && noiVampirSzam>0){
    samLoszere=samLoszere-2;
    noiVampirSzam=noiVampirSzam-1;
    // van 4 loszer es 1 no
    }
    else{}

    if(samLoszere>2 && noiVampirSzam>0){
    samLoszere=samLoszere-2;
    noiVampirSzam=noiVampirSzam-1;
    // van 2 loszer es 0 no
}else{}

    if(samLoszere>2 && noiVampirSzam>0){
    // mivel az es feltetel nem teljesul (nulla no) nem lep be az if-be
    samLoszere=samLoszere-2;
    noiVampirSzam=noiVampirSzam-1;
}else{}

if(samLoszere>4 && himVampirSzam>0){
    //ellenorzes, hogy van-e loszer a himVampirra
    samLoszere=samLoszere-4;
    himVampirSzam=himVampirSzam-1;
}else{}

if(samLoszere>4 && alphaVampirSzam>0){
    //ellenorzes, hogy van e loszer az alphaVampirra
    samLoszere=samLoszere-8;
    alphaVampirSzam=alphaVampirSzam-1;
}else{}
}else{}
console.log('Samnek ennyi loszere maradt: '+samLoszere);
