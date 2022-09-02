import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private final String[] stream;
    private final int n;
    private int ptr;

    public OrderedStream(int n) {
        this.n = n;
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int id, String value) {
        stream[id] = value;
        List<String> ret = new ArrayList<>();
        if (stream[ptr] == null) {
            return ret;
        }
        int index = ptr;
        while (index <= n && stream[index] != null) {
            ret.add(stream[index]);
            index++;
        }
        ptr = index;
        return ret;
    }
}
