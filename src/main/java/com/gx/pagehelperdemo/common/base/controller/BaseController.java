package com.gx.pagehelperdemo.common.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

/**
 * 通用Controller
 */
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    /**
     * 获取response
     */
    public HttpServletResponse getResponse(){
        return response;
    }

    /**
     * 获取request
     */
    public HttpServletRequest getRequest(){
        return request;
    }

    /**
     * 获取session
     */
    public HttpSession getSession(){
        return request.getSession();
    }

    /**
     * 获取session值方法
     * @param key
     */
    public void getSession(String key){
        getSession().getAttribute(key);
    }

    /**
     * 设置session值方法
     * @param key
     * @param object
     */
    public void setSession(String key, Object object){
        getSession().setAttribute(key, object);
    }

    /**
     * 设置attribute方法
     * @param key
     * @param object
     */
    public void setAttribute(String key, Object object){
        request.setAttribute(key, object);
    }

    /**
     * 获取attribute方法
     * @param key
     */
    public Object getAttribute(String key){
        return request.getAttribute(key);
    }

    /**
     * 获取当前BaseUrlPath
     * @return
     */
    public String getBaseUrlPath() {
        String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
        return contextPath;
    }

    /**
     * 使用OutputStream字节流向客户端浏览器输出
     * @param str
     * @throws IOException
     */
    public void write(String str) throws IOException {
        response.setHeader("content-type", "text/html;charset=UTF-8");
        OutputStream outputStream = response.getOutputStream();
        byte[] bt = str.getBytes("UTF-8");
        outputStream.write(bt);
    }

    /**
     * 使用PrintWriter字符流向客户端浏览器输出
     * @param str
     * @throws IOException
     */
    public void printWrite(String str) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 或者通过输出设置响应头控制浏览器行为
        // out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        out.write(str);
    }

    /**
     * 下载项目下的文件
     * @param filepath 文件在项目路径
     * @throws IOException
     */
    public void downloadFileByOutputStream(String filepath) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath(filepath);//获取绝对路径
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        InputStream in = new FileInputStream(realPath);
        byte[] buffer = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0, len);
        }
        in.close();
        out.close();
    }

}
