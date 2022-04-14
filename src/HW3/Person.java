package HW3;

public class Person implements Comparable<Person>{
	String id;
	String firstName;
	String lastName;

	public Person(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Person [" + id + " " + firstName + " " + lastName + "]";
	}


	@Override
	public int compareTo(Person other) {
		return id.compareTo(other.id);
	}
}
