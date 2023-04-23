package Network.Layers.Activation;

import java.lang.Math;

public class Sigmoid extends ActivationFunction{
    @Override
    protected double activate(Double value) {
        return 1 / (1 + Math.exp(-value));
    }

    @Override
    protected Double derivation(Double value, Double referenceValue) {
        return value * (activate(referenceValue) * (1 - activate(referenceValue)));
    }
}
