package com.xinlan.imageprocessndk;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinlan.imageeditlibrary.editimage.fliter.PhotoProcessing;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    private ImageView mImageView;
    private Button mLoadBtn;

    private Bitmap mBit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image);
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener((v) -> {
            Bitmap b = null;
            try {
                b = BitmapFactory.decodeStream(getAssets().open("along.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            final Bitmap bit2 = Bitmap.createBitmap(b.copy(Bitmap.Config.ARGB_8888, true));
            int width = bit2.getWidth();
            int height = bit2.getHeight();
            int[] pixels = new int[width * height];

            bit2.getPixels(pixels, 0, width, 0, 0, width, height);

            for (int i = 0; i < pixels.length; i++) {
                int clr = pixels[i];

                int alpha = (clr & 0xff000000)>>>24;
                int red = (clr & 0x00ff0000) >>> 16; // 取高两位
                int green = (clr & 0x0000ff00) >>> 8; // 取中两位
                int blue = clr & 0x000000ff; // 取低两位

                //System.out.println(Integer.toHexString(clr)+"   ARGB = " + alpha +" "+ red +" "+green +" "+blue);
            }


            final Bitmap bit = Bitmap.createBitmap(b.copy(Bitmap.Config.ARGB_8888, true));


            PhotoProcessing.handleSmooth(bit, 374.0f);
            mImageView.setImageBitmap(bit);
        });


        mLoadBtn = findViewById(R.id.load);
        mLoadBtn.setOnClickListener((v) -> {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int imageWidth = metrics.widthPixels / 2;
            int imageHeight = metrics.heightPixels / 2;

            String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + File.separator + "along.jpg";
            mBit = BitmapUtils.getSampledBitmap(path, imageWidth, imageHeight);

            mImageView.setImageBitmap(mBit);
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }
}
