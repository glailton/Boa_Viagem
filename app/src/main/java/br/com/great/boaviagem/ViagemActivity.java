package br.com.great.boaviagem;

        import android.app.Activity;
        import android.os.Bundle;
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


}
