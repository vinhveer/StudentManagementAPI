package com.vinhveer.studentmanagementapi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("")
    public String test()
    {
        return "index";
    }
}