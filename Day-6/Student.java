public class Student {
    private int studentId;
    private String name;
    private String course;
    private double marks;
    public Student(int studentId,String name,String course,double amrks){
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
}
