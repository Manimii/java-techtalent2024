let text = "JavaScript es increíble";
document.getElementById("text").innerHTML = text;
document.getElementById("length").innerHTML = text.length;
document.getElementById("slice").innerHTML = text.slice(14);
document.getElementById("substring").innerHTML = text.substring(0, 10); // slice(0, 10) también funciona

let bienvenido = " Bienvenido a la programación ";
document.getElementById("bienvenido").innerHTML = bienvenido;
document.getElementById("trim").innerHTML = bienvenido.trim();
document.getElementById("toUpperCase").innerHTML = bienvenido.toUpperCase();
document.getElementById("replace").innerHTML = bienvenido.replace(
  "programación",
  "JavaScript"
);
document.getElementById("concat").innerHTML = bienvenido.concat("en 2024");
document.getElementById("bienvenido-todo").innerHTML = bienvenido
  .trim()
  .toUpperCase()
  .replace("PROGRAMACIÓN", "JAVASCRIPT")
  .concat(" en 2024");
