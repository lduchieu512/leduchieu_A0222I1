package bai_thi.hr_model;

public class Employee extends Human{
    String salary;
    String department;
    String job;

    public Employee() {
    }

    public Employee(String salary, String department, String job) {
        this.salary = salary;
        this.department = department;
        this.job = job;
    }

    public Employee(String id, String fullName, String birthDay, String address, String phoneNumber, String salary, String department, String job) {
        super(id, fullName, birthDay, address, phoneNumber);
        this.salary = salary;
        this.department = department;
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String getHRData() {
        return super.getHRData()+","+getSalary()+","+getDepartment()+","+getJob();
    }

    @Override
    public String toString() {
        return "Nhân viên: "+ super.toString() +
                ", salary='" + salary + '\'' +
                ", department='" + department + '\'' +
                ", job='" + job + '\'';
    }
}
