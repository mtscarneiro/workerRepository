package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entities.enums.WorkerLevel;

public class Worker {	
	private String name;
    private WorkerLevel level;
    private double baseSalary;
    
    private Department department;
    private List<hourContract> c= new ArrayList<>(); 
    
    public Worker() {
    }

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<hourContract> getContracts() {
		return c;
	}

	public void addContract(hourContract contract) {
    	c.add(contract);
    	
    }
    public void removeContract(hourContract contract) {
    	c.remove(contract);
    }
    public Double income(int year, int month) {
    	double sum = baseSalary;
    	Calendar cal = Calendar.getInstance();
    	for(hourContract h: c) {
    		cal.setTime(h.getDate());
    		int h_year = cal.get(Calendar.YEAR);
    		int h_month = cal.get(Calendar.MONTH);
    		if (year == h_year && month == h_month) {
    			sum += h.totalValue();
    		}
    	}
    	return sum;
    }

}
