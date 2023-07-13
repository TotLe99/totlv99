import java.util.*;

public class ProductManager {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<Product>();
    }

    //hien thi
    public void displayProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    //create
    public Product create() {
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Mô tả: ");
        String describe = sc.nextLine();

        return new Product(name, price, quantity, describe);
    }

    //them
    public void addProduct() {
        Product product = create();
        products.add(product);
        System.out.println("Bạn đã thêm thành công!");
    }

    //Cập nhật
    public void updateProduct() {
        System.out.print("Mã sản phẩm: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean check = false;
        for (Product product : products) {
            if (id == product.getId()) {
                System.out.println("\nCập nhật sản phẩm '" + id + "'");
                System.out.print("Tên: ");
                String newName = sc.nextLine();
                System.out.print("Giá: ");
                double newPrice = Double.parseDouble(sc.nextLine());
                System.out.print("Số lượng: ");
                int newQuantity = Integer.parseInt(sc.nextLine());
                System.out.print("Mô tả: ");
                String newDescribe = sc.nextLine();

                product.setName(newName);
                product.setPrice(newPrice);
                product.setQuantity(newQuantity);
                product.setDescribe(newDescribe);
                check = true;
                System.out.println("\nBạn đã sửa thành công!");
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
        }
    }

    public void deleteProduct() {
        System.out.print("Mã sản phẩm: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Xác nhận xoá (Y): ");
        String y = sc.nextLine();
        boolean check = false;
        for (Product product : products) {
            if (id == product.getId()) {
                if (y.equals("y") || y.equals("Y")) {
                    products.remove(product);
                }
            }
            System.out.println("Bạn đã xoá thành công!");
            check = true;
            break;
        }
        if (!check) {
            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
        }
    }

    public void sortUpProduct() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public double findMaxPrice() {
        double max = 0;
        for (Product product : products) {
            if (product.getPrice() > max) {
                max = product.getPrice();
            }
        }
        return max;
    }

    public void searchAllMaxPrice() {
        double max = findMaxPrice();
        for (Product product : products) {
            if (product.getPrice() == max) {
                System.out.println(product);
            }
        }
    }


    public void readProductInFileCSV() {
    }

    public void saveProductInFileCSV() {
    }
}
