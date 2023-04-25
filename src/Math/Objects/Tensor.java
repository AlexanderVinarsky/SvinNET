package Math.Objects;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Tensor {
    ArrayList<Matrix> channels;

    public Tensor (Matrix matrix) {
        this.channels = new ArrayList<Matrix>();
        this.channels.add(matrix);
    }

    public Tensor(ArrayList<Matrix> channels) {
        this.channels = channels;
    }

    public ArrayList<Double> flatten() {
        var flatten = new ArrayList<Double>();
        for (var channel: channels) {
            flatten = new ArrayList<Double>(Stream.concat(flatten.stream(), channel.toList().stream()).toList());
        }
        return flatten;
    }

    public ArrayList<Matrix> getChannels() {
        return channels;
    }

    public void print() {
        for (var channel: channels) {
            channel.print();
        }
    }
}
