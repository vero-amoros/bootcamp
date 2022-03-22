describe('Pruebas calculadora', () => {
    describe("Suma", () => {
        describe('OK', () => {
            it("Suma enteros", () => {
                let pantalla = {value: 10};
                let calculadora = new Calculadora(pantalla);
                calculadora.limpiar();
                expect(pantalla.value).toBe(0);
                calculadora.ponNumero(2);
                calculadora.elige("+");
                calculadora.ponNumero(3);
                calculadora.calculos();
                expect(pantalla.value).toBe(5);

            })
        });
    })
});

