package ali.sendsms.service;

import java.util.List;

public interface ISendSms {
    public void sendSms(List<String> phoneNumbers);
}
