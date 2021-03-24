package mobile.common.service.impl;

import mobile.common.service.CommonService;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
    public String saveLog(String msg) {
        return msg;
    }
}
