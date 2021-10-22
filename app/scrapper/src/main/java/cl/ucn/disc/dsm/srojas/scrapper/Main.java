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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * The main class to scrappe the contactos UCN.
 *
 * @author Sebastián Rojas.
 */
@Slf4j
public final class Main {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * The main method for the scrappe.
     * @param args To use
     * @throws IOException The IO exception
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        // Load the file into the data
        String data = FileUtils.readFileToString(new File("funcionarios.jason"),
                StandardCharsets.UTF_8);

        // Define the type
        Type type = new TypeToken<List<Funcionario>>(){
        }.getType();

        // The list of functionaries (string -> List<Funcionario>)
        List<Funcionario> funcionarios = GSON.fromJson(data, type);

        final int start = funcionarios.get(funcionarios.size() - 1).getId();
        final int end = 300;

        Random random = new Random();
        for (int id = start + 1; id < end; id++) {

            // Wait for...
            Thread.sleep(50 + random.nextInt(350));

            // Connect and get the document
            Document doc = Jsoup
                    .connect("http://admision01.ucn.cl/directoriotelefonicoemail/" +
                            "fichaGenerica/?cod=" + id)
                    .get();

            // Scrapping
            String nombre = doc.getElementById("lblNombre").text();
            // Check if the page with that id contained information, skip if data not found
            if(nombre.length() <= 1) {
                log.warn("No data found for id: {}", id);
                continue;
            }
            String cargo = doc.getElementById("lblCargo").text();
            String unidad = doc.getElementById("lblUnidad").text();
            String email = doc.getElementById("lblEmail").text();
            String telefono = doc.getElementById("lblTelefono").text();
            String oficina = doc.getElementById("lblOficina").text();
            String direccion = doc.getElementById("lblDireccion").text();

            // Calling the constructor
            Funcionario funcionario = Funcionario.builder()
                    .id(id)
                    .nombre(nombre)
                    .cargo(cargo)
                    .unidad(unidad)
                    .email(email)
                    .telefono(telefono)
                    .oficina(oficina)
                    .direccion(direccion)
                    .build();

            // Add the functionary into the list
            funcionarios.add(funcionario);

            if (funcionarios.size() % 3 == 0) {
                // Write the list of functionary in JSON format
                FileUtils.writeStringToFile(new File("funcionarios.jason"),
                        GSON.toJson(funcionarios),
                        StandardCharsets.UTF_8);
            }
        }
    }
}