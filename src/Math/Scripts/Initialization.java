package Math.Scripts;

import Math.Objects.Matrix;
import Network.Initialization.IWeightsInitialization;

import java.lang.Math;
import java.util.Random;

public class Initialization implements IWeightsInitialization {
    public Matrix Initialize(Matrix matrix) {
        var scale = Math.sqrt(2.0 / matrix.getColumns());
        for (var i = 0; i < matrix.getRows(); i++)
            for (var j = 0; j < matrix.getColumns(); j++)
                matrix.body[i][j] = new Random().nextDouble() * scale * 2 - scale;
        return matrix;
    }
}
