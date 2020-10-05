
function Jugador(nombre) {
    this.nombre = nombre;
    this.pv = 100;
    this.sp = 100;

    this.curar = function (jugadorObjetivo) {

        if (this.sp > 40) {
            this.sp -= 40;
            jugadorObjetivo.pv += 20;
        } else {
            console.log(this.nombre + " no tiene sp suficiente");
        }

    }
};

var gandalf = new Jugador("Gandalf");
var legolas = new Jugador("Legolas");

console.log(gandalf);
console.log(legolas);

gandalf.curar(legolas);

console.log(gandalf);
console.log(legolas);