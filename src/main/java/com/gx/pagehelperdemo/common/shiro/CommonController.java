package com.gx.pagehelperdemo.common.shiro;

import com.gx.pagehelperdemo.common.base.controller.BaseController;
import com.gx.pagehelperdemo.entity.UserInfo;
import com.gx.pagehelperdemo.service.UserService;
import javafx.geometry.Pos;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.util.StringUtil;

/**
 * 通用控制器
 * @author zj
 */
@Controller
public class CommonController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String userAccount, String userPassword, ModelAndView model) throws Exception {
        getRequest().setCharacterEncoding("UTF-8");
        getResponse().setContentType("text/html;charset=UTF-8");
        String url = "redirect:/go";
        if(StringUtil.isEmpty(userAccount) || StringUtil.isEmpty(userPassword)){
            model.addObject("msg", "用户名和密码不能为空!");
            return url;
        }
        // shiro登录验证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userAccount, userPassword);
        try {
            subject.login(token);
            url = "redirect:/home";
            model.addObject("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            model.addObject("msg", "密码错误");
        } catch (LockedAccountException e) {
            model.addObject("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            model.addObject("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        getSession().setAttribute("msg", "sss");
        return url;
    }

    /**
     * 登录页面
     */
    @RequestMapping("go")
    public String go(){
        return "login";
    }

    /**
     * 登出
     */
    @RequestMapping("logout")
    public String logout(){
        return "login";
    }

    /**
     * 登录成功页面
     */
    @RequestMapping("home")
    public String index(){
        return "index";
    }

    /**
     * 没有权限页面
     */
    @RequestMapping("noPermission")
    public String noPermission(){
        return "/error/403";
    }

    /**
     * 服务器错误页面
     */
    @RequestMapping("serviceError")
    public String serviceError(){
        return "/error/500";
    }

    /**
     * 查看密码加密后的值
     * @param args
     */
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "123";//密码原值
        Object salt = "123";//盐值
        int hashIterations = 2;//加密2次
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        System.out.println(result);
    }

}
