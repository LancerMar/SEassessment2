import java.util.List;

public interface FileIO {

    public LoR loadR();

    public LoS loadS();

    public void save(LoR loR, LoS loS);

}
