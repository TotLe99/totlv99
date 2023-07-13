import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) throws IOException {
        System.out.println("Nhap link file: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }

    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();

            System.out.println("Tong = " + sum);
        } catch (Exception e) {
            System.err.println("File ko ton tai hoac noi dung co loi!");
        }
    }
}
