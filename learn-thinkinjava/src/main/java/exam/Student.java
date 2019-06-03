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
}
