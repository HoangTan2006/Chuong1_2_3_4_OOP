package iuh.fit.oop.bai1;

import java.time.YearMonth;
import java.util.Arrays;

public class QuanLyHoaDon {
	private HoaDon[] danhSachHoaDon;
	private int count;
	
	public QuanLyHoaDon(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size phai lon hon 0");
		}
		this.danhSachHoaDon = new HoaDon[size];
		this.count = 0;
	}
	
	private boolean isExists(HoaDon hoaDon) {
		for (int i = 0; i < count; i++) {
			if (danhSachHoaDon[i].equals(hoaDon)) return true;
		}
		return false;
	}
	
	private void extend() {
		this.danhSachHoaDon = Arrays.copyOf(danhSachHoaDon, count * 2);
	}
	
	public void themHoaDon(HoaDon hoaDon) {
		if (hoaDon == null || isExists(hoaDon)) return;
		
		if (count == danhSachHoaDon.length) extend();
		
		danhSachHoaDon[count++] = hoaDon;
	}
	
	public HoaDon[] xuatDanhSach() {
		return Arrays.copyOf(danhSachHoaDon, count);
	}
	
	public int tongSoHoaDonTheoGio() {
		int count = 0;
		for(int i = 0; i < count; i++) {
			if (danhSachHoaDon[i].getClass().equals(HoaDonTheoGio.class)) {
				count++;
			}
		}
		return count;
	}
	
	public int tongSoHoaDonTheoNgay() {
		int count = 0;
		for(int i = 0; i < count; i++) {
			if (danhSachHoaDon[i].getClass().equals(HoaDonTheoNgay.class)) {
				count++;
			}
		}
		return count;
	}
	
	public double tinhTrungBinhThanhTien(int thang, int nam) {
		if ((thang < 1 && thang > 12) || nam < 1) {
			throw new IllegalArgumentException("Ngay va thang khong hop le");
		}
		
		YearMonth yearMonth = YearMonth.of(nam, thang);
		
		double sum = 0;
		int quantity = 0;
		
		for (int i = 0; i < count; i++) {
			if (yearMonth.equals(YearMonth.from(danhSachHoaDon[i].getNgayHoaDon()))) {
				sum += danhSachHoaDon[i].thanhTien();
				quantity++;
			}
		}
		
		return sum / quantity;
	}
}
