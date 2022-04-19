package Good_Morning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private String command;
    private ArrayList<String> options;
    private ArrayList<String> values;

    public String executeJob(EmployeeHandler employeeHandler){
        switch (this.command){
            case "ADD":
                employeeHandler.addEmployee(this.options, this.values);
                return null;
            case "SCH":
                return employeeHandler.searchEmployee(this.options, this.values);
            case "DEL":
                return employeeHandler.deleteEmployee(this.options, this.values);
            case "MOD":
                return employeeHandler.modifyEmployee(this.options, this.values);
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
