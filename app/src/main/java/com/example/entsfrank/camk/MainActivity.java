package com.example.entsfrank.camk;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Activity request codes
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;

    // directory name to store captured images and videos
    private static final String IMAGE_DIRECTORY_NAME = "Hello Camera";

    private Uri fileUri;  //file Url to store image
    private ImageView imgPreview;
    private Button btnCapturePicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPreview = (ImageView)findViewById(R.id.imgPreview);
        btnCapturePicture = (Button)findViewById(R.id.btnCapturePicture);

    // capture image click event
        btnCapturePicture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //capture image
                captureImage();
            }
        });
    }
}
