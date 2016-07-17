package com.gycsi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gycsi.domain.Gary;
import com.gycsi.pojo.User;
import com.gycsi.service.GaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qian-pc on 7/12/16.
 */
@Controller
public class GaryController {
    @Autowired
    GaryService garyService;

    @RequestMapping("/gary")
    public String garyCX(Model model){
        User user = new User();
        user.setName("姓名");
        user.setAge(12);

        model.addAttribute("title","测试信息检索");
        model.addAttribute("user",user);

        return "gary";
    }

    @RequestMapping("/gary/{sfzh}")
    public String getInfo(@PathVariable("sfzh") String sfzh,Model model){
        List<Gary> garyList = (List<Gary>) garyService.getGaryByHid(sfzh);
        model.addAttribute("gary",garyList);
        return "gary-result";
    }

    @RequestMapping("/gary-cx/{sfzh}")
    @ResponseBody
    public String getInfoCx(@PathVariable("sfzh") String sfzh,Model model) throws JsonProcessingException {
        List<Gary> garyList = (List<Gary>) garyService.getGaryByHid(sfzh);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(garyList);
        return json;
    }
}
