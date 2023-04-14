package Network.Layers;

import Math.Objects.Tensor;

public interface ILayer {
    public Tensor GetNextLayer(Tensor tensor);
    public Tensor BackPropagate(Tensor error, double learningRate, Boolean backPropagate);
    public Tensor GetValues();
    public String GetData();
    public String LoadData(String data);
}
