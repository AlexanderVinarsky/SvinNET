package Network.Layers;

import Math.Objects.Tensor;

public interface ILayer {
    public Tensor getNextLayer(Tensor tensor);
    public Tensor backPropagate(Tensor error, Double learningRate, Boolean backPropagate);
    public Tensor getValues();
    public String getData();
    public String loadData(String data);
}
