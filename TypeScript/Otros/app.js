//tsc app.ts -w => es para inicializar los cambios en tiempo de compilación
//tsc -init => Creará un archivo tsconfig.json que será toda la configuración del proyecto
// tsc *.ts -w
console.log("Hola TypeScript!!!");
/**
 * TIPOS DE DATOS
 */
//BOOLEANS
var esSuperman = true;
var esBatman;
var esAcuaman = true;
if (esSuperman) {
    console.log("Estamos salvados");
}
else {
    console.log("!Ooops! ohh");
}
// NUMBERS
var avengers = 5;
var villanos;
var otros = 2;
//Strings
var cadena = "Alexjandrohum";
var apellido = "HerMen";
var concatenar = "Los datos son: " + cadena + ", " + apellido;
console.log(concatenar);
//Arreglos
var arreglo = [1, 2, 4, 5, 43, 4];
var cadenas2 = ["uno", "dos", "res"];
console.log(cadenas2[0].charAt(0));
// Tuplas
//Nos sirven para especificar reglas de elementos que ya conocemos
var heroe43 = ["dasd", 324];
// Enumeraciones
var Volumen;
(function (Volumen) {
    Volumen[Volumen["min"] = 0] = "min";
    Volumen[Volumen["med"] = 1] = "med";
    Volumen[Volumen["max"] = 2] = "max";
})(Volumen || (Volumen = {}));
var audio = Volumen.min;
console.log(audio);
// Void
function llamada_metodo() {
    console.log("LLamada completa");
}
// Never
function error(mensaje) {
    throw new Error(mensaje);
}
//error("Error crítico.... línea 11..");
// Cast
var cualquierValor = "Cualquier cosa";
var largoDelString = cualquierValor.length;
console.log(largoDelString);
