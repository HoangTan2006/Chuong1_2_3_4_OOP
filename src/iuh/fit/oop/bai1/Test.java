package iuh.fit.oop.bai1;

import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon(10);
		
		HoaDonTheoGio hoaDon1= new HoaDonTheoGio("HG001", LocalDate.of(2013, 9, 13), "A", "P0001", 50000, 2);
		HoaDonTheoNgay hoaDon2 = new HoaDonTheoNgay("HG002", LocalDate.of(2013, 9, 10), "B", "P0002", 52000, 2);
		HoaDonTheoGio hoaDon3= new HoaDonTheoGio("HG003", LocalDate.of(2013, 10, 20), "C", "P0002", 50000, 2);
		HoaDonTheoNgay hoaDon4 = new HoaDonTheoNgay("HG004", LocalDate.of(2013, 4, 15), "D", "P0003", 50000, 2);
		HoaDonTheoGio hoaDon5 = new HoaDonTheoGio("HG005", LocalDate.of(2013, 5, 28), "E", "P0004", 50000, 2);
		
		quanLyHoaDon.themHoaDon(hoaDon1);
		quanLyHoaDon.themHoaDon(hoaDon2);
		quanLyHoaDon.themHoaDon(hoaDon3);
		quanLyHoaDon.themHoaDon(hoaDon4);
		quanLyHoaDon.themHoaDon(hoaDon5);
		
		for (HoaDon hd : quanLyHoaDon.xuatDanhSach()) {
			System.out.println(hd);
		}
		
		System.out.printf("\nTong so hoa don theo ngay: %d\n", quanLyHoaDon.tongSoHoaDonTheoNgay());
		System.out.printf("Tong so hoa don theo gio: %d\n", quanLyHoaDon.tongSoHoaDonTheoGio());
		
		System.out.printf("Trung binh thanh tien thang 9/2013: %.2f", quanLyHoaDon.tinhTrungBinhThanhTien(9, 2013));
	}
}
