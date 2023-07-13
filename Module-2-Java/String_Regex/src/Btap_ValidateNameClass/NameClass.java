package Btap_ValidateNameClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {

    private static final String CLASS_REGEX = "^[CAP]+[0-9]{4}+[GHIK]$";
    public NameClass() {}
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

