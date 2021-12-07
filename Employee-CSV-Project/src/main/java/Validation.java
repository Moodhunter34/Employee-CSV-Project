import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validateEmail(String email){
        return Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").matcher(email).matches();
    }
    public static boolean validateEmployee(Employee employee){
        return (employee.getRawData() == null);
    }
    public static boolean validateName(String name){
        return Pattern.compile("/^[a-z ,.'-]+$/i").matcher(name).matches();
    }
    public static boolean validateChar(String character){
        if (character.length() > 1){
            return false;
        }
        return validateName(character);
    }
    public static boolean validateDate(String date){
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean validateInteger(String integer){
        try {
            Integer i = Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
