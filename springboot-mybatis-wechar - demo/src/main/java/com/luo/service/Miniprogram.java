package com.luo.service;

import com.luo.utils.HttpRequest;

public class Miniprogram {
    public static void main(String[] args) {
        String appid = "wx2b8fc958297c4d71";
        String secret = "274ecce84ba5a46c65134e13d276d201";
        final String ACCESS_TOKEN = "32_WTmzU1wJWTrvLHlnNXwt82FjZzNRjPYXmm0TMwO35K9GCM7LbUU6gEW0hhf-LgTkrS_qdKMr_0-6jUNgRpveUNFYwMypMZR9NtzQf8PDqoHtD_zUzbrnbRA82gpvz9PHt41Z6qKrQHQ8inRnOMPjACAZXA";
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+ACCESS_TOKEN+"&next_openid=NEXT_OPENID";
        System.out.println(HttpRequest.doGet(url));
    }
}
