package io.hz.modules.mis.controller;

import io.hz.modules.mis.service.MisNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MisNoteService misNoteService;

    @RequestMapping("misnote/del")
    public String del(@RequestParam("id") Integer id){
        misNoteService.deleteById(id);
        return "modules/pro/shoucang";
    }
}
