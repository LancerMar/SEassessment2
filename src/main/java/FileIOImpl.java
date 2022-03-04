import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

public class FileIOImpl implements FileIO{

    private String loc_filePath;

    public FileIOImpl(String filePath){
        loc_filePath=filePath;
    }

    @Override
    public LoR loadR() {
        return null;
    }

    @Override
    public LoS loadS() {
        return null;
    }

    @Override
    public void save(LoR loR, LoS loS) {
        String jsonStrR = JSON.toJSONString(loR.getLoR());
        String jsonStrS = JSON.toJSONString(loS.getLoS());
        System.out.println(jsonStrR);
        System.out.println(jsonStrS);
        List<TeachingRequire> teachingRequires = JSONArray.parseArray(jsonStrR,TeachingRequire.class);
        List<Staff> staffs = JSONArray.parseArray(jsonStrS, Staff.class);
    }

    public void writefile(String Jstring){
        
    }

    public static void main(String[] args){
        System.out.println("test");
    }
}
