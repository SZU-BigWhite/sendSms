package ali.sendsms.factory;

import ali.sendsms.config.SmsConfig;
import cn.javaer.aliyun.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsTemplateFactory {
    @Autowired
    SmsConfig smsConfig;
    @Bean
    public SmsTemplate smsTemplate(){
        System.out.println(smsConfig.getSignName());
        System.out.println(smsConfig.getTemplateCode());
        SmsTemplate smsTemplate = SmsTemplate.builder()
                .signName(smsConfig.getSignName())
                .templateCode(smsConfig.getTemplateCode())
                .build();
        return smsTemplate;
    }
}
