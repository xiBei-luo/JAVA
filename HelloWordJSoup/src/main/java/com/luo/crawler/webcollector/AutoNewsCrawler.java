package com.luo.crawler.webcollector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * Created by Luowenlv on 2018/11/29,10:00
 */
public class AutoNewsCrawler extends BreadthCrawler {


    public AutoNewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("http://sousuo.gov.cn/column/19423/0.htm");

        String regx = "http://www.gov.cn/xinwen/[0-9]{4}-[0-9]{2}/[0-9]{2}/content_[0-9]{7}.htm";

        this.addRegex(regx);
        this.addRegex("-.*\\.(jpg|png|gif).*");
        this.addRegex("-.*#.*");

        setThreads(50);
        getConf().setTopN(100);

    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        if (page.matchUrl("http://www.gov.cn/xinwen/[0-9]{4}-[0-9]{2}/[0-9]{2}/content_[0-9]{7}.htm")) {
            String title = page.select(".content").select(".padd").select(".article").select("h1").text();
            String content = page.select("#UCAP-CONTENT").select("p").text();

            System.out.println("URL:\n" + url);
            System.out.println("title:\n" + title);
            System.out.println("content:\n" + content);
        }
    }

    public static void main(String[] args) throws Exception {
        AutoNewsCrawler crawler = new AutoNewsCrawler("crawl", true);
        crawler.start(5);
    }

}