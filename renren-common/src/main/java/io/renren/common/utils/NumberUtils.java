package io.renren.common.utils;

import java.util.Random;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/9/27
 * @Description: 订单号生成方法
 **/
public class NumberUtils {

    /**
     * @Author: 胡成
     * @Date:   2018/9/27 13:48
     * @Description: 生成红包券编码
    **/
    public static String rewardNo(){
        String random = getRandom620(3);
        return "QTYD" + System.currentTimeMillis() + random;
    }

    /**
     * @Author: 胡成
     * @Date:   2018/9/27 13:48
     * @Description: 生成随机数
    **/
    public static String getRandom620(Integer length) {
        String result = "";
        Random rand = new Random();
        int n = 20;
        if (null != length && length > 0) {
            n = length;
        }
        int randInt = 0;
        for (int i = 0; i < n; i++) {
            randInt = rand.nextInt(10);
            result += randInt;
        }
        return result;
    }
}
