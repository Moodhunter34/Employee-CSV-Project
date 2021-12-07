import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreEmployees {
    private final String FILE_NAME  = "Employee-CSV-Project";

    public void csvToListOfEmployees() throws IOException {
        List<String[]> csvContent = CSVToEmployeeArrayList.readData(FILE_NAME);
        for (int i = 1; i < csvContent.size(); i++) {
            boolean invalidEmployeeId;
            boolean invalid
            String[] currentRow = csvContent.get(i);

            }

        }
    }

