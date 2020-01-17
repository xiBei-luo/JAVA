package com.greenplatform.service.payService;

import java.math.BigDecimal;
import java.util.Map;


public interface WxService {

    String payBack(String resXml);

    Map doUnifiedOrder() throws Exception;
}
