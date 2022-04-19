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

    public String executeJob(EmployeeHandler employeeHandler){
        switch (getCommand()){
            case "ADD":
                employeeHandler.addEmployee(getOptions(), getValues());
                return null;
            case "SCH":
                return employeeHandler.searchEmployee(getOptions(), getValues());
            case "DEL":
                return employeeHandler.deleteEmployee(getOptions(), getValues());
            case "MOD":
                return employeeHandler.modifyEmployee(getOptions(), getValues());
            default :
                return null;
        }
    }

    public void splitCommandLine(String line){
        List<String> words = Arrays.asList(line.split(","));

        command = words.get(0);
        options = new ArrayList<>(words.subList(1,4));
        values = new ArrayList<>(words.subList(4,words.size()));
    }
}
