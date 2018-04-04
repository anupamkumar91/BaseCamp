
public class Person {
	private String name;

	Person(String name) {
		this.setName(name);
	}

	boolean isOutstanding() {
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Professor extends Person {

	int booksPublished;

	Professor(String name, int booksPublished) {
		super(name);
		this.booksPublished = booksPublished;

		// TODO Auto-generated constructor stub
	}

	void print() {

		System.out.println("Professor Name:" + this.getName());
		System.out.println("Book Published:" + booksPublished);
	}

	@Override
	boolean isOutstanding() {
		if (booksPublished > 4) {

			return true;
		}
		return false;

	}
}

class Student extends Person {

	double percentage;

	Student(String name, double percentage) {
		super(name);
		this.percentage = percentage;
	}

	void display() {

		System.out.println("Student name:" + this.getName());
		System.out.println("Student percentage:" + percentage);

	}

	@Override
	boolean isOutstanding() {
		if (percentage > 85) {

			return true;
		}
		return false;

	}
}