package iuh.fit.oop.bai3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public abstract class Employee {
	protected final int thePayrollNumber;
	protected String theName;
	protected double theBasicMonthlySalary;
	
	protected Employee(int thePayrollNumber,String theName, double theBasicMonthlySalary) {
		if (thePayrollNumber < 0) {
			throw new IllegalArgumentException("The Payroll Number khong hop le");
		}
		
		this.thePayrollNumber =  thePayrollNumber;
		setTheName(theName);
		setTheBasicMonthlySalary(theBasicMonthlySalary);
	}

	public void setTheName(String theName) {
		if (theName == null || theName.isBlank()) {
			throw new IllegalArgumentException("Ten nhan vien khong hop le");
		}
		this.theName = theName;
	}

	public void setTheBasicMonthlySalary(double theBasicMonthlySalary) {
		if (theBasicMonthlySalary < 0) {
			throw new IllegalArgumentException("Luong phai lon hon 0");
		}
		this.theBasicMonthlySalary = theBasicMonthlySalary;
	}

	public int getThePayrollNumber() {
		return thePayrollNumber;
	}

	public String getTheName() {
		return theName;
	}

	public double getTheBasicMonthlySalary() {
		return theBasicMonthlySalary;
	}

	public abstract double getMonthlySalary();
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		return String.format("%-5s | %-20s | %15s | %15s", 
				thePayrollNumber,
				theName,
				nf.format(theBasicMonthlySalary),
				nf.format(getMonthlySalary()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(thePayrollNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Employee other = (Employee) obj;
		return thePayrollNumber == other.thePayrollNumber;
	}
}
