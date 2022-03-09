import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class FileIO_LoD implements FileIO{

    private String loc_filePath;

    public FileIO_LoD(String filePath){
        this.loc_filePath=filePath;
    }

    @Override
    public ListOfData load() throws Exception{
        ListOfData lod;
        String str_json = readJsonFile();

        if("list_of_teaching_requirements.txt"==loc_filePath){
            
            lod = new LoR();
            lod.parse_json_str(str_json);
        }
        else if("list_of_staffs.txt"==loc_filePath){
            lod  = new LoS();
            lod.parse_json_str(str_json);
        }
        else{
            lod=null;
        }

        return lod;
    } 

    @Override
    public void save(ListOfData lod) throws Exception{
        WriteJsonFile(lod.get_json_str());
    }

    private String readJsonFile() throws Exception{
        String str_LoD="";
        char buf[] = new char[1024*10];
        //Read from file
        InputStreamReader input_stream =new InputStreamReader(new FileInputStream(new File(this.loc_filePath)),"UTF-8");
        int len = input_stream.read(buf);
        str_LoD  = new String(buf,0,len);
        return str_LoD;
    }

    private void WriteJsonFile(String str_LoD) throws Exception{
        OutputStreamWriter output_stream = new OutputStreamWriter(new FileOutputStream(this.loc_filePath),"UTF-8");
        output_stream.write(str_LoD);
        output_stream.flush();
        output_stream.close();
    }

    public static void main(String[] args){
        System.out.println("teststart:\r\n");
        String test_file_path = "testfile.txt";
        FileIO_LoD ftest=new FileIO_LoD(test_file_path);
        try {
            ftest.WriteJsonFile("this is a write and read data test");
            System.out.println(ftest.readJsonFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

