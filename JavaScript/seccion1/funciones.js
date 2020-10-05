/**Declaracion de funciones */

function primeraFuncion(){
    var a = 20;
    console.log("mi Primera funcion, valor de a: "+a);
}

primeraFuncion();

/**Funciones con parametros */

function imprimirFunction( parametro1, parametro2){
    console.log("Parametro1: "+parametro1 + " Parametro2: "+parametro2);
}

imprimirFunction("Alejandro", "Herrera");

/**Retorno de las funciones  */
function retornandoAlgo(a, b){
    return a + b;
}

console.log(retornandoAlgo(34,2));