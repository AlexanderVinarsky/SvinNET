package Network.Layers.Perceptron;

import Math.Objects.Matrix;
import Math.Objects.Tensor;
import Network.Initialization.IWeightsInitialization;
import Network.Layers.ILayer;

public class PerceptronLayer implements ILayer {

    private double[] neurons;
    private double[] bias;
    private Matrix weights;
    private Boolean isEndLayer;

    public PerceptronLayer(int size, int nextSize, IWeightsInitialization weightsInitialization) {
        neurons = new double[size];
        bias    = new double[nextSize];
        weights = weightsInitialization.Initialize(new Matrix(nextSize, size));

        for (var i = 0; i < nextSize; i++)
            bias[i] = .001d;

        isEndLayer = false;
    }

    public PerceptronLayer(int size) {
        neurons = new double[size];
        bias    = new double[size];
        weights = new Matrix(size,size);

        for (var i = 0; i < size; i++)
            weights.body[i][i] = 1;

        isEndLayer = true;
    }

    @Override
    public Tensor GetNextLayer(Tensor tensor) {
        return null;
    }

    @Override
    public Tensor BackPropagate(Tensor error, double learningRate, Boolean backPropagate) {
        return null;
    }

    @Override
    public Tensor GetValues() {
        return null;
    }

    @Override
    public String GetData() {
        return null;
    }

    @Override
    public String LoadData(String data) {
        return null;
    }
}
