import tensorflow as tf

converter = tf.lite.TFLiteConverter.from_saved_model('./model/cat_dog_cnn')

tflite_model = converter.convert()
open("./liteModel/cat_dog_cnn.tflite", "wb").write(tflite_model)