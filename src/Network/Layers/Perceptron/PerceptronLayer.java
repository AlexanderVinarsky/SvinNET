package Network.Layers.Perceptron;

import Math.Objects.Matrix;
import Math.Objects.Tensor;
import Math.Objects.Vector;
import Network.Initialization.IWeightsInitialization;
import Network.Layers.ILayer;

public class PerceptronLayer implements ILayer {

    private Double[] neurons;
    private Double[] bias;
    private Matrix weights;
    private Boolean isEndLayer;

    public PerceptronLayer(Integer size, Integer nextSize, IWeightsInitialization weightsInitialization) {
        neurons = new Double[size];
        bias    = new Double[nextSize];
        weights = weightsInitialization.Initialize(new Matrix(nextSize, size));

        for (var i = 0; i < nextSize; i++)
            bias[i] = .001d;

        isEndLayer = false;
    }

    public PerceptronLayer(Integer size) {
        neurons = new Double[size];
        bias    = new Double[size];
        weights = new Matrix(size,size);

        for (var i = 0; i < size; i++)
            weights.body[i][i] = 1d;

        isEndLayer = true;
    }

    @Override
    public Tensor GetNextLayer(Tensor tensor) {
        neurons = tensor.flatten().toArray(neurons);
        var nextLayer = new Matrix(neurons).multiply(weights).toVector().plus(new Vector(bias));
        return nextLayer.toTensor(1, nextLayer.getSize(),1);
    }

    @Override
    public Tensor BackPropagate(Tensor error, Double learningRate, Boolean backPropagate) {
        var previousError = new Vector(error.flatten().toArray(new Double[0]));
        if (isEndLayer) {
            return previousError.toTensor(1, previousError.getSize(), 1);
        }

        var neuronsError = previousError.toMatrix(1, previousError.getSize()).multiply(weights.transpose());
        if(backPropagate) {
            for(int i = 0; i<weights.getRows(); i++) {
                for(int j = 0; j< weights.getColumns(); j++) {
                    weights.body[i][j] -= neurons[i] * previousError.getBody()[j] * learningRate;
                }
            }

            for (int i = 0; i<weights.getRows(); i++) {
                bias[i] -= previousError.getBody()[i] * learningRate;
            }
        }
        return neuronsError.toVector().toTensor(1, neuronsError.getColumns()*neuronsError.getColumns(), 1);
    }

    @Override
    public Tensor GetValues() {
        return new Vector(neurons).toTensor(1, neurons.length, 1);
    }

    @Override
    public String GetData() {
        var temp = "";
        temp += weights.toVector().getBody();
        return temp;
    }

    @Override
    public String LoadData(String data) {
        return null;
    }
}
