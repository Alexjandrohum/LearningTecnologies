var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
console.log("Programación Orientada a objetos en Type Script");
var Heroes = /** @class */ (function () {
    //Codigo completo
    /*
    public nombre: string;
    public nombreReal: string;

    constructor(nombre: string, nombreReal: string) {
        this.nombre = nombre;
        this.nombreReal = nombreReal;
    }
    */
    //Código optimizado
    function Heroes(nombre, nombreReal) {
        this.nombre = nombre;
        this.nombreReal = nombreReal;
        console.log("Constructor de Avenger llamado");
    }
    Heroes.prototype.getNombre = function () {
        return this.nombre;
    };
    return Heroes;
}());
var Xmen = /** @class */ (function (_super) {
    __extends(Xmen, _super);
    function Xmen(a, b) {
        var _this = this;
        console.log("Constructor Xmen llamado");
        _this = _super.call(this, a, b) || this;
        return _this;
    }
    Xmen.prototype.getValor = function () {
        return _super.prototype.getNombre.call(this);
    };
    return Xmen;
}(Heroes));
//Forma completa de acceder e instanciar a las clases
//let heroeName: Heroes = new Heroes("Batman", "Jose");
//Forma optimizada
var heroeName = new Xmen("Batman", "Jose");
console.log(heroeName);
console.log(heroeName.getValor());
