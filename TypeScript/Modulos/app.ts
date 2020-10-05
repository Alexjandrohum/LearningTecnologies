import { obtenerPi } from "./validaciones/numeros";
import * as valores from "./validaciones/textos";

console.log("Estructurando módulos de TypeScript");

console.log(obtenerPi());
console.log(valores.mostrarTexto("Alexjandrohum"));

console.log("Edad: " + valores.mostrarEdad());

function regresar<T>(arg: T) {
    return arg;
}

console.log(regresar(124324));

class Cuadrado<T extends number | string>{
    base: T;
    altura: T;
    area(): number {
        return +this.base * +this.altura;
    }
}

let cuadrad0 = new Cuadrado<number | string>();
cuadrad0.altura = "3223";
cuadrad0.base = 234;
console.log(" El Área es: " + cuadrad0.area());

/**
 * DECORADORES DE CLASES
 */

function planVillano(constructor: Function) {
    constructor.prototype.imprimirPlan = function () {
        console.log("El plan de " + this.nombre + " es dominar el mundo.");
    }
}

function imprimible(constructor: Function) {
    constructor.prototype.imprimir = function () {
        console.log(this);
    }
}

@imprimible
@planVillano
class Villanos {
    constructor(public nombre: string) { }
}

let lex = new Villanos("Lex Luthor");
(<any>lex).imprimirPlan();
(<any>lex).imprimir();

console.log("******* DECORADORES EN LOS MÉTODOS **********");

function editable(esEditable: boolean) {
    return function (target: any, nombrePropiedad: string, descriptor: PropertyDescriptor) {
        try {
            descriptor.writable = esEditable;
        } catch (TypeError ) {
            console.log(TypeError);

        }

    }
}

class DecoradoresMetodos {
    constructor(public nombre: string) { }

    @editable(true)
    plan() {
        console.log("Plan de dominar el mundo");
    }
}

let decorador = new DecoradoresMetodos("Nombre");

//decorador.plan();

decorador.plan = function () {
    console.log("Decorador de Flores");
}

try {
    decorador.plan();
} catch (TypeError) {
    console.log(TypeError);

}



