package com.wang.weixin.contrl;

import com.wang.weixin.protracted.SignInfo;
import com.wang.weixin.protracted.dao.ActivityDAO;
import com.wang.weixin.protracted.dao.UserDAO;
import com.wang.weixin.service.ICoreService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Anbang.Wang on 2016/5/10.
 */
@Controller(value = "/wx")
public class WeiXinContrl {
    private static int num = 0;

    @Resource(name = "activityDAO")
    private ActivityDAO activityDAO;

    @Resource(name = "userDAO")
    private UserDAO userDAO;

    @Resource(name = "coreService")
//    @Autowired
//    @Qualifier(value = "coreService")
    private ICoreService coreService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String wxGet(HttpServletRequest request) {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        if (!(StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce) || StringUtils.isEmpty(echostr))){
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (SignInfo.checkSignature(signature, timestamp, nonce)) {
                return echostr;
            }
        }
        return "Error";
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String sxPost(HttpServletRequest request) {
        return coreService.processRequest(request);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView hashCode(@RequestParam(required=false, name = "uid") @Nonnull String uid) {
        ModelAndView model = new ModelAndView();
        model.addObject("num", num++);
        model.addObject("uid", uid);

        model.setViewName("userShow");
        return model;
    }

}
