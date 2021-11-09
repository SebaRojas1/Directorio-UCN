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
package cl.ucn.disc.dsm.srojas.directorioucn;

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


    public static FuncionarioBuilder builder() {
        return new FuncionarioBuilder();
    }

    public static class FuncionarioBuilder {
        private Integer id;
        private String nombre;
        private String cargo;
        private String unidad;
        private String email;
        private String telefono;
        private String oficina;
        private String direccion;

        FuncionarioBuilder() {
        }

        public FuncionarioBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public FuncionarioBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public FuncionarioBuilder cargo(String cargo) {
            this.cargo = cargo;
            return this;
        }

        public FuncionarioBuilder unidad(String unidad) {
            this.unidad = unidad;
            return this;
        }

        public FuncionarioBuilder email(String email) {
            this.email = email;
            return this;
        }

        public FuncionarioBuilder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public FuncionarioBuilder oficina(String oficina) {
            this.oficina = oficina;
            return this;
        }

        public FuncionarioBuilder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        //public Funcionario build() {
        //    return new Funcionario(id, nombre, cargo, unidad, email, telefono, oficina, direccion);
        //}

        public String toString() {
            return "Funcionario.FuncionarioBuilder(id=" + this.id + ", nombre=" + this.nombre + ", cargo=" + this.cargo + ", unidad=" + this.unidad + ", email=" + this.email + ", telefono=" + this.telefono + ", oficina=" + this.oficina + ", direccion=" + this.direccion + ")";
        }
    }
}
