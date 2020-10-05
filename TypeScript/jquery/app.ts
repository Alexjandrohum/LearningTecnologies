import "jquery";
import "sweetalert";
console.log("Hola mundo");

$(document).ready(function(){
    console.log("Pagina lista y cargada...");
    $("h1").text("Hola Alexjandrohum desde TypeScript");
})

$("#botAlerta").on("click", function(){
    swal("Good job!", "You clicked the button!", "success");
});


