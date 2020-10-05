let getNombre = async () => 'Alexjandrohum';

getNombre().then(nombre => {
    //Lanzamiento del error
    //throw new Error('No existe un nombre para ese Usuario');
    console.log(nombre);
})
    .catch(e => {
        console.log('Error de ASYNC', e);
    });

console.log(getNombre());

let getName = async () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('Alejandro');
        }, 3000);

    });
}

let saludo = async() =>{
    let nombre = await getName();
    return `Hola ${nombre}`;
}

saludo().then(mensaje =>{
    console.log(mensaje);
})