/**FUNCIONES TYPEOF  E INSTANCEOF */

console.log("FUNCIONES TYPEOF E INSTANCEOF");

function identifica(param){
    console.log(typeof param);
    console.log(param instanceof Persona);
}

function Persona(){
    this.nombre = "Alexjandrohum";
    this.edad = 30;
}

var alexjandrohum = new Persona();

identifica( alexjandrohum);

console.log("ARREGLOS");

var arreglo = [5,6,4,6,3,6,];
console.log(arreglo);

console.log("Posicion "+ arreglo[3]);

/**Para colocar todos los números al reves de todo el arreglo */
arreglo.reverse();

console.log(arreglo);

/**Funcion MAP regresa un arreglo  */

arreglo = arreglo.map( function(elem){
    elem *= 2;
    return elem;
});

console.log(arreglo);

arreglo = arreglo.map( Math.sqrt);

//lo convierte en un string y coloca entre ello lo qu queramos
arreglo = arreglo.join("-");

//Para cortar una cadena
arreglo = arreglo.split("-");


//Como agregar mas elementos al arreglo
//agrega el elemento al último
arreglo.push("6");
//Agregar elementos al principio
arreglo.unshift("0");
console.log(arreglo);

//Conversión a string 
console.log(arreglo.toString());

//Eliminar el ultimo elemento del arreglo
var eliminar = arreglo.pop();

//eliminar un elemento(s)
//en que posiscion y cuantos elementos
arreglo.splice(1,1);
console.log(arreglo);
//Agregar elementos despues de las dos posiciones
arreglo.splice(1,1,354,234,54);
console.log("arreglo");

//cortar algo especificamente
//Cortar un rango de elementos
arreglo.slice(1,2);

//AGREGANDO VALORES A UN ARREGLO

var arr = [
    true,
    {
        nombre: "Alejandro",
        apellido: "Herrera"
    }, 
    function(){
        console.log("Estoy dentro de un arreglo");
    }
];

console.log(arr);
console.log(arr[0]);
console.log(arr[1]);
console.log(arr[1].nombre);
console.log(arr[2]);
console.log(arr[2]());

