package Good_Morning;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Command {
    ArrayList<String> options;
    ArrayList<String> parameters;

    public Command(ArrayList<String> options, ArrayList<String> parameters) {
        this.options = options;
        this.parameters = parameters;
    }

    public abstract Employee ExecuteJob(HashMap<String, Employee> employee, ArrayList<String> options, ArrayList<String> parameters);
}

