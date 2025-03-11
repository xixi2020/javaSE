package designPattern.proxyPattern;

/**
 * 实现静态代理：用车票举例
 */
public class StaticProxy {
    public static void main(String[] args) {
        //使用代理类进行购票
        PorxyStation porxyStation = new PorxyStation();
        porxyStation.sell();
    }

}
/**
 * 车站购票站
 */
class TrainStation implements SellTickets{

    @Override
    public void sell() {
        System.out.println("已购买车站的票！");
    }

    @Override
    public void seat() {

    }
}

/**
 * 代售点购票
 */
class PorxyStation implements SellTickets{
    TrainStation trainStation = new TrainStation();
    String seat;

    //静态代理增强车站购票站功能
    @Override
    public void sell() {
        System.out.println("代售点正在加速抢座：");
        trainStation.sell();
    }

    @Override
    public void seat() {

    }

}
