package exercise2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Person implements Serializable {
	private final String firstName;
	private final String lastName;
	private final LocalDate birthDate;

	protected Person(String firstName, String lastName, LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(firstName, person.firstName) &&
			Objects.equals(lastName, person.lastName) &&
			Objects.equals(birthDate, person.birthDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, birthDate);
	}
}
