import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css'],
})
export class CalculadoraComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  operaciones: string = '';
  resultado: string = '0';
  resu: number = 0;
  one: number = 0;
  two: number = 0;
  operador: string = '';
  eleccion: string = '';

  ponNumero(num: string) {
    this.one += parseFloat(num);
    const ultimo = this.operaciones[this.operaciones.length - 1];

    if (ultimo === '=') {
      this.operaciones = '';
      this.resultado = '';
    }

    this.operaciones = this.operaciones + num;
  }

  coma() {
    if (this.operaciones != '') {
      const ultimo = this.operaciones[this.operaciones.length - 1];

      if (
        ultimo === '/' ||
        ultimo === '*' ||
        ultimo === '-' ||
        ultimo === '+'
      ) {
        this.operaciones = this.operaciones + '0.';
      } else {
        this.operaciones = this.operaciones + '.';
      }
    } else {
      this.operaciones = this.operaciones + '0.';
    }
  }

  ponOper(oper: string) {
    if (this.one == 0) {
      this.one = parseFloat(this.operaciones);
    }
    this.two = this.one;
    this.one = 0;
    this.eleccion = oper;

    const ultimo = this.operaciones[this.operaciones.length - 1];

    if (ultimo === '=') this.operaciones = this.resultado;

    if (ultimo === '/' || ultimo === '*' || ultimo === '-' || ultimo === '+') {
      return;
    }

    this.operaciones = this.operaciones + oper;
  }

  calculos() {
    this.separa();
    switch (this.eleccion) {
      case '+':
        this.resu = this.one + this.two;
        break;
      case '-':
        this.resu = this.one - this.two;
        break;
      case '*':
        this.resu = this.one * this.two;
        break;
      case '/':
        this.resu = this.one / this.two;
        break;
    }
    if (this.two === -1) {
      this.resultado = this.one.toString();
    } else {
      this.resultado = this.resu.toFixed(2).toString();
    }

    this.two = this.one;
    this.one = parseFloat(this.resultado);
  }

  separa() {
    var MyArray = this.operaciones.split(this.eleccion);

    if (
      this.operaciones.includes('+') ||
      this.operaciones.includes('-') ||
      this.operaciones.includes('*') ||
      this.operaciones.includes('/')
    ) {
      this.one = parseFloat(MyArray[0]);
      this.two = parseFloat(MyArray[1]);
    } else {
      console.log('entroooo');

      this.one = parseFloat(this.operaciones);
      this.two = -1;
    }
  }
  dameResultado() {
    this.calculos();
    const ultimo = this.operaciones[this.operaciones.length - 1];

    if (ultimo === '=') {
      return;
    } else {
      this.operaciones = this.operaciones + '=';
    }
    if (this.operaciones == '0') this.operaciones = '';
  }
  limpiar() {
    this.resultado = '';
    this.operaciones = '';
    this.one = 0;
    this.two = 0;
  }
}
