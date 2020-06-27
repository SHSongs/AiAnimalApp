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
    for file in os.listdir('../catdog/training_set/training_set' + '/'+folder):
        img = cv2.imread('../catdog/training_set/training_set' + '/' + folder + '/'+file)
        x_train.append(img)
    y_train += [k] * len(os.listdir('../catdog/training_set/training_set' + '/'+folder))


foldernames = os.listdir('../catdog/test_set/test_set')

for k, folder in enumerate(foldernames):
    for file in os.listdir('../catdog/test_set/test_set' + '/'+folder):
        img = cv2.imread('../catdog/test_set/test_set' + '/' + folder + '/'+file)
        x_test.append(img)
    y_test += [k] * len(os.listdir('../catdog/test_set/test_set' +'/' +folder))


x_train = np.array(x_train)
y_train = np.array(y_train)
x_test = np.array(x_test)
y_test = np.array(y_test)

print(x_train.shape)