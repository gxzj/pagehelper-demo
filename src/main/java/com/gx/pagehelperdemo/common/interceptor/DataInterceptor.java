package com.gx.pagehelperdemo.common.interceptor;

import com.gx.pagehelperdemo.common.util.CharacterFilterUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * 自定义数据校验拦截器，过滤非法字符、生成日记等等
 */
public class DataInterceptor implements HandlerInterceptor {

    public String[] excludes = {"",""}; //排除数组

    //进入拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        return true;
    }

    //视图渲染出来之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
        //日记
        //排除不需要处理的，可以通过url/key排除
        Set<Map.Entry<String, Object>> entries = modelAndView.getModel().entrySet();
        boolean isWithSpecialSymbol = false;
        for (Map.Entry<String, Object> map:entries) {
            String key = map.getKey(); //可以通过key排除不需要过滤
            String value = map.getValue().toString();
            isWithSpecialSymbol = CharacterFilterUtil.specialSymbols(value); //判断非法参数
        }
        if(!isWithSpecialSymbol){
            modelAndView.addObject("data", "ok");
        }else{
            modelAndView.addObject("data", "非法参数");
        }
    }

    //完成校验后，清理资源，处理异常，释放缓存数据
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }

}
