package domain;

public class Vacancy {
	private int id;
	private String location;
	private String skill_required;
	private int no_of_seats;
	private String jobCategory;
	private String qualification;
	private int emp_id;
	
	public Vacancy(int id, String location, String skill_required,
			int no_of_seats, String jobCategory, String qualification,
			int emp_id) {
		this.id = id;
		this.location = location;
		this.skill_required = skill_required;
		this.no_of_seats = no_of_seats;
		this.jobCategory = jobCategory;
		this.qualification = qualification;
		this.emp_id = emp_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkill_required() {
		return skill_required;
	}

	public void setSkill_required(String skill_required) {
		this.skill_required = skill_required;
	}

	public int getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "Vacancy [id=" + id + ", location=" + location
				+ ", skill_required=" + skill_required + ", no_of_seats="
				+ no_of_seats + ", jobCategory=" + jobCategory
				+ ", qualification=" + qualification + ", emp_id=" + emp_id
				+ "]";
	}
	
	
	
	


}

