let empleados = [{
    id: 1,
    nombre: 'Alexjandrohum'
}, {
    id: 2,
    nombre: "Maria"
}, {
    id: 3,
    nombre: 'Juan'
}];

let salarios = [{
    id: 1,
    salario: 1000
}, {
    id: 2,
    salario: 2000
}];

let getEmpleado = (id) => {
    return new Promise((resolve, reject) => {
        let empleadoDB = empleados.find(empleado => empleado.id === id);
        if (!empleadoDB) {
            reject(`No existe un empleado con el ID ${id}`);
        } else {
            resolve(empleadoDB);
        }
    })
}

getEmpleado(1).then(empleado => {
    console.log("Empleado de BD", empleado);
}, (err) => {
    console.log(err);
});



let getSAlario2 = (empleado) => {
    return new Promise((resolve, reject) => {
        let salarioDB = salarios.find(salario => salario.id === empleado.id);

        if (!salarioDB) {
            reject(`No se encontró una salario para el empleado con ID ${empleado.id}`);
        } else {
            resolve({
                nombre: empleado.nombre,
                salario: salarioDB.salario,
                id: empleado.id
            });
        }
    });
}


getEmpleado(2).then(empleado => {
    console.log("Empleado de BD", empleado);

    getSAlario2(empleado).then(resp => {
        console.log(`Èl salario de ${resp.nombre} es de ${resp.salario}$`);
    }, errc => console.log(err));

}, (err) => {
    console.log(err);
});

/**
 * PROMESAS ANIDADAS O EN CADENA
 */
console.log("PROMESAS ANIDADAS")

getEmpleado(20).then(empleado => {
    return getSAlario2(empleado);
})
    .then(resp => {
        console.log(`El salario de ${resp.nombre} es de ${resp.salario}`);
    })
    .catch(err =>{
        console.log(err);
    })


