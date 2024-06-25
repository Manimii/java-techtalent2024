window.onload = function () {
    let letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
    let mensaje = "";
    const input = document.getElementById("dni");
    const output = document.getElementById("result");

    document.getElementById("submit").addEventListener("click", function() {calcularLetra()});

    function calcularLetra() {
        let inputLength = input.value.length;
        let slicedLetter = input.value.slice(inputLength - 1);
        let num = Number(input.value.slice(0, inputLength - 1));

        if (num < 0 || num > 99999999) {
            mensaje = "El número proporcionado no es válido.";

        } else {
            let indexLetra = num % 23;
            let letra = letras[indexLetra];

            if (letra == slicedLetter) {
                mensaje = "El número y la letra del DNI son correctos."

            } else {
                mensaje = "La letra que has indicado no es correcta.";
            }

        }

        output.innerHTML = mensaje;

    }
}