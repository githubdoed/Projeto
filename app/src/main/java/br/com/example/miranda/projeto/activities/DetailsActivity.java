package br.com.example.miranda.projeto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.example.miranda.projeto.R;
import br.com.example.miranda.projeto.services.pojos.Body;
import br.com.example.miranda.projeto.services.pojos.Departure;
import br.com.example.miranda.projeto.services.DepartureDeserializer;
import br.com.example.miranda.projeto.services.pojos.Params;
import br.com.example.miranda.projeto.services.pojos.PojoDeparture;
import br.com.example.miranda.projeto.services.pojos.PojoStreet;
import br.com.example.miranda.projeto.services.pojos.Route;
import br.com.example.miranda.projeto.services.RouteListener;
import br.com.example.miranda.projeto.services.ServiceGenerator;
import br.com.example.miranda.projeto.services.pojos.Street;
import br.com.example.miranda.projeto.services.StreetDeserializer;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetailsActivity extends AppCompatActivity {

    private Button voltar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView = (TextView) findViewById(R.id.textView3);
        textView.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        Route route = (Route) intent.getExtras().getSerializable("route");
        Body body = new Body(new Params(null, route.getId()));

        ServiceGenerator.createService(RouteListener.class).getDeparturesByRouteId(body, new Callback<JsonElement>() {
            @Override
            public void success(JsonElement jsonElement, Response response) {
                Gson gson = new GsonBuilder().registerTypeAdapter(PojoDeparture.class, new DepartureDeserializer()).create();
                final Map<String, List<Departure>> mapDeparture = gson.fromJson(jsonElement, PojoDeparture.class).getMapDeparture();
                preenchaTextViewComHorarios(mapDeparture);
            }
            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        ServiceGenerator.createService(RouteListener.class).getStopsByRouteId(body, new Callback<JsonElement>() {
            @Override
            public void success(JsonElement jsonElement, Response response) {
                Gson gson = new GsonBuilder().registerTypeAdapter(PojoStreet.class, new StreetDeserializer()).create();
                final List<Street> streets = gson.fromJson(jsonElement, PojoStreet.class).getStreets();
                preenchaTextViewComRuas(streets);
            }
            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        voltar = (Button) findViewById(R.id.button2);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void preenchaTextViewComHorarios(Map<String, List<Departure>> mapDeparture) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("HORÁRIOS:\n\n");
        Set<String> keys = mapDeparture.keySet();
        for(String key : keys) {
            resultado.append(retornaTipo(key)).append("\n");
            for(Departure departure : mapDeparture.get(key)) {
                resultado.append(departure.getTime()).append("  ");
            }
            resultado.append("\n");
        }
        textView.setText(resultado.toString());
    }

    private void preenchaTextViewComRuas(List<Street> streets) {
        StringBuilder resultado = new StringBuilder();
        resultado.append(textView.getText().toString());
        resultado.append("\n\nPARADAS:\n\n");
        for (Street street : streets) {
            resultado.append(street.getName()).append("\n");
        }
        textView.setText(resultado.toString());
    }

    private String retornaTipo(String key) {
        if ("WEEKDAY".equals(key)) {
            return "Dias da Semana";
        } else if ("SATURDAY".equals(key)) {
            return "Sábados";
        } else {
            return "Domingos";
        }
    }
}
