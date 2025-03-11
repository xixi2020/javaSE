package designPattern.proxyPattern.StarJDKProxy;

public class BigStar implements Star{
    //明星的名字
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String sing(String name) {
        System.out.println(getName() + "正在唱:" + name);
        return "thanks!everyone!";
    }

    @Override
    public void dance() {
        System.out.println(getName() + "正在天舞");
    }
}
