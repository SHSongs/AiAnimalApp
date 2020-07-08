import tensorflow as tf

model = tf.keras.Sequential([
    tf.keras.layers.Convolution2D(filters=64, kernel_size=(3, 3),
                                  padding='same', activation='relu', input_shape=(224, 224, 3)),
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
    tf.keras.layers.Convolution2D(filters=512, kernel_size=(3, 3), activation='relu'),
    tf.keras.layers.Convolution2D(filters=512, kernel_size=(3, 3), activation='relu'),
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2),
                                 strides=(1, 1), padding='valid'),


    tf.keras.layers.Flatten(),
    tf.keras.layers.Dense(100, activation='relu'),
    tf.keras.layers.Dense(2, activation='softmax')
])

print(model.summary())