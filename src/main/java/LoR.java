import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LoR implements ListOfData{

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

    @Override
    public void print(PrintStream ps){
        for(TeachingRequire teachingRequire:loR){
            teachingRequire.print(ps);
            ps.println();
        }
    }

    @Override
    public String get_json_str(){
        return JSON.toJSONString(loR);
    }

    @Override
    public void parse_json_str(String str_json){
        loR=JSONArray.parseArray(str_json,TeachingRequire.class);
    }

}
