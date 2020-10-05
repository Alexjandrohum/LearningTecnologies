console.log("FUNCIONES Y OBJETOS");

// Funciones básicas

let heroe: string = "Flash";

function imprime_heroe(): string {
    return heroe;
}

let activar_batisenal = function (): string {
    return "Batiseñal activada.";
}

console.log(imprime_heroe());
console.log(activar_batisenal());

// Paramatros obligatorios en las funciones
function nombreCompleto(nombre: string, apellido: string): string {
    return nombre + " " + apellido;
}

let nombreHeroe = nombreCompleto("clark", "kent");
console.log(nombreHeroe);

// Parametros opcionales

function nombreCompleto2(nombre: string, apellido?: string): string {
    return nombre + ' ' + apellido;
}

console.log(nombreCompleto2("Alexjandrohum"));

// Parametros REST

function paramRest(nombre: string, ...otros: string[]): string {
    return nombre + " " + otros.join(" ");
}

let persona1: string = paramRest("ALexjandrohum", "Herrera Mendoza", "23", "Programador Junior");
let persona2: string = paramRest("Jose Luis", "Carmona Duran", "24", "Programador Senior", "Trabajando");

console.log(persona1);
console.log(persona2);

//Objetos

let personas = {
    nombre: "Alex",
    edad: 23,
    poderes: ["Puede correr", "Puede volar"]
};

// Definir el tipo de Objeto

let usuario: { nombre: string, apellido: string, edad: number, profesiones: string[] } = {
    nombre: "Alex",
    apellido: "Hermen",
    edad: 23,
    profesiones: ["programdor", "diseñador"]
};

//Métodos dentro de objetos

let operaciones: { suma: (a: number, b: number) => number, resultado: () => void } = {
    suma(a, b) {
        return a + b;
    },
    resultado() {
        console.log("Resultado de la suma: " + this.suma);
    }
};

// Tipos personalizados
type Profesionistas = {
    nombre: string,
    apellido: string,
    edad: number,
    profesiones: string[]
}

let carreras: Profesionistas = {
    nombre: "Alex",
    apellido: "Hermen",
    edad: 23,
    profesiones: ["programdor", "diseñador"]
}

// Archivo de salida OutFile

