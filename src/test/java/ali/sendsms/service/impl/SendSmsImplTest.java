package ali.sendsms.service.impl;

import ali.sendsms.SendsmsApplicationTests;
import cn.javaer.aliyun.sms.SmsTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SendSmsImplTest extends SendsmsApplicationTests {

    @Autowired
    SendSmsImpl sendSms;

    @Test
    public void sendSms() {
        List<String> pn=new ArrayList<>();
        pn.add("18312872507");
        sendSms.sendSms(pn);
    }
}