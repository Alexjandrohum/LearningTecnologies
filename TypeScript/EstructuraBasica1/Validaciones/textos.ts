namespace Validaciones {
    export function validarTexto(texto: string): boolean {
        if (texto.length < 3) {
            return true;
        }

        return false;
    }

    export function mostrarText():string{
        return "Hola Alexjandrohum";
    }
}

// npm install systemjs@0.19.41
//  npm install systemjs
// npm install systemjs@0.19.41
