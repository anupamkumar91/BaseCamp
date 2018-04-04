
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person[] person = new Person[5];

		Person student = new Student("Anupam", 90);
		Person student1 = new Student("Subash", 70);
		Person student2 = new Student("Gaurav", 87);

		Person professor = new Professor("Prof.Hardy", 2);
		Person professor1 = new Professor("Prof.Mary", 6);

		person[0] = student;
		person[1] = student1;
		person[2] = student2;
		person[3] = professor;
		person[4] = professor1;

		for (int i = 0; i < person.length; i++) {

			Object object = person[i];

			if (object.getClass() == Student.class) {
				Student s = (Student) object;
				if (s.isOutstanding()) {

					s.display();
				}
			} else {

				Professor p = (Professor) object;
				if (p.isOutstanding()) {
					p.print();
				}
			}
		}

	}

}
