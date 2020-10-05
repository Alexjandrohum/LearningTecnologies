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

let getEmpleado = async (id) => {
    let empleadoDB = empleados.find(empleado => empleado.id === id);
    if (!empleadoDB) {
        throw new Error(`No existe un empleado con el ID ${id}`);
    } else {
        return (empleadoDB);
    }
}

let getSAlario2 = async(empleado) => {
    let salarioDB = salarios.find(salario => salario.id === empleado.id);

    if (!salarioDB) {
        throw new Error(`No se encontró una salario para el empleado con ID ${empleado.id}`);
    } else {
        return({
            nombre: empleado.nombre,
            salario: salarioDB.salario,
            id: empleado.id
        });
    }

}


getEmpleado(2).then(empleado => {
    console.log("Empleado de BD", empleado);

    getSAlario2(empleado).then(resp => {
        console.log(`Èl salario de ${resp.nombre} es de ${resp.salario}$`);
    }, errc => console.log(err));

}, (err) => {
    console.log(err);
});

let getInformacion = async (id) => {
    let empleado = await getEmpleado(id);
    let resp = await getSAlario2(empleado);

    console.log(resp);
    return `${resp.nombre} tiene un salario de ${resp.salario}`;
}

getInformacion(1)
    .then(menasaje => console.log(menasaje))
    .catch(err => console.log(err));