package com.example.myapplication;

import static com.example.myapplication.R.id.urlimage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class ImageFragment extends Fragment {

    ImageView imageView;
    boolean imageposition = true;
    public void setImage(Bitmap imageBitmap) {
        imageView.setImageBitmap(imageBitmap);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        imageView = view.findViewById(urlimage);


        imageView.setVisibility(View.VISIBLE);


        imageView.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (imageposition) {
                    //If image is visible, hide it
                    imageView.setVisibility(View.GONE);
                    imageposition = false;

                } else {
                    // If image is hidden, show it
                    imageView.setVisibility(View.VISIBLE);
                    imageposition = true;

                }


            }
                });


        int res;
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                if (imageView.getVisibility() == View.VISIBLE) {
//                   res= imageView.getVisibility() = View.GONE;
//                } else {
//                    res= imageView.getVisibility() = View.VISIBLE;
//                }
//            }
//
//
//        });



        return view;
    }
}
