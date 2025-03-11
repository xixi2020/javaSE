package designPattern.proxyPattern.StarJDKProxy;

import java.lang.reflect.Proxy;

public class GetProxy {
    public static void main(String[] args) {
        ProxyUtil proxyUtil = new ProxyUtil();
        Star starProxy = proxyUtil.getStarProxy(new BigStar("ly"));
        String res = starProxy.sing("hrz");
        //这里要接收sing方法的结果
        System.out.println(res);
        starProxy.dance();
    }
}
