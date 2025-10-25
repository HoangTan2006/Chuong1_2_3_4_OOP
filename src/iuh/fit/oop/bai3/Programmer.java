package iuh.fit.oop.bai3;

public class Programmer extends Employee{
	protected String theLanguage;

	public Programmer(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMonthlySalary);
		setTheLanguage(theLanguage);
	}
	
	public String getTheLanguage() {
		return theLanguage;
	}

	public void setTheLanguage(String theLanguage) {
		if (theLanguage == null || theLanguage.isBlank()) {
			throw new IllegalArgumentException("Ngon ngu lap trinh khong hop le");
		}
		this.theLanguage = theLanguage;
	}
	
	@Override
	public double getMonthlySalary() {
		if (theLanguage.equals("Java")) {
			return theBasicMonthlySalary + theBasicMonthlySalary * 0.2;
		} else {
			return theBasicMonthlySalary;
		}
	}

	@Override
	public String toString() {
		return String.format("%s | %s",
				super.toString(),
				theLanguage);
	}
}
