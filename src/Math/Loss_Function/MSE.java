package Math.Loss_Function;

import Math.Objects.Tensor;

public class MSE extends LossFunction{
    @Override
    public double GetLoss(Tensor outputTensor, Tensor expectedTensor) {
        var sum = 0.0;
        for (var channel = 0; channel < outputTensor.getChannels().size(); channel++)
            for (var x = 0; x < outputTensor.getChannels().get(channel).getRows(); x++)
                for (var y = 0; y < outputTensor.getChannels().get(channel).getColumns(); y++)
                    sum += Math.pow(expectedTensor.getChannels().get(channel).getBody()[x][y] -
                            outputTensor.getChannels().get(channel).getBody()[x][y], 2);

        return Loss(sum, outputTensor.flatten().size());
    }

    @Override
    public Tensor GetErrorTensor(Tensor outputTensor, Tensor expectedTensor) {
        return null;
    }
}
