import tensorflow as tf

class DummyTensorFlow:

    def basicSetup(self):
        node1 = tf.constant(3.0)
        node2 = tf.constant(2.0)
        print(node1, node2)

    def basicSetupRun(self):
        node1 = tf.constant(3.0)
        node2 = tf.constant(2.0)
        session = tf.Session()
        print(session.run([node1, node2]))

        node3 = tf.add(node1, node2)
        print(session.run(node3))

    def getAdder(self):
        a = tf.placeholder(tf.float32)
        b = tf.placeholder(tf.float32)
        adder_node = a + b
        print(tf.Session().run(adder_node, {a: 3, b: 4}))

