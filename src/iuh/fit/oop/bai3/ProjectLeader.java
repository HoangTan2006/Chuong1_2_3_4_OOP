package iuh.fit.oop.bai3;

public class ProjectLeader extends Programmer {

	public ProjectLeader(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMonthlySalary, theLanguage);
	}
	
	@Override
	public double getMonthlySalary() {
		return theBasicMonthlySalary + theBasicMonthlySalary * 0.2;
	}
}
