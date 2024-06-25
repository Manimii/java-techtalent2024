window.onload = function(){
    // variables
    let estado = 0; // 0 -> 1 operando; 1 -> 2 operandos
    let op1 = 0;
    let op2 = 0;
    let op1Length = 0;
    let operador = "";

    // elmentos #display
    const display = document.getElementById("inputDisplay");
    const output = document.getElementById("output");

    // Event Listeners del cuerpo de la calculadora
    botonNumeros(); // numeros
    document.getElementById("delete").addEventListener("click", function() {deleteDisplay()}); // DEL
    botonOperadores(); // "/", "X", "+", "-", "="

    // Funciones

    function botonNumeros() {
        const numeros = document.getElementsByClassName("numeros");
        let numerosLength = numeros.length;
        for (let index = 0; index < numerosLength; index++) {
            const element = numeros[index];
            let num = element.innerHTML;
            element.addEventListener("click", function() {addToDisplay(num)});
        }
    }

    function botonOperadores() {
        const operadores = document.getElementsByClassName("operadores");
        let operadoresLength = operadores.length;
        for (let index = 1; index < operadoresLength; index++) {
            const element = operadores[index];
            let simbolo = element.innerHTML;
            element.addEventListener("click", function() {opera(simbolo)});
        }
    }

    function resetDisplay() {
        display.value = "";
    }

    function addToDisplay(num) {
        display.value += num;

    }

    function deleteDisplay() {
        let valueLength = display.value.length;
        let slicedValue = display.value.slice(valueLength - 1);
        let newValue = display.value.slice(0, valueLength - 1);
        display.value = newValue;
        if (slicedValue === "/" || slicedValue === "X" || slicedValue === "+" || slicedValue === "-") {
            op1 = 0;
            op2 = 0;
            operador = "";
            estado = 0;
        }
    }

    function opera(simbolo) {
        switch(estado) {
            case 0:
                if (simbolo !== "=") {
                    op1 = display.value;
                    addToDisplay(simbolo);
                    op1Length = display.value.length;
                    operador = simbolo;
                    estado++;
                }    
                break;
            case 1:
                if (simbolo === "=") {
                    op2 = display.value.slice(op1Length);
                    calcula(op1, op2, operador);
                    op1 = 0;
                    operador = "";
                    op2 = 0;
                    resetDisplay();
                    estado = 0;
                }
                break;
            default:
                console.log("default opera");
                break;
        }
    }

    function calcula(op1, op2, operador) {
        let result = 0;
        switch (operador) {
            case "/":
                result = op1 / op2;
                break;
            case "X":
                result = op1 * op2;
                break;
            case "-":
                result = Number(op1) - Number(op2);
                break;
            case "+":
                result = Number(op1) + Number(op2);
                break;
            default:
                console.log("default calcula");
                break;
        }
        output.value = result;

    }
}