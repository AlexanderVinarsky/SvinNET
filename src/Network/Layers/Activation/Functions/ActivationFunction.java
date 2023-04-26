package Network.Layers.Activation.Functions;

import Math.Objects.Matrix;
import Math.Objects.Tensor;

public abstract class ActivationFunction {
    protected abstract double activate(Double value);

    public Tensor activate(Tensor tensor) {
        for (int i = 0; i<tensor.getChannels().toArray().length; i++) {
            tensor.getChannels().set(i, activate(tensor.getChannels().get(i)));
        }
        return tensor;
    }

    public Matrix activate(Matrix matrix) {
        for (int x = 0; x < matrix.getRows(); x++) {
            for (int y = 0; y < matrix.getRows(); y++) {
                matrix.getBody()[x][y] = activate(matrix.body[x][y]);
            }
        }
        return matrix;
    }

    public Double[] activate(Double[] array) {
        for (var i = 0; i < array.length; i++)
            array[i] = activate(array[i]);

        return array;
    }

    protected abstract Double derivation(Double value, Double referenceValue);

    public Tensor derivation(Tensor tensor, Tensor referenceTensor) {
        for (int i = 0; i<tensor.getChannels().toArray().length; i++) {
            tensor.getChannels().set(i, derivation(tensor.getChannels().get(i),
                        referenceTensor.getChannels().get(i)));
           }
        return tensor;
    }

    public Matrix derivation(Matrix matrix, Matrix referenceMatrix) {
        for (var x = 0; x < matrix.getRows(); x++)
            for (var y = 0; y < matrix.getColumns(); y++)
                matrix.body[x][y] = derivation(matrix.body[x][y], referenceMatrix.body[x][y]);

        return matrix;
    }

    public Double[] derivation(Double[] array, Double[] referenceArray) {
        for (var i = 0; i < array.length; i++)
            array[i] = derivation(array[i], referenceArray[i]);

        return array;
    }
}