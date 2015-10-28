package br.com.example.miranda.projeto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.example.miranda.projeto.R;
import br.com.example.miranda.projeto.adapters.RouteAdapter;
import br.com.example.miranda.projeto.services.RouteListener;
import br.com.example.miranda.projeto.services.RouteResult;
import br.com.example.miranda.projeto.services.ServiceGenerator;
import br.com.example.miranda.projeto.services.Stop;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private EditText localizacao;
    private Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localizacao = (EditText) findViewById(R.id.editText);
        buscar = (Button) findViewById(R.id.button);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final List<RouteResult> listRouteResult = retornaRotas(localizacao.getText().toString());
                ListView listView = (ListView) findViewById(R.id.listView);
                RouteAdapter adapter = new RouteAdapter(MainActivity.this, listRouteResult);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                        RouteResult routeResult = listRouteResult.get(position);
                        carregaEstradasEhorarios(routeResult);

                        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("routeResult", (Serializable) routeResult);
                        intent.putExtras(bundle);

                        startActivity(intent);
                    }
                });

            }
        });
    }


    private List<RouteResult> retornaRotas(String localizacao) {
        List<RouteResult> listRouteResult = new ArrayList<RouteResult>();

        RouteListener routeListener = ServiceGenerator.createService(RouteListener.class);
        Stop stop = new Stop("%" + localizacao + "%");
        routeListener.getRoutesByStopName(stop, new Callback<JsonElement>() {
            @Override
            public void success(JsonElement jsonElement, Response response) {
                Toast.makeText(getApplicationContext(), jsonElement.toString(), Toast.LENGTH_LONG).show();
                // carregar listRouteResult com as rotas retornadas
            }
            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        listRouteResult.add(new RouteResult("1", "Pantanal"));
        return listRouteResult;
    }


    private void carregaEstradasEhorarios(RouteResult routeResult) {
        // carregar estradas e horários

    }


}