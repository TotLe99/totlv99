public class Product {
    private static int count = 0;
    private int id;
    private String name;
    private double price; //gia
    private int quantity; //so luong
    private String describe; //mo ta

    public Product() {
        this.id = ++count;
    }

    public Product(String name, double price, int quantity, String describe) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return
                "Mã sản phẩm: " + id +
                        ", Tên: '" + name + '\'' +
                        ", Giá: " + price +
                        ", Số lượng: " + quantity +
                        ", Mô tả: '" + describe + '\'';
    }
}
