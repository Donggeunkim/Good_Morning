package Good_Morning;

import java.util.ArrayList;
import java.util.TreeMap;

public class AddCommand {
    private String employeeNum;
    private String name;
    private String cl;
    private String phoneNum;
    private String birthday;
    private String certi;

    public AddCommand(ArrayList<String> options, ArrayList<String> parameters) {
        this.employeeNum = parameters.get(0);
        this.name = parameters.get(1);
        this.cl = parameters.get(2);
        this.phoneNum = parameters.get(3);
        this.birthday = parameters.get(4);
        this.certi = parameters.get(5);
    }

    public Employee ExecuteJob(TreeMap<String, Employee> employee, ArrayList<String> options, ArrayList<String> parameters) {
        if(isExistEmployeeNum(employee)) return null;
        if(!isValidParameters()) return null;
        Employee employeeData = new Employee(this.employeeNum, this.name, this.cl, this.phoneNum, this.birthday, this.certi);
        return employeeData;
    }

    private boolean isExistEmployeeNum(TreeMap<String, Employee> employee) {
        if(employee.get(this.employeeNum) == null) return false;
        return true;
    }

    private boolean isValidParameters() {
        if(this.employeeNum == null || this.employeeNum.isEmpty()) return false;
        if(this.name == null || this.name.isEmpty()) return false;
        if(this.cl == null || this.cl.isEmpty()) return false;
        if(this.phoneNum == null || this.phoneNum.isEmpty()) return false;
        if(this.birthday == null || this.birthday.isEmpty()) return false;
        if(this.certi == null || this.certi.isEmpty()) return false;
        return true;
    }
}
