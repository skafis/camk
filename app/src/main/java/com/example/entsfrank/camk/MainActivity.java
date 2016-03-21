package com.example.entsfrank.camk;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
//        Capturing Camera Image will lauch camera app requrest image capture
        private void captureImage(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        //start image Capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }
//    Receiving activity result method will be called after closing the camera

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if the result is capturing Image
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE){
            if (requestCode == RESULT_OK){
                // successfully captured the image
                // display it in image view
                previewCapturedImage();
                }else if (resultCode == RESULT_CANCELED){
                //user cancelled Image Capture
                Toast.makeText(getApplicationContext(),"User cancelled image capture",Toast.LENGTH_SHORT).show();
            } else {
                //failed to capture image
                Toast.makeText(getApplicationContext(),"Sorry failed to capture image", Toast.LENGTH_SHORT).show();
            }
        }
//        super.onActivityResult(requestCode, resultCode, data);
    }
}
}
