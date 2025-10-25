package iuh.fit.oop.bai5;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public abstract class ChuyenXe {
	protected String maSoChuyen;
	protected String hoTenTaiXe;
	protected String soXe;
	protected double doanhThu;
	
	protected ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
		setMaSoChuyen(maSoChuyen);
		setHoTenTaiXe(hoTenTaiXe);
		setSoXe(soXe);
		setDoanhThu(doanhThu);
	}

	public void setMaSoChuyen(String maSoChuyen) {
		if (maSoChuyen == null || maSoChuyen.isBlank()) {
			throw new IllegalArgumentException("Ma so chuyen khong duoc de trong");
		}
		this.maSoChuyen = maSoChuyen;
	}
	
	public void setHoTenTaiXe(String hoTenTaiXe) {
		if (maSoChuyen == null || maSoChuyen.isBlank()) {
			throw new IllegalArgumentException("ho ten tai xe khong duoc de trong");
		}
		this.hoTenTaiXe = hoTenTaiXe;
	}
	
	public void setSoXe(String soXe) {
		if (maSoChuyen == null || maSoChuyen.isBlank()) {
			throw new IllegalArgumentException("So xe khong duoc de trong");
		}
		this.soXe = soXe;
	}
	
	public void setDoanhThu(double doanhThu) {
		if (doanhThu <= 0) {
			throw new IllegalArgumentException("Doanh thu khong duoc de trong");
		}
		this.doanhThu = doanhThu;
	}
	
	public String getMaSoChuyen() {
		return maSoChuyen;
	}
	
	public String getHoTenoTaiXe() {
		return hoTenTaiXe;
	}
	
	public String getSoXe() {
		return soXe;
	}
	
	public double getDoanhThu() {
		return doanhThu;
	}
	
	public abstract double tongDoanhThu();
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		return String.format("%12s | %-21s | %7s | %14s",
				maSoChuyen,
				hoTenTaiXe,
				soXe,
				nf.format(doanhThu));
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSoChuyen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return Objects.equals(maSoChuyen, other.maSoChuyen);
	}
	
}
