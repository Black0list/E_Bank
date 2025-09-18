package Utils;

import Main.Main;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class Validation {

    public static boolean AuthCheck(){
        return Main.USER != null;
    }

    public static boolean checkPassword(String password) {
        String regex = ".{6,}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    public static boolean checkMoney(BigDecimal money){
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher((CharSequence) money).matches();
    }
}
