window.onload = function() {
    let valores = [true, 5, false, "hola", "adios", 2];

    // 1.
    if (valores[3] > valores[4]) {
        console.log(valores[3] + " es mayor");

    } else {
        console.log(valores[4] + " es mayor");
    }

    // 2.
    console.log(valores[0] || valores[2]);
    console.log(valores[0] && valores[2]);

    // 3.
    console.log(valores[1] + " + " + valores[5] + " = " + (valores[1] + valores[5]));
    console.log(valores[1] + " - " + valores[5] + " = " + (valores[1] - valores[5]));
    console.log(valores[1] + " / " + valores[5] + " = " + (valores[1] / valores[5]));
    console.log(valores[1] + " * " + valores[5] + " = " + (valores[1] * valores[5]));
    console.log(valores[1] + " % " + valores[5] + " = " + (valores[1] % valores[5]));
}