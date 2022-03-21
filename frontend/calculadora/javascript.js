class Calculadora {
  constructor(pantalla) {
    this.inicializar();
    this.limpiar.bind(this);
    this.pantalla = pantalla;
  }

  inicializar() {
    this.one = 0;
    this.two = 0;
    this.operador;
  }

  actualiza() {
    this.pantalla.value = this.one;
  }

  limpiar() {
    this.one = 0;
    this.two = 0;
    this.actualiza();
  }

  ponNumero(numero) {
    if (this.one == 0 && this.one !== "0.") {
      this.one = numero;
    } else {
      this.one += numero;
    }
    this.actualiza();
  }

  coma() {
    if (this.one == 0) {
      this.one = "0.";
    } else if (this.one.indexOf(".") == -1) {
      this.one += ".";
    }
    this.actualiza();
  }

  elige(eleccion) {
    if (this.one == 0) {
      this.one = parseFloat(this.pantalla.value);
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

