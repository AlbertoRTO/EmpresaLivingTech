package com.example.tico.empresalivingtech.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tico.empresalivingtech.R;

public class EmpresaActivity extends Activity {

    Button empresa1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);

      empresa1 = (Button)findViewById(R.id.empresa1);

        empresa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
