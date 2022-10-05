package OceanTech.training.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String VALID_EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]" + "+\\.[a-zA-Z]{2,6}$";

    public static boolean isEmail(String emailAddress) {
        Pattern pattern = Pattern.compile(VALID_EMAIL_REGEX);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }

    public static double parseDoubleNumber(String numberText) {
        double result = 0d;
        try {
            result = Double.parseDouble(numberText);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException();
        }
        return result;
    }

    public static boolean isID(String id) throws IDFormatException {
        boolean check=true;
        int n=id.length();
        if(n!=4) check=false;
        else{
            String s=id.substring(2,4);
            try{
                int a=Integer.parseInt(s);
                check=true;
            }catch (NumberFormatException e){
                check=false;
                throw new IDFormatException("ID is invalid!");
            }
        }
        return check;
    }
}
