package com.greenplatform.service.payService;

import java.util.Map;


public interface WxService {

    String payBack(String resXml);

    Map doUnifiedOrder() throws Exception;
}
