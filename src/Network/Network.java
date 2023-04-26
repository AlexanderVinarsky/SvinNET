package Network;

import Math.Loss_Function.LossFunction;
import Math.Objects.Matrix;
import Math.Objects.Tensor;
import Network.Layers.ILayer;
import java.util.ArrayList;

public class Network {
    private ArrayList<ILayer> layers;

    public Network(ArrayList<ILayer> layers) {
        this.layers = layers;
    }

    public ArrayList<ILayer> getLayers() {
        return layers;
    }

    public Tensor forwardFeed(Tensor data) {
        for (int i = 0; i < layers.size(); i++) {
            data = layers.get(i).getNextLayer(data);
        }
        return data;
    }

    public Tensor BackPropagate(Double expectedAnswer, Double expectedValue, LossFunction lossFunction,
                                Double learningRate, Boolean backPropagate) {
        var expectedTensor = new Tensor(new Matrix(1, layers.get(layers.size()-1).getValues().flatten().size()));
        for (int i = 0; i < expectedTensor.getChannels().get(0).getRows(); i++) {
            for (var j = 0; j < expectedTensor.getChannels().get(0).getColumns(); j++) {
                if (j == expectedAnswer)
                    expectedTensor.getChannels().get(0).getBody()[i][j] = expectedValue;
            }
        }

        var errorTensor = lossFunction.GetErrorTensor(layers.get(layers.size()-1).getValues(), expectedTensor);
        for (var i = layers.size() - 1; i >= 0; i--)
            errorTensor = layers.get(i).backPropagate(errorTensor, learningRate, backPropagate);
        return errorTensor;
    }
}
