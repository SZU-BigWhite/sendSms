package ali.sendsms.controller;

import ali.sendsms.service.impl.SendSmsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SendSmsController {

    @Autowired
    SendSmsImpl sendSms;
    @GetMapping("/sendSms")
    @ResponseBody
    public String snedSms(@RequestParam(required = true,value="phoneNum") String phoneNum){
        List<String> pn=new ArrayList<>();
        pn.add(phoneNum);
        sendSms.sendSms(pn);
        return "success";
    }

}
