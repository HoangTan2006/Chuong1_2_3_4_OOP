package iuh.fit.oop.bai3;

import java.util.Arrays;

public class SoftwareHouse {
	private String theName;
	private Employee[] listStaff;
	private int quantityEmployee;

	public SoftwareHouse(String theName) {
		setTheName(theName);
		
		this.listStaff = new Employee[25];
		this.quantityEmployee = 0;
	}
	
	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		if (theName == null || theName.isBlank()) {
			throw new IllegalArgumentException("Ten khong hop le");
		}
		this.theName = theName;
	}

	public boolean addEmployee(Employee employee) {
		if (employee == null) {
			throw new IllegalArgumentException("Thong tin nhan vien khong hop le");
		}
		
		if (quantityEmployee == listStaff.length) return false;
		
		for (int i = 0; i < quantityEmployee; i++) {
			if (listStaff[i].equals(employee)) return false;
		}
		
		listStaff[quantityEmployee++] = employee;
		return true;
	}
	
	public void displayAllStaff() {
		for (int i = 0; i < quantityEmployee; i++) {
			System.out.println(listStaff[i]);
		}
	}
	
	public double getMonthlySalaryBill() {
		double total = 0;
		
		for (int i = 0; i < quantityEmployee; i++) {
			total += listStaff[i].getMonthlySalary();
		}
		
		return total;
	}
	
	public Employee[] sortAllStaffByName() {
		Employee[] sorted = Arrays.copyOf(listStaff, quantityEmployee);
		mergeSortEmployee(sorted, 0, quantityEmployee - 1);
		
		return sorted;
		
	}
	
	public void displayListProgrammers() {
		for (int i = 0; i < quantityEmployee; i++) {
			if (listStaff[i].getClass().equals(Programmer.class)) {
				System.out.println(listStaff[i]);
			}
		}
	}
	
	public boolean updateDepartmentForAdmin(int aPayrollNo, String deptNew) {
		for (int i = 0; i < quantityEmployee; i++) {
			if (listStaff[i].getThePayrollNumber() == aPayrollNo &&
					(listStaff[i] instanceof Administrator administrator)) {
				administrator.setTheDePartMent(deptNew);
				return true;
			}
		}
		return false;
	}
	
	private void mergeSortEmployee(Employee[] employees, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSortEmployee(employees, left, mid);
			mergeSortEmployee(employees, mid + 1, right);
			merge(employees, left, mid, right);
		}
	}
	
	private void merge(Employee[] employees, int left, int mid, int right) {
		int ll = mid - left + 1;
		int lr = right - mid;
		
		Employee[] leftArray = new Employee[ll];
		Employee[] rightArray = new Employee[lr];
		
		for (int i = 0; i < ll; i++) leftArray[i] = employees[left + i];
		for (int i = 0; i < lr; i++) rightArray[i] = employees[mid + i + 1];
		
		int i = 0, j = 0, k = left;
		
		while (i < ll && j < lr) {
			if (leftArray[i].getTheName().compareToIgnoreCase(
					rightArray[j].getTheName()) < 0) {
				employees[k++] = leftArray[i++];
			} else {
				employees[k++] = rightArray[j++];
			}
		}
		
		while (i < ll) employees[k++] = leftArray[i++];
		while (j < lr) employees[k++] = rightArray[j++];
	}
}
