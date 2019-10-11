package com.example.hacking.demo.controller;

import com.example.hacking.common.utils.StringUtils;
import com.example.hacking.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 连接测试 控制器层
 *
 * @author jintingying
 * Created on 2019/10/11
 * @version 1.0
 */
@Slf4j // in lombok
@RestController
public class connectTestController {


    @GetMapping(value = "/conn")
    public String connTest(@RequestParam(required = false) String email,
                    @RequestParam String name,
                    @RequestParam(required = false) String phone){

        log.info("email: " + email + "/n phone: " + phone);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Info:\n");
//        if(StringUtils.isNotEy(email))
        stringBuilder.append("email is " + (StringUtils.isEmail(email)?"current ":"error ") + "format!\n");
        stringBuilder.append("phone is " + (StringUtils.isPhone(phone)?"current ":"error ") + "format!\n");
        return stringBuilder.toString();
    }

    @GetMapping(value = "/time")
    public String timeTime(@RequestParam String timeStr, @RequestParam String fmt){
        if(!StringUtils.isNotEy(timeStr))
            return "error";
        Date date = DateUtils.stringToDate(timeStr, fmt);
        log.info("timeStr : " + timeStr );
        log.info("date : " + date );

        log.info( DateUtils.simpleDateFormat_YDM_HMS.toPattern() );
        return DateUtils.dateToString(date, DateUtils.simpleDateFormat_YDM_HMS.toPattern());
    }
}
