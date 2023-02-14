package com.cursoandroid.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        //capiturando o campo imagem da tela
        ImageView imageResultado = findViewById(R.id.imageView);
        //capiturando o campo texto da tela
        TextView textReposta = findViewById(R.id.txtMensagem);

        int numero = new Random().nextInt(3);//0 1 2 gera um numero entre 0 e 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero]; // grava na variavel a palavra correspondente a posssição no array

        // modo de mostra a imagem escolhida pelo App
        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        // verificação se o App ganho do jogador
        if (
                (opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                        (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                        (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))
        ) {
            textReposta.setText("App Ganhou!");
        } else if (
                (opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                        (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura")) ||
                        (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra"))
        ) {
            textReposta.setText("Você Ganhou!");
        } else {
            textReposta.setText("Houve um empate!");
        }

    }


}