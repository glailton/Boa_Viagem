package br.com.great.boaviagem;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class BoaViagemActivity extends Activity {

    private EditText edUser;
    private EditText edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edUser = (EditText) findViewById(R.id.ed_user);
        edPass = (EditText) findViewById(R.id.ed_pass);
    }

    public void loginApp(View v){
        String user = edUser.getText().toString();
        String pass = edPass.getText().toString();
        Log.d("Tag Name", user);
        Log.d("Tag Name", pass);


        if("great".equals(user) && "lge123".equals(pass)){
            Toast toast = Toast.makeText(getApplicationContext(), "Usuário e Senha corretos!",Toast.LENGTH_LONG);
            toast.show();
        } else{
            String msgError = getString(R.string.auth_fail);
            Toast toast = Toast.makeText(getApplicationContext(), msgError ,Toast.LENGTH_LONG);
            toast.show();
        }
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
