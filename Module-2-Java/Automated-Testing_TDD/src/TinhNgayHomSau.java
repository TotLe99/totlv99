import java.util.Scanner;

public class TinhNgayHomSau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ngày:");
        int ngay = sc.nextInt();
        System.out.print("Tháng: ");
        int thang = sc.nextInt();
        System.out.print("Năm: ");
        int nam = sc.nextInt();

        int ngayHomSau = ngay + 1;
        int thangHomSau = thang;
        int namHomSau = nam;

        // Kiểm tra tính hợp lệ của ngày, tháng và năm
        if (ngayHomSau > soNgayTrongThang(thang, nam) || ngayHomSau < 1) {
            ngayHomSau = 1;
            thangHomSau++;
            if (thangHomSau > 12) {
                thangHomSau = 1;
                namHomSau++;
            }
        }

        System.out.println(ngayHomSau + "/" + thangHomSau + "/" + namHomSau);
    }

    public static int soNgayTrongThang(int thang, int nam) {
        int soNgay;
        switch (thang) {
            case 2:
                if ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) {
                    soNgay = 29;
                } else {
                    soNgay = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                soNgay = 30;
                break;
            default:
                soNgay = 31;
        }
        return soNgay;
    }
}