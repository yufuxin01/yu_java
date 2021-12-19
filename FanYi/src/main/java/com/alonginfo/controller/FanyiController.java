package com.alonginfo.controller;

import com.alonginfo.modle.Fanyi;
import com.alonginfo.service.FanyiService;
import com.alonginfo.utils.MD5Util;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/11/30 16:17
 */
@RestController
@RequestMapping("/fanyi")
public class FanyiController {

    @Resource
    private FanyiService fanyiService;


    @GetMapping("/fan")
    public String fanyi(Fanyi fanyi, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
        ModelAndView mav = new ModelAndView();
        String sing = fanyi.getAppid()+fanyi.getQ()+fanyi.getSalt()+fanyi.getMiyao();
        System.out.println(sing);
        String m = MD5Util.to_MD5(sing);
        System.out.println("MD5"+m);
        String fan = "http://api.fanyi.baidu.com/api/trans/vip/translate?q=";
        String yi = "&from="+fanyi.getFrom()+"&to="+fanyi.getTo()+"&appid="+fanyi.getAppid()+"&salt="+fanyi.getSalt()+"&sign=";
        String x = fan+yi+m;
        String q = URLEncoder.encode(fanyi.getQ(), "UTF-8");
        String URL = String.format(fan+"%s"+yi+m,q);
        System.out.println(URL);
        response.sendRedirect(URL);
        return "redirect:"+URL;
    }


}
