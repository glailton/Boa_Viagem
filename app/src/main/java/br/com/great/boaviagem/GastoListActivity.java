package br.com.great.boaviagem;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GastoListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String,Object>> gastos;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

     /*   setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listarGastos()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);*/

        String[] de = {"imageTipoViagem", "listDestino", "listData", "listValor"};
        int[] para = {R.id.imageTipoViagem, R.id.listDestino, R.id.listData, R.id.listValor};

        SimpleAdapter adapter = new SimpleAdapter(this, listarGastos(),
                R.layout.lista_gasto, de, para);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){
      /*  TextView textView = (TextView) v;
        String mensagem = "Gasto selecionado: " + textView.getText();*/
        Map<String,Object>map=gastos.get(position);
        String descricao=(String)map.get("descricao");
        String mensagem="Gasto selecionada: "+descricao;
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, GastoListActivity.class));
    }

    private List<Map<String,Object>>listarGastos() {
        gastos=new ArrayList<Map<String,Object>>();
        Map<String,Object>item = new HashMap<String,Object>();
        item.put("data","04/02/2012");
        item.put("descricao","Diária Hotel");
        item.put("valor","R$ 260,00");
        item.put("categoria",R.color.categoria_hospedagem);
        gastos.add(item);

        return gastos;

     /*   return Arrays.asList("Sanduíche R$ 19,90",
                "Táxi Aeroporto - Hotel R$ 34,00",
                "Janta R$ 59,00",
                "Revista R$ 12,00",
                "Almoço R$ 120,00");*/
    }
}
