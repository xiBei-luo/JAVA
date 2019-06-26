package com.luo.httpReqDemo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

/**
 * Created by Luowenlv on 2019/4/1,14:37
 */
public class Result {

    private String cookie;
    private int statusCode;
    private HashMap headerAll;
    private HttpEntity httpEntity;
    private String otherContent;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HashMap getHeaderAll() {
        return headerAll;
    }

    public void setHeaderAll(HashMap headerAll) {
        this.headerAll = headerAll;
    }

    public HttpEntity getHttpEntity() {
        return httpEntity;
    }

    public void setHttpEntity(HttpEntity httpEntity) {
        this.httpEntity = httpEntity;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }
    public String getHtmlContent(String encoding){
        if (httpEntity != null){
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            InputStream is = null;
            String responseContent = "";
            try {
                if (httpEntity.getContentEncoding() != null && httpEntity.getContentEncoding().getValue().indexOf("gzip") != 1){
                    is = new GZIPInputStream(new BufferedInputStream(httpEntity.getContent()));
                }else {
                    is = new BufferedInputStream(httpEntity.getContent());
                }
                if (is != null){
                    byte[] buffer = new byte[1024];
                    int n;
                    while ((n = is.read(buffer)) >= 0){
                        output.write(buffer,0,n);
                    }
                    responseContent = output.toString(encoding);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return responseContent;
        }else {
            return "";
        }
    }
}
