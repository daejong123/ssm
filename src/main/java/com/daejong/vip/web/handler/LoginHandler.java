package com.daejong.vip.web.handler;

import com.daejong.common.ThisSystemException;
import com.daejong.vip.entity.UserEntity;
import com.daejong.vip.function.UserFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by DaeJong on 2017/4/7.
 */

@Controller
public class LoginHandler {

    @Autowired
    private UserFunction userFunction;

    @RequestMapping("/login.do")
    public java.lang.String login(java.lang.String username, String password, HttpServletRequest request) {
        try {
            UserEntity userEntity = userFunction.login(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", userEntity);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            //由于在视图解析器里配置了, 重定向时会加上上下文/WEB-INF/views/. 所以这里就转发
            return "forward:/login.jsp";
        }
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")
    public String index() {
        return "index";
    }

    @RequestMapping("/welcome.do")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/logOut.do")
    public String logOut(HttpSession session) {
        //让session失效
        session.invalidate();
        return "redirect:/login.jsp";
    }

    //get方式是获取更新视图
    @RequestMapping(value = "/updatePassword.do", method = RequestMethod.GET)
    public String updatePasswordView() {
        return "updatePassword";
    }

    //post方式是进行数据更新, 并显示视图.
    @RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
    public String updatePassword(HttpServletRequest request, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        System.out.println(oldPassword + "," + newPassword + "," + newPasswordConfirm);
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("currentUser");
        try {
            userFunction.updatePassword(userEntity.getId(), oldPassword, newPassword, newPasswordConfirm);
        } catch (ThisSystemException e) {
            request.setAttribute("message", e.getMessage());
            return "updatePassword";
        }
        session.setAttribute("message", "修改成功, 请重新登录");
        return "redirect:/login.jsp";
    }


    /**
     * 测试
     * 使用@ResponseBody来返回json数据
     * 需要导入的包 jackson-annotations, jackson-core, jackson-dataBind.
     */
    @RequestMapping(value = "/getJson.do/{name1}", method = RequestMethod.GET)
    @ResponseBody
    public Map getJson(@PathVariable("name1") String name1) {
        Map<java.lang.String, Object> json = new HashMap<>();
        json.put("params", name1);
        json.put("name", "daejongHelloworld");
        json.put("password", "123456");

        UserEntity userEntity = new UserEntity();
        userEntity.setId("2120142126");
        userEntity.setAccount("alipay");
        userEntity.setName("daejong");
        userEntity.setPassword("888888");

        List list = new ArrayList();
        list.add(userEntity);
        list.add(userEntity);
        json.put("user", list);
        return json;
    }
    /**
     * json结果如下
     *
     {
     "password": "123456",
     "name": "daejongHelloworld",
     "user": [
     {
     "id": "2120142126",
     "account": "alipay",
     "password": "888888",
     "name": "daejong"
     },
     {
     "id": "2120142126",
     "account": "alipay",
     "password": "888888",
     "name": "daejong"
     }
     ]
     }
     */
}
