package ali.sendsms.service.impl;


import ali.sendsms.service.ISendSms;
import cn.javaer.aliyun.sms.SmsClient;
import cn.javaer.aliyun.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class SendSmsImpl implements ISendSms {

    private final String PhoneNumredisKey="phoneNum";

    @Autowired
    SmsClient smsClient;
    @Autowired
    SmsTemplate smsTemplate;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void sendSms(List<String> phoneNumbers) {

        Map<String,String> param=new HashMap<>();
        smsTemplate.setPhoneNumbers(phoneNumbers);
        //获得验证码
        String code = addRedis(phoneNumbers.get(0));

        //发送验证码短信
        param.put("code",code);
        smsTemplate.setTemplateParam(param);
        smsClient.send(smsTemplate);
    }
    private String addRedis(String phoneNum){
        String code=String.valueOf((int)(Math.random()*(9999-1000+1)+1000));
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        Boolean check = opsForValue.setIfAbsent(phoneNum, code, 5, TimeUnit.MINUTES);

        if(!check){
            opsForValue.get(phoneNum);
        }
        return code;
    }
}
