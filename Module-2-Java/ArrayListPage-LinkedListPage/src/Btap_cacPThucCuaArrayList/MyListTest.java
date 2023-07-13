package Btap_cacPThucCuaArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        //thêm ptu vào cuối
        myList.add(5);
        myList.add(6);
        myList.add(1, 3);
        myList.add(1, 5);
        myList.add(1, 1);

        System.out.println("==== Sau khi Thêm phần tử ====");
        System.out.println("List: " + myList.toString());
        System.out.println("Số phần tử = " + myList.size());
        System.out.println("Kiểm tra ptu '" + myList.contains(10) + "'");
        System.out.println("Trả về Ptu tại vị trí i: " + myList.get(4));

        System.out.println("\n==== Sau khi Sao Chép List ====");
        MyList<Integer> clonedList = myList.clone();
        System.out.println("Bản sao: " + clonedList.toString());

        myList.remove(1);
        myList.remove(4);
        myList.size();
        System.out.println("\n==== Sau khi Xoá phần tử ====");
        System.out.println("List: " + myList.toString());
        System.out.println("Số phần tử = " + myList.size());

        myList.clear();
        System.out.println("\n==== Sau khi xoá hết phần tử ====");
        System.out.println("List: " + myList.toString());

    }
}
