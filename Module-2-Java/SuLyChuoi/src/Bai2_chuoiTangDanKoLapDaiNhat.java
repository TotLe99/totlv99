import java.util.Scanner;

public class Bai2_chuoiTangDanKoLapDaiNhat {
    public static String findMaxSubstring(String str) {
        String max_Substring = "";
        for (int i = 0; i < str.length(); i++) {
            String current_Substring = String.valueOf(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > current_Substring.charAt(current_Substring.length() - 1)){
                    current_Substring += str.charAt(j);
                } else {
                    break;
                }
            }
            if (current_Substring.length() > max_Substring.length()) {
                max_Substring = current_Substring;
            }
        }
        return max_Substring;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap: ");
        String str = sc.nextLine();

        System.out.println(findMaxSubstring(str));
    }
}
