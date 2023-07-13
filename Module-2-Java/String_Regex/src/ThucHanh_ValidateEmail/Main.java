package ThucHanh_ValidateEmail;

public class Main {
    private static Email email;
    public static final String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@gmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String[] args) {
        email = new Email();
        for (String emaill : validEmail) {
            boolean isValid = email.validate(emaill);
            System.out.println("Email is " + emaill + " is valid " + isValid);
        }
        for (String emaill : invalidEmail) {
            boolean isValid = email.validate(emaill);
            System.out.println("Email is " + emaill + " is valid " + isValid);
        }
    }
}
