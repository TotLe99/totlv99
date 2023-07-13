package Btap_QLyNhanVien;

public abstract class NhanSu  {
//    private static int id = 0;
    private String name;
    private int birthDay;
    private String phone;

    public NhanSu() {
    }

    public NhanSu(String name, int birthDay, String phone) {
//        id++;
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
    }

//    public static int getId() {
//        return id;
//    }
//
//    public static void setId(int id) {
//        NhanSu.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract double tongLuong();

    @Override
    public abstract String toString();

}
