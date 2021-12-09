import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreEmployees {
    private final String FILE_NAME  = "Employee-CSV-Project";

    public void csvToListOfEmployees() throws IOException {
        List<String[]> csvContent = CSVToEmployeeArrayList.readData(FILE_NAME);
        for (int i = 0; i < csvContent.size(); i++) {
            for (int j = 0; j < csvContent.get(i).length; j++) {

            }

        }
    }
}
