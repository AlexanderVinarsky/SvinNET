package Network.Layers.Activation;

import java.lang.Math;

public class Sigmoid extends ActivationFunction{
    @Override
    protected double Activate(Double value) {
        return 1 / (1 + Math.exp(-value));
    }

    @Override
    protected Double Derivation(Double value, Double referenceValue) {
        return value * (Activate(referenceValue) * (1 - Activate(referenceValue)));
    }
}
