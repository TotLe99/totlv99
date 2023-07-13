package Btap_QLyNhanVien;

import java.text.DecimalFormat;

public class NVfulltime extends NhanSu implements Comparable<NVfulltime>{
    private double heSoLuong;
    private static final long luongCung = 3000000;
    private static int id = 0;
    private int order;
    public NVfulltime() {
    }

    public NVfulltime(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public NVfulltime(String name, int birthDay, String phone) {
        super(name, birthDay, phone);
        this.order = ++id;
    }

    public NVfulltime(String name, int birthDay, String phone, double heSoLuong) {
        super(name, birthDay, phone);
        this.heSoLuong = heSoLuong;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        NVfulltime.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }


    @Override
    public double tongLuong() {
        return luongCung * getHeSoLuong();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#,###,### VND");
        return "NhanSu{" +
                "id=" + getOrder() +
                ", name='" + getName() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", phone=" + getPhone() +
                '}' + " : NVfulltime{" +
                "Hệ số lương = " + getHeSoLuong() + " , Tổng lương = " + formatter.format(tongLuong()) +
                '}';
    }

    @Override
    public int compareTo(NVfulltime o) {
        return Integer.compare(super.getBirthDay(), o.getBirthDay());
    }
}
