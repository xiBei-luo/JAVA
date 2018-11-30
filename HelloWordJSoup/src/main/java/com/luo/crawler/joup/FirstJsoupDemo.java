package com.luo.crawler.joup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/28,9:09
 */
public class FirstJsoupDemo {
    public static void main(String[] args) throws IOException {
        /*Document doc = Jsoup.connect("https://blog.csdn.net/u014798883/article/details/54909951").get();

        Elements test = doc.select("#content_views").select("p");

        String str = test.toString();
        String text = test.text();
        System.out.println("text is:"+text);*/

        Document document = Jsoup.connect("https://www.zhihu.com/explore/recommendations")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                .get();
        Element main = document.getElementById("zh-recommend-list-full");
        Elements url = main.select("div")
                .select("div")
                .select("h2")
                .select("a[class=question_link]");
        //System.out.println(url);//首页的链接

        for (Element question:url){

            String URL=question.attr("abs:href");
            Document document2=Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                    .get();
            //问题
            //System.out.println(document2);
            Elements title = document2.select("#root").select(".QuestionHeader").select(".QuestionHeader-title");
            //问题描述
            Elements detail=document2.select("#root").select(".QuestionHeader-detail").select("span");
            //回答
            Elements answer=document2.select("#root").select(".AnswerCard").select(".RichContent-inner").select("span").select("p");
            System.out.println("\n"+"链接："+URL
                    +"\n"+"标题："+title.text()
                    +"\n"+"问题描述："+detail.text()
                    +"\n"+"回答："+answer.text());


        }



    }
}
