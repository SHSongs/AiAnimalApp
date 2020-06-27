package com.example.myapplication;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;

import org.tensorflow.lite.Interpreter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

import com.example.myapplication.Utils.FileUtiil;


public class MainActivity extends Activity{
    /** Image size along the x axis. */
    private int imageSizeX;

    /** Image size along the y axis. */
    private int imageSizeY;

    /** A ByteBuffer to hold image data, to be feed into Tensorflow Lite as inputs. */
    private ByteBuffer imgData = null;

    /** An array to hold inference results, to be feed into Tensorflow Lite as outputs. */
    private float[][] labelProbArray = null;

    TextureView textureView;

    Interpreter tflite;
    private final Interpreter.Options tfliteOptions = new Interpreter.Options();


    /** Dimensions of inputs. */
    private static final int DIM_BATCH_SIZE = 1;

    private static final int DIM_PIXEL_SIZE = 1;

    static final int DIM_IMG_SIZE_X = 224;
    static final int DIM_IMG_SIZE_Y = 224;


    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128.0f;

    /* Preallocated buffers for storing image data in. */
    private int[] intValues = new int[DIM_IMG_SIZE_X * DIM_IMG_SIZE_Y];


    private MappedByteBuffer tfliteModel;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager assetManager = getApplicationContext().getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open("fox.jpg");
            bitmap = BitmapFactory.decodeStream(istr);
            bitmap = Bitmap.createScaledBitmap(bitmap, 28, 28, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            tfliteModel = FileUtiil.loadMappedFile(this, "converted_model.tflite");
            tflite = new Interpreter(tfliteModel, tfliteOptions);


            int imageTensorIndex = 0;

            int[] imageShape = tflite.getInputTensor(imageTensorIndex).shape();
            imageSizeY = imageShape[1];
            imageSizeX = imageShape[2];


        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /** Writes Image data into a {@code ByteBuffer}. */
    private void convertBitmapToByteBuffer(Bitmap bitmap) {
        if (imgData == null) {
            return;
        }
        imgData.rewind();
        bitmap.getPixels(intValues, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        // Convert the image to floating point.
        int pixel = 0;
        for (int i = 0; i < DIM_IMG_SIZE_X; ++i) {
            for (int j = 0; j < DIM_IMG_SIZE_Y; ++j) {
                final int val = intValues[pixel++];
                imgData.putFloat((((val >> 16) & 0xFF)-IMAGE_MEAN)/IMAGE_STD);
                imgData.putFloat((((val >> 8) & 0xFF)-IMAGE_MEAN)/IMAGE_STD);
                imgData.putFloat((((val) & 0xFF)-IMAGE_MEAN)/IMAGE_STD);
            }
        }
    }

}
