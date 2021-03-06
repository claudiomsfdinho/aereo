package aereo.usjt.br.aereo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
/**
 *
 */
public class MainActivity extends ActionBarActivity {

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    Button bntBuscar;
    String origem, destino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config();
    }

    private void config(){
        destino = "";
        origem = "";
        bntBuscar = (Button) findViewById(R.id.botao_consultar);
        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origens);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecao());
        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destinos);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecao());

    }

    private class DestinoSelecao implements AdapterView.OnItemSelectedListener{

        @Override

        public void onItemSelected(AdapterView <?> parent , View view, int position, long id) {
           destino = (String) parent.getItemAtPosition(position);

        }
        @Override

        public void onNothingSelected(AdapterView<?> parent)
        {

        }

    }



    private class OrigemSelecao implements AdapterView.OnItemSelectedListener{

        @Override

        public void onItemSelected(AdapterView <?> parent , View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);

        }
        @Override

        public void onNothingSelected(AdapterView<?> parent)
        {

        }

    }

    //constantes


    public  final static String ORIGEM = "br.usjt.ORIGEM";
    public  final static String DESTINO = "br.usjt.DESTINO";

    // metodo chamado para consultar ao clicar
public void consultarVoos(View view) {
    String pOrigem = this.origem.equals("Selecione o Voo de Origem") ? "" : origem;
    String pDestino = this.destino.equals("Selecione o Voo de Destino") ? "" : destino;


    Intent intent = new Intent(this, VooActivity.class);

    intent.putExtra(ORIGEM, pOrigem);
    intent.putExtra(DESTINO, pDestino);

    startActivity(intent);

}
}

