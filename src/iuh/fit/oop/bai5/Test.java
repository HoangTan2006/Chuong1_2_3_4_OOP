package iuh.fit.oop.bai5;

import java.text.NumberFormat;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		String header = String.format(
			    " | %-7s | %-21s | %-7s | %14s | %18s | %11s | %14s |%n",
			    "Ma so chuyen", "Ho ten tai xe", "So xe", "Doanh thu", "So tuyen/ Noi den", "So Km/Ngay di duoc", "Tong doanh thu"
			);
		
		QuanLyChuyenXe quanLyChuyenXe = new QuanLyChuyenXe(10);
		
		quanLyChuyenXe.themChuyenxe(new ChuyenXeNoiThanh("001", "Nguyen Van A", "10", 10000.0, 702, 10));
		quanLyChuyenXe.themChuyenxe(new ChuyenXeNoiThanh("003", "Le Van A", "10", 7000.0, 703, 7));

		quanLyChuyenXe.themChuyenxe(new ChuyenXeNgoaiThanh("002", "Nguyen Van B", "11", 100000.0, "Sai Gon", 5));
		quanLyChuyenXe.themChuyenxe(new ChuyenXeNgoaiThanh("004", "Pham Van B", "12", 90000.0, "Tay Ninh", 3));
		
		System.out.println(header);
		for (ChuyenXe ce : quanLyChuyenXe.getDanhSachChuyenXe()) {
			System.out.println(ce);
		}
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		System.out.printf("\nTong doanh thu cua nhung xe noi thanh: %s\n", nf.format(quanLyChuyenXe.tongDoanhThuXeNoiThanh()));
		System.out.printf("Tong doanh thu cua nhung xe ngoai thanh: %s\n", nf.format(quanLyChuyenXe.tongDoanhThuXeNgoaiThanh()));
	}
	
}
