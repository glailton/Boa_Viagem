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


public class ViagemListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> viagens;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

     /*   setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listarViagens()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);*/

        String[] de = {"imageTipoViagem", "listDestino", "listData", "listValor"};
        int[] para = {R.id.imageTipoViagem, R.id.listDestino, R.id.listData, R.id.listValor};

        SimpleAdapter adapter = new SimpleAdapter(this, listarViagens(),
                R.layout.lista_viagem, de, para);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    private List<Map<String, Object>> listarViagens(){
        viagens = new ArrayList<Map<String, Object>>();

        Map<String,Object> item = new HashMap<String, Object>();
        item.put("imageTipoViagem", R.drawable.negocios);
        item.put("listDestino", "São Paulo");
        item.put("data","02/02/2012 a 04/02/2012");
        item.put("total","Gasto total R$ 314,98");
        viagens.add(item);

        item = new HashMap<String,Object>();
        item.put("imagem",R.drawable.lazer);
        item.put("destino","Maceió");
        item.put("data","14/05/2012 a 22/05/2012");
        item.put("total","Gasto total R$ 25834,67");
        viagens.add(item);

        return viagens;

     //   return Arrays.asList("Fortaleza", "Gramado", "Canela", "Porto Alegre", "São Paulo");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){
        Map<String, Object> map = viagens.get(position);
        String destino = (String) map.get("listDestino");
        String mensagem = "Viagem selecionada: "+ destino;
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, GastoListActivity.class));
      /*  TextView textView = (TextView) v;
        String mensagem = "Viagem selecionada: " + textView.getText();
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, GastoListActivity.class));*/
    }
}
