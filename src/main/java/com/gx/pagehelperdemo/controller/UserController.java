package com.gx.pagehelperdemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.pagehelperdemo.common.ApiResponse;
import com.gx.pagehelperdemo.common.base.controller.BaseController;
import com.gx.pagehelperdemo.common.exception.CustomerException;
import com.gx.pagehelperdemo.entity.UserInfo;
import com.gx.pagehelperdemo.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Controller
@RequestMapping("/user")  //继承BaseController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 处理局部异常
     */
    @ExceptionHandler(CustomerException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleCustomerException(Exception e, Model model){
        model.addAttribute("ex", e);
        return "/error/sys_error";
    }

    //返回状态码
    @RequestMapping("testApiSuccess")
    @ResponseBody
    public ApiResponse testApiSuccess(){
        return ApiResponse.ofSuccess("成功");
    }

    /**
     * 返回状态码例子
     * @return
     */
    @RequestMapping("testApiMessage")
    @ResponseBody
    public ApiResponse testApiMessage(){
        return ApiResponse.ofMessage(10001, "余额不足");
    }

    //抛出业务异常
    @RequestMapping("testBaseException")
    public void testBaseException(){
        userService.testBaseException();
    }

    @RequestMapping("test1")
    @ResponseBody
    public ApiResponse test1(int pageNum, int pageSize){
        //分页插件开启
        PageHelper.startPage(pageNum , pageSize);
        List<UserInfo> tests = userService.findAll(); //自定义查询方法，必须跟在PageHelper.startPage(x,x)后面
        //得到分页的结果对象
        PageInfo<UserInfo> personPageInfo = new PageInfo<>(tests);
        //得到分页中的条目对象
        long size = personPageInfo.getTotal();
        List<UserInfo> pageList = personPageInfo.getList();
        return ApiResponse.ofSuccess(size, pageList);
    }

    @RequestMapping("findUsers")
    @ResponseBody
    public Object findUsers() {
        //自定义条件查询--更多条件criteria.xxx预览
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("userAccount", "%zj%"); //模糊查询
        //分页插件开启
        PageHelper.startPage(1 , 3);
        List<UserInfo> users = userService.findByExample(example);
        //得到分页的结果对象
        PageInfo<UserInfo> personPageInfo = new PageInfo<>(users);
        //得到分页中的条目对象
        List<UserInfo> pageList = personPageInfo.getList();
        return pageList; //返回分页数据
    }

    //模糊 + 分页
    @RequestMapping("findListByExampleAndRowBounds")
    @ResponseBody
    public Object findListByExampleAndRowBounds(Integer page, Integer limit, String blur) {
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        int begin = (page - 1) * limit;
        //自定义条件分页查询
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //模糊查询
        criteria.andLike("userPassword", "%"+blur+"%");
        // RowBounds使用mysql的limit分页
        RowBounds rowBounds = new RowBounds(begin, limit); // offset起始行
        List<UserInfo> users = userService.findListByExampleAndRowBounds(example, rowBounds);
        return users;
    }

    @RequestMapping("findModelById")
    @ResponseBody
    public Object findModelById(int id) {
        //主键查询
        UserInfo userInfo = userService.findModelById(id);
        return userInfo;
    }

    @RequestMapping("findListByModel")
    @ResponseBody
    public Object findListByModel(UserInfo userInfo) {
        // 实体条件查询
        List<UserInfo> list = userService.findListByModel(userInfo);
        return list;
    }

    @RequestMapping("findAll")
    @ResponseBody
    public Object findAll() {
        // 查询全部
        List<UserInfo> userInfos = userService.findAll();
        return userInfos;
    }

    @RequestMapping("insertModel")
    @ResponseBody
    public Object insertModel(UserInfo userInfo) {
        // 新增一行
        int result = userService.insertModel(userInfo);
        return result;
    }

    @RequestMapping("insertModelList")
    @ResponseBody
    public Object insertModelList(List<UserInfo> userInfos) {
        // 新增多行---前端传递List<UserInfo>对应的json
        int result = userService.insertModelList(userInfos);
        return result;
    }

    @RequestMapping("updateModel")
    @ResponseBody
    public Object updateModel(UserInfo userInfo) {
        // 修改一行
        int result = userService.updateModel(userInfo);
        return result;
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public Object deleteById(int id) {
        // 删除一行
        int result = userService.deleteById(id);
        return result;
    }

    @RequestMapping("deleteByModel")
    @ResponseBody
    public Object deleteByModel(UserInfo userInfo) {
        // 删除一行
        int result = userService.deleteByModel(userInfo);
        return result;
    }

    @RequestMapping("deleteByIdList")
    @ResponseBody
    public Object deleteByIdList(List<Integer> idlist) {
        // 删除多行
        int result = userService.deleteByIdList(idlist);
        return result;
    }

}
