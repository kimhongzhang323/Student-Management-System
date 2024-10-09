package test.java;
import java.util.ArrayList;
import main.java.models.Student; // Adjust the package name as necessary

class StudentManager {
    private ArrayList<Student> students;

    public StudentManager(){
        this.students = new ArrayList<Student>();

    }

    public void removeStudent(int matricNo){
        for (Student student : this.students){
            if (student.matricNo == matricNo){
                this.students.remove(student);
                break;
            }
        }
    }

    public void saveAllStudentsToFile(String filename){
        for (Student student : students){
            student.saveToFile(filename);
        }
    }

    public void loadStudentsFromFile(String filename){
        // 读取文件中的学生信息
        Student.loadFromFile(filename);
    }

    public void pritntAllStudents(){
        for (Student student : students){
            System.out.println(student.getStudentInfo());
        }
    }
}