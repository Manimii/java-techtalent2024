window.onload = function() {
    let n = 5;
    let facorial = 1;
    for (let index = n; index > 1; index--) {
        facorial *= index;    
    }
    console.log("Factorial de " + n + ": " + facorial);
}