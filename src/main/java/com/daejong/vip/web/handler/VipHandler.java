package com.daejong.vip.web.handler;

import com.daejong.common.ThisSystemException;
import com.daejong.vip.entity.VipEntity;
import com.daejong.vip.function.impl.VipFunctionImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DaeJong on 2017/4/12.
 */

@Controller
@RequestMapping("/vip")
public class VipHandler {

    @Autowired
    private VipFunctionImpl vipFunction;

    @RequestMapping(value = "/qry.do", method = RequestMethod.GET)
    public ModelAndView qryView(@RequestParam(required = true, defaultValue = "1") Integer page,
                                @RequestParam(required = true, defaultValue = "2") Integer pageSize,
                                ModelAndView mv) throws Exception{
        //初始化(进入页面)的时候, 查询全部的结果.
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", "");
        //使用分页插件-pageHelper, 进行分页查询, 必须写在select查询前面.
        PageHelper.startPage(page, pageSize);
        List<VipEntity> list = vipFunction.selectLike(map);
        System.out.println(list.size());
        PageInfo<VipEntity> p = new PageInfo<>(list);
        mv.setViewName("vip/qry");
        mv.addObject("vipList", list);
        mv.addObject("page", p);
        return mv;
    }

    @RequestMapping(value = "/qry.do", method = RequestMethod.POST)
    public String qry(String key, HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
//        key = new String(key.getBytes("iso8859-1"), "utf-8");
        request.setAttribute("daejong", key);
        map.put("key", key);
        List<VipEntity> list = vipFunction.selectLike(map);
        request.setAttribute("vipList", list);
        return "vip/qry";
    }


    //测试查询的是单条数据
    @RequestMapping(value = "/qryOne.do")
    @ResponseBody
    public VipEntity qryOne(String key, HttpServletRequest request) throws Exception {
        VipEntity vipEntity = null;
        try {
            vipEntity = vipFunction.selectById(key);
            System.out.println(vipEntity);
        } catch (ThisSystemException e) {
            e.printStackTrace();
        }
        return vipEntity;
    }
}
