import tensorflow as tf
import matplotlib.pyplot as plt
import cv2
import os
import numpy as np

x_train = []
y_train = []
x_test = []
y_test = []

foldernames = os.listdir('../catdog/training_set/training_set')

for k, folder in enumerate(foldernames):
    for file in os.listdir('../catdog/training_set/training_set' + '/' + folder):
        img = cv2.imread('../catdog/training_set/training_set' + '/' + folder + '/' + file)
        x_train.append(img)
    y_train += [k] * len(os.listdir('../catdog/training_set/training_set' + '/' + folder))

foldernames = os.listdir('../catdog/test_set/test_set')

for k, folder in enumerate(foldernames):
    for file in os.listdir('../catdog/test_set/test_set' + '/' + folder):
        img = cv2.imread('../catdog/test_set/test_set' + '/' + folder + '/' + file)
        x_test.append(img)
    y_test += [k] * len(os.listdir('../catdog/test_set/test_set' + '/' + folder))


x_train = x_train[0:10]
y_train = y_train[0:10]

x_train = np.array(x_train)
y_train = np.array(y_train)
x_test = np.array(x_test)
y_test = np.array(y_test)

print(x_train.shape)

model = tf.keras.Sequential([
    tf.keras.layers.Convolution2D(filters=64, kernel_size=(3, 3),
                                  padding='same', activation='relu', input_shape=(224, 224, 1)),
    tf.keras.layers.Convolution2D(filters=64, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
    tf.keras.layers.Convolution2D(filters=64, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2),
                                 strides=(1, 1), padding='valid'),
    tf.keras.layers.Convolution2D(filters=128, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
    tf.keras.layers.Convolution2D(filters=128, kernel_size=(3, 3), activation='relu', strides=(2, 2)),
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2),
                                 strides=(1, 1), padding='valid'),
    tf.keras.layers.Convolution2D(filters=256, kernel_size=(3, 3), activation='relu'),
    tf.keras.layers.Convolution2D(filters=256, kernel_size=(3, 3), activation='relu'),
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2),
                                 strides=(1, 1), padding='valid'),

    tf.keras.layers.Flatten(),
    tf.keras.layers.Dense(2, activation='softmax')
])

model.compile(optimizer=tf.keras.optimizers.Adam(), loss='categorical_crossentropy', metrics=['accuracy'])

x_train = 1 - x_train / 255.0
x_test = 1 - x_test / 255.0

y_train = tf.keras.utils.to_categorical(y_train)
y_test = tf.keras.utils.to_categorical(y_test)

x_train = x_train.reshape((-1,224,224,1))
x_test = x_test.reshape((-1,224,224,1))


his = model.fit(x_train, y_train, epochs=1, batch_size=10, validation_split=0.2)



print(his.history['acc'])

model.save('./model/cat_dog_cnn')

converter = tf.lite.TFLiteConverter.from_saved_model('./model/cat_dog_cnn')

tflite_model = converter.convert()
open("./liteModel/cat_dog_cnn.tflite","wb").write(tflite_model)