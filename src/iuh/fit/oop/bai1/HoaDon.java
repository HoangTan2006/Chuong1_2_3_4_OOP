package iuh.fit.oop.bai1;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class HoaDon {
	protected String maHoaDon;
	protected LocalDate ngayHoaDon;
	protected String tenKhachHang;
	protected String maPhong;
	protected double donGia;
	
	protected HoaDon(String maHoaDon, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia) {
		setMaHoaDon(maHoaDon);
		setNgayHoaDon(ngayHoaDon);
		setTenKhachHang(tenKhachHang);
		setMaPhong(maPhong);
		setDonGia(donGia);
	}

	public void setMaHoaDon(String maHoaDon) {
		if (maHoaDon == null || maHoaDon.isBlank() || maHoaDon.contains(" ")) {
			throw new IllegalArgumentException("Ma hoa don khong duoc chua khoang trang");
		}
		this.maHoaDon = maHoaDon;
	}
	
	public void setNgayHoaDon(LocalDate ngayHoaDon) {
		if (ngayHoaDon == null || ngayHoaDon.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Ngay hoa don phai truoc ngay hien tai");
		}
		this.ngayHoaDon = ngayHoaDon;
	}
	
	public void setTenKhachHang(String tenKhachHang) {
		if (tenKhachHang == null || tenKhachHang.isBlank()) {
			throw new IllegalArgumentException("Ten khach hang khong duoc de trong");
		}
		this.tenKhachHang = tenKhachHang;
	}
	
	public void setMaPhong(String maPhong) {
		if (maPhong == null || maPhong.isBlank() || maPhong.contains(" ")) {
			throw new IllegalArgumentException("Ma phong khong duoc chua khoang trang");
		}
		this.maPhong = maPhong;
	}
	
	public void setDonGia(double donGia) {
		if (donGia <= 0) {
			throw new IllegalArgumentException("Don gia phai lon hon 0");
		}
		this.donGia = donGia;
	}
	
	public String getMaHoaDon() {
		return maHoaDon;
	}
	
	public LocalDate getNgayHoaDon() {
		return ngayHoaDon;
	}
	
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	
	public String getMaPhong() {
		return maPhong;
	}
	
	public double getDonGia() {
		return donGia;
	}
	
	public abstract double thanhTien();
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-Vn"));
		
		return String.format(" %s | %s | %s | %s | %s",
				maHoaDon,
				dtf.format(ngayHoaDon),
				tenKhachHang,
				maPhong,
				nf.format(donGia));
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
}
