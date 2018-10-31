package com.byk.myboke.commen.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;

/**
 * @Author: bianyakun
 * @Date: 2018/7/5 9:46
 * @Todo:
 */
@Service
public class SMSUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${byk.SMS.appid}")
    private  int appid;

    @Value("${byk.SMS.appkey}")
    private  String appkey;

    @Value("${byk.SMS.templateId}")
    private  int  templateId;

    /**
     * @Author: bianyakun
     * @Date: 2018/7/5 10:54
     * @todo: 输入一个电话号码，发送短信
     * @param:   * @param null
     */
    public void sendSMS(String phoneNumber) {
        System.out.println("====="+appid);
//        // 短信应用SDK AppID     // 1400开头
//        int appid = ;
//        // 短信应用SDK AppKey
//        String appkey = "";
//        // 需要发送短信的手机号码
//       // phoneNumber = "13999999999";
//        // 短信模板ID，需要在短信应用中申请
//        int templateId =  ;
        // 签名// NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
        String smsSign = "";
        try {
            String[] params = {};//参数，验证码为5678，30秒内填写
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            logger.info(result.toString());
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();

        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }catch (Exception e) {
            // 网络IO错误
            e.printStackTrace();
        }
    }
}
