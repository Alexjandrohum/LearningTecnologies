
let getUsuarioById = (id, callback) => {
    let usuario = {
        nombre: "Alex",
        id
    }

    callback(usuario);
}

getUsuarioById(10, (usuario) =>{
    console.log("El usuario de la base de datos", usuario);
});