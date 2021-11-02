package cl.ucn.disc.dsm.srojas.directorioucn;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.loader.content.AsyncTaskLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import lombok.NonNull;

/**
 * The ViewModel of Funcionario.
 *
 * @author Sebastián Rojas.
 */
public final class FuncionarioViewModel extends AndroidViewModel {

    private MutableLiveData<List<Funcionario>> funcionarios;

    public FuncionarioViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     *
     * @return the LiveData of list of funcionario.
     */
    public LiveData<List<Funcionario>> getFuncionarios() {

        // Lazy load
        if(this.funcionarios == null) {
            this.funcionarios = new MutableLiveData<>();
            this.loadFuncionarios();
        }

        return this.funcionarios;
    }

    /**
     * Read the Funcionarios from funcionarios.jason.
     */
    private void loadFuncionarios() {

        // Run in the background.
        AsyncTask.execute(() -> {

            List<Funcionario> theFuncionarios;

            // Read the funcionarios.jason.
            try (final InputStream is = super.getApplication().getAssets().open("funcionarios.jason")){

                // Get the Type of List<Funcionarios> with reflection.
                final Type funcionariosListType = new TypeToken<List<Funcionario>>(){}.getType();

                // The json to object converter.
                final Gson gson = new GsonBuilder().create();

                // The Reader.
                final Reader reader = new InputStreamReader(is);

                // Google Gson.
                theFuncionarios = gson.fromJson(reader, funcionariosListType);

            }
            catch (IOException e) {
                e.printStackTrace();
                return;
            }

            this.funcionarios.postValue(theFuncionarios);

        });

    }
}
