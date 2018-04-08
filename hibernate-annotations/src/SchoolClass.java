import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="schoolClasses")
public class SchoolClass implements java.io.Serializable {
	
	@Id//nazwa kolumny jest taka sama jak nazwa agrumentu//
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private int startYear;
	@Column
	private int currentYear;
	@Column
	private String profile;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Set<Student> students;

	public SchoolClass() {
		students = new HashSet<Student>();
	}
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String toString() {
		return "Class: " + profile + " (Started: " + getStartYear() + ", Current year: " + getCurrentYear() + ")";
	}
}