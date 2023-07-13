package ThucHanh_validateAccount;

public class Main {
    private static AccountEx accountEx;
    public static final String[] validAccount = new String[]{"123abc_", "_abc123", "______", "123456", "abcdefgh"};
    public static final String[] invalidAccount = new String[]{".@", "12345", "1234_", "abcde"};

    public static void main(String[] args) {
        accountEx = new AccountEx();
        for (String account : validAccount) {
            boolean isValid = accountEx.validate(account);
            System.out.println("Account is " + account + " is valid " + isValid);
        }
        for (String account : invalidAccount) {
            boolean isValid = accountEx.validate(account);
            System.out.println("Account is " + account + " is valid " + isValid);
        }
    }
}
