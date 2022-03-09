import com.alibaba.fastjson.annotation.JSONField;

import java.io.PrintStream;

public class TeachingRequire {

    private String className;
    private String requirement;
    private int capacity;
    @JSONField(serialize = false)
    private Staff staff;
    private CourseDate startDate;
    private CourseDate endDate;

    public TeachingRequire(String className, String requirement, int capacity, CourseDate startDate, CourseDate endDate) {
        this.className = className;
        this.requirement = requirement;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public CourseDate getStartDate() {
        return startDate;
    }

    public void setStartDate(CourseDate startDate) {
        this.startDate = startDate;
    }

    public CourseDate getEndDate() {
        return endDate;
    }

    public void setEndDate(CourseDate endDate) {
        this.endDate = endDate;
    }

    public void print(PrintStream ps){
        ps.print("Class ");
        ps.print(className + ": requirement is " + requirement + "; start date is ");
        startDate.print_date(ps);
        ps.print("; end date is ");
        endDate.print_date(ps);
        if (staff!=null){
            ps.print("; staff is " + staff.getName());
        }
        else {
            ps.print("; staff is empty");
        }
    }

}
