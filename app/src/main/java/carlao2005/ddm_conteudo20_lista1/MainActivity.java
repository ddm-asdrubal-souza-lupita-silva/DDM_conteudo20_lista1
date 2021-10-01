package carlao2005.ddm_conteudo20_lista1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    // atributos referentes aos objetos da interface
    private ListView lista;

    // atributo com os textos a serem exibidos na lista
    private ArrayList<String> textos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ligando o atributo lista
        lista = findViewById( R.id.lista );

        // colocando vários textos no arraylist
        String[] t = { "um", "dois", "três", "quatro", "cinco", "seis", "sete",
                       "oito", "nove", "dez", "onze", "doze", "treze", "sete",
                       "oito", "nove", "dez", "onze", "doze", "treze", "um",
                       "dois", "três", "quatro", "cinco", "seis"                };

        // coloca todas as strings do vetor t como elementos do arraylist textos
        textos.addAll( Arrays.asList(t) );

        // criar um adapter para nossa lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(

                this,                                  // contexto da activity
                android.R.layout.simple_list_item_1,   // o desenho de item já pronto
                android.R.id.text1,                    // o ID do TextView dentro do item
                textos                              ); // o ArrayList com as strings a serem exibidas

        // configurar a lista para utilizar este objeto adaptador
        lista.setAdapter( adaptador );

        EscutadorLista el = new EscutadorLista();

        // configurar a lista com o escutador de cliques comuns
        lista.setOnItemClickListener( el );

        //lista.setLongClickable(true);

        // configurar a lista com o escutador de cliques longos
        lista.setOnItemLongClickListener( el );
    }



    // Classe interna do objeto escutador de cliques na lista.

    private class EscutadorLista implements AdapterView.OnItemClickListener,
                                            AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // O parâmetro i é o número do item clicado ...
            Toast.makeText(MainActivity.this, "Clique comum: " + textos.get(i),
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            // O parâmetro i é o número do item clicado ...
            Toast.makeText(MainActivity.this, "Clique longo: " + textos.get(i),
                    Toast.LENGTH_SHORT).show();

            // receita de bolo: retornar true, indicando que o evento foi tratado.
            // se retornar false, vai querer tratar clique comum também
            return true;
        }

    }




}