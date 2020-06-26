package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.tensorflow.lite.Interpreter;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;

import com.example.myapplication.Utils.FileUtiil;


public class MainActivity extends Activity{
    /** Image size along the x axis. */
    private int imageSizeX;

    /** Image size along the y axis. */
    private int imageSizeY;
    Interpreter tflite;
    private final Interpreter.Options tfliteOptions = new Interpreter.Options();

    private MappedByteBuffer tfliteModel;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            tfliteModel = FileUtiil.loadMappedFile(this, "converted_model.tflite");
            tflite = new Interpreter(tfliteModel, tfliteOptions);
            int[] input = new int[]{0};
            int[] output = new int[]{0};

            //tflite.run(input, output);
            int imageTensorIndex = 0;
            int[] imageShape = tflite.getInputTensor(imageTensorIndex).shape(); // {1, height, width, 3}
            imageSizeY = imageShape[1];
            imageSizeX = imageShape[2];

            Log.d("predict", String.valueOf(output[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
