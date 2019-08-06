package io.hz.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WX_mainController {

    @GetMapping("/Wx_Login")
    public String index(){
        return "modules/pro/wxlogin";
    }
}
