package com.luo.crawler;

/**
 * Created by Luowenlv on 2018/11/29,14:17
 */
public class RegTest {
    public static void main(String[] args) {
        String reg = "https://www.zhihu.com/question/\\d{8}/answer/\\d{9}";
        String str = "https://www.zhihu.com/question/61624754/answer/524843672";

        System.out.println(str.matches(reg));
    }
}
