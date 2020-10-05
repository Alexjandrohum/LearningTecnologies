    function evento(arg){
        console.log("Me disparé");
        console.log(arg);
    }

    function eventoDobleClick(){
        console.log("Doble click");
    }

    // Agregar eventos desde JavaScript

    var objeto = document.getElementById("inputId");

    objeto.addEventListener("click", evento);

    function validar(){
        var nombre = document.getElementById("txtNombre").value;
        var apellido = document.getElementById("txtApellido").value;
        if(nombre.length < 1){
            return false;
        }
        if(apellido.length < 1){
            return false;
        }
        return true; 
    }