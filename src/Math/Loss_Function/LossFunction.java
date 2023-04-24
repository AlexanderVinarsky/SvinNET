package Math.Loss_Function;

import Math.Objects.Tensor;

public abstract class LossFunction {
    protected static double Loss(double sum, int count) {
        return (1.0 / count) * sum;
    }

    public abstract double GetLoss(Tensor outputTensor, Tensor expectedTensor);

    public abstract Tensor GetErrorTensor(Tensor outputTensor, Tensor expectedTensor);
}
