package designPattern.proxyPattern;
//动态代理类实现购票

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



public class JDKDynamicProxy{
    public static void main(String[] args) {
        SellTickets porxy = new PorxyStationFactory().getPorxy();
        porxy.sell();
        porxy.seat();
    }
}

/**
 * 代理售票点工厂类：不需要实现具体的接口
 *
 */
class PorxyStationFactory {
    private TrainStationPoint stationPoint = new TrainStationPoint("软卧");

    //获取代理对象的通用方法
    public SellTickets getPorxy(){
        /**
         */
        SellTickets sellTickets = (SellTickets)Proxy
                /**
                 *  创建代理类的静态方法：newProxyInstance(类加载器，接口类，调用委托方法的处理类)
                 */
                .newProxyInstance(stationPoint.getClass().getClassLoader(),
                        stationPoint.getClass().getInterfaces(),
                        //通用处理类：用来调用委托方法：这里就是sell方法
                        (proxy, method, args) -> {
                            //增强的方法
                            System.out.println("代理成功，正在抢座：" );
                            //通过反射得到具体处理的方法
                            Object o = method.invoke(stationPoint, args);
                            return o;
                        });

        return sellTickets;
    }


}

//依旧是车站卖票站
class TrainStationPoint implements SellTickets{
    private String seat;

    public TrainStationPoint(String seat) {
        this.seat = seat;
    }

    @Override
    public void sell() {
        System.out.println("车站已购票！");
    }

    @Override
    public void seat() {
        System.out.println("正在选座:" + seat);
    }
}

