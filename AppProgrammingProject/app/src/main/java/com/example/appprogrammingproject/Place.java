package com.example.appprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appprogrammingproject.Utils.FileUtiil;

import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.TensorProcessor;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.TensorLabel;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.common.ops.NormalizeOp;
import org.tensorflow.lite.support.image.ImageProcessor;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.image.ops.ResizeWithCropOrPadOp;
import org.tensorflow.lite.support.image.ops.Rot90Op;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class Place extends AppCompatActivity {


    /**
     * Float model does not need dequantization in the post-processing. Setting mean and std as 0.0f
     * and 1.0f, repectively, to bypass the normalization.
     */
    private static final float PROBABILITY_MEAN = 0.0f;

    private static final float PROBABILITY_STD = 1.0f;


    /** Image size along the x axis. */
    private int imageSizeX;

    /** Image size along the y axis. */
    private int imageSizeY;


    /** Input image TensorBuffer. */
    private TensorImage inputImageBuffer;

    /** Output probability TensorBuffer. */
    private TensorBuffer outputProbabilityBuffer;

    /** Processer to apply post processing of the output probability. */
    private TensorProcessor probabilityProcessor;


    Interpreter tflite;
    private final Interpreter.Options tfliteOptions = new Interpreter.Options();
    /** Labels corresponding to the output of the vision model. */

    /** Labels corresponding to the output of the vision model. */
    private List<String> labels;


    Map<String, Float> labeledProbability;


    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128.0f;
    private MappedByteBuffer tfliteModel;



    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;
    TextView textView;

    Bitmap imageBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        dispatchTakePictureIntent();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            this.imageBitmap = imageBitmap;
            imageView.setImageBitmap(imageBitmap);

            predict();

        }
    }


    @SuppressLint("DefaultLocale")
    private void predict(){

        AssetManager assetManager = getApplicationContext().getAssets();

        InputStream istr;
        try {

            labels = FileUtil.loadLabels(this, getLabelPath());
            tfliteModel = FileUtiil.loadMappedFile(this, "place_cnn.tflite");
            //istr = assetManager.open("dog.4.jpg");
            //imageBitmap = BitmapFactory.decodeStream(istr);
            imageBitmap = Bitmap.createScaledBitmap(imageBitmap, 224, 224, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tflite = new Interpreter(tfliteModel, tfliteOptions);

        int imageTensorIndex = 0;

        int[] imageShape = tflite.getInputTensor(imageTensorIndex).shape();
        imageSizeY = imageShape[1];
        imageSizeX = imageShape[2];
        DataType imageDataType = tflite.getInputTensor(imageTensorIndex).dataType();
        int probabilityTensorIndex = 0;
        int[] probabilityShape =
                tflite.getOutputTensor(probabilityTensorIndex).shape(); // {1, NUM_CLASSES}
        DataType probabilityDataType = tflite.getOutputTensor(probabilityTensorIndex).dataType();




        // Creates the input tensor.
        inputImageBuffer = new TensorImage(imageDataType);

        // Creates the output tensor and its processor.
        outputProbabilityBuffer = TensorBuffer.createFixedSize(probabilityShape, probabilityDataType);


        // Creates the post processor for the output probability.
        // fixme 넣을까 말까?
        probabilityProcessor = new TensorProcessor.Builder().add(getPostprocessNormalizeOp()).build();


        inputImageBuffer = loadImage(imageBitmap,1);

        tflite.run(inputImageBuffer.getBuffer(), outputProbabilityBuffer.getBuffer().rewind());


        labeledProbability =
                new TensorLabel(labels, probabilityProcessor.process(outputProbabilityBuffer))
                        .getMapWithFloatValue();


        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (Object o : sortByValue(labeledProbability)) {
            if(i > 2){
                break;
            }
            String temp = (String) o;
            float persent = 0;
            persent = labeledProbability.get(temp);
            persent = persent * 100;

            sb.append(temp).append(" = ").append(String.format("%.3f",persent)).append("%\n");
            i++;
        }

        textView.setText(sb.toString());

    }
    public List sortByValue(final Map map) {
        ArrayList list = new ArrayList(map.keySet());

        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });

        // Collections.reverse(list); // 주석시 오름차순

        return list;
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    private TensorImage loadImage(Bitmap bitmap,int sensorOrientation) {
        inputImageBuffer.load(bitmap);
        int cropSize = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int numRotation = sensorOrientation / 90;
        // TODO(b/143564309): Fuse ops inside ImageProcessor.
        ImageProcessor imageProcessor =
                new ImageProcessor.Builder()
                        .add(new ResizeWithCropOrPadOp(cropSize, cropSize))
                        .add(new ResizeOp(imageSizeX, imageSizeY, ResizeOp.ResizeMethod.NEAREST_NEIGHBOR))
                        .add(new Rot90Op(numRotation))
                        .add(getPreprocessNormalizeOp())
                        .build();
        return imageProcessor.process(inputImageBuffer);
    }


    protected TensorOperator getPreprocessNormalizeOp() {
        return new NormalizeOp(IMAGE_MEAN, IMAGE_STD);
    }
    protected TensorOperator getPostprocessNormalizeOp() {
        return new NormalizeOp(PROBABILITY_MEAN, PROBABILITY_STD);
    }

    protected String getLabelPath() {
        return "place_labels.txt";
    }
}
