package com.example.hacking.modules.demo.controller;

import com.example.hacking.common.annotation.SetValue;
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

    @SetValue(value = "project.version")
    private String version;

    public String getVersion() {
        return version;
    }

    @GetMapping(value = "/retVersion")
    public String retVersion(){
        log.info(version);
        return version;
    }

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


    /**
     *
     *
     * @param: timeStr
     * @param: fmt
     * @return java.lang.String
     */
    @GetMapping(value = "/time")
    public String timeTime(@RequestParam String timeStr, @RequestParam String fmt){
        if(!StringUtils.isNotEyAndSp(timeStr))
            return "无效参数：未输入 | 为空 | 全为空格";

        Date date = DateUtils.convert(timeStr);
        String str = date.toString();
        log.info(str);
        return DateUtils.dateToString(date, "yyyy-MM-dd hh:mm:ss");
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
