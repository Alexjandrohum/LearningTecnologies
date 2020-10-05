console.log("Getters and Setters en Type Script");

class Persona {
    public nombre: string;
    private apellido: string;
    private edad: number;

    constructor(nombre: string, apellido: string, edad: number) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    get name():string{
        return this.nombre;
    }
    set name(nombre2:string){
        this.nombre = nombre2;
    }
}

let persona = new Persona("ALexjandrohum", "Hermen", 23);

console.log(persona.name);
persona.name = "Alejandro";
console.log(persona.name);