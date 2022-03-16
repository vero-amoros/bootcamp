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
    // if(isNan(numeroIntroducido)){
    //   alert("Tienes que introducir un número")
    // }
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

function Ejercicio3(tam, ini) {
  let array = [];

  for (let i = 0; i < tam; i++) {
    array.push(ini);
  }
  console.log(array);
}

function Ejercicio4(cuantos) {
  let num = cuantos;
  let primos = 0;
  let array = [];
  function esPrimo(numero) {
    for (let i = 2, raiz = Math.sqrt(numero); i <= raiz; i++)
      if (numero % i === 0) return false;
    return numero > 1;
  }

  for (let x = 0; x <= 200; x++) {
    if (esPrimo(x)) {
      array.push(x);
      primos++;
    }
    if (primos === num) {
      break;
    }
  }
  return array;
}

function Ejercicio5(dni) {
  var numero, miletra, letra;
  var regex = /^\d{1,8}[A-Z]$/;
  dni = dni.toUpperCase();

  if (regex.test(dni) === true) {
    numero = dni.substr(0, dni.length - 1); //cojo el numero del dni
    miletra = dni.substr(dni.length - 1, 1); //cojo la letra del dni
    numero = numero % 23; //para saber qué letra corresponde con el numero
    letra = "TRWAGMYFPDXBNJZSQVHLCKE";
    letra = letra.substring(numero, numero + 1); //miro qué letra es en el string de letras
    if (letra != miletra) {
      return "Dni erróneo, la letra no se corresponde";
    } else {
      return "Dni correcto";
    }
  } else {
    return "Dni erróneo, formato no válido";
  }
}

function Ejercicio6(str) {
  const trim = str.replace(/ /g, "").toUpperCase();

  const alreves = trim.split("").reverse().join("");

  if (alreves === trim) {
    return "La cadena '" + str + "' es un palíndromo";
  } else {
    return "La cadena '" + str + "' no es un palíndromo";
  }
}


function Ejercicio7() {
  this.inicializar = function () {
    this.intentos = 0;
    this.encontrado = false;
    this.random = Ejercicio1(0, 100);
  };

  this.inicializar();

  this.jugada = function (num) {
    if (this.intentos >= 10 || num < 0 || num > 100) {
      return "No válido";
    }
    if (this.getFinalizado()) {
      return "FINALIZADO";
    }
    this.intentos++;
    if (this.random === num) {
      this.encontrado = true;
      return "ACERTASTE";
    } else if (this.intentos >= 10) {
      return "Fin de los intentos";
    } else if (this.random > num) {
      return "MAYOR";
    } else {
      return "MENOR";
    }
  }

  this.getResultado = function () {
    return this.resultado;
  }
  this.getFinalizado = function () {
    return this.intentos >= 10 || this.encontrado;
  }
  this.getJugada = function () {
    return this.intentos;
  }
}

class Ejercicio8 {
  constructor() {
    this.inicializar();
    this.jugada(23);
  }

  inicializar() {
    this.intentos = 0;
    this.encontrado = false;
    this.random = Ejercicio1(0, 100);
  }

  jugada(num) {
    if (this.intentos >= 10 || num < 0 || num > 100) {
      return "No válido";
    }
    if (this.getFinalizado()) {
      return "FINALIZADO";
    }
    this.intentos++;
    if (this.random === num) {
      this.encontrado = true;
      return "ACERTASTE";
    } else if (this.intentos >= 10) {
      return "Fin de los intentos";
    } else if (this.random > num) {
      return "MAYOR";
    } else {
      return "MENOR";
    }
  }

  getResultado() {
    return this.resultado;
  }
  getFinalizado() {
    return this.intentos >= 10 || this.encontrado;
  }
  getJugada() {
    return this.intentos;
  }
}
