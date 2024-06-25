window.onload = function() {

    console.log(checkString("BUENOS DÍAS"));
    console.log(checkString("buenas tardes"));
    console.log(checkString("Buenas Noches"));

    function checkString(s) {
        let mensaje = "";
        let upper = s.toUpperCase();
        let lower = s.toLowerCase();
        
        if (s === upper) {
            mensaje = s + ": Todas las letras son mayúsculas."

        } else if (s === lower) {
            mensaje = s + ": Todas las letras son minúsculas."

        } else {
            mensaje = s + ": El String es una mezcla de mayúsculas y minúsculas."
        }

        return mensaje;

    }
}