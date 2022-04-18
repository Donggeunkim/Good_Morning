package Good_Morning;

import java.util.ArrayList;
import java.util.TreeMap;

public class AddCommand extends Command{
    String employeeNum;
    String name;
    String cl;
    String phoneNum;
    String birthday;
    String certi;

    public AddCommand(ArrayList<String> options, ArrayList<String> parameters) {
        super(options, parameters);
        this.employeeNum = parameters.get(0);
        this.name = parameters.get(1);
        this.cl = parameters.get(2);
        this.phoneNum = parameters.get(3);
        this.birthday = parameters.get(4);
        this.certi = parameters.get(5);
    }

    @Override
    public Employee ExecuteJob(TreeMap<String, Employee> employee, ArrayList<String> options, ArrayList<String> parameters) {
        if(isExistEmployeeNum(employee)) return null;
        Employee employeeData = new Employee(this.employeeNum, this.name, this.cl, this.phoneNum, this.birthday, this.certi);
        return employeeData;
    }

    private boolean isExistEmployeeNum(TreeMap<String, Employee> employee) {
        if(employee.get(this.employeeNum) == null) return false;
        return true;
    }
}
