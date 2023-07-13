package Btap_QLyNhanVien;

import java.util.Arrays;
import java.util.Scanner;

public class ManagerNVpartime {

    Scanner sc = new Scanner(System.in);
    NVpartime[] nvpartime = new NVpartime[]{};
    NVpartime nVParTime = new NVpartime();

    public void showNVpartime() {
        for (NVpartime nVpartime : nvpartime) {
            System.out.println(nVpartime.toString());
        }
    }

    public void addNVpartime() {

        //nhan vien partime
        System.out.println("Thông tin NV partime");
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập năm sinh: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập SĐT: ");
        String phone = sc.nextLine();
        nVParTime = new NVpartime(name, age, phone);
        NVpartime[] newNVpartime = new NVpartime[nvpartime.length + 1];

        newNVpartime[newNVpartime.length - 1] = nVParTime;
        for (int i = 0; i < nvpartime.length; i++) {
            newNVpartime[i] = nvpartime[i];
        }
        nvpartime = newNVpartime;
    }


    public void tinhLuongNVpartime() {
        System.out.println("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (NVpartime nVpartime : nvpartime) {
            if (id == nVpartime.getOrder()) {
                System.out.println("Số giờ: ");
                double soGioLam = Double.parseDouble(sc.nextLine());

                nVParTime = new NVpartime(soGioLam);
                nVpartime.setSoGioLam(soGioLam);
                break;
            }
        }
    }

    public void deleteNVpartime() {
        System.out.println("Nhập ID cần xoá: ");
        int id = Integer.parseInt(sc.nextLine());

        NVpartime[] deleteNVpartime = new NVpartime[nvpartime.length - 1];
        for (int i = 0; i < nvpartime.length; i++) {
            if (id == nVParTime.getOrder()) {
                for (int j = 0; j < deleteNVpartime.length; j++) {
                    if (j < i) {
                        deleteNVpartime[j] = nvpartime[j];
                    } else {
                        deleteNVpartime[j] = nvpartime[j + 1];
                    }
                }
            }
        }
        nvpartime = deleteNVpartime;
    }

    public void editNVpartime() {
        System.out.println("Nhập ID cần sửa");
        int id = Integer.parseInt(sc.nextLine());

        for (NVpartime nVpartime : nvpartime) {
            if (id == nVpartime.getOrder()) {
                System.out.println("Tên sửa:");
                nVpartime.setName(sc.nextLine());
                System.out.println("Sửa Sn: ");
                nVpartime.setBirthDay(Integer.parseInt(sc.nextLine()));
                System.out.println("Sửa SĐT: ");
                nVpartime.setPhone(sc.nextLine());
                break;
            }
        }
    }

    public void searchNVpartime() {
        System.out.println("Tìm NV: ");
        String name = sc.nextLine();
        for (int i = 0; i < nvpartime.length; i++) {
            if (name.equals(nvpartime[i].getName())) {
                System.out.println(nvpartime[i].toString());
            }
        }
    }

    public void xepTheoSNNVpartime() {
        Arrays.sort(nvpartime);

        for (NVpartime nVpartime : nvpartime) {
            System.out.println(nVpartime.toString());
        }
    }
}
