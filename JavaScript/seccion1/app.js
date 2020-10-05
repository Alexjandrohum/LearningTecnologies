var a  = 12;
var b = "Alexjandrohum";

/*TIPOS DE SALIDA A CONSOLA*/
console.log(b);
console.warn(b);
console.info(b);
console.error(b);

/*Declaración de los objetos*/
var obj = {
    numero :23,
    texto: "Alexjandrohum"
};

console.log(obj);

/**Un objeto dentro de otro objeto */
var obj2 = {
    numero: 34,
    apellido: "Herrera",
    objHijo: {
        ciudad: "Mexico",
        calle: "septiembre",
        numero: 16
    }
}
console.log(obj2);

/**Ingresando a datos de los objetos */
console.log("***** INGRESANDO A LOS OBJETOS *****");

var persona = {
    nombre: "ALex",
    apellido: "Herrera",
    ciudad: {
        pueblo: "Cuapiaxtla",
        localidad: "Cardenas"
    }
};

console.log(persona);
console.log(persona.ciudad);
console.log(persona.ciudad.zip = 234234);
console.log(persona);
console.log(persona.ciudad.zip);

console.log("*** ACCESO A INFORMACION DE UN OBJETO DE FORMA DINÁMICA ***");

var elementoSeleccionado = "apellido";

console.log(persona[elementoSeleccionado]);