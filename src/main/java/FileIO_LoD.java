import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;


public class FileIO_LoD implements FileIO{

    private String loc_filePath;

    public FileIO_LoD(String filePath){
        this.loc_filePath=filePath;
    }

    @Override
    public ListOfData load(){
        ListOfData lod;

        if("list_of_teaching_requirements.txt"==loc_filePath){
            lod  = new LoR();
        }
        else if("list_of_staffs"==loc_filePath){
            lod  = new LoS();
        }
        else{
            lod=null;
        }

        return lod;
    } 

    @Override
    public void save(ListOfData lod){

    }

    public static void main(String[] args){
        System.out.println("test");
    }
}

    // @Override
    // public LoR loadR() {
    //     return null;
    // }

    // @Override
    // public LoS loadS() {
    //     return null;
    // }

    // @Override
    // public void save(LoR loR, LoS loS) {
    //     String jsonStrR = JSON.toJSONString(loR.getLoR());
    //     String jsonStrS = JSON.toJSONString(loS.getLoS());
    //     System.out.println(jsonStrR);
    //     System.out.println(jsonStrS);
    //     List<TeachingRequire> teachingRequires = JSONArray.parseArray(jsonStrR,TeachingRequire.class);
    //     List<Staff> staffs = JSONArray.parseArray(jsonStrS, Staff.class);
    // }
