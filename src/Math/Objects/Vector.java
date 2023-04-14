package Math.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vector {
    private int size;
    private double[] body;

    public Vector(double[] body) {
        this.size = body.length;
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void random() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            body[i] = rand.nextDouble();
        }
    }

    public Vector plus(Vector vector) {
        for (int i = 0; i < size; i++) {
            this.body[i] += vector.body[i];
        }
        return this;
    }

    public Vector minus(Vector vector) {
        for (int i = 0; i < size; i++) {
            this.body[i] -= vector.body[i];
        }
        return this;
    }

    public Vector multiply(Vector vector) {
        for (int i = 0; i < size; i++) {
            this.body[i] *= vector.body[i];
        }
        return this;
    }

    public Vector multiply(double value) {
        for (int i = 0; i < size; i++) {
            this.body[i] *= value;
        }
        return this;
    }

    public Vector divide(Vector vector) {
        for (int i = 0; i < size; i++) {
            this.body[i] /= vector.body[i];
        }
        return this;
    }

    public Vector divide(double value) {
        for (int i = 0; i < size; i++) {
            this.body[i] /= value;
        }
        return this;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(this.body[i] + " ");
        }
    }

    public List<Double> toList() {
        var tempList = new ArrayList<Double>();
        for (int i = 0; i < size; i++) {
            tempList.add(body[i]);
        }
        return tempList;
    }

    /*public Matrix toMatrix(int x, int y, int) {
        var matrix = new Matrix(1, vector.size);

        for (int i = 0; i < vector.size; i++) {
            matrix.body[0][i] = vector.body[i];
        }
        return matrix;
    }

    public Tensor toTensor(int x, int y, int channels) {
        var tensor = new Tensor(new List<Matrix>);
        var position = 0;

        for (var k = 0; k < channels; k++)
            tensor.channels.add(toMatrix(x,y,position));

        return tensor;
    }*/
}
