package com.example.kietnguyen.mediaappmusic;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtTimeSong, txtTimeTotal, txtTitle;
    SeekBar seekbarSong;
    ImageView btnPrevious, btnPlay, btnNext;
    MediaPlayer mediaPlayer;

    ArrayList<Song> arraySong;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        AddSong();
        KhoiTaoMediaPlayer();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.stop);
                }else{
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.play);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                position++;
                if(position > arraySong.size() - 1){
                    position = 0;
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
            }
        });
    }

    private void UpdateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdanggio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhdanggio.format(mediaPlayer.getCurrentPosition()));
                seekbarSong.setProgress(mediaPlayer.getCurrentPosition());
                // kiem tra thoi gian bai hat hoan thanh thi chuyen bai khac
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                            mediaPlayer.release();
                        }
                        position++;
                        if(position > arraySong.size() - 1){
                            position = 0;
                        }
                        KhoiTaoMediaPlayer();
                        mediaPlayer.start();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void KhoiTaoMediaPlayer() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
        SetTimeTotal();
        UpdateTimeSong();
    }

    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Anh Phai Quen", R.raw.anhphaiquencaonamthanh));
        arraySong.add(new Song("Khau Lai Trai Tim Em", R.raw.khaulaitraitimemhaanh));
        arraySong.add(new Song("Nguoi La Thoang Qua", R.raw.nguoilathoangquakhoimy));
        arraySong.add(new Song("Thu Tu Nguoi Thuong Cu", R.raw.thutunguoithuongcutruongkieudiem));
        arraySong.add(new Song("Tinh Ban", R.raw.tinhbantuduatuanhung));


    }

    private void AnhXa() {
        txtTimeSong = findViewById(R.id.txtTimeSong);
        txtTimeTotal = findViewById(R.id.txtTimeTotal);
        txtTitle = findViewById(R.id.textviewTitle);
        btnPrevious = findViewById(R.id.imgButtonPrevious);
        btnPlay = findViewById(R.id.imgButtonPlay);
        btnNext = findViewById(R.id.imgButtonNext);
        seekbarSong = findViewById(R.id.seekbarProgress);

    }

    private void SetTimeTotal(){
        final SimpleDateFormat dinhdanggio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhdanggio.format(mediaPlayer.getDuration()) + "");
        seekbarSong.setMax((int)mediaPlayer.getDuration());
        seekbarSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtTimeSong.setText(dinhdanggio.format(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekbarSong.getProgress());
                txtTimeSong.setText(dinhdanggio.format(seekbarSong.getProgress()));
            }
        });
    }


}
