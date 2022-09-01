package kz.bitlab.springboot.thymeleaftask1demo.db;
import java.util.ArrayList;

public class DBUtil {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Long index = 6L;

    static{
        students.add(new Student(1L,"Shyryn","Akanova", 90,"A"));
        students.add(new Student(2L,"Rauan","Ilyasov", 88,"C"));
        students.add(new Student(3L,"Serik","Yerikov", 48,"F"));
        students.add(new Student(4L,"Sabina","Aset", 77,"B"));
        students.add(new Student(5L,"Karina","Daniyarova", 33,"F"));
    }

    public static void addStudent(Student student){
        students.add(student);
        index++;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static Long getIndex() {
        return index;
    }
}
