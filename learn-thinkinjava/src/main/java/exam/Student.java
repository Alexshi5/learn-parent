package exam;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * author Alex
 * date 2019/6/3
 * description 利用反射来循环获取对象的属性以及属性值
 */
public class Student {
    public String test;
    private String name;
    private String age;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

class StudentTest{
    public static void main(String[] args) {
        StudentTest test = new StudentTest();
        //test.example1();
        test.example2();
    }

    public void example1(){
        try {
            Student student = new Student();
            student.setName("zhangsan");
            student.setAge("26");
            student.setPhone("13627629031");

            Map<String,String> map = new HashMap<>();
            Class<? extends Student> studentClass = student.getClass();
            Field[] declaredFields = studentClass.getDeclaredFields();
            for(Field field : declaredFields){
                String fieldName = field.getName();
                String methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                Method method = studentClass.getMethod(methodName);
                Object result = method.invoke(student);
                map.put(fieldName,result.toString());
            }
            System.out.println(map.size() + map.get("name"));
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public void example2(){
        Integer a = 10, b = 5;
        System.out.println("a=" + a + ",b=" + b);
        this.example3(a,b);
        System.out.println("a=" + a + ",b=" + b);
    }

    private void example3(int a, int b){
       // Class<Integer> integerClass1 = int.class;
        //Class<Integer> integerClass2 = Integer.TYPE;

        /*Class<Integer> studentClass = Integer.class;
        Field[] fields = studentClass.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }*/

        try {
            int temp = a;
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(a, b);
            value.setInt(b, temp);

            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
