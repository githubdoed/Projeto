package br.com.example.miranda.projeto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.example.miranda.projeto.R;
import br.com.example.miranda.projeto.services.RouteResult;

public class DetailsActivity extends AppCompatActivity {

    private Button voltar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        resultado = (TextView) findViewById(R.id.textView3);
        Intent intent = getIntent();
        RouteResult routeResult = (RouteResult) intent.getExtras().getSerializable("routeResult");
        resultado.setText(retornaTextoResultado(routeResult));

        voltar = (Button) findViewById(R.id.button2);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private StringBuilder retornaTextoResultado(RouteResult routeResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rota: " + routeResult.getNmRoute());
        stringBuilder.append("\nEstradas...");
        stringBuilder.append("\nHorários...");
        return stringBuilder;
    }
}
