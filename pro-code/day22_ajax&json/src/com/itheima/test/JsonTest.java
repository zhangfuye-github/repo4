package com.itheima.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Person;
import com.itheima.domain.Student;
import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/12
 * @Description:
 */
public class JsonTest {
    @Test
    public void test() throws JsonProcessingException {
        //1.创建Person对象
        Person person = new Person();
        Student student = new Student();
        student.setId(1);
        student.setMonitor("lisi");
        student.setClassID(3);
        person.setName("zhangsan");
        person.setAge(23);
        person.setGender("男");
        person.setSt(student);
        person.setBirthday(new Date());
        //创建处理器
        ObjectMapper mapper = new ObjectMapper();
        //进行转换
        String s = mapper.writeValueAsString(person);//{"name":"zhangsan","gender":"男","age":23,"birthday":1602494811201}
        System.out.println(s);

    }
    @Test
    public void test1() throws IOException {
        //1.创建Person对象
//        Person person = new Person();
//        Student student = new Student();
//        student.setId(1);
//        student.setMonitor("lisi");
//        student.setClassID(3);
//        person.setName("zhangsan");
//        person.setAge(23);
//        person.setGender("男");
//        person.setSt(student);
//        person.setBirthday(new Date());
        //创建处理器
        ObjectMapper mapper = new ObjectMapper();
//        //进行转换
//        String s = mapper.writeValueAsString(person);//{"name":"zhangsan","gender":"男","age":23,"birthday":1602494811201}
//        System.out.println(s);
        String json1="{\"name\":\"zhangsan\",\"gender\":\"男\",\"age\":23,\"birthday\":\"2020-10-12\",\"st\":{\"id\":1,\"classID\":3,\"monitor\":\"lisi\"}}";
        Person person = mapper.readValue(json1, Person.class);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = dateFormat.format(person.getBirthday());
        System.out.println(s);

    }
}
