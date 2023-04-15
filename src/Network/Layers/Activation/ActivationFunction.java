package Network.Layers.Activation;

import Math.Objects.Tensor;

public abstract class ActivationFunction {
    protected abstract double activate(Double value);

    /*public Tensor Activate(Tensor tensor) {
        for (int i = 0; i<tensor.getChannels().toArray().length; i++) {
            for (int x = 0; x < tensor.getChannels()[i].get)
        }
    }*/
}
