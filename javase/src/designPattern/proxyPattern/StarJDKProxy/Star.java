package designPattern.proxyPattern.StarJDKProxy;

/**
 * 模拟代理类，经纪人代理艺人的行为，艺人只用提供表演内容方法。
 */
public interface Star {
    /**
     * 唱歌方法
     * @param name 歌曲名字
     * @return
     */
    String sing(String name);
    void dance();
}
