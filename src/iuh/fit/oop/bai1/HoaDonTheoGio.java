package iuh.fit.oop.bai1;

import java.time.LocalDate;

public class HoaDonTheoGio extends HoaDon {
	private int soGioThue;
	
	public HoaDonTheoGio(String maHoaDon, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia,
			int soGioThue) {
		super(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia);
		setSoGioThue(soGioThue);
	}

	public void setSoGioThue(int soGioThue) {
		if (soGioThue <= 0 || soGioThue > 30) {
			throw new IllegalArgumentException("So gio thue phai lon hon 0, neu lon hon 30 thi khong dung hoa don nay.");
		}
		this.soGioThue = soGioThue;
	}
	
	public int getSoGioThue() {
		return soGioThue;
	}

	@Override
	public double thanhTien() {
		return ((soGioThue > 24) ? 24 : soGioThue) * donGia;
	}
	
	@Override
	public String toString() {
		return String.format(" | %s | %s |", 
				super.toString(), 
				soGioThue);
	}
	
}
