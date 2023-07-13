import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Thang ");
        int thang = sc.nextInt();

        String ngayTrongThang;
        switch (thang) {
            case 2:
                ngayTrongThang = " 28 hoac 29";
                break;

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                ngayTrongThang = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                ngayTrongThang = "30";
                break;
            default:
                ngayTrongThang = "";
        }

        if (!ngayTrongThang.equals("")) {
            System.out.printf("Thang '%d' co %s ngay", thang, ngayTrongThang);
        } else {
            System.out.print("Nhap sai thang!");
        }
    }
}