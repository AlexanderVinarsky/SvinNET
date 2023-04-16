package Network.Layers.Activation;

import Math.Objects.Matrix;
import Math.Objects.Tensor;

public abstract class ActivationFunction {
    protected abstract double Activate(Double value);

    public Tensor Activate(Tensor tensor) {
        for (int i = 0; i<tensor.getChannels().toArray().length; i++) {
            tensor.getChannels().set(i, Activate(tensor.getChannels().get(i)));
        }
        return tensor;
    }

    public Matrix Activate (Matrix matrix) {
        for (int x = 0; x < matrix.getRows(); x++) {
            for (int y = 0; y < matrix.getRows(); y++) {
                matrix.getBody()[x][y] = Activate(matrix.body[x][y]);
            }
        }
        return matrix;
    }

    public Double[] Activate (Double[] array) {
        for (var i = 0; i < array.length; i++)
            array[i] = Activate(array[i]);

        return array;
    }

    protected abstract Double Derivation(Double value, Double referenceValue);

    public Tensor Derivation(Tensor tensor, Tensor referenceTensor) {
        for (int i = 0; i<tensor.getChannels().toArray().length; i++) {
            tensor.getChannels().set(i, Derivation(tensor.getChannels().get(i),
                        referenceTensor.getChannels().get(i)));
           }
        return tensor;
    }

    public Matrix Derivation(Matrix matrix, Matrix referenceMatrix) {
        for (var x = 0; x < matrix.getRows(); x++)
            for (var y = 0; y < matrix.getColumns(); y++)
                matrix.body[x][y] = Derivation(matrix.body[x][y], referenceMatrix.body[x][y]);

        return matrix;
    }

    public Double[] Derivation(Double[] array, Double[] referenceArray) {
        for (var i = 0; i < array.length; i++)
            array[i] = Derivation(array[i], referenceArray[i]);

        return array;
    }
}