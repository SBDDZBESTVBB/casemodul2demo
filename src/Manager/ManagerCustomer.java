package Manager;

import Taodoituong.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerCustomer {
    public ArrayList<Customer> customers= new ArrayList<>();
    Scanner scanner =new Scanner(System.in);
    public void dangky(ManagerAccount managerAccount){
        System.out.println("Nhap user name");
        String username = scanner.nextLine();
        System.out.println("Nhap password");
        String password = scanner.nextLine();
        if(managerAccount.ktrausername(username)){
            System.out.println("Nhap fullname");
            String fullname = scanner.nextLine();
            System.out.println("Nhap address");
            String address = scanner.nextLine();
            System.out.println("Nhap so dien thoai");
            int sdt = Integer.parseInt(scanner.nextLine());
            Customer customer = new Customer(username,password,fullname,address,sdt);
            customers.add(customer);
            managerAccount.accounts.add(customer);
            customer.setId(managerAccount.accounts.get(managerAccount.accounts.size()-1).getId()+1);
        }else {
            System.out.println("Tai khoan da ton tai");
            return;
        }
    }

    public void deleteByid() {
        System.out.println("Nhap id khach hang can xoa");
        int id;
        while (true){
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Nhap sai du lieu moi nhap lai");
            }
        }
        for (Customer c:customers
             ) {
            if(c.getId()==id) customers.remove(c);
        }
    }

    @Override
    public String toString() {
        return "ManagerCustomer{" +
                "customers=" + customers +
                '}';
    }
}
