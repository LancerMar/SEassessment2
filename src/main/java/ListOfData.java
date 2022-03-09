import java.io.PrintStream;

public interface ListOfData {

    public void print(PrintStream ps);
    public String get_json_str();
    public void parse_json_str(String str_json);

}