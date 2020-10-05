/**Creacion de una cookie */

//document.cookie = "nombre=Alexjandrohum";

var cookies = document.cookie;

//console.log(cookies);





function crearCookie(nombre, valor) {
    // COlocar una fecha de expiración
    var hoy = new Date();
    hoy.setMonth(hoy.getMonth() + 1);
    document.cookie = nombre + "=" + valor;
}

/**
 * FUNCIONES ESPECIALES
 */

// BIND 
var carro = {
    color: "Blanco",
    marca: "Mazda",
    imprimir: function () {
        var salida = this.marca + " - " + this.color;
        return salida;
    }
}

console.log(carro.imprimir());

var logCarro = function (arg1, arg2) {
    console.log("Carro: ", this.imprimir());
}

//logCarro(); this imprimir is not function

var logModeloCarro = logCarro.bind(carro);
logModeloCarro("dato1", "dato2");

logModeloCarro.call(carro, "d1", "d2");
logModeloCarro.apply(carro, ["wqe", "eqwe"]);


//FUNCIONES PRESTADAS
//Para poder alcanzar otras caracteristicas de otro objeto ya definido

//CONDICIONALES TERNARIAS

var a = 30;
var b = 20;

var c = (a > b) ? function () {
    console.log("A es mayor que B");
    return a;
}() : function () {
    return b;
}()

//console.log(c);

c = (a > b) ? true : false;

//console.log(c);


// SWITH

var mes = 2;

switch (mes) {
    case 1:
        console.log("Enero");
        break;
    case 2:
        console.log("Febrero");
        break;
    case 2:
        console.log("Febrero");
    default:
        console.log("Cualquier otro mes");

}


//TRABJANDO CON JSON

var objetosJS = {
    nombre: "Alexjandrohum",
    edad: 23
};

console.log("Objeto literal: " + objetosJS);

// Parseando de un objeto a una estructura JSON
var jsonString = JSON.stringify(objetosJS);

console.log(jsonString);

// Parsear de un JSON a un objeto

var objetoDesdeJSON = JSON.parse(jsonString);
console.log(objetoDesdeJSON);

//Accediendo a los datos del objeto parseado desde JSON

console.log("Nombre Usuario: " + objetoDesdeJSON.nombre);


// FOR IN

var Persona = function () {
    this.nombre = "Juan";
    this.apellido = "Pineda";
    this.edad = 21;
};

//Instanciar el objeto
var juan = new Persona();

//Agregando una propiedad al objeto
Persona.prototype.direccion = "16 de septiembre";

for (prop in juan) {
    if (!juan.hasOwnProperty(prop)) {
        continue;
    }
    console.log(prop, ":", juan[prop]);
}

//Para evaluar los valores de los arreglos

[1, 2, 4, false, "dasf", 35].forEach(function (val) {
    //console.log(val);
});

// ROTULANDO CICLOS
console.log("ROTULANDO CICLOS");
for_principal:
for (var i = 1; i <= 5; i++) {
    console.log("i", i);

    for (var j = 1; j <= 5; j++) {
        console.log("j", j);
        continue for_principal;
    }
}

console.log("FUNCIONES DE TIEMPO");

setTimeout(function(){
    console.log("Paso un segundo");
}, 1000);

var segundos = 0;
var intervalo = setInterval(function(){
    segundos ++;
    console.log("seg",segundos);

    if(segundos === 3){
        clearInterval(intervalo);
    }
},1000);

var juan = {
    nombre: "ALexjandrohum",
    edad: 23,
    imprimir: function(){
        var self = this;
        setTimeout(function(){
            console.log(self);
            console.log(self.nombre, self.edad);
        },1000);
    }
};

juan.imprimir();