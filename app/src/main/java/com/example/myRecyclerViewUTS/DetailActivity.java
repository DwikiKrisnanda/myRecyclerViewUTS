package com.example.myRecyclerViewUTS;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("link") && getIntent().hasExtra("nama") && getIntent().hasExtra("posisi") && getIntent().hasExtra("umur") && getIntent().hasExtra("warganegara") && getIntent().hasExtra("no") && getIntent().hasExtra("detail")){

            String Link = getIntent().getStringExtra("link");
            String Nama = getIntent().getStringExtra("nama");
            String Posisi = getIntent().getStringExtra("posisi");
            String Umur = getIntent().getStringExtra("umur");
            String WargaNegara = getIntent().getStringExtra("warganegara");
            String No = getIntent().getStringExtra("no");
            String Detail = getIntent().getStringExtra("detail");

            setImage(Link,Nama,Posisi,Umur,WargaNegara,No,Detail);
        }
    }

    private void setImage(String Link, String Nama, String Posisi, String Umur, String WargaNegara, String No, String Detail){
        TextView namaDetail = findViewById(R.id.img_namaPemain);
        namaDetail.setText(Nama);
        TextView posisiDetail = findViewById(R.id.img_posisiPemain);
        posisiDetail.setText(Posisi);
        TextView umurDetail = findViewById(R.id.img_umurPemain);
        umurDetail.setText(Umur);
        TextView wargaNegaraDetail = findViewById(R.id.img_wargaNegara);
        wargaNegaraDetail.setText(WargaNegara);
        TextView noDetail = findViewById(R.id.img_noPemain);
        noDetail.setText(No);
        TextView det = findViewById(R.id.img_detailPemain);
        det.setText(Detail);

        ImageView gambarDetail = findViewById(R.id.imagePemain);
        Glide.with(this)
                .asBitmap()
                .load(Link)
                .into(gambarDetail);
    }
}