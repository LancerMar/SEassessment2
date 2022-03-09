import com.alibaba.fastjson.annotation.JSONField;

import java.io.PrintStream;

public class Staff extends Person{

    @JSONField(serialize = false)
    private Administrator administrator;

    private String major;

    private String training;

    public Staff(String name, int age, String gender, String major, String training) {
        super(name, age, gender);
        this.major = major;
        this.training = training;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public void print(PrintStream ps) {
        ps.print("Staff ");
        super.print(ps);
        ps.print("; major is " + major + "; " + training);
        if (administrator!=null){
            ps.print("; admin is " + administrator.getName());
        }
        else {
            ps.print("; no admin");
        }
    }
}
