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
console.log("CLASES EN JAVA SCRIPT");
var Avenger = /** @class */ (function () {
    function Avenger(nombre, poder) {
        this.nombre = nombre;
        this.poder = poder;
    }
    return Avenger;
}());
var AvengerVolador = /** @class */ (function (_super) {
    __extends(AvengerVolador, _super);
    function AvengerVolador() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return AvengerVolador;
}(Avenger));
var hulk = new Avenger("Thor", "trueno");
var falcon = new AvengerVolador("Hulk", "dsfsd");
console.log(hulk);
console.log(falcon);
