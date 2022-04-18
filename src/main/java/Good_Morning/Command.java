package Good_Morning;

import java.util.ArrayList;

public abstract class Command {
    private ArrayList<String> options;
    private ArrayList<String> parameters;

    public Command(ArrayList<String> options, ArrayList<String> parameters) {
        this.options = options;
        this.parameters = parameters;
    }

    public Employee ExecuteJob() {
        return null;
    }
}
