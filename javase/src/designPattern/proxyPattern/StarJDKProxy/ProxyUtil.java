package designPattern.proxyPattern.StarJDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类统一生成方法
 */
public class ProxyUtil {
    //生成明星代理类
    public static Star getStarProxy(BigStar bigStar){

        Star starProxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
              new Class[]{Star.class},
                new InvocationHandler() {
                    //回调方法，这里会对每一个方法进行反射增强
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")){
                            System.out.println("收取唱歌费用10w元");
                        }else if (method.getName().equals("dance")){
                            System.out.println("收取跳舞演出费20w元");
                        }
                        //统一返回方法运行结果;
                        return method.invoke(bigStar, args);
                    }
                }
        );
        return starProxy;
    }
}
