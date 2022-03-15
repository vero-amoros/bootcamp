
function Ejercicio1(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}

function Ejercicio2() {
  let numeroIntroducido = 0;
  let numeroBuscado = Ejercicio1(0, 100);
  let intentos = 0;
  let encontrado = false;
  do {
    intentos += 1;
    console.log("Dame tu número del 1 al 100 (" + intentos + " de 10): ");
    console.log("[" + numeroBuscado + "]: ");
    numeroIntroducido = parseInt(prompt("Dame un número del 0 al 100"));
    if (numeroBuscado === numeroIntroducido) {
      encontrado = true;
    } else if (numeroBuscado > numeroIntroducido) {
      console.log("Mi número es mayor.");
    } else {
      console.log("Mi número es menor.");
    }
  } while (intentos < 10 && !encontrado);
  if (encontrado) {
    console.log("¡Bien! Acertaste.");
  } else {
    console.log(
      "¡Vaya! Se acabaron los intentos, el número era el " + numeroBuscado
    );
  }
}

function Ejercicio3(tam, ini){
    let array = [];

    for(let i=0; i<tam;i++){
        array.push(ini);
    }
    console.log(array);
}

function Ejercicio4(cuantos) {
  let num = cuantos;
  let primos = 0;
  function esPrimo(numero) {
    for (let i = 2, raiz = Math.sqrt(numero); i <= raiz; i++)
      if (numero % i === 0) return false;
    return numero > 1;
  }

  for (let x = 0; x <= 200; x++) {
    if (esPrimo(x)) {
      console.log("Número primo: " + x);
      primos++;
    }
    if (primos === num) {
      break;
    }
  }
}


