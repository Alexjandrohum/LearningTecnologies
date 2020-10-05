console.log("CLASES EN JAVA SCRIPT");

class Avenger{
    nombre:string;
    poder:string;
    constructor(nombre:string, poder:string){
        this.nombre = nombre;
        this.poder = poder;
    }
}

class AvengerVolador extends Avenger{

}

let hulk = new Avenger("Thor","trueno");
let falcon = new AvengerVolador("Hulk","dsfsd");

console.log(hulk);
console.log(falcon);