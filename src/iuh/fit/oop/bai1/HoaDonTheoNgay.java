package iuh.fit.oop.bai1;

import java.time.LocalDate;

public class HoaDonTheoNgay extends HoaDon {
	private int soNgaythue;
	
	public HoaDonTheoNgay(String maHoaDon, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia,
			int soNgaythue) {
		super(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia);
		setSoNgaythue(soNgaythue);
	}

	public void setSoNgaythue(int soNgaythue) {
		if (soNgaythue <= 0) {
			throw new IllegalArgumentException("So ngay thue phai lon hon 0");
		}
		this.soNgaythue = soNgaythue;
	}
	
	public int getSoNgaythue() {
		return soNgaythue;
	}
	
	@Override
	public double thanhTien() {
		if (soNgaythue > 7) {
			return (((soNgaythue - 7) * 0.8) + 7) * donGia; 
		} else {
			return soNgaythue * donGia;
		}
	}

	@Override
	public String toString() {
		return String.format(" | %s | %s |",
			super.toString(),
			soNgaythue);
	}
	
}
