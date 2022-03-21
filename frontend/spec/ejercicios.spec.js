describe('Pruebas de los ejercicios', () => {
    describe('Ejercicio 1', () => {
        describe('OK', () => {
            it('Genera aleatorio', () => {
                let num = Ejercicio1(1,100);
                expect(num).toBeGreaterThanOrEqual(1)
                expect(num).toBeLessThanOrEqual(100)

            })
        });

        describe('KO', () => {
            it('Falta parámetro', () =>{
                expect(() => Ejercicio1(1)).toThrow();
            })
        });
        
    });

    describe('Ejercicio 2', () => {
        it('Pendiente')
    });

    describe('Ejercicio 5', () => {
        describe('NIF OK', () => {
            ['23456787a', '4g', '48729160a'].forEach(caso => {
                it(`NIF: ${caso}`, () => expect(Ejercicio5(caso)).toBeTrue())
                })
            
        });

        describe('NIF KO', () => {
            ['1234', '4g'].forEach(caso => {
                it(`NIF: ${caso}`, () => expect(Ejercicio5(caso)).toBeFalse())
                })
        });
        
    });

    
})