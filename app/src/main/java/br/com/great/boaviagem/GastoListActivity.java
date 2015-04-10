package br.com.great.boaviagem;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GastoListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String,Object>> gastos;
    private String dataAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

     /*   setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listarGastos()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);*/

        String[] de = {"data", "descricao", "valor", "categoria"};
        int[] para = {R.id.data, R.id.descricao, R.id.valor, R.id.categoria};

        SimpleAdapter adapter = new SimpleAdapter(this, listarGastos(),
                R.layout.lista_gasto, de, para);

        adapter.setViewBinder(new GastoViewBinder());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

        registerForContextMenu(getListView());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){
      /*  TextView textView = (TextView) v;
        String mensagem = "Gasto selecionado: " + textView.getText();*/
        Map<String,Object>map=gastos.get(position);
        String descricao=(String)map.get("descricao");
        String mensagem="Gasto selecionada: " + descricao;
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gasto_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if (item.getItemId() == R.id.remover){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            gastos.remove(info.position);
            getListView().invalidateViews();
            dataAnterior = "";
            //remover do banco de dados
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private List<Map<String,Object>>listarGastos() {
        gastos=new ArrayList<Map<String,Object>>();
        Map<String,Object>item = new HashMap<String,Object>();
        item.put("data","04/02/2012");
        item.put("descricao","Diária Hotel");
        item.put("valor","R$ 260,00");
        item.put("categoria",R.color.categoria_hospedagem);
        gastos.add(item);

        item = new HashMap<String, Object>();
        item.put("data", "03/02/2012");
        item.put("descricao", "Wifi");
        item.put("valor", "R$ 7,00");
        item.put("categoria", R.color.categoria_outros);
        gastos.add(item);

        item = new HashMap<String, Object>();
        item.put("data", "02/02/2012");
        item.put("descricao", "Táxi Aeroporto - Hotel");
        item.put("valor", "R$ 34,00");
        item.put("categoria", R.color.categoria_transporte);
        gastos.add(item);

        item = new HashMap<String, Object>();
        item.put("data", "02/02/2012");
        item.put("descricao", "Sanduíche");
        item.put("valor", "R$ 19,90");
        item.put("categoria", R.color.categoria_alimentacao);
        gastos.add(item);

        return gastos;

     /*   return Arrays.asList("Sanduíche R$ 19,90",
                "Táxi Aeroporto - Hotel R$ 34,00",
                "Janta R$ 59,00",
                "Revista R$ 12,00",
                "Almoço R$ 120,00");*/
    }



    private class GastoViewBinder implements SimpleAdapter.ViewBinder{

        private String dataAnterior = "";

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation){
            if(view.getId() == R.id.data){
                if (!dataAnterior.equals(data)){
                    TextView textView = (TextView) view;
                    textView.setText(textRepresentation);
                    dataAnterior = textRepresentation;
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.GONE);
                }
                return true;
            }

            if (view.getId() == R.id.categoria){
                Integer id = (Integer) data;
                view.setBackgroundColor(getResources().getColor(id));
                return true;
            }
            return false;
        }
    }
}


