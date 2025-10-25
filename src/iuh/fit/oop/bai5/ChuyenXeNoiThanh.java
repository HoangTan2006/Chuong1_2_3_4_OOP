package iuh.fit.oop.bai5;

import java.text.NumberFormat;
import java.util.Locale;

public class ChuyenXeNoiThanh extends ChuyenXe{
	private int soTuyen;
	private int soKmDiDuoc;
	
	public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, int soTuyen,
			int soKmDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		setSoTuyen(soTuyen);
		setSoKmDiDuoc(soKmDiDuoc);
	}

	public void setSoTuyen(int soTuyen) {
		if (soTuyen < 0) {
			throw new IllegalArgumentException("So tuyen phai lon hon 0");
		}
		this.soTuyen = soTuyen;
	}
	
	public void setSoKmDiDuoc(int soKmDiDuoc) {
		if (soKmDiDuoc < 0) {
			throw new IllegalArgumentException("So km di duoc phai lon hon 0");
		}
		this.soKmDiDuoc = soKmDiDuoc;
	}
	
	public int getSoTuyen() {
		return soTuyen;
	}
	
	public int getSoKmDiDuoc() {
		return soKmDiDuoc;
	}
	
	@Override
	public double tongDoanhThu() {
		return soKmDiDuoc * doanhThu;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		return String.format(" | %s | %18d | %18d | %14s |", 
				super.toString(),
				soTuyen,
				soKmDiDuoc,
				nf.format(tongDoanhThu()));
	}
}
