package com.example.tico.empresalivingtech.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tico.empresalivingtech.R;

public class ServicoActivity extends Activity {

    Button servico1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        servico1 = (Button) findViewById(R.id.serviço1);

        servico1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
