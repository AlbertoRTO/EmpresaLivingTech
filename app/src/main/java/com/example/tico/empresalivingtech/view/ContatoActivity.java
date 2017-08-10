package com.example.tico.empresalivingtech.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tico.empresalivingtech.R;

public class ContatoActivity extends Activity {

    Button contato1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        contato1 = (Button)findViewById(R.id.contato1);

       contato1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
