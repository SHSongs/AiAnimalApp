import tensorflow as tf


def model_common(inputs, outputs, model_path):
    with tf.Session() as sess:
        sess.run(tf.global_variables_initializer())

        # input_tensors: List of input tensors. Type and shape are computed using get_shape() and dtype.
        # output_tensors: List of output tensors (only .name is used from this).
        converter = tf.lite.TFLiteConverter.from_session(sess,
                                                         input_tensors=inputs,
                                                         output_tensors=outputs)
        # 세션에 들어있는 모든 연산, 즉 모델 전체를 변환
        # 반환값은 TFLite 형식의 Flatbuffer 또는 Graphviz 그래프
        flat_data = converter.convert()

        # 텍스트가 아니기 때문에 바이너리 형태로 저장. w(write), b(binary)
        with open(model_path, 'wb') as f:
            f.write(flat_data)


# 입력 1개, 출력 1개
def simple_model_1(model_path):
    # 에러. 반드시 shape을 지정해야 함.
    # x = tf.placeholder(tf.int32)

    # 안드로이드에서 전달한 입력과 출력 변수가 플레이스 홀더와 연동
    x = tf.placeholder(tf.int32, shape=[1])
    out = x * 5

    model_common([x], [out], model_path)

    # 에러. 반드시 [] 형태로 전달해야 함.
    # model_common(x, out, model_path)


simple_model_1('simple_1.tflite')
