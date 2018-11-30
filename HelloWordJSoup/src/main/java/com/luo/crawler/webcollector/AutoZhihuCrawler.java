package com.luo.crawler.webcollector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

/**
 * Created by Luowenlv on 2018/11/29,14:47
 */
public class AutoZhihuCrawler extends BreadthCrawler {
    //https://www.zhihu.com/question/61624754/answer/524843672
    private String regx = "https://www.zhihu.com/question/\\d{8}/answer/\\d{9}";
    private String imgRegx = "-.*\\.(jpg|png|gif).*";
    private String imgRegx2 = "-.*#.*";



    /**
     * 构造一个基于RocksDB的爬虫
     * RocksDB文件夹为crawlPath，crawlPath中维护了历史URL等信息
     * 不同任务不要使用相同的crawlPath
     * 两个使用相同crawlPath的爬虫并行爬取会产生错误
     *
     * @param crawlPath RocksDB使用的文件夹
     * @param autoParse 是否根据设置的正则自动探测新URL
     */
    public AutoZhihuCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("https://www.zhihu.com/");


        this.addRegex(regx);
        this.addRegex(imgRegx);
        this.addRegex(imgRegx2);
        setThreads(50);
        getConf().setTopN(100);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        if (page.code() == 301 || page.code() == 302){
            next.addAndReturn(page.location()).meta(page.meta());
            return;
        }//处理重定向(然而并没有解决)
        String url = page.url();
        if (url.matches(regx)){
            String question = page.select(".QuestionHeader").select(".QuestionHeader-main").select(".QuestionHeader-title").text();
            String detail = page.select(".QuestionHeader-detail").select(".RichText").text();
            String answer = page.select(".RichContent").select("p").text();

            System.out.println("question:"+question);
            System.out.println("detail:"+detail);
            System.out.println("answer:"+answer);
        }

    }

    public static void main(String[] args) throws Exception {
        AutoZhihuCrawler autoZhihuCrawler = new AutoZhihuCrawler("crawl",true);
        autoZhihuCrawler.start(5);
    }
}
