import UIKit

//Sintaxis Enumeración

enum PersonalData{
    case name
    case surname
    case address
    case phone
    // case, name, surname, address, phone
    //De esa forma también lo podemos definir
}

var currentData: PersonalData = .name
var input = "Brais"

currentData = .phone
input = "66666"

//Enumeraciones con valores asociados
 
enum complexPersonalData{
    case name(String)
    case surname(String, String)
    case address(String, Int)
    case phone(Int)
}

var complexCurrentData: complexPersonalData = .name("Alejandro")
complexCurrentData = .address("Privada 16 de septiembre", 0)

//Enumeraciones con el mismo tipo de valor

enum RawPersonalData: String{
    case name = "Nombre"
    case surname = "Apellidos"
    case address = "Dirección"
    case phone = "Número de celular"
}

RawPersonalData.phone.rawValue

//Protocolos genéricos
//Protocoloes delegados
