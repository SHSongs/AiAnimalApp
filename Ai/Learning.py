import tensorflow as tf
import matplotlib.pyplot as plt
import cv2
import os
import numpy as np
import random
x_train = []
y_train = []
x_test = []
y_test = []

foldernames = os.listdir('../catdog/training_set/training_set')

for k, folder in enumerate(foldernames):
    len = 0
    for c, file in enumerate(os.listdir('../catdog/training_set/training_set' + '/' + folder)):
        if c > 1500:
            len = c
            break
        img = cv2.imread('../catdog/training_set/training_set' + '/' + folder + '/' + file)
        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        img = cv2.resize(gray, (224, 224))
        img = img.reshape(224, 224, 1)
        x_train.append(img)
    y_train += [k] * len

foldernames = os.listdir('../catdog/test_set/test_set')

for k, folder in enumerate(foldernames):
    len = 0
    for c, file in enumerate(os.listdir('../catdog/test_set/test_set' + '/' + folder)):
        if c > 100:
            len = c
            break
        img = cv2.imread('../catdog/test_set/test_set' + '/' + folder + '/' + file)
        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        img = cv2.resize(gray, (224, 224))
        img = img.reshape(224, 224, 1)
        x_test.append(img)
    y_test += [k] * len

x_train = np.array(x_train)
y_train = np.array(y_train)
x_test = np.array(x_test)
y_test = np.array(y_test)


x_train = x_train / 255.0
x_test = x_test / 255.0



y_train = tf.keras.utils.to_categorical(y_train)
y_test = tf.keras.utils.to_categorical(y_test)

print(y_train)
#
# model = tf.keras.Sequential([
#     tf.keras.layers.Convolution2D(filters=64, kernel_size=(3, 3),
#                                   padding='same', activation='relu', input_shape=(224, 224, 1)),
#     tf.keras.layers.Convolution2D(filters=64, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
#     tf.keras.layers.Convolution2D(filters=64, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
#     tf.keras.layers.MaxPooling2D(pool_size=(2, 2),
#                                  strides=(1, 1), padding='valid'),
#     tf.keras.layers.Convolution2D(filters=128, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
#     tf.keras.layers.Convolution2D(filters=128, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
#     tf.keras.layers.MaxPooling2D(pool_size=(2, 2),
#                                  strides=(1, 1), padding='valid'),
#     tf.keras.layers.Convolution2D(filters=256, kernel_size=(3, 3), activation='relu'),
#     tf.keras.layers.Convolution2D(filters=256, kernel_size=(3, 3), activation='relu'),
#     tf.keras.layers.MaxPooling2D(pool_size=(2, 2),
#                                  strides=(1, 1), padding='valid'),
#
#     tf.keras.layers.Flatten(),
#     tf.keras.layers.Dense(2, activation='softmax')
# ])
#
# model.compile(optimizer=tf.keras.optimizers.Adam(), loss='categorical_crossentropy', metrics=['accuracy'])
#
# his = model.fit(x_train, y_train, epochs=100, batch_size=100)
#
# test_loss, test_acc = model.evaluate(x_test,  y_test, verbose=2)
# print(test_acc)
#
# model.save('./model/cat_dog_cnn')
#
# converter = tf.lite.TFLiteConverter.from_saved_model('./model/cat_dog_cnn')
#
# tflite_model = converter.convert()
# open("./liteModel/cat_dog_cnn.tflite", "wb").write(tflite_model)
