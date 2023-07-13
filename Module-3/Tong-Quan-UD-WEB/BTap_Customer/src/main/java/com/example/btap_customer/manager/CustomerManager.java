package com.example.btap_customer.manager;
import com.example.btap_customer.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    public static List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer("Nguyen Van Hoan", LocalDate.of(1983,8,20), "Ha Noi", "https://watermark.lovepik.com/photo/20211121/large/lovepik-business-office-portrait-picture_500562044.jpg"));
        customers.add(new Customer("Nguyen Van Hoan", LocalDate.of(1983,8,20), "Ha Noi", "https://watermark.lovepik.com/photo/20211129/large/lovepik-mens-office-in-business-picture_501169469.jpg"));
        customers.add(new Customer("Nguyen Van Khoa", LocalDate.of(1994,8,14), "Ha Nam", "https://watermark.lovepik.com/photo/20211201/large/lovepik-young-business-male-office-image-picture_501365973.jpg"));
    }
}

