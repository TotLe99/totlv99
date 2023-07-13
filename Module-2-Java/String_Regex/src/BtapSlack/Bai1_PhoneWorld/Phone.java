package BtapSlack.Bai1_PhoneWorld;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    public static final String PHONE = "^\\+84-\\d+-\\d+$";

    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Số điện thoại Việt Nam(+84) : ");
        String phoneNumber = sc.nextLine();

        System.out.println(phoneNumber + " là " + validate(phoneNumber));
    }
}
