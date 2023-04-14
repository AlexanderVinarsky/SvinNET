package Math.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Tensor {
    List<Matrix> channels;

    public Tensor(List<Matrix> channels) {
        this.channels = channels;
    }

    public List<Double> Flatten() {
        var flatten = new ArrayList<Double>();
        for (var channel: channels) {
            flatten = new ArrayList<Double>(Stream.concat(flatten.stream(), channel.toList().stream()).toList());
        }
        return flatten;
    }
}
