/**Los prototipos */

// son las caracteristicas que se pueden hacer con un atributo

//FUNCIONES ANÓNIMAS
var a = 10;

(function () {

    console.log(a);
    function cambiarA() {
        a = 20;
    }

    cambiarA();
    console.log(a);

})();


function ejecutarfuncion( fn ){
    fn();
    return true;
};

console.log();

ejecutarfuncion(function(){
    console.log("Funcion anónima ejecutada!");
})


/** */

