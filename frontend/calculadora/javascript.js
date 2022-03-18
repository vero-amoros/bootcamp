class Calculadora {
  constructor() {
    this.inicializar();
  }

  
  inicializar() {
    this.one = 0;
    this.two = 0;
    this.operador;
  }

  limpiar() {
    this.one = 0;
    this.two = 0;
    this.actualiza();
  }

  actualiza() {
    document.getElementById("pantallita").value = this.one;
  }

  ponNumero(numero) {
    if (this.one == 0 && this.one !== "0.") {
      this.one = numero;
    } else {
      this.one += numero;
    }
    this.actualiza();
  }

  conComa() {
    if (this.one == 0) {
      this.one = "0.";
    } else if (this.one.indexOf(".") == -1) {
      this.one += ".";
    }
    this.actualiza();
  }

  elige(eleccion) {
    if (this.one == 0) {
        this.one = parseFloat(document.getElementById("pantallita").value);
      }
      this.two = parseFloat(this.one);
      this.one = 0;
      this.operador = eleccion;
  }


  calculos() {
    this.one = parseFloat(this.one);
    switch (this.operador) {
      case "+":
        this.one += this.two;
        break;
      case "-":
        this.one = this.two - this.one;
        break;
      case "*":
        this.one *= this.two;
        break;
      case "/":
        this.one = this.two / this.one;
        break;
    }
    this.actualiza();
    this.two = parseFloat(this.one);
    this.one = 0;
  }

 
}

const coma = document.getElementById("coma");
const clear = document.getElementById("clear");
const igual = document.getElementById("igual");
const numeros = document.querySelectorAll("[data-numero]");
const oper = document.querySelectorAll("[data-oper]");

const calculadora = new Calculadora();

coma.addEventListener("click", calculadora.conComa);
clear.addEventListener("click", calculadora.limpiar);
igual.addEventListener("click", calculadora.calculos);


numeros.forEach((button) => {
  button.addEventListener("click", () => {
    calculadora.ponNumero(button.innerText);
  });
});

oper.forEach((button) => {
  button.addEventListener("click", () => {
    calculadora.elige(button.value);
  });
});
