package com.otherwisestudios.calculadoraimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText et_peso, et_altura, et_nombre, et_resultadovalor;
    TextView tv_resultadodescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_peso = (EditText) findViewById(R.id.et_peso);
        et_altura = (EditText) findViewById(R.id.et_altura);
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_resultadovalor = (EditText) findViewById(R.id.et_resultadovalor);

        tv_resultadodescripcion = (TextView) findViewById(R.id.tv_resultadodescripcion);

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


    public void calcular(View view){

        /*
        * IMC = peso / altura*altura
         *
         * IMC = 69 / 1,69²
        * */

        float IMC = 0;
        //NumberFormat format ;

        float peso = Float.parseFloat(et_peso.getText().toString());

        float altura = Float.parseFloat(et_altura.getText().toString());

        altura/=100; //para pasar de cm a metros

        IMC =  peso / (altura*altura);

        et_resultadovalor.setText(String.valueOf(IMC));

        int descripcion_val_id = R.string.obesidad3;
        if(IMC<17){
            descripcion_val_id = R.string.muybajopeso;
        }else if(IMC>=17 && IMC <18.5){
            descripcion_val_id = R.string.bajopeso;
        }else if(IMC>=18.5 && IMC < 25){
            descripcion_val_id = R.string.pesonormal;
        }else if(IMC>=25 && IMC < 30){
            descripcion_val_id = R.string.sobrepeso;
        }else if(IMC>=30 && IMC < 35){
            descripcion_val_id = R.string.obesidad1;
        }else if(IMC>=35 && IMC <40){
            descripcion_val_id = R.string.obesidad2;
        }

        tv_resultadodescripcion.setText(descripcion_val_id);

    }

}
