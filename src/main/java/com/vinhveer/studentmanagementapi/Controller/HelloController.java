package com.vinhveer.studentmanagementapi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping("")
    public String test()
    {
        return "index";
    }
}
