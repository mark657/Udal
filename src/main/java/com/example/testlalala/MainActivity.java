package com.example.testlalala;

import androidx.appcompat.app.AppCompatActivity;
import java.io.FileNotFoundException;
import java.io.InputStream;
import android.net.Uri;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private final int Pick_image = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
         Button PickImage = (Button) findViewById(R.id.button);

        PickImage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick (View view){

                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");

                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case Pick_image:
                if(resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }}}





