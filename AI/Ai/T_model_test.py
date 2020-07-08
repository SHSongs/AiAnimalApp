import tensorflow as tf
import os
import cv2
import numpy as np

img = cv2.imread('../catdog/training_set/training_set/dogs/dog.17.jpg')
img = cv2.resize(img, (224, 224))
img = img.reshape(1,224,224,3)

x_test = []

foldernames = os.listdir('../catdog/test_set/test_set')
for k, folder in enumerate(foldernames):
    for c, file in enumerate(os.listdir('../catdog/test_set/test_set' + '/' + folder)):
        if c >= 1:
            break
        print(file)
        img = cv2.imread('../catdog/test_set/test_set' + '/' + folder + '/' + file)

        img = cv2.resize(img, (224, 224))
        img = img.reshape(224, 224, 3)

        x_test.append(img)

x_test = np.array(x_test)

model = tf.keras.models.load_model('./model/cat_dog.hdf5')
model.save('./model/t_cat_dog')
converter = tf.lite.TFLiteConverter.from_saved_model('./model/t_cat_dog')

tflite_model = converter.convert()
open("./liteModel/t_cat_dog.tflite", "wb").write(tflite_model)



result = model.predict(x_test)


print(result)
