package Network;

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
        var tensor = data;
        return tensor;
    }

    //public Tensor BackPropagate(double expectedAnswer, double expectedValue, LossFunction )
}
