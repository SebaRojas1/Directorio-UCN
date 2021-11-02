package cl.ucn.disc.dsm.srojas.directorioucn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * The Adapter of Funcionario
 *
 * @author Sebastián rojas.
 */
public final class FuncionarioAdapter extends BaseAdapter {

    // The list of funcionarios
    private final List<Funcionario> funcionarios = new ArrayList<>();

    // The inflater
    private LayoutInflater inflater;

    /**
     * The constructor
     * @param context
     */
    public FuncionarioAdapter(Context context){

        //get the inflater
        this.inflater = LayoutInflater.from(context);

    }

    /**
     * The size of the list of {@link Funcionario}.
     * @return the size.
     */
    @Override
    public int getCount() {
        return this.funcionarios.size();
    }

    /**
     * The {@link Funcionario} at the position inserted.
     * @param position
     * @return the {@link Funcionario} at the position inserted.
     */
    @Override
    public Funcionario getItem(int position) {
        return this.funcionarios.get(position);
    }

    /**
     * return the pos.
     * @param position
     * @return the same pos.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Add all the {@link Funcionario} into the Adapter.
     * @param theFuncionarios
     */
    public void setFuncionarios(List<Funcionario> theFuncionarios) {
        this.funcionarios.addAll(theFuncionarios);
    }

    /**
     * return a ConvertView with a Holder.
     * @param position to get.
     * @param convertView to use.
     * @param parent the outer component.
     * @return a ConvertView with a Holder.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // The holder
        ViewHolder holder;

        // Inflate only the rows visibles
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.row_funcionario, parent, false);

            // Construct the ViewHolder
            holder = new ViewHolder(convertView);

            // Save into the convertView
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertView.getTag();

        }

        // Assign the values!
        final Funcionario funcionario = this.getItem(position);
        holder.nombre.setText(funcionario.getNombre());
        holder.email.setText(funcionario.getEmail());

        return convertView;
    }

    private static class ViewHolder{

        TextView nombre;
        TextView email;

        ViewHolder(View view) {
            this.nombre = view.findViewById(R.id.rf_tv_nombre);
            this.email = view.findViewById(R.id.rf_tv_email);
        }
    }

}
