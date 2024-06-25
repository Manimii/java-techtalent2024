window.onload = function() {

    console.log(esPar(10));
    console.log(esPar(11));
    console.log(esPar(2));
    console.log(esPar(5));
    console.log(esPar(0));
    console.log(esPar(1));
    console.log(esPar(2));

    function esPar(n) {
        let mensaje = "";
        if (n % 2 === 0) {
            mensaje = n + " es un número par.";

        } else {
            mensaje = n + " es un número impar.";
        }

        return mensaje;
    }
}