import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LoS implements ListOfData{

    private List<Staff> loS = new ArrayList<>();

    public List<Staff> getLoS() {
        return loS;
    }

    public void add_staff(Staff staff){
        loS.add(staff);
    }

    public Staff find_staff_by_major(String major){
        for(Staff staff:loS){
            if(staff.getMajor().equals(major)){
                return staff;
            }
        }
        return null;
    }

    @Override
    public void print(PrintStream ps){
        for (Staff staff:loS){
            staff.print(ps);
            ps.println();
        }
    }

}
