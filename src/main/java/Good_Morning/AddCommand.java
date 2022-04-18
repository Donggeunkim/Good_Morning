package Good_Morning;

import java.util.ArrayList;

public class AddCommand extends Command{
    private String employeeNum;
    private String name;
    private String cl;
    private String phoneNum;
    private String birthday;
    private String certi;

    public AddCommand(ArrayList<String> options, ArrayList<String> parameters) {
        super(options, parameters);
        this.employeeNum = parameters.get(0);
        this.name = parameters.get(1);
        this.cl = parameters.get(2);
        this.phoneNum = parameters.get(3);
        this.birthday = parameters.get(4);
        this.certi = parameters.get(5);
    }

    public Employee ExecuteJob() {
        Employee employeeData = new Employee(employeeNum, name, cl, phoneNum, birthday, certi);
        return employeeData;
    }
}
