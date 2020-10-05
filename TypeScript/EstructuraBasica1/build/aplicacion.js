var Validaciones;
(function (Validaciones) {
    function validarFecha(fecha) {
        if (isNaN(fecha.valueOf())) {
            return false;
        }
        return true;
    }
    Validaciones.validarFecha = validarFecha;
})(Validaciones || (Validaciones = {}));
var Validaciones;
(function (Validaciones) {
    function validarTexto(texto) {
        if (texto.length < 3) {
            return true;
        }
        return false;
    }
    Validaciones.validarTexto = validarTexto;
    function mostrarText() {
        return "Hola Alexjandrohum";
    }
    Validaciones.mostrarText = mostrarText;
})(Validaciones || (Validaciones = {}));
console.log("Holaaa TypeScript");
console.log(Validaciones.mostrarText());
