package iuh.fit.oop.bai3;

public class Administrator extends Employee {
	protected String theDePartMent;

	public Administrator(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theDePartMent) {
		super(thePayrollNumber, theName, theBasicMonthlySalary);
		setTheDePartMent(theDePartMent);
	}
	
	public String getTheDePartMent() {
		return theDePartMent;
	}

	public void setTheDePartMent(String theDePartMent) {
		if (theDePartMent == null || theDePartMent.isBlank()) {
			throw new IllegalArgumentException("Ten phong ban khong hop le");
		}
		this.theDePartMent = theDePartMent;
	}
	
	@Override
	public double getMonthlySalary() {
		return theBasicMonthlySalary + theBasicMonthlySalary * 0.4;
	}

	@Override
	public String toString() {
		return String.format("%s | %s",
				super.toString(),
				theDePartMent);
	}
}
