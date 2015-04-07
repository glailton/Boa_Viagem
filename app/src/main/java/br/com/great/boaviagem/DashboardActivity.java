package br.com.great.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }

    public void selecionarOpcao(View v){
     /*   TextView textView = (TextView) v;
        String opcao = "Opcao: " + textView.getText().toString();
        Toast.makeText(this, opcao, Toast.LENGTH_LONG).show();*/

        switch (v.getId()){
            case R.id.nova_viagem:
                startActivity(new Intent(this,ViagemActivity.class));
                break;
        }
    }
}
