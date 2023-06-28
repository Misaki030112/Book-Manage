package com.book.controller;

import com.book.domain.Admin;
import com.book.domain.ReaderCard;
import com.book.domain.ReaderInfo;
import com.book.service.LoginService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

//标注为一个Spring mvc的Controller
@Controller
public class LoginController {

    private LoginService loginService;


    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


    @Autowired
    private Producer kaptchaProducer;
    
    //负责处理login.html请求
    @RequestMapping(value = {"/","/login.html"})
    public String toLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }
    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.html";
    }


    //负责处理loginCheck.html请求
    //请求参数会根据参数名称默认契约自动绑定到相应方法的入参中
    @RequestMapping(value = "/api/loginCheck", method = RequestMethod.POST)
    public @ResponseBody Object loginCheck(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        String passwd = request.getParameter("passwd");
                boolean isReader = loginService.hasMatchReader(id, passwd);
                boolean isAdmin = loginService.hasMatchAdmin(id, passwd);
        HashMap<String, String> res = new HashMap<String, String>();
                if (isAdmin==false&&isReader==false) {
                    res.put("stateCode", "0");
                    res.put("msg","账号或密码错误！");
                } else if(isAdmin){
                    Admin admin=new Admin();
                    admin.setAdminId(id);
                    admin.setPassword(passwd);
                    request.getSession().setAttribute("admin",admin);
                    res.put("stateCode", "1");
                    res.put("msg","管理员登陆成功！");
                }else {
                    ReaderCard readerCard = loginService.findReaderCardByUserId(id);
                    request.getSession().setAttribute("readercard", readerCard);
                    res.put("stateCode", "2");
                    res.put("msg","读者登陆成功！");
                }
        return res;
    };
    @RequestMapping("/admin_main.html")
    public ModelAndView toAdminMain(HttpServletResponse response) {

            return new ModelAndView("admin_main");
    }


    @RequestMapping("/reader_main.html")
    public ModelAndView toReaderMain(HttpServletResponse response) {

        return new ModelAndView("reader_main");
    }



    @RequestMapping("/admin_repasswd.html")
    public ModelAndView reAdminPasswd() {

        return new ModelAndView("admin_repasswd");
    }

    @RequestMapping("/admin_repasswd_do")
    public String reAdminPasswdDo(HttpServletRequest request,String oldPasswd,String newPasswd,String reNewPasswd,RedirectAttributes redirectAttributes ) {

        Admin admin=(Admin) request.getSession().getAttribute("admin");
        int id=admin.getAdminId();
        String passwd=loginService.getAdminPasswd(id);

        if(passwd.equals(oldPasswd)){
            boolean succ=loginService.adminRePasswd(id,newPasswd);
            if (succ){

                redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
                return "redirect:/admin_repasswd.html";
            }
            else {
                redirectAttributes.addFlashAttribute("error", "密码修改失败！");
                return "redirect:/admin_repasswd.html";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "旧密码错误！");
            return "redirect:/admin_repasswd.html";
        }
    };

    //配置404页面
     @RequestMapping("*")
     public String notFind(){
     return "404";
       }

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;
       
    @RequestMapping(value = "/kaptcha.jpg",  method = RequestMethod.GET)
    public ModelAndView  getCaptchaImage(@RequestParam(value =  "timeStamp", required = false) String timeStamp,
                                         HttpServletRequest request,  HttpServletResponse response) throws IOException {

        ModelAndView mav = new ModelAndView();
        //以下来自于com.google.code.kaptcha.servlet.KaptchaServlet
        response.setDateHeader("Expires", 0L);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码 key
        String key = "captcha_codes_"+ String.valueOf(10000) +System.currentTimeMillis();
        //生成验证码
        String capText = captchaProducerMath.createText();

//        String capText = this.kaptchaProducer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        if (timeStamp != null) {
            System.out.println("触发点击事件");
            request.getSession().setAttribute(Constants.KAPTCHA_SESSION_DATE, timeStamp); //将原有的常量对应的值变成现在的时间戳值
        }
        BufferedImage bi = this.kaptchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);

        return null;
    }

}