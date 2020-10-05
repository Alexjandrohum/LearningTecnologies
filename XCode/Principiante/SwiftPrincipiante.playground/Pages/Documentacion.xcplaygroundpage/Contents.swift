//: [Previous](@previous)

import Foundation

/**
 INTRODUCCIÓN DE TEXTO DENTRO DE UNA IMPRECIÓN DINÁMICAMENTE
 */

var myNombre: String = "Alexjandrohum"

print("Mi nombre es: \(myNombre)")// Yehaa ja ja

/**
 SENTENCIA SWITCH
 */

var s = 0
switch 3 {
case s:
    print("Hola 3")
    break
case s:
    print("hola")
    break
default:
    print("Adios")
}

/**
 ARRAYS
 */

let name = "Alexjandrohum"
let apellidos = "Herrera Mendoza"
let edad = "23"

//Inicialización de Arrays
let myArray = Array<String>()
var MyModernArray = [String]()
var myArrayAlternativo: [String] = []
//Agregar datos al array
MyModernArray.append(name)
MyModernArray.append(apellidos)
MyModernArray.append(edad)
print(MyModernArray)

//Añadir un conjunto de datos
MyModernArray.append(contentsOf:["Mira","nada más"])
print(MyModernArray)
print(myArrayAlternativo)

// Acceso a datos
print(MyModernArray[0])
//Modificación de los datoa del Array
MyModernArray[0] = "Alejandro"
print(MyModernArray)
//Eliminar valores
MyModernArray.remove(at: 4)
print(MyModernArray)

//Recorrer los valores
print("** Impresiones **")
for values in MyModernArray {
    print(values)
}

/**
 DICCIONARIOS
 */

 //Sintaxis
let myOldDictionary = Dictionary<String, Int>()//Forma clásica
var myNewDictionary = [String:Int]()//Actual

//Añadir valores
myNewDictionary = ["Alexjandrohum":23, "Maria":24, "Jose Luis":25]
print(myNewDictionary)
//Añadir un dato sin perder los anteriores
myNewDictionary["Moure"] = 003
myNewDictionary["Juan"] = 034234
print(myNewDictionary)
//Acceso a un dato
print(myNewDictionary["Alexjandrohum"])
//Actualizar un dato del diccionario
myNewDictionary["Alexjandrohum"] = 12
print(myNewDictionary)
myNewDictionary.updateValue(13, forKey: "Alexjandrohum")
print(myNewDictionary)

/**
 RECORRIENDO BUCLES EN ARRAYS Y DICCIONARIOS
 */

let myStringArray2 = ["Alexjandrohu","Hermen", "Pablo"]
let myNewDictionary2 = ["Uno":1,"Dos":2,"Tres":3,"Cuatro":4]
//For
for nombres in myStringArray2{
    print(nombres)
}

for numeros in myNewDictionary2{
    print(numeros)
}


/**
 CLASES
 */

class  myClass{
    
    var name: String
    var age: Int
    var languages: [String]
    
    
    init(name:String, age:Int,languages:[String]){
        self.name = name
        self.age = age
        self.languages = languages
    }
}
