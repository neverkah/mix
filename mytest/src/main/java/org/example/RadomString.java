package org.example;

import com.hzj.entity.Student;
import com.hzj.entity.User;
import com.hzj.util.MyConnectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RadomString {

    public static void main(String[] args) {
        List<User> stuList = new ArrayList<>();
        for (int i = 20001; i <= 200000; i++) {

            User user = new User();

            user.setId(i);

            user.setAge(100);
            user.setName(genRandomName(8));

            user.setDeptNo( new Random().nextInt(15)+1);
            stuList.add(user);

        }

        MyConnectionUtils.batchUpdateUser(stuList);
    }


    public static void main33(String[] args) {
        List<Student> stuList = new ArrayList<>();
        for (int i = 1; i <= 200000; i++) {

            Student student = new Student();

            student.setId(i);

            student.setGender(genGender());
            student.setName(genRandomName(8));

            student.setAdress(genRandomName(20));
            stuList.add(student);

        }

        MyConnectionUtils.batchUpdate(stuList);
    }


    public static void main22(String[] args) {
//        genRandomStr();
//        genGender();
        System.out.println("insert all");
        for (int i = 1; i <= 2000; i++) {

            System.out.print("into student(id,gender,name) values");
            System.out.print("(");

            System.out.print(i);

            System.out.print(",");

            System.out.print("'" + genGender() + "'");
            System.out.print(",");
            System.out.print("'" + genRandomName(8) + "'");
            System.out.print(")");


            System.out.println();

        }
        System.out.println("select * from dual;");
    }

    @Test
    public static String genGender() {
        int x = new Random().nextInt(2);


        if (x == 0) {
            return "男";
        } else {
            return "女";
        }


    }

    @Test
    public static String genRandomName(int length) {

        StringBuilder str = new StringBuilder();
        for (int j = 1; j <= length; j++) {
            int x = new Random().nextInt(15);


            str.append((char) (x + 97));
        }


        return str.toString();


    }


}
