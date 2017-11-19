package com.daejong.vip.web.handler;

import com.daejong.common.JsonResult;
import com.daejong.vip.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DaeJong on 2017/4/20.
 */

@Controller
@RequestMapping("/json")
public class TestJsonHandler {

    //post请求, 这里会自动对请求的json数据进行封装
    @RequestMapping(value = "/postList.do", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult postUserList(@RequestBody List<UserEntity> list) {
        System.out.println(list);
        JsonResult<List> jsonResult = new JsonResult(list, "success");
        return jsonResult;
    }

    //post请求, 获取请求体中的参数{"id":100}
    @RequestMapping(value = "/testPost.do", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult testPost(@RequestBody Map<String, String> map) {
        System.out.println(map.get("id"));
        UserEntity userEntity = new UserEntity();
        userEntity.setId(map.get("id"));
        userEntity.setAccount("中国");
        userEntity.setName("大钟");
        userEntity.setPassword("123");
        JsonResult jsonResult = new JsonResult(userEntity, "success");
        return jsonResult;
    }

    //get请求, 这里会将请求参数进行封装
    @RequestMapping(value = "/testRequestParam.do",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult testRequestParam(UserEntity userEntity) throws UnsupportedEncodingException {
        System.out.println(new String(userEntity.getName().getBytes("iso8859-1"), "utf-8"));
        System.out.println(userEntity);
        JsonResult jsonResult = new JsonResult(userEntity, "success");
        return jsonResult;
    }

    //get和post都可以获取数据
    @RequestMapping(value = "/testGet.do/{id}")
    @ResponseBody
    public JsonResult testGet(@PathVariable("id") String id) {
        List<UserEntity> list = new ArrayList<>();
        UserEntity userEntity = null;
        for (int i = 0; i < 10; i++) {
            userEntity = new UserEntity();
            userEntity.setId(i + "100");
            userEntity.setAccount("大钟-" + id);
            userEntity.setPassword("1234-" + i);
            userEntity.setName("中国-" + i);
            list.add(userEntity);
        }
        JsonResult jsonResult = new JsonResult(list, "success");
        return jsonResult;
    }
}
