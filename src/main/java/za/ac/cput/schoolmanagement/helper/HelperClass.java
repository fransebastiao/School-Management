package za.ac.cput.schoolmanagement.helper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class HelperClass {
    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if(isEmptyOrNull(str))return StringUtils.EMPTY;
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue){
        if(isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }

    public static void checkEmail(String s){ //Method that ensures that emails are valid.
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(s))
            throw new IllegalArgumentException("Email not valid");
    }

    public static void checkIfObjectNull(String objectName, Object object){ //Checks object attributes to ensure they are not null.
        if (object == null){
            throw new IllegalArgumentException(String.format("%s is null", objectName));
        }
    }

    public static int validatePostalCode(int postalCode){
        if(postalCode > 999 && postalCode < 10000) {
            return postalCode;
        }
        throw new IllegalArgumentException("Insert a number from 1000 to 9999");
    }

}
