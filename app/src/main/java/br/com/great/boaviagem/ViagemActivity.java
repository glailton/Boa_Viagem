package br.com.great.boaviagem;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;

        import java.util.Calendar;

public class ViagemActivity extends Activity {

    private int ano, mes, dia;
    private Button dataChegada, dataSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viagem);
        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataChegada = (Button) findViewById(R.id.dataChegada);
        dataChegada.setText(dia + "/" + (mes+1) + "/" + ano);
        dataSaida = (Button) findViewById(R.id.dataSaida);
        dataSaida.setText(dia + "/" + (mes+1) + "/" + ano);
    }

    public void salvarViagem(View v){

    }
    @SuppressWarnings("deprecation")
    public void selecionarData(View v){
        showDialog(v.getId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.viagem_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item){
        switch (item.getItemId()){
            case R.id.novo_gasto:
                startActivity(new Intent(this, GastoActivity.class));
                return true;
            case R.id.remover:
                //remover do banco de dados
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }

}
