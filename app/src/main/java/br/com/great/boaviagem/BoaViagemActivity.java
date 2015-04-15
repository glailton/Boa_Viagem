package br.com.great.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class BoaViagemActivity extends Activity {

    private static final String MANTER_CONECTADO = "manter_conectado";
    private EditText edUser;
    private EditText edPass;
    private CheckBox manterConectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edUser = (EditText) findViewById(R.id.ed_user);
        edPass = (EditText) findViewById(R.id.ed_pass);
        manterConectado = (CheckBox) findViewById(R.id.manterConectado);

        SharedPreferences preferencias = getPreferences(MODE_PRIVATE);
        boolean conectado = preferencias.getBoolean(MANTER_CONECTADO, false);

        if (conectado) {
            startActivity(new Intent(this, DashboardActivity.class));
        }

    }

    public void loginApp(View v){
        String user = edUser.getText().toString();
        String pass = edPass.getText().toString();
        Log.d("Tag Name", user);
        Log.d("Tag Name", pass);


        if("great".equals(user) && "lge".equals(pass)){

            SharedPreferences preferencias = getPreferences(MODE_PRIVATE);

            SharedPreferences.Editor editor = preferencias.edit();
            editor.putBoolean(MANTER_CONECTADO, manterConectado.isChecked());
            editor.commit();
            startActivity(new Intent(this,DashboardActivity.class));
        }else {
            String mensagemErro = getString(R.string.auth_fail);
            Toast toast = Toast.makeText(getApplicationContext(), mensagemErro ,Toast.LENGTH_LONG);
            toast.show();
        }
          /*  Toast toast = Toast.makeText(getApplicationContext(), "Usuário e Senha corretos!",Toast.LENGTH_LONG);
            toast.show();*/
       //     startActivity(new Intent(this,DashboardActivity.class));
    //    } else{
      //      String msgError = getString(R.string.auth_fail);
        //    Toast toast = Toast.makeText(getApplicationContext(), msgError ,Toast.LENGTH_LONG);
          //  toast.show();
     //   }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
