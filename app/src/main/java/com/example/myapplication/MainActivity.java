package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    String URL;
    private Bitmap downloadedImage;

    Button downloadbutton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.texturl);


    }



    public void Download_Image_AsyncTask(View view) {
        DownloadImage obj = new DownloadImage();
        try {

            URL=editText.getText().toString();
            Bitmap bitmap = obj.execute(URL).get();

            ImageFragment imageFragment1=  (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.frag1);

            ImageFragment imageFragment2=  (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.frag2);

            ImageFragment imageFragment3=  (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.frag3);

            ImageFragment imageFragment4=  (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.frag4);


            imageFragment1.setImage(bitmap);
            imageFragment2.setImage(bitmap);
            imageFragment3.setImage(bitmap);
            imageFragment4.setImage(bitmap);

            downloadedImage = bitmap;


        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Bitmap getDownloadedImage() {
        return downloadedImage;
    }


    public class DownloadImage extends AsyncTask<String,Void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Log.d("TAG","doInBackground() in progress...");
                return bitmap;

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
