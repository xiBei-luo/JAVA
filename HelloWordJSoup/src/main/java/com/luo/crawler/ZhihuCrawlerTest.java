package com.luo.crawler;

/**
 * Created by Luowenlv on 2018/11/28,14:03
 */
public class ZhihuCrawlerTest {
    public static void main(String[] args) throws Exception {
        ZhihuCrawler zhihuCrawler = new ZhihuCrawler("crawler",true);
        zhihuCrawler.addSeed("http://www.zhihu.com/question/21003086");
        zhihuCrawler.addRegex("\"http://www.zhihu.com/.*\"");
        zhihuCrawler.start(5);

    }
}
