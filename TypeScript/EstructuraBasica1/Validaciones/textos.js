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
