package Btap_QLyNhanVien;

import java.text.DecimalFormat;

public class NVpartime extends NhanSu implements Comparable<NVpartime> {
    private double soGioLam;
    private static final double luongTrong1Gio = 30000;

    static int id = 0;
    private int order;

    public NVpartime() {
    }

    public NVpartime(double soGioLam) {
        this.soGioLam = soGioLam;
    }

    public NVpartime(String name, int birthDay, String phone) {
        super(name, birthDay, phone);
        this.order = ++id;
    }

    public NVpartime(String name, int birthDay, String phone, double soGioLam) {
        super(name, birthDay, phone);
        this.soGioLam = soGioLam;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        NVpartime.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(double soGioLam) {
        this.soGioLam = soGioLam;
    }

    @Override
    public double tongLuong() {
        return luongTrong1Gio * getSoGioLam();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#,###,### VND");
        return "NhanSu{" +
                "id=" + getOrder() +
                ", name='" + getName() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", phone=" + getPhone() +
                '}' + " : NVpartime{" +
                "Số giờ làm =" + getSoGioLam() + "h , Tổng lương = " + formatter.format(tongLuong()) +
                '}';
    }

    @Override
    public int compareTo(NVpartime o) {
        return Integer.compare(super.getBirthDay(), o.getBirthDay());
    }
}
