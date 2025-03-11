package designPattern.factoryPattern;

/**
 * 简单工厂模式
 * 使用 '简单工厂模式' 来设计一个咖啡店点餐系统。设计一个咖啡类 (Coffee) ，并定义其两个子类 (美式咖啡AmericanCoffee 和 拿铁咖啡LatteCoffee)，
 * 再设计一个咖啡店类 (CoffeeStore)，咖啡店具有点咖啡的功能。
 */


public class SimpleFactoryMethodPattern {

    public static void main(String[] args) {
        SimpleCoffeeStroe simpleCoffeeStroe = new SimpleCoffeeStroe();
        simpleCoffeeStroe.orderCoffee("americano");
        simpleCoffeeStroe.orderCoffee("latte");
    }

}
//这里是咖啡店类，用来指定咖啡
class SimpleCoffeeStroe{
    public void orderCoffee(String type){
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = simpleCoffeeFactory.createCoffee(type);
        coffee.getName();
        coffee.addMilk();
        coffee.addSuger();
    }
}


//咖啡工厂用来生产咖啡
class SimpleCoffeeFactory{
//    public Coffee createCoffee(String type){
//        Coffee coffee = null;
////        if("americano".equals(type)){
////            coffee = new SimpleAmerciaCoffee("美式");
////        } else if ("latte".equals(type)) {
////            coffee = new SimpleLatteCoffee("拿铁");
//        }
//        return coffee;
//    }
    //这里也可以是静态工厂
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if("americano".equals(type)){
            coffee = new SimpleAmerciaCoffee("美式");
        } else if ("latte".equals(type)) {
            coffee = new SimpleLatteCoffee("拿铁");
        }
        return coffee;
    }
}

//咖啡工厂类：提供了创建产品的方法，调用者通过该方法来获取产品。
class SimpleAmerciaCoffee implements Coffee{

    String name;

    public SimpleAmerciaCoffee(String name) {
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println("咖啡:"+ name);
    }

    @Override
    public void addMilk() {
        System.out.println("美式建议不加奶");
    }

    @Override
    public void addSuger() {
        System.out.println("美式建议不加糖");
    }
}
class SimpleLatteCoffee implements Coffee{

    String name;

    public SimpleLatteCoffee(String name) {
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println("咖啡:"+ name);;
    }

    @Override
    public void addMilk() {
        System.out.println("拿铁加奶");
    }

    @Override
    public void addSuger() {
        System.out.println("拿铁可加糖");
    }
}
