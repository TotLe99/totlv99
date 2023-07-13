package Manager;

import Bill.ElectricityBill;
import Objects.Bank;
import Objects.MBBank;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MBBankManager {
    static Scanner sc = new Scanner(System.in);
    static String nameBank;
    static String accountBank;
    static String passwordAccount;
    static String nameAccount;
    static int PIN;

    List<MBBank> mbBanks = new ArrayList<>();
    List<ElectricityBill> electricityBills = new ArrayList<>();

    {
        loadData();
        loadDataElectricityBill();
    }

    public MBBankManager() {
    }

    public void addAccount() {
        inputNameBank();
        inputAccountBank();
        boolean check = false;
        for (MBBank mbBank1 : mbBanks) {
            if (accountBank.equals(mbBank1.getAccountBank())) {
                System.out.println("Số tài khoản đã tồn tại.");
                check = true;
                break;
            }
        }
        if (!check) {
            inputPasswordAccount();
            inputNameAccount();
            inputPIN();

            MBBank mbBank = new MBBank();
            mbBank.setNameBank(nameBank);
            mbBank.setAccountBank(accountBank);
            mbBank.setPasswordAccount(passwordAccount);
            mbBank.setNameAccount(nameAccount);
            mbBank.setPIN(PIN);

            mbBanks.add(mbBank);
            System.out.println("Thêm thành công!");
        }

        saveData();
    }

    public void editAccount() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean check = false;
        for (MBBank mbBank1 : mbBanks) {
            if (accountBank.equals(mbBank1.getAccountBank())) {
                System.out.print("Mật khẩu mới: ");
                String passwordAccount = sc.nextLine();
                System.out.print("Nhập lại mật khẩu: ");
                String repeatPasswordAccount = sc.nextLine();

                if (repeatPasswordAccount.equals(passwordAccount)) {
                    mbBank1.setPasswordAccount(repeatPasswordAccount);
                    System.out.print("Xác nhận mã PIN: ");
                    int PIN = Integer.parseInt(sc.nextLine());

                    if (PIN == mbBank1.getPIN()) {
                        System.out.println("Thay đổi thông tin thành công!");
                        check = true;
                    } else {
                        System.err.println("Mã PIN không chính xác.");
                        return;
                    }

                } else {
                    System.err.println("Mật khẩu không trùng khớp.");
                    return;
                }
                break;
            }
        }
        if (!check) {
            System.err.println("Số tài khoản không tồn tại.");
        }

        saveData();
    }

    public void deleteAccount() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean check = false;
        for (MBBank mbBank1 : mbBanks) {
            if (accountBank.equals(mbBank1.getAccountBank())) {
                System.out.print("Xác nhận mã PIN: ");
                int PIN = Integer.parseInt(sc.nextLine());
                if (PIN == mbBank1.getPIN()) {
                    mbBanks.remove(mbBank1);
                    check = true;
                    System.out.println("Xoá thành công!");
                    break;
                } else {
                    System.err.println("Mã PIN không chính xác.");
                    return;
                }
            }
        }
        if (!check) {
            System.err.println("Số tài khoản không tồn tại.");
        }

        saveData();
    }

    public void rechargeMoney() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean check = false;
        for (MBBank mbBank1 : mbBanks) {
            if (accountBank.equals(mbBank1.getAccountBank())) {
                System.out.print("Nhập số tiền nạp: ");
                long money = Long.parseLong(sc.nextLine());
                mbBank1.setMoney(+money);
                check = true;
                System.out.println("Tài khoản " + mbBank1.getAccountBank() + " đã nạp " + money + "$");
                System.out.println("Số dư: " + mbBank1.getMoney() + "$");
                break;
            }
        }
        if (!check) {
            System.err.println("Số tài khoản không tồn tại!");
        }

        saveData();
    }

    public void takeMoney() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean check = false;
        for (MBBank mbBank1 : mbBanks) {
            if (accountBank.equals(mbBank1.getAccountBank())) {
                System.out.print("Nhập số tiền rút: ");
                long money = Long.parseLong(sc.nextLine());


                if (mbBank1.getMoney() >= money) {
                    System.out.print("Xác nhận mã PIN: ");
                    int PIN = Integer.parseInt(sc.nextLine());

                    if (PIN == mbBank1.getPIN()) {
                        mbBank1.setMoney(-money);
                        check = true;
                        System.out.println("Tài khoản " + mbBank1.getAccountBank() + " đã rút " + money + "$");
                        System.out.println("Số dư: " + mbBank1.getMoney() + "$");
                    } else {
                        System.err.println("Mã PIN không chính xác.");
                        return;
                    }

                } else {
                    System.err.println("Số dư không đủ.");
                    return;
                }
                break;
            }
        }
        if (!check) {
            System.err.println("Số tài khoản không tồn tại.");
        }

        saveData();
    }

    public void displayAccount() {
        for (MBBank mbBank1 : mbBanks) {
            System.out.println(mbBank1);
        }
    }

    public void sendMoney() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean check = false;

        for (MBBank mbBank1 : mbBanks) {
            if (accountBank.equals(mbBank1.getAccountBank())) {
                System.out.println("---- Người nhận ----");
                System.out.print("STK: ");
                String accountBankReceiver = sc.nextLine();
                boolean checkNameAccount = false;
                for (MBBank mbBankReceiver : mbBanks) {
                    if (accountBankReceiver.equals(mbBankReceiver.getAccountBank())) {
                        System.out.println(mbBankReceiver.getNameAccount());

                        System.out.print("Số tiền gửi: ");
                        long money = Long.parseLong(sc.nextLine());
                        if (mbBank1.getMoney() >= money) {
                            System.out.print("Xác nhận mã PIN: ");
                            int PIN = Integer.parseInt(sc.nextLine());
                            if (mbBank1.getPIN() == PIN) {
                                mbBank1.setMoney(-money);
                                mbBankReceiver.setMoney(+money);
                                System.out.println("STK " + mbBank1.getAccountBank() + " đã gửi " + money + "$ cho STK " + accountBankReceiver);
                                System.out.println("Giao dịch thành công!");
                                check = true;

                                System.out.println("----Check các TK----");
                                System.out.println("TK " + mbBank1.getAccountBank() + " , số dư: " + mbBank1.getMoney());
                                System.out.println("TK " + mbBankReceiver.getAccountBank() + " , số dư: " + mbBankReceiver.getMoney());
                            } else {
                                System.err.println("Mã PIN không chính xác.");
                                return;
                            }
                        } else {
                            System.err.println("Số dư không đủ.");
                            return;
                        }
                        checkNameAccount = true;
                        break;
                    }
                }
                if (!checkNameAccount) {
                    System.err.println("Tài khoản người nhận không tồn tại.");
                    return;
                }
                break;
            }
        }
        if (!check) {
            System.err.println("Số tài khoản người gửi không tồn tại");
        }

        saveData();
    }

    public void receiveElectricityBill() {
        electricityBills.add(new ElectricityBill("Điện1123", LocalDate.of(2023, 1, 1), 120000, "Chưa thanh toán", null));
        electricityBills.add(new ElectricityBill("Điện2223", LocalDate.of(2023, 2, 2), 110000, "Chưa thanh toán", null));
        electricityBills.add(new ElectricityBill("Điện3323", LocalDate.of(2023, 3, 3), 150000, "Chưa thanh toán", null));
        electricityBills.add(new ElectricityBill("Điện4423", LocalDate.of(2023, 4, 4), 50000, "Chưa thanh toán", null));
        electricityBills.add(new ElectricityBill("Điện5523", LocalDate.of(2023, 5, 5), 85000, "Chưa thanh toán", null));
        electricityBills.add(new ElectricityBill("Điện6623", LocalDate.of(2023, 6, 6), 200000, "Chưa thanh toán", null));

        MBBank selectedMBBank = null;
        ElectricityBill selectedElectricityBill = null;

        System.out.print("STK nhận bill: ");
        String accountBank = sc.nextLine();
        System.out.print("Mã điện: ");
        int idElectricityBill = Integer.parseInt(sc.nextLine());

        for (MBBank mbBank1 : mbBanks) {
            if (accountBank.equals(mbBank1.getAccountBank())) {
                selectedMBBank = mbBank1;
                break;
            }
        }
        if (selectedMBBank == null) {
            System.err.println("Số tài khoản không tồn tại.");
            return;
        }

        for (ElectricityBill electricityBill : electricityBills) {
            if (idElectricityBill == electricityBill.getId()) {
                selectedElectricityBill = electricityBill;
                break;
            }
        }
        if (selectedElectricityBill == null) {
            System.err.println("Hoá đơn điện không tồn tại.");
            return;
        }

        for (int i = 0; i < selectedMBBank.getElectricityBills().size(); i++) {
            if (selectedMBBank.getElectricityBills().get(i).getId() == idElectricityBill) {
                System.err.println("Bạn đã nhận Hoá Đơn này.");
                return;
            }
        }

        selectedMBBank.addElectricityBill(selectedElectricityBill);
        System.out.println("TK" + selectedMBBank.getAccountBank() + " đã nhận hoá đơn Điện '" + selectedElectricityBill.getName() + "'");

        saveData();
        saveDataElectricityBill();
    }

    public void payElectricityBill2() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean check = false;
        for (MBBank mbBank : mbBanks) {
            if (accountBank.equals(mbBank.getAccountBank())) {
                System.out.print("Thanh toán Hoá đơn số: ");
                int idElectricityBill = Integer.parseInt(sc.nextLine());
                boolean checkIdElectricityBill = false;

                for (int i = 0; i < mbBank.getElectricityBills().size(); i++) {
                    // Tạo biến tạm thời để lưu trữ đối tượng hoá đơn điện tìm thấy
                    ElectricityBill foundElectricityBill = null;
                    if (idElectricityBill == mbBank.getElectricityBills().get(i).getId()) {
                        foundElectricityBill = mbBank.getElectricityBills().get(i);
                        checkIdElectricityBill = true;

                        // Kiểm tra xem hoá đơn đã thanh toán hay chưa
                        if (foundElectricityBill.getStatus().equals("Đã Thanh Toán")) {
                            System.out.println("Hoá đơn " + foundElectricityBill.getName() + " đã thanh toán.");
                            return;
                        }

                        // Tiếp tục xử lý khi hoá đơn điện tồn tại và chưa thanh toán
                        System.out.print("Nhập tiền '" + foundElectricityBill.getMoney() + "'$ để thanh toán: ");
                        long money = Long.parseLong(sc.nextLine());
                        if (mbBank.getMoney() >= foundElectricityBill.getMoney()) {
                            if (money == foundElectricityBill.getMoney()) {
                                System.out.print("Xác nhận mã PIN: ");
                                int PIN = Integer.parseInt(sc.nextLine());
                                if (PIN == mbBank.getPIN()) {
                                    mbBank.setMoney(-money);
                                    foundElectricityBill.setStatus("Đã Thanh Toán");
                                    foundElectricityBill.setDatePaid(LocalDate.now());

                                    System.out.println("TK " + mbBank.getAccountBank() + " đã thanh toán hoá đơn " +
                                            foundElectricityBill.getName() + " : -" + money + "$");
                                    System.out.println("Số dư: " + mbBank.getMoney());
                                    check = true;
                                    break;
                                } else {
                                    System.err.println("Mã PIN không chính xác.");
                                    return;
                                }
                            } else {
                                System.err.println("Vui lòng nhập đúng số tiền");
                                return;
                            }
                        } else {
                            System.err.println("Số dư không đủ.");
                            return;
                        }
                    }
                }
                //Kiểm tra xem hoá đơn điện có tồn tại hay không
                if (!checkIdElectricityBill) {
                    System.err.println("Hoá đơn không tồn tại.");
                    return;
                }
            }
            break;
        }
        if (!check) {
            System.err.println("Số tài khoản không tồn tại.");
        }

        saveDataElectricityBill();
        saveData();
    }

    public void deleteElectricityBill() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean checkSTK = false;
        for (MBBank mbBank : mbBanks) {
            if (accountBank.equals(mbBank.getAccountBank())) {
                checkSTK = true;
                System.out.print("Xoá mã Điện: ");
                int idElectricityBill = Integer.parseInt(sc.nextLine());
                boolean checkIdElectricityBill = false;
                for (int i = 0; i < mbBank.getElectricityBills().size(); i++) {
                    if (idElectricityBill == mbBank.getElectricityBills().get(i).getId()) {
                        mbBank.deleteElectricityBill(mbBank.getElectricityBills().get(i));
                        checkIdElectricityBill = true;
                        System.out.println("Hoá đơn " + mbBank.getElectricityBills().get(i).getName() + " đã xoá thành công!");
                        break;
                    }
                }
                if (!checkIdElectricityBill) {
                    System.err.println("Hoá đơn Điện không tồn tại");
                    return;
                }
            }
        }
        if (!checkSTK) {
            System.err.println("Số tài khoản không tồn tại");
        }

        saveDataElectricityBill();
        saveData();
    }

    public void displayElectricityBill() {
        System.out.print("Nhập STK: ");
        String accountBank = sc.nextLine();
        boolean check = false;
        for (MBBank mbBank : mbBanks) {
            if (accountBank.equals(mbBank.getAccountBank())) {
                System.out.println(mbBank.toStringPayElectricityBill());
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Số tài khoản không tồn tại.");
        }
    }

    //Save and UpLoad Data MBbank
    public void saveData() {
        File file = new File("src/data/MBBank.txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(mbBanks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        File file = new File("src/data/MBBank.txt");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            mbBanks = (List<MBBank>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save and UpLoad Data Electricity Bill
    public void saveDataElectricityBill() {
        File file = new File("src/data/ElectricityBill.txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(electricityBills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataElectricityBill() {
        File file = new File("src/data/ElectricityBill.txt");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            electricityBills = (List<ElectricityBill>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // REGEX
    public boolean checkNameBankRegex(String regex) {
        return Pattern.matches("^([A-Z]+[a-z]*[ ]*)+$", regex);
    }

    public String inputNameBank() {

        while (true) {
            System.out.print("Nhập tên Bank: ");
            nameBank = sc.nextLine();
            if (checkNameBankRegex(nameBank)) {
                return nameBank;
            }

            System.err.println("\nViết HOA chữ đầu");
        }
    }

    public boolean checkAccountBankRegex(String regex) {
        return Pattern.matches("^\\w{9,14}$", regex);
    }

    public String inputAccountBank() {
        while (true) {
            System.out.print("Nhập STK: ");
            accountBank = sc.nextLine();
            if (checkAccountBankRegex(accountBank)) {
                return accountBank;
            }
            System.err.println("\nVui lòng nhập 9-14 ký tự Số hoặc Chữ");
        }
    }

    public boolean checkPasswordAccountRegex(String regex) {
        return Pattern.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z]).{6,}$", regex);
    }

    public String inputPasswordAccount() {
        while (true) {
            System.out.print("Nhập mật khẩu: ");
            passwordAccount = sc.nextLine();
            if (checkPasswordAccountRegex(passwordAccount)) {
                return passwordAccount;
            }
            System.err.println("\nÍt nhất 1 ký tự đặc biệt, viết Hoa, số, 6 ký tự trở lên");
        }
    }

    public boolean checkNameAccountRegex(String regex) {
        return Pattern.matches("^(?=.*[A-Z])[A-Za-z]{2,}(\\s[A-Za-z]{2,})+$", regex);
    }

    public String inputNameAccount() {
        while (true) {
            System.out.print("Nhập tên: ");
            nameAccount = sc.nextLine();
            if (checkNameAccountRegex(nameAccount)) {
                return nameAccount;
            }
            System.err.println("\nVui lòng nhập đầy đủ họ tên");
        }
    }

    public boolean checkPIN(String regex) {
        return Pattern.matches("^\\d{6}$", regex);
    }

    public String inputPIN() {
        while (true) {
            System.out.print("Nhập mã PIN: ");
            String input = sc.nextLine();
            if (input.matches("\\d+")) {
                PIN = Integer.parseInt(input);
                if (checkPIN(input)) {
                    return input;
                }
                System.err.println("Vui lòng nhập 6 chữ số.");
            }
        }
    }
}