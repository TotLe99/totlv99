package Btap_QLyNhanVien;

import java.util.Arrays;
import java.util.Scanner;

public class ManagerNVfulltime {

    Scanner sc = new Scanner(System.in);
    NVfulltime[] nvfulltime = new NVfulltime[]{};
    NVfulltime nVfulltime = new NVfulltime();

    public void showNVfulltime() {
        for (NVfulltime nVfulltime : nvfulltime) {
            System.out.println(nVfulltime.toString());
        }
    }

    public void addNVfulltime() {
        //nhan vien full time
        System.out.println("Thông tin NV Fulltime");
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập năm sinh: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập SĐT: ");
        String phone = sc.nextLine();
        nVfulltime = new NVfulltime(name, age, phone);
        NVfulltime[] newNVfulltime = new NVfulltime[nvfulltime.length + 1];
        newNVfulltime[newNVfulltime.length - 1] = nVfulltime;
        for (int i = 0; i < nvfulltime.length; i++) {
            newNVfulltime[i] = nvfulltime[i];
        }
        nvfulltime = newNVfulltime;
    }

    public void tinhLuongNVfulltime() {
        System.out.println("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (NVfulltime nVfulltime1 : nvfulltime) {
            if (id == nVfulltime1.getOrder()) {
                System.out.println("Hệ số lương: ");
                double heSoLuong = Double.parseDouble(sc.nextLine());
                nVfulltime1.setHeSoLuong(heSoLuong);
                break;
            }
        }
    }

    public void deleteNVfulltime() {
        System.out.println("Nhập ID cần xoá: ");
        int id = Integer.parseInt(sc.nextLine());

        NVfulltime[] deleteNVfulltime = new NVfulltime[nvfulltime.length - 1];
        for (int i = 0; i < nvfulltime.length; i++) {
            if (id == nVfulltime.getOrder()) {
                for (int j = 0; j < deleteNVfulltime.length; j++) {
                    if (j < i) {
                        deleteNVfulltime[j] = nvfulltime[j];
                    } else {
                        deleteNVfulltime[j] = nvfulltime[j + 1];
                    }
                }
            }
        }
        nvfulltime = deleteNVfulltime;
    }

    public void editNVfulltime() {
        System.out.println("Nhập ID cần sửa");
        int id = Integer.parseInt(sc.nextLine());

        for (NVfulltime nVfulltime : nvfulltime) {
            if (id == NVfulltime.getId()) {
                System.out.println("Tên sửa:");
                nVfulltime.setName(sc.nextLine());
                System.out.println("Sửa Sn: ");
                nVfulltime.setBirthDay(Integer.parseInt(sc.nextLine()));
                System.out.println("Sửa SĐT: ");
                nVfulltime.setPhone(sc.nextLine());
                break;
            }
        }

    }

    public void searchNVfulltime() {
        System.out.println("Tìm NV: ");
        String name = sc.nextLine();
        for (int i = 0; i < nvfulltime.length; i++) {
            if (name.equals(nvfulltime[i].getName())) {
                System.out.println(nvfulltime[i].toString());
            }
        }
    }

    public void xepTheoSNNVfulltime() {
        Arrays.sort(nvfulltime);

        for (NVfulltime nVfulltime1 : nvfulltime) {
            System.out.println(nVfulltime1.toString());
        }
    }
}

