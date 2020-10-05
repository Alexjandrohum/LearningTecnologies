//tsc app.ts -w => es para inicializar los cambios en tiempo de compilación
//tsc -init => Creará un archivo tsconfig.json que será toda la configuración del proyecto
// tsc *.ts -w

console.log("Hola TypeScript!!!");

/**
 * TIPOS DE DATOS
 */

 //BOOLEANS

 let esSuperman:boolean = true;
 let esBatman: boolean;
 let esAcuaman:boolean = true;

 if(esSuperman){
     console.log("Estamos salvados");
 }else{
     console.log("!Ooops! ohh");
 }

 // NUMBERS

 let avengers:number = 5;
 let villanos:number;
 let otros = 2;

 //Strings

 let cadena:string = "Alexjandrohum";
 let apellido:string = "HerMen";

let concatenar:string = `Los datos son: ${cadena}, ${apellido}`;

console.log(concatenar);

//Arreglos

let arreglo:number[] = [1,2,4,5,43,4];

let cadenas2:string[] = ["uno","dos","res"];

console.log(cadenas2[0].charAt(0));

// Tuplas
//Nos sirven para especificar reglas de elementos que ya conocemos
let heroe43:[string, number] = ["dasd",324];

// Enumeraciones

enum Volumen{
    min,
    med,
    max
}

let audio:number = Volumen.min;
console.log(audio);


// Void

function llamada_metodo():void{
    console.log("LLamada completa");
}

// Never

function error(mensaje:any):never{
    throw new Error(mensaje);
}

//error("Error crítico.... línea 11..");

// Cast

let cualquierValor:any = "Cualquier cosa";
let largoDelString:number = (<string>cualquierValor).length;
console.log(largoDelString);