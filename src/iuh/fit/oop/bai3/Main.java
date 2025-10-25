package iuh.fit.oop.bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	String header = String.format("%-5s | %-20s | %15s | %15s | %-10s",
    	        "ID", "Tên nhân viên", "Lương cơ bản", "Lương thực lãnh", "Ngôn ngữ/Phong ban");
    	
        Scanner sc = new Scanner(System.in);
        SoftwareHouse company = new SoftwareHouse("IUH Software Solutions");
        
        //Test data
        company.addEmployee(new Programmer(1001, "Alice Johnson", 4500000.0, "Java"));
        company.addEmployee(new Programmer(1002, "Bob Smith", 5000000.0, "Python"));
        company.addEmployee(new Programmer(1003, "Charlie Brown", 4800000.0, "C++"));
        company.addEmployee(new Programmer(1004, "Diana Adams", 5200000.0, "JavaScript"));
        company.addEmployee(new Programmer(1005, "Evan Thompson", 5500000.0, "Kotlin"));

        company.addEmployee(new Administrator(2001, "Fiona Green", 6000000.0, "HR"));
        company.addEmployee(new Administrator(2002, "George White", 6200000.0, "Finance"));
        company.addEmployee(new Administrator(2003, "Helen Clark", 6100000.0, "Operations"));
        company.addEmployee(new Administrator(2004, "Ian Miller", 6400000.0, "IT"));
        company.addEmployee(new Administrator(2005, "Jane Lee", 6300000.0, "Marketing"));

        int choice;
        do {
            System.out.println("\n===== MENU QUAN LY CONG TY PHAN MEM =====");
            System.out.println("1. Them nhan vien moi");
            System.out.println("2. Hien thi danh sach tat ca nhan vien");
            System.out.println("3. Tinh tong tien luong phai tra hang thang");
            System.out.println("4. Sap xep danh sach nhan vien theo ten");
            System.out.println("5. Hien thi danh sach lap trinh vien");
            System.out.println("6. Cap nhat phong ban cho quan ly");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println("Nhap thong tin nhan vien moi:");
                    System.out.print("Loai nhan vien (1 - Programmer, 2 - Administrator): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ma so nhan vien: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ten nhan vien: ");
                    String name = sc.nextLine();
                    System.out.print("Luong co ban: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee emp = null;
                    if (type == 1) {
                        System.out.print("Nhap ngon ngu lap trinh: ");
                        String lang = sc.nextLine();
                        emp = new Programmer(id, name, salary, lang);
                    } else if (type == 2) {
                        System.out.print("Nhap ten phong ban: ");
                        String dept = sc.nextLine();
                        emp = new Administrator(id, name, salary, dept);
                    }

                    boolean added = company.addEmployee(emp);
                    System.out.println(added ? "==> Them nhan vien thanh cong!" : "==> Them that bai (trung ma hoac day danh sach)");
                    break;

                case 2:
                	System.out.println(header);
                    company.displayAllStaff();
                    break;

                case 3:
                    System.out.printf("Tong tien luong hang thang: $%,.2f%n", company.getMonthlySalaryBill());
                    break;

                case 4:
                	System.out.println(header);
                    for (Employee e : company.sortAllStaffByName()) {
                    	System.out.println(e);
                    }
                    System.out.println("==> Da sap xep nhan vien theo ten!");
                    break;

                case 5:
                	System.out.println(header);
                    company.displayListProgrammers();
                    break;

                case 6:
                    System.out.print("Nhap ma so nhan vien quan ly: ");
                    int payroll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhap ten phong ban moi: ");
                    String newDept = sc.nextLine();

                    boolean updated = company.updateDepartmentForAdmin(payroll, newDept);
                    System.out.println(updated ? "==> Cap nhat thanh cong!" : "==> Khong tim thay nhan vien hoac khong phai quan ly!");
                    break;

                case 0:
                    System.out.println("==> Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (choice != 0);

        sc.close();
    }
}
