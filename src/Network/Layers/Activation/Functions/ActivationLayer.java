package Network.Layers.Activation.Functions;

import Math.Objects.Matrix;
import Math.Objects.Tensor;
import Network.Layers.ILayer;

import java.util.ArrayList;

public class ActivationLayer implements ILayer {

    public ActivationLayer(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
        input = new Tensor(new ArrayList<Matrix>());
    }

    private ActivationFunction activationFunction;
    private Tensor input;

    @Override
    public Tensor getNextLayer(Tensor tensor) {
        input = activationFunction.activate(tensor);
        return new Tensor(new ArrayList<Matrix>(input.getChannels()));
    }

    @Override
    public Tensor backPropagate(Tensor error, Double learningRate, Boolean backPropagate) {
        return activationFunction.derivation(error, input);
    }

    @Override
    public Tensor getValues() {
        return input;
    }

    @Override
    public String getData() {
        return "";
    }

    @Override
    public String loadData(String data) {
        return data;
    }
}
