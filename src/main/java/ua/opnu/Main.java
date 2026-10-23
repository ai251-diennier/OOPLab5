package ua.opnu;

public class Main {
    public static void main(String[] args) {
        TimeSpan empty = new TimeSpan();

        System.out.println("========== TASK 1: TimeSpan ==========");

        TimeSpan fromMinutes = new TimeSpan(150);
        TimeSpan interval = new TimeSpan(2, 30);
        TimeSpan copy = new TimeSpan(interval);
        System.out.println("Empty: " + empty);
        System.out.println("150 minutes: " + fromMinutes);
        System.out.println("Copy: " + copy);
        interval.add(1, 45);
        System.out.println("After add(1, 45): " + interval);
        interval.add(30);
        interval.add(fromMinutes);
        System.out.println("After other additions: " + interval);
        interval.subtract(1, 15);
        interval.subtract(30);
        interval.subtract(fromMinutes);
        System.out.println("After subtractions: " + interval);
        System.out.println("Hours: " + interval.getHours() + ", minutes: " + interval.getMinutes());
        System.out.println("Total hours: " + interval.getTotalHours());
        System.out.println("Total minutes: " + interval.getTotalMinutes());
        interval.scale(2);
        System.out.println("Scaled x2: " + interval);
        interval.subtract(10000);
        System.out.println("After excessive subtraction: " + interval);

        //TASK 2
        System.out.println("\n========== TASK 2: Inheritance ==========");

        Person person = new Person("Іваненко", "Іван", 40);
        Student student1 = new Student("Петренко", "Олег", 19, "КН-21", "12345");
        Student student2 = new Student("Коваленко", "Анна", 20, "КН-22", "67890");
        Lecturer lecturer1 = new Lecturer("Шевченко", "Марія", 45, "Комп'ютерні науки", 25000);
        Lecturer lecturer2 = new Lecturer("Бондар", "Андрій", 50, "Математика", 30000);

        Person[] people = {
                person,
                student1,
                student2,
                lecturer1,
                lecturer2
        };
        System.out.println("\n--- People information ---");
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}