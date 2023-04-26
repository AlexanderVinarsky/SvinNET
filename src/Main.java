import Network.Initialization.HeInitialization;
import Network.Layers.Activation.Functions.ActivationLayer;
import Network.Layers.Activation.Functions.Sigmoid;
import Network.Layers.ILayer;
import Network.Layers.Perceptron.PerceptronLayer;
import Network.Network;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var layersList = new ArrayList<ILayer>();
        layersList.add(new PerceptronLayer(784, 35, new HeInitialization()));
        layersList.add(new ActivationLayer(new Sigmoid()));
        layersList.add(new PerceptronLayer(35, 10, new HeInitialization()));
        layersList.add(new ActivationLayer(new Sigmoid()));
        layersList.add(new PerceptronLayer(10));
        Network network = new Network(layersList);
    }
}

