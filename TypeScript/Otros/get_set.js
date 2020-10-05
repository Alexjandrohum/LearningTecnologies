console.log("Getters and Setters en Type Script");
var Persona = /** @class */ (function () {
    function Persona(nombre, apellido, edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    Object.defineProperty(Persona.prototype, "name", {
        get: function () {
            return this.nombre;
        },
        set: function (nombre2) {
            this.nombre = nombre2;
        },
        enumerable: false,
        configurable: true
    });
    return Persona;
}());
var persona = new Persona("ALexjandrohum", "Hermen", 23);
console.log(persona.name);
persona.name = "Alejandro";
console.log(persona.name);
