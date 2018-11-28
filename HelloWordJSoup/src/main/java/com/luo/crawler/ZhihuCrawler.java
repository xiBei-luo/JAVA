package com.luo.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

import java.util.regex.Pattern;

/**
 * Created by Luowenlv on 2018/11/28,13:57
 */
public class ZhihuCrawler extends BreadthCrawler {

    public ZhihuCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String question_regex = "^http://www.zhihu.com/question/[0-9]+";
        if (Pattern.matches(question_regex,page.url())){
            System.out.println("正在抓取"+page.url());
            String title = page.select(".QuestionHeader-title").text();
            System.out.println("详情——"+title);
        }
    }
}
