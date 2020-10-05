console.log("Programación Orientada a objetos en Type Script");

class Heroes {
    //Codigo completo
    /*
    public nombre: string;
    public nombreReal: string;

    constructor(nombre: string, nombreReal: string) {
        this.nombre = nombre;
        this.nombreReal = nombreReal;
    }
    */
    //Código optimizado

    

    constructor(public nombre: string, private nombreReal: string) {
        console.log("Constructor de Avenger llamado");
    }

    protected getNombre():string{
        return this.nombre;
    }
}

class Xmen extends Heroes{

    constructor( a:string, b:string){
        console.log("Constructor Xmen llamado");
        super(a, b);
    }

    public getValor():string{
        return super.getNombre();
    }

}

//Forma completa de acceder e instanciar a las clases
//let heroeName: Heroes = new Heroes("Batman", "Jose");
//Forma optimizada
let heroeName = new Xmen("Batman", "Jose"); 


console.log(heroeName);

console.log(heroeName.getValor());