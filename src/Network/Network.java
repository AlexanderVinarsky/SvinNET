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

    /*public Tensor BackPropagate(Double expectedAnswer, Double expectedValue, LossFunction lossFunction,
                                Double learningRate, Boolean BackPropagate) {
        var expectedTensor = new Tensor(new Matrix(1, layers.get(layers.size()-1).getValues().flatten().size()));
        for (int i = 0; i < expectedTensor.getChannels().get(0).getRows(); i++) {
            for (var j = 0; j < expectedTensor.getChannels().get(0).getColumns(); j++) {
                if (j == (Integer)expectedAnswer)
                    expectedTensor.Channels[0].Body[i, j] =expectedValue;
            }
        }

        var errorTensor = errorFunction.GetErrorTensor(Layers[^1].GetValues(), expectedTensor);
        for (var i = Layers.Count - 1; i >= 0; i--)
            errorTensor = Layers[i].BackPropagate(errorTensor, learningRate, backPropagate);
        return errorTensor;
    }
*/
}
