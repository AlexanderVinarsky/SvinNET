package Math.Loss_Function;

import Math.Objects.Matrix;
import Math.Objects.Tensor;

import java.util.ArrayList;

public class MSE extends LossFunction{
    @Override
    public double GetLoss(Tensor outputTensor, Tensor expectedTensor) {
        var sum = 0.0;
        for (int channel = 0; channel < outputTensor.getChannels().size(); channel++)
            for (int x = 0; x < outputTensor.getChannels().get(channel).getRows(); x++)
                for (int y = 0; y < outputTensor.getChannels().get(channel).getColumns(); y++)
                    sum += Math.pow(expectedTensor.getChannels().get(channel).getBody()[x][y] -
                            outputTensor.getChannels().get(channel).getBody()[x][y], 2);

        return Loss(sum, outputTensor.flatten().size());
    }

    @Override
    public Tensor GetErrorTensor(Tensor outputTensor, Tensor expectedTensor) {
        var tensor = new Tensor(new ArrayList<Matrix>());
        for (int channel = 0; channel < outputTensor.getChannels().size(); channel++) {
            tensor.getChannels().add(new Matrix(outputTensor.getChannels().get(channel).getRows(),
                    outputTensor.getChannels().get(channel).getColumns()));
            for (int x = 0; x < outputTensor.getChannels().get(channel).getRows(); x++)
                for (int y = 0; y < outputTensor.getChannels().get(channel).getColumns(); y++){
                    tensor.getChannels().get(channel).getBody()[x][y] = 2 *
                            (outputTensor.getChannels().get(channel).getBody()[x][y] -
                            expectedTensor.getChannels().get(channel).getBody()[x][y]);
                }
        }

        return tensor;
    }
}
