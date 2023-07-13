package Btap_ValidatePhone;


public class Main {
    private static PhoneNumber phoneNumber;
    public static final String[] validClass = new String[]{"(84)-(0987654321)", "(81)-(0234567890)"};
    public static final String[] inValidClass = new String[]{"(a9)-(1234567800)", "(11)-(b234567888)"};

    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();
        for (String number : validClass) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println("Phone number " + number + " is valid " + isValid);
        }
        for (String number : inValidClass) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println("Phone number " + number + " is valid " + isValid);
        }
    }

}
