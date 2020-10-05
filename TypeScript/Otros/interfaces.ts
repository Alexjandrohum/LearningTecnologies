console.log("Interfaces en Type Script");

interface Xmens {
    nombre: string;
    regenerar(nombreReal: string): void;
}

function enviarMision(xmen: Xmens) {
    console.log("Enviando a: " + xmen.nombre);
    xmen.regenerar("Logan");
}

let wolverine = {
    nombre: "Wolverine",
    regenerar(x: string) {
        console.log("Se ha regenerado: " + x);
    }
};

enviarMision(wolverine);

class Mutante implements Xmens {
    nombre: string;
    esBueno: boolean;
    regenerar(valor: string) {
        console.log("Regenerando a: " + valor);
    }
}

let superHeroe = new Mutante();
superHeroe.regenerar("Alexjandrohum");


/**
 * INTERFACES PARA LAS FUNCIONES
 */

interface DosNumerosFunc {
    (num1: number, num2: number): number;
}

let sumar: DosNumerosFunc;

sumar = function(a:number, b: number){
    return a + b;
}

console.log("La suma de los dos numeros es: "+sumar(3,6));
