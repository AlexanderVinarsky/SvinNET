package Math.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vector {
    private Integer size;
    private Double[] body;

    public Vector(Double[] body) {
        this.size = body.length;
        this.body = body;
    }

    public Double[] getBody() {
        return body;
    }

    public Integer getSize() {
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

    public Matrix toMatrix(Integer rows, Integer cols, Integer pos) {
        var matrix = new Matrix(rows,cols);
        for (var i = 0; i < rows; i++)
            for (var j = 0; j < cols; j++) {
                if (size <= pos) return null;
                matrix.body[i][j] = body[pos++];
            }
        return matrix;
    }

    public Matrix toMatrix(Integer rows, Integer cols) {
        int pos = 0;
        var matrix = new Matrix(rows,cols);
        for (var i = 0; i < rows; i++)
            for (var j = 0; j < cols; j++) {
                if (size <= pos) return null;
                matrix.body[i][j] = body[pos++];
            }
        return matrix;
    }

    public Tensor toTensor(Integer rows, Integer cols, Integer channels) {
        List<Matrix> matrixList = new ArrayList<>();
        Tensor tensor = new Tensor(matrixList);
        if (channels*rows*cols > size) {
            return null;
        }
        for (var k = 0; k < channels; k++)
            tensor.channels.add(toMatrix(rows,cols,k*rows*cols));
        return tensor;
    }
}
