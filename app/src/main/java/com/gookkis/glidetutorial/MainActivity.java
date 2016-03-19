package com.gookkis.glidetutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button btnSimple, btnPlaceholder, btnResizeCrop;
    ImageView imageView;
    public static String urlSimple = "http://www.gookkis.com/wp-content/uploads/2016/03/orzgDBXs.png";
    public static String urlPlaceholder = "http://www.gookkis.com/wp-content/uploads/2016/03/hello-android.png";
    public static String urlResizeCrop = "http://www.gookkis.com/wp-content/uploads/2016/03/android.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        initOnClick();
    }

    public void initView() {

        //inisialisasi button
        btnSimple = (Button) findViewById(R.id.btn_simple);
        btnPlaceholder = (Button) findViewById(R.id.btn_placeholder);
        btnResizeCrop = (Button) findViewById(R.id.btn_resize_crop);

        //inisialisasi image view
        imageView = (ImageView) findViewById(R.id.image_view);

    }

    private void initOnClick() {

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //perintah menampilkan gambar dari url
                Glide.with(MainActivity.this)
                        .load(urlSimple)
                        .into(imageView);
            }
        });

        btnPlaceholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //perintah menampilkan gambar dari url dan menambahkan placeholder
                Glide.with(MainActivity.this)
                        .load(urlPlaceholder)
                                //placeholder berfungsi menampilkan gambar sebelum dimuat
                        .placeholder(R.drawable.placeholder)
                                //error menampilkan gambar jika terjadi eror saat load gambar dari url
                        .error(R.drawable.notfound)
                        .into(imageView);
            }
        });

        btnResizeCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //perintah menampilkan gambar dari url dan melakukan rezisepada gambar mnjadi 50px x 50px,
                //sehingga gambar terlihat pecah karena dari ukuran aslinya adalah 300px x 300px
                Glide.with(MainActivity.this)
                        .load(urlResizeCrop)
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.notfound)
                        //resize gambar/bitmap menjadi 50 x 50
                        .override(50, 50)
                        //methode center crop
                        .centerCrop()
                        .into(imageView);
            }
        });
    }
}
