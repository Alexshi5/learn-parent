package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2019/1/12
 * description
 */
public interface Service {
    void fun();
}

interface ServiceFactory{
    Service getService();
}

class Implementation implements Service{
    @Override
    public void fun() {
        System.out.println("Implementation fun()");
    }
}

class ImplementationFactory implements ServiceFactory{
    @Override
    public Service getService() {
        return new Implementation();
    }
}

class ServiceTest{
    public static void service(ServiceFactory factory){
        Service service = factory.getService();
        service.fun();
    }
    public static void main(String[] args) {
        ServiceTest.service(new ImplementationFactory());
        //打印结果：Implementation fun()
    }
}
