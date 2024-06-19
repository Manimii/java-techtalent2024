let texto = "Texto generado con un evento en JavaScript";

function generaTexto() {
    let textoParrafo = document.getElementById("texto").innerHTML;

    if (textoParrafo == texto) {
        document.getElementById("texto").innerHTML = "";

    } else {
        document.getElementById("texto").innerHTML = texto;
        
    }
}