import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends Person{

    private List<Person> staffs = new ArrayList<>();

    public Administrator(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void add_staff(Staff staff){
        staffs.add(staff);
        staff.setAdministrator(this);
    }

    public void print(PrintStream ps) {
        super.print(ps);
        if (staffs!=null){
            ps.print(" manage:" + staffs.get(0).getName());
            for (int i=1; i<staffs.size(); i++ ){
                ps.print("," + staffs.get(i).getName());
            }
        }
        else {
            ps.print(" no teacher is managed");
        }
    }

}
