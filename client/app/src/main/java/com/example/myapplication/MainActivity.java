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

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.common.TensorProcessor;
import org.tensorflow.lite.support.common.ops.NormalizeOp;
import org.tensorflow.lite.support.image.ImageProcessor;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.image.ops.ResizeWithCropOrPadOp;
import org.tensorflow.lite.support.image.ops.Rot90Op;
import org.tensorflow.lite.support.label.TensorLabel;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.example.myapplication.Utils.FileUtiil;


public class MainActivity extends Activity{

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

    /** A ByteBuffer to hold image data, to be feed into Tensorflow Lite as inputs. */
    private ByteBuffer imgData = null;

    /** An array to hold inference results, to be feed into Tensorflow Lite as outputs. */
    private float[][] labelProbArray = null;




    /** Input image TensorBuffer. */
    private TensorImage inputImageBuffer;

    /** Output probability TensorBuffer. */
    private TensorBuffer outputProbabilityBuffer;

    /** Processer to apply post processing of the output probability. */
    private TensorProcessor probabilityProcessor;


    TextureView textureView;

    Interpreter tflite;
    private final Interpreter.Options tfliteOptions = new Interpreter.Options();
    /** Labels corresponding to the output of the vision model. */
    private List<String> labels;

    /** Dimensions of inputs. */
    private static final int DIM_BATCH_SIZE = 1;

    private static final int DIM_PIXEL_SIZE = 1;

    static final int DIM_IMG_SIZE_X = 224;
    static final int DIM_IMG_SIZE_Y = 224;


    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128.0f;

    /* Preallocated buffers for storing image data in. */
    private int[] intValues = new int[DIM_IMG_SIZE_X * DIM_IMG_SIZE_Y];

    Map<String, Float> labeledProbability;

    private MappedByteBuffer tfliteModel;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager assetManager = getApplicationContext().getAssets();



        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open("cat.1569.jpg");
            bitmap = BitmapFactory.decodeStream(istr);
            bitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        float[] out = null;
        try {
            tfliteModel = FileUtiil.loadMappedFile(this, "t_cat_dog.tflite");
            tflite = new Interpreter(tfliteModel, tfliteOptions);

            // Loads labels out from the label file.
            labels = FileUtil.loadLabels(this, getLabelPath());

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


            inputImageBuffer = loadImage(bitmap,1);

            tflite.run(inputImageBuffer.getBuffer(), outputProbabilityBuffer.getBuffer().rewind());

            out = outputProbabilityBuffer.getFloatArray();


        } catch (IOException e) {
            e.printStackTrace();
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
        return "labels.txt";
    }

}
