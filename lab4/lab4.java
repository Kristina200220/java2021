import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class lab4 {
    // c11=0
    public static void main(String[] args) {
        Student[] studentArray = new Student[3];
        studentArray[0] = new Student("Kristina", "Bondar", 17, 92, 100);
        studentArray[1] = new Student("Pitt", "Better", 18, 91, 63);
        studentArray[2] = new Student("Frank", "Lampard", 17, 92, 77);
        Arrays.sort(studentArray, Comparator.comparing(Student::getAge));
        System.out.printf("Sort : %s \n",
                Arrays.toString(studentArray));
        Arrays.sort(studentArray, Comparator.comparing(Student::getName).reversed());
        System.out.printf("Reverse sort : %s",
                Arrays.toString(studentArray));
    }
}
    class Student {
        String name;
        String surname;
        int age;
        int group;
        int mark;

        public Student(String name, String surname, int age, int group, int mark) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.group = group;
            this.mark = mark;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student myClass = (Student) o;
            return name == myClass.name &&
                    surname == myClass.surname &&
                    age == myClass.age &&
                    group == myClass.group &&
                    mark == myClass.mark;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, group, mark);
        }
        int getAge() {
            return this.age;
        }
        String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' + ", age=" + age + ", group=" + group + ", mark=" + mark +
                    '}';
        }
    }

