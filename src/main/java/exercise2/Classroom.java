package exercise2;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Classroom implements Serializable {
	private final Teacher teacher;
	private final Student[] students;

	public Classroom(Teacher teacher, Student[] students) {
		this.teacher = teacher;
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Student[] getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return String.format("Classroom[teacher=%s, %d students]", teacher, students.length);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Classroom classroom = (Classroom) o;
		return Objects.equals(teacher, classroom.teacher) &&
			Arrays.equals(students, classroom.students);
	}

	@Override
	public int hashCode() {
		return Objects.hash(teacher, students);
	}
}
