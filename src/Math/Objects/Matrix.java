package Math.Objects;
import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrix {
    private Integer rows;
    private Integer columns;
    public Double[][] body;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.columns = cols;
        body = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                body[i][j] = 0d;
            }
        }
    }

    public Matrix(Double[][] body) {
        this.rows = body.length;
        this.columns = body[0].length;
        this.body=body;
    }

    public Matrix(Double[] body) {
        this.rows = body.length;
        this.columns = 1;
        this.body[0]=body;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Double[][] getBody() {
        return body;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(body[i][j]);
            }
        }
    }

    public void random() {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                body[i][j] = rand.nextDouble();
            }
        }
    }

    public Matrix multiplyMatrix(Matrix matrix){
        if (rows != matrix.columns) {
            System.out.println("ХРЮ");
            return null;
        }
        Matrix endMatrix = new Matrix(rows, matrix.columns);
        for (int i = 0; i < endMatrix.rows; i++) {
            for (int j = 0; j < endMatrix.columns; j++) {
                for (int k = 0; k < matrix.rows; k++) {
                    endMatrix.body[i][j] += body[i][k] * matrix.body[k][j];
                }
            }
        }
        return endMatrix;
    }

    public List<Double> toList() {
        var tempList = new ArrayList<Double>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tempList.add(body[i][j]);
            }
        }
        return tempList;
    }

    public Vector toVector() {
        return new Vector (toList().toArray(new Double[columns*rows]));
    }

    public Matrix transpose() {
        var temp = new Double[columns][rows];
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
