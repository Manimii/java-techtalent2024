window.onload = function() {
    factorial(0);
    factorial(1);
    factorial(2);
    factorial(3);
    factorial(4);
    factorial(5);

    function factorial(n){
        let f = 1;
        for (let index = n; index > 1; index--) {
            f *= index;    
        }
        console.log("Factorial de " + n + ": " + f);
    }

    
}