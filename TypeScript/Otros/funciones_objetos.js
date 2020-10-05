console.log("FUNCIONES Y OBJETOS");
// Funciones básicas
var heroe = "Flash";
function imprime_heroe() {
    return heroe;
}
var activar_batisenal = function () {
    return "Batiseñal activada.";
};
console.log(imprime_heroe());
console.log(activar_batisenal());
// Paramatros obligatorios en las funciones
function nombreCompleto(nombre, apellido) {
    return nombre + " " + apellido;
}
var nombreHeroe = nombreCompleto("clark", "kent");
console.log(nombreHeroe);
// Parametros opcionales
function nombreCompleto2(nombre, apellido) {
    return nombre + ' ' + apellido;
}
console.log(nombreCompleto2("Alexjandrohum"));
// Parametros REST
function paramRest(nombre) {
    var otros = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        otros[_i - 1] = arguments[_i];
    }
    return nombre + " " + otros.join(" ");
}
var persona1 = paramRest("ALexjandrohum", "Herrera Mendoza", "23", "Programador Junior");
var persona2 = paramRest("Jose Luis", "Carmona Duran", "24", "Programador Senior", "Trabajando");
console.log(persona1);
console.log(persona2);
//Objetos
var personas = {
    nombre: "Alex",
    edad: 23,
    poderes: ["Puede correr", "Puede volar"]
};
// Definir el tipo de Objeto
var usuario = {
    nombre: "Alex",
    apellido: "Hermen",
    edad: 23,
    profesiones: ["programdor", "diseñador"]
};
//Métodos dentro de objetos
var operaciones = {
    suma: function (a, b) {
        return a + b;
    },
    resultado: function () {
        console.log("Resultado de la suma: " + this.suma);
    }
};
var carreras = {
    nombre: "Alex",
    apellido: "Hermen",
    edad: 23,
    profesiones: ["programdor", "diseñador"]
};
// Archivo de salida OutFile
