const osszeadas = (a,b) => { //arrow function
    let eredmeny = a + b;
    return eredmeny;
};
//nem hasznaljuk mert maradi
function kivonas (a, b) { // Aztan amikor megadod akkor az bemeneti konzekvens
    let eredmeny = a - b;
    return eredmeny;
}
const szorzas = (a,b) => a*b; // roviditett forma

let pelda1 = osszeadas(1,5);//bemeneti argumentum az a, b.
let pelda2 = osszeadas(6,77);
let pelda3 = kivonas(7,1);
let pelda4 = szorzas(6,2);
console.log(pelda1);
console.log(pelda2);
console.log(pelda3);


console.log(pelda4)


const hello = (name) => {
    console.log(`helo ${name}!`);//procedura, fuggveny (ez specko nincs RETURN VALUE)
};

hello('Szandra');

const hello6 = (name = `Bela`) => { //forditott ` ' - hulye jel esc alatt
console.log(`hello ${name}! :)`); 
};

hello6();
hello6('lala');

const kisebb = (ez, ennel) =>{
    if(ez<ennel){
    return true;
    }else{
        return false;
    }
}
console.log(kisebb(2,3));