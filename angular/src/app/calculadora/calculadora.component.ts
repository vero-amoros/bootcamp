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
    console.log('uno arriba' + this.one);
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

      //Que no se puedan poner dos operadores seguidos
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
    this.one = 0; //
    this.eleccion = oper;
    console.log('eleccion ' + this.eleccion);

    const ultimo = this.operaciones[this.operaciones.length - 1];

    if (ultimo === '=') this.operaciones = this.resultado;

    //Que no se puedan poner dos operadores seguidos
    if (ultimo === '/' || ultimo === '*' || ultimo === '-' || ultimo === '+') {
      return;
    }

    this.operaciones = this.operaciones + oper;
    //  this.calcAnswer();
  }
  getLastOperand() {
    //cambiar
    let pos: number;
    console.log(this.operaciones);
    pos = this.operaciones.toString().lastIndexOf('+');
    if (this.operaciones.toString().lastIndexOf('-') > pos)
      pos = this.operaciones.lastIndexOf('-');
    if (this.operaciones.toString().lastIndexOf('*') > pos)
      pos = this.operaciones.lastIndexOf('*');
    if (this.operaciones.toString().lastIndexOf('/') > pos)
      pos = this.operaciones.lastIndexOf('/');
    console.log('Last ' + this.operaciones.substr(pos + 1));
    return this.operaciones.substring(pos + 1);
  }

  calculos() {
    this.separa();

    console.log('one ' + this.one + 'two ' + this.two);
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
    this.resultado = this.resu.toString();
    console.log('resultados ' + this.resu + ' ' + this.resultado);

    this.two = this.one;
    this.one = parseFloat(this.resultado);
  }

  separa() {
    var MyArray = this.operaciones.split(this.eleccion);
    this.one = parseFloat(MyArray[0]);
    this.two = parseFloat(MyArray[1]);
  }
  dameResultado() {
    this.calculos();
    this.operaciones = this.operaciones + '=';
    if (this.operaciones == '0') this.operaciones = '';
  }
  limpiar() {
    this.resultado = '';
    this.operaciones = '';
    this.one = 0;
    this.two = 0;
  }
}
