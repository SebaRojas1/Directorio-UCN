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

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sebastián Rojas.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Funcionario Adapter
     */
    protected FuncionarioAdapter funcionarioAdapter;

    /**
     *
     * @param savedInstanceState the state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the List (RecyclerView).
        final RecyclerView recyclerView = findViewById(R.id.am_rv_funcionarios);
        // The type of layout of RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL
                , false));

        // Build the Adapter
        this.funcionarioAdapter = new FuncionarioAdapter();
        // Union of Adapter + RecyclerView
        recyclerView.setAdapter(this.funcionarioAdapter);

        // Build the ViewModel
        FuncionarioViewModel funcionarioViewModel = ViewModelProvider // Provider
                .AndroidViewModelFactory // The Factory
                .getInstance(this.getApplication()) // The Singleton instance of Factory
                .create(FuncionarioViewModel.class); // Call the Constructor of FuncionarioViewModel

        funcionarioViewModel.getFuncionarios().observe(this, funcionarios -> {
            // Set the funcionarios (from view model)
            funcionarioAdapter.setFuncionarios(funcionarios);
            // Refresh the Recycler (ListView)
            funcionarioAdapter.notifyDataSetChanged();
        });

    }

}