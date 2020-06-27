
import matplotlib.pyplot as plt
import cv2
import os


x_train = []
y_train = []
x_test = []
y_test = []


foldernames = os.listdir('../catdog/training_set/training_set')

for k, folder in enumerate(foldernames):
    for file in os.listdir('../catdog/training_set/training_set' + '/'+folder):
        x_train.append(file)
    y_train += [k] * len(os.listdir('../catdog/training_set/training_set' + '/'+folder))


foldernames = os.listdir('../catdog/test_set/test_set')

for k, folder in enumerate(foldernames):
    for file in os.listdir('../catdog/test_set/test_set' + '/'+folder):
        x_test.append(file)
    y_test += [k] * len(os.listdir('../catdog/test_set/test_set' + '/'+folder))
