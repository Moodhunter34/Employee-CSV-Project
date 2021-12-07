import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVToEmployeeArrayList {
    public List<String[]> readData(String fileName) throws IOException {
        List<String[]> output = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                output.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        }
        return output;
    }
}
