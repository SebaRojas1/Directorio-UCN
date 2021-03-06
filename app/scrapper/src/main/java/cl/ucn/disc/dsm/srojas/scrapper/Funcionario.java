/**
 * Copyright 2021 Sebastián Rojas Rodriguez sebastian.rojas04@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package cl.ucn.disc.dsm.srojas.scrapper;

import lombok.Builder;
import lombok.Getter;

/**
 * The UCN functionary.
 *
 * @author Sebastián Rojas.
 */
@Builder
public final class Funcionario {

    //The ID.
    @Getter
    private final Integer id;

    //The name.
    @Getter
    private final String nombre;

    //The occupation.
    @Getter
    private final String cargo;

    //The unity.
    @Getter
    private final String unidad;

    //The email.
    @Getter
    private final String email;

    //The telephone number.
    @Getter
    private final String telefono;

    //The office.
    @Getter
    private final String oficina;

    //The direction.
    @Getter
    private final String direccion;
}
