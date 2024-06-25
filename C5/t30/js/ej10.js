window.onload = function () {

    console.log(esPalindromo("amor a roma"));
    console.log(esPalindromo("Hola Mundo!"));
    console.log(esPalindromo("sé verlas al revés"));

    function esPalindromo(s) {
        let mensaje = "";
        let reversed = s.split("").reverse().join("");
        reversed = reversed.split(" ").join("");
        let stringSplit = s.split(" ").join("");

        if (reversed === stringSplit) {
            mensaje = s + ": es un palíndromo.";

        } else {
            mensaje = s + ": no es un palíndromo.";
        }

        return mensaje;
    }
}