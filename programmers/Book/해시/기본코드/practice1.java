package 해시.기본코드;


class Student {
    final int id;
    final String name;
    Student(int id, String name){
        this.id = id;
        this.name = name;
    }
}

public class practice1 {    
    public static void main(String[] args) {
        Student[] students = new Student[100];

        //학번이 10인 Student 검색
        if(students[10]==null) {
            System.out.println("10번 학생 없음");
        } else {
            System.out.println("10번 : " + students[10].name);
        }

        //학번이 20인 Student 삽입
        Student student = new Student(20, "홍길동");
        students[student.id] = student;

        //학번이 30인 Student 삭제
        students[30] = null;

    }
}
