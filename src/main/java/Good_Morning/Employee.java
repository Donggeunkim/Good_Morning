package Good_Morning;

public class Employee {
    private int employedYear;
    private String employeeNum;
    private String name;
    private String cl;
    private String phoneNum;
    private String birthday;
    private String certi;

    public Employee(String employeeNum, String name, String cl, String phoneNum, String birthday, String certi){
        setEmployedYear(employeeNum);
        this.employeeNum = employeeNum;
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.certi = certi;
    }

    public int getEmployedYear() {
        return employedYear;
    }

    public void setEmployedYear(String employeeNum) {
        int year = Integer.parseInt(employeeNum.substring(0,2));
        if (year < 22)
            this.employedYear = 2000 + year;
        else
            this.employedYear = 1900 + year;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
        setEmployedYear(employeeNum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCerti() {
        return certi;
    }

    public void setCerti(String certi) {
        this.certi = certi;
    }

    public void SetPrintInfo(String certi) {
        this.certi = certi;
    }
}
