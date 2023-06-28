package com.example.reproductorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private ImageView foto;
    private TextView titulo;
    private int posicion = 0;
    private int[] lista = {R.raw.sikora, R.raw.yankee, R.raw.bad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foto = findViewById(R.id.foto);
        titulo = findViewById(R.id.titulo);

        mediaPlayer = MediaPlayer.create(this, lista[posicion]);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    foto();
                }
                break;
            case R.id.btnPause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    foto();
                }
                break;
            case R.id.btnStop:
                mediaPlayer.stop();
                posicion= 0;
                foto();
                mediaPlayer= MediaPlayer.create(this, lista[posicion]);
                break;
            case R.id.btnAnt:
                if (posicion== 0) {
                    posicion= lista.length - 1;
                    foto();
                } else {
                    posicion--;
                    foto();
                }
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, lista[posicion]);
                mediaPlayer.start();
                break;
            case R.id.btnSig:
                if (posicion== lista.length - 1) {
                    posicion= 0;
                    foto();
                } else {
                    posicion++;
                    foto();
                }
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, lista[posicion]);
                mediaPlayer.start();
                break;
            default:
                break;
        }
    }

    public void foto(){
        if (posicion== 0) {
            foto.setImageResource(R.drawable.sikora);
            titulo.setText(R.string.cancion1);
        }
        else if(posicion== 1){
            foto.setImageResource(R.drawable.yankee);
            titulo.setText(R.string.cancion2);
        }
        else if(posicion== 2){
            foto.setImageResource(R.drawable.bad);
            titulo.setText(R.string.cancion3);
        }
    }

}