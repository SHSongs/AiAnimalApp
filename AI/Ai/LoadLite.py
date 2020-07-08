import tensorflow as tf
import tensorflow as tf
import matplotlib.pyplot as plt
import cv2
import os
import numpy as np
import time

model = tf.keras.models.load_model('./model/cat_dog.hdf5')


x_test = []
y_test = []

foldernames = os.listdir('../catdog/training_set/training_set')

for k, folder in enumerate(foldernames):
    len = 0
    for c, file in enumerate(os.listdir('../catdog/test_set/test_set' + '/' + folder)):
        if c > 3:
            len = c
            break
        img = cv2.imread('../catdog/test_set/test_set' + '/' + folder + '/' + file)
        pp = plt.imread('../catdog/test_set/test_set' + '/' + folder + '/' + file)

        img = cv2.resize(img, (224, 224))
        img = img.reshape(224, 224, 3)
        plt.imshow(pp)
        print('a')
        time.sleep(3)
        x_test.append(img)
    y_test += [k] * len

x_test = np.array(x_test)
y_test = np.array(y_test)

x_test = x_test / 255.0

loss, acc = model.evaluate(x_test,  y_test, verbose=2)
print("복원된 모델의 정확도: {:5.2f}%".format(100*acc))