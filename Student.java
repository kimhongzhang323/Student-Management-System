import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

class Course {
    private String courseName;
    private String courseCode; // 新增课程编号
    private int credits; // 新增学分

    public Course(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseInfo() {
        return this.courseCode + ": " + this.courseName + " (" + this.credits + " credits)";
    }
}

class Student {
    protected String name;
    protected int matricNo;
    protected ArrayList<Course> courses;
    protected String faculty;
    protected String contactNo; // 修改为字符串以支持更复杂的号码格式

    public Student(String name, int matricNo) {
        this.name = name;
        this.matricNo = matricNo;
        this.courses = new ArrayList<Course>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public String getStudentInfo() {
        String info = "Name: " + this.name + 
                      "\nMatric No: " + this.matricNo + 
                      "\nFaculty: " + this.faculty + 
                      "\nContact No: " + this.contactNo + 
                      "\nCourses: ";
        for (Course course : this.courses) {
            info += course.getCourseInfo() + "\n";
        }
        return info;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setContactNo(String contactNo) {
        if (isValidPhoneNumber(contactNo)) {
            this.contactNo = contactNo;
        } else {
            System.out.println("Invalid contact number. Please enter a valid phone number.");
        }
    }

    // 验证手机号格式
    private boolean isValidPhoneNumber(String contactNo) {
        // 正则表达式：以 01 开头的 10 位数字
        String regex = "^(01\\d{2}-?\\d{7}|01\\d{8})$"; 
        // 支持带或不带连字符的格式, 
        //例如 012-3456789 或 0123456789, 解释：^01\d{2}-?\d{7}$ 表示以01开头，后面跟着2位数字，然后是可选的连字符，最后是7位数字
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(contactNo).matches();
    }

    // 保存学生信息到文件
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(getStudentInfo());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving student information: " + e.getMessage()); // 打印异常信息
        }
    }
    // 从文件加载学生信息
    public static void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error saving student information: " + e.getMessage()); // 打印异常信息
        }
    }

}
