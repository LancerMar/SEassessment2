import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.PrintStream;
import java.lang.reflect.Type;
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
            if(staff.getMajor().equals(major) && !staff.getTraining().equals("is training")){
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

    @Override
    public String get_json_str(){
        return JSON.toJSONString(loS);
    }

    @Override
    public void parse_json_str(String str_json){
        loS=JSONArray.parseArray(str_json,Staff.class);
    }
}
