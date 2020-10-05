/**POLIFORMISMO */

//Una funcion que puede recibir varios tipos de datos en una función

function determinarDato(a){
    if(a === undefined){
        console.log("A es undifined... no se que hacer");
    }

    if(typeof a === "number"){
        console.log("A es un numero y puedo hacer operaciones con números");
    }
}

var b = new Number(3);
console.log(b + 10);

determinarDato(4);

//Objetos Strings 
var a  = new String("Alexjandrohum Hermen");

console.log(a[0]);

var b = "Alexjandrohum";

console.log(a.toUpperCase);//Realiza todo en mayúsculas
console.log(a.toLowerCase);//Todo en minúsculas

var i = a.indexOf("l"); //Busqueda de un caracter en el string
console.log("La posición de la letra buscada es: "+i);

 i = a.lastIndexOf("n");
console.log("La posición del ultimo caracter buscado: "+i);
//Para substraer un elemento completo de una cadena de texto desde la última posición hasta la primera
var nombre = a.substr(0, a.indexOf(" "));
console.log(nombre);

var separacion = a.split();
console.log(separacion);

/**
 * FECHAS
 */

 var fecha = new Date();
 var fechaMilisegundo = new Date(2);//Fecha con milisegundos

 /**
  * EXPRECIONES REGULARES
  */

  //var reg1 = RegExp("p");
  var reg2 = /a/;

  var texto = "Hola mundo";

  var arr = texto.match(reg2);
  console.log(arr);

  var buqueda = texto.match(/^O/);//La primera opcion es cualquier caracter
  busqueda = texto.match(/[a-z]/);//Busqueda de rangos
  var busqueda2 = texto.match(/[aeiou].$/);//busqueda de cualquier vocal seguido de cualquier caracter
 var busquedaEspacios = texto.match(/\s/);
    