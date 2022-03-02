import java.io.PrintStream;

public class Staff extends Person{

    private Administrator administrator;
    private String major;
    private boolean training;

    public Staff(String name, int age, String gender, String major) {
        super(name, age, gender);
        this.major = major;
        this.training=false;
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

    public boolean getTraining() {
        return training;
    }

    public void setTraining(boolean training) {
        this.training = training;
    }

    public void print(PrintStream ps) {
        super.print(ps);
        ps.print(" major is " + major + "; training is " + training);
        if (administrator!=null){
            ps.print("; admin is " + administrator.getName());
        }
        else {
            ps.print("; no admin");
        }
    }
}
