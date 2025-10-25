package iuh.fit.oop.bai5;

import java.text.NumberFormat;
import java.util.Locale;

public class ChuyenXeNgoaiThanh extends ChuyenXe{
	private String noiDen;
	private int soNgayDiDuoc;
	
	public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, String noiDen,
			int soNgayDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		setNoiDen(noiDen);
		setSoNgayDiDuoc(soNgayDiDuoc);
	}

	public void setNoiDen(String noiDen) {
		if (noiDen == null || noiDen.isBlank()) {
			throw new IllegalArgumentException("Noi den khong duoc de trong");
		}
		this.noiDen = noiDen;
	}
	
	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		if (soNgayDiDuoc < 0) {
			throw new IllegalArgumentException("So ngay di duoc khong duoc am");
		}
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	public String getNoiDen() {
		return noiDen;
	}
	
	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}
	
	@Override
	public double tongDoanhThu() {
		return soNgayDiDuoc * doanhThu;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		return String.format(" | %s | %18s | %18d | %14s |", 
				super.toString(),
				noiDen,
				soNgayDiDuoc,
				nf.format(tongDoanhThu()));
	}
}
