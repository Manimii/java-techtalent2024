let texto;

function getText() {
    texto = document.getElementById('ocultar').innerHTML;
    console.log(texto);
}

function ocultar() {
    document.getElementById('ocultar').style='display:none';
}

function mostrar() {
    document.getElementById('ocultar').style='display:block';
}