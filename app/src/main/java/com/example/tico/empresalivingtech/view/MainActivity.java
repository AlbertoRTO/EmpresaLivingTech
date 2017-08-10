package com.example.tico.empresalivingtech.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tico.empresalivingtech.R;

public class MainActivity extends Activity {


    private ImageView botaoEmpresa;
    private ImageView botaoServico;
    private ImageView botaoContato;
    private ImageView botaoCliente;
    private ImageView botaoCadastrar;
    Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSair = (Button)findViewById(R.id.empresa1);

        botaoEmpresa = (ImageView) findViewById(R.id.empresaId);
        botaoServico = (ImageView) findViewById(R.id.servicoId);
        botaoContato = (ImageView) findViewById(R.id.contatoId);
        botaoCliente = (ImageView) findViewById(R.id.clienteId);
        botaoCadastrar = (ImageView) findViewById(R.id.cadastroId);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        botaoEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmpresaActivity.class));
            }
        });
        botaoServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ServicoActivity.class));
            }
        });
        botaoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContatoActivity.class));
            }
        });
        botaoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClienteActivity.class));
            }
        });
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });

    }
}
