package Good_Morning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private String command_;
    private ArrayList<String> options_;
    private ArrayList<String> values_;

    public String GetCommand() {
        return command_;
    }

    public ArrayList<String> GetOptions() {
        return options_;
    }

    public ArrayList<String> GetValues() {
        return values_;
    }

    public void SplitCommnadLine(String line){
        List<String> words = Arrays.asList(line.split(","));

        command_ = words.get(0);
        options_ = new ArrayList<>(words.subList(1,4));
        values_ = new ArrayList<>(words.subList(4,words.size()));
    }
}
