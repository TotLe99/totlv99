package Btap_ValidateNameClass;

public class Main {
    private static NameClass nameClass;
    public static final String[] validClass = new String[]{"C0223G", "A0323K"};
    public static final String[] inValidClass = new String[]{"C0319M", "P0323A"};

    public static void main(String[] args) {
        nameClass = new NameClass();
        for (String name : validClass) {
            boolean isValid = nameClass.validate(name);
            System.out.println("Class name is " + name + " is valid " + isValid);
        }
        for (String name : inValidClass) {
            boolean isValid = nameClass.validate(name);
            System.out.println("Class name is " + name + " is valid " + isValid);
        }
    }
}
