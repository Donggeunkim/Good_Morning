package Good_Morning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private String command;
    private ArrayList<String> options;
    private ArrayList<String> values;

    public String getCommand() {
        return command;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void splitCommnadLine(String line){
        List<String> words = Arrays.asList(line.split(","));

        command = words.get(0);
        options = new ArrayList<>(words.subList(1,4));
        values = new ArrayList<>(words.subList(4,words.size()));
    }
}
