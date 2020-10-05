console.log("Interfaces en Type Script");
function enviarMision(xmen) {
    console.log("Enviando a: " + xmen.nombre);
    xmen.regenerar("Logan");
}
var wolverine = {
    nombre: "Wolverine",
    regenerar: function (x) {
        console.log("Se ha regenerado: " + x);
    }
};
enviarMision(wolverine);
var Mutante = /** @class */ (function () {
    function Mutante() {
    }
    Mutante.prototype.regenerar = function (valor) {
        console.log("Regenerando a: " + valor);
    };
    return Mutante;
}());
var superHeroe = new Mutante();
superHeroe.regenerar("Alexjandrohum");
var sumar;
sumar = function (a, b) {
    return a + b;
};
console.log("La suma de los dos numeros es: " + sumar(3, 6));
