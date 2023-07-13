import java.util.Scanner;

public class timNgayHomSau {
    public static void main(String[] args) {
        int ngay, thang, nam;

        Scanner sc = new Scanner(System.in);
        System.out.print("Ngày:");
        ngay = sc.nextInt();
        System.out.print("Tháng: ");
        thang = sc.nextInt();
        System.out.print("Năm: ");
        nam = sc.nextInt();

        int ngayHomSau = ngay + 1;

        if ((thang == 1) || (thang == 3) || (thang == 5) || (thang == 7) || (thang == 8) || (thang == 10) || (thang == 12)) {
            if (ngayHomSau <= 31) {
                System.out.println(ngayHomSau + "/" + thang + "/" + nam);
            } else {
                ngayHomSau = ngay / 31;
                thang += ngayHomSau % 31;

                if (thang > 12) {
                    int thangTren12 = thang / 12;
                    nam += thangTren12 % 12;
                }
                System.out.println(ngayHomSau + "/" + thang + "/" + nam);
            }
        } else if ((thang == 4) || (thang == 6) || (thang == 9) || (thang == 11)) {
            if (ngayHomSau <= 30) {
                System.out.println(ngayHomSau + "/" + thang + "/" + nam);
            } else {
                ngayHomSau = 1;
                for (int i = 30; i < ngay; i++) {
                    ngayHomSau++;
                }
                thang++;
                if (thang > 12) {
                    thang = 1;
                    for (int i = 12; i < thang; i++) {
                        thang++;
                    }
                    nam++;
                }
                System.out.println(ngayHomSau + "/" + thang + "/" + nam);
            }
        } else if (thang == 2) {
            if ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) {
                if (ngayHomSau <= 29) {
                    System.out.println(ngayHomSau + "/" + thang + "/" + nam);
                } else {
                    ngayHomSau = 1;
                    for (int i = 28; i < ngay; i++) {
                        ngayHomSau++;
                    }
                    thang++;
                    System.out.println(ngayHomSau + "/" + thang + "/" + nam);
                }
            } else {
                if (ngayHomSau <= 28) {
                    System.out.println(ngayHomSau + "/" + thang + "/" + nam);
                } else {
                    ngayHomSau = 1;
                    for (int i = 28; i < ngay; i++) {
                        ngayHomSau++;
                    }
                    thang++;
                    System.out.println(ngayHomSau + "/" + thang + "/" + nam);
                }
            }
        }
    }
}


