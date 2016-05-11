package com.wang.weixin.contrl;

import com.wang.weixin.service.ICoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/10.
 */
@Controller(value = "weixin")
public class WeiXinContrl {
    @Resource
    @Qualifier("coreService")
    private ICoreService coreService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String wxGet(HttpServletRequest request){
        return coreService.processRequest(request);
    }
}
