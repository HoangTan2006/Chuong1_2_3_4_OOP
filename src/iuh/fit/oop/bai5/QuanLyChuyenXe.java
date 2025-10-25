package iuh.fit.oop.bai5;

import java.util.Arrays;

public class QuanLyChuyenXe {
	private ChuyenXe[] danhSachChuyenXe;
	private int count;
	
	public QuanLyChuyenXe(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("Size khong duoc be hon 0");
		}
		this.danhSachChuyenXe = new ChuyenXe[size];
		this.count = 0;
	}
	
	public void themChuyenxe(ChuyenXe chuyenXe) {
		if (chuyenXe == null || count == danhSachChuyenXe.length) return;
		
		for (int i = 0; i < count; i++) {
			if (danhSachChuyenXe[i].equals(chuyenXe)) return;
		}
		
		danhSachChuyenXe[count++] = chuyenXe;
	}
	
	public ChuyenXe[] getDanhSachChuyenXe() {
		return Arrays.copyOf(danhSachChuyenXe, count);
	}
	
	public double tongDoanhThuXeNoiThanh() {
		double total = 0.0;
		for (int i = 0; i < count; i++) {
			if (danhSachChuyenXe[i].getClass().equals(ChuyenXeNoiThanh.class)) {
				total += danhSachChuyenXe[i].tongDoanhThu();
			}
		}
		return total;
	}
	
	public double tongDoanhThuXeNgoaiThanh() {
		double total = 0.0;
		for (int i = 0; i < count; i++) {
			if (danhSachChuyenXe[i].getClass().equals(ChuyenXeNgoaiThanh.class)) {
				total += danhSachChuyenXe[i].tongDoanhThu();
			}
		}
		return total;
	}
}
