package bai_thi.hr_model;

public class Student extends Human {
    String scored;
    String className;
    String dayJoint;

    public Student() {
    }

    public Student(String scored, String className, String dayJoint) {
        this.scored = scored;
        this.className = className;
        this.dayJoint = dayJoint;
    }

    public Student(String id, String fullName, String birthDay, String address, String phoneNumber, String scored, String className, String dayJoint) {
        super(id, fullName, birthDay, address, phoneNumber);
        this.scored = scored;
        this.className = className;
        this.dayJoint = dayJoint;
    }

    public String getScored() {
        return scored;
    }

    public void setScored(String scored) {
        this.scored = scored;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDayJoint() {
        return dayJoint;
    }

    public void setDayJoint(String dayJoint) {
        this.dayJoint = dayJoint;
    }

    @Override
    public String getHRData() {
        return super.getHRData()+","+getScored()+","+getClassName()+","+getDayJoint();
    }

    @Override
    public String toString() {
        return "Học sinh: "+ super.toString() +
                ", scored='" + scored + '\'' +
                ", className='" + className + '\'' +
                ", dayJoint='" + dayJoint + '\'';
    }
}
