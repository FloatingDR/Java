package Ioc;

//Ioc的作用是把这些依赖关系的属性从代码里拿出，通过容器来维护
public class IocTest {
    private IUser user;
    public void setUser(IUser user){
        this.user=user;
    }
    public IUser getUser(){
        return  this.user;
    }
    public void test(){
        this.user.say();
    }

    public static void main(String[] args) {
        IocTest test=new IocTest();
        test.setUser(new AdminUser());
        test.test();
    }
}
