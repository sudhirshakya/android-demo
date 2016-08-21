package io.sorus.temples;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {

    private static final int TAKE_PICTURE = 11;
    private static final int SELECT_PICTURE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    public void usePhoto (View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void takePhoto(View view) {
        Intent ii = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            ii.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(createImageFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        startActivityForResult(ii, TAKE_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK)
            usePicture();
        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK) {
            mCurrentPhotoPath = data.getData().toString();
            usePicture();
        }
    }

    private void usePicture() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Uri uri = Uri.parse(mCurrentPhotoPath);
        imageView.setImageURI(uri);
    }
}
