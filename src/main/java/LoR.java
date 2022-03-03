import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LoR {

    private List<TeachingRequire> loR = new ArrayList<>();

    public List<TeachingRequire> getLoR() {
        return loR;
    }

    public void add_teachingRequire(TeachingRequire teachingRequire){
        loR.add(teachingRequire);
    }

    public void update_teachRequire(TeachingRequire teachingRequire){
        for(TeachingRequire tr:loR){
            if(tr.getClassName().equals(teachingRequire.getClassName())){
                tr.setStaff(teachingRequire.getStaff());
            }
        }
    }

    public void print(PrintStream ps){
        for(TeachingRequire teachingRequire:loR){
            teachingRequire.print(ps);
            ps.println();
        }
    }

}
