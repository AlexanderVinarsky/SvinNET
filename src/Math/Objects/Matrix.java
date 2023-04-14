package Math.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrix {
    private int rows;
    private int columns;
    public double[][] body;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.columns = cols;
        body = new double[rows][cols];
    }

    public Matrix(double[][] body) {
        this.rows = body.length;
        this.columns = body[0].length;
        this.body=body;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void print() {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.println(body[i][j]);
            }
        }
    }

    public void random() {
        Random rand = new Random();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                body[i][j] = rand.nextDouble();
            }
        }
    }

    public Matrix multiplyMatrix(Matrix matrix){
        Matrix temp = new Matrix(rows, matrix.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < temp.columns; j++) {
                for (int k = 0; k < matrix.rows; k++) {
                    temp.body[i][j] += body[i][k] * matrix.body[k][j];
                }
            }
        }
        return temp;
    }

    public List<Double> toList() {
        var tempList = new ArrayList<Double>();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                tempList.add(body[i][j]);
            }
        }
        return tempList;
    }

    public Matrix transpose() {
        var temp = new double[columns][rows];
        for (var i = 0; i < rows; i++)
            for (var j = 0; j < columns; j++)
                temp[j][i] = body[i][j];
        return new Matrix(temp);
    }

    public Matrix multiply(Matrix matrix) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                this.body[i][j] *= matrix.body[i][j];
            }
        }
        return this;
    }

    public Matrix plus(Matrix matrix) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                this.body[i][j] += matrix.body[i][j];
            }
        }
        return this;
    }

    public Matrix minus(Matrix matrix) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                this.body[i][j] -= matrix.body[i][j];
            }
        }
        return this;
    }

    public Matrix divide(Matrix matrix) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                this.body[i][j] /= matrix.body[i][j];
            }
        }
        return this;
    }

}
