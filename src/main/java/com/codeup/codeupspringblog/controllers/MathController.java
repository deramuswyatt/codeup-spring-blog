package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{x}/{y}")
    @ResponseBody
    public long add(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y) {
//        return x - y;
//        int total = (x - y);
return String.format("%d minus %d equals %d", x, y, x-y);
    }

    @GetMapping("/multiply/{x}/{y}")
    @ResponseBody
    public long multiply(@PathVariable int x, @PathVariable int y) {
        return x * y;
    }

    @GetMapping("/divide/{x}/{y}")
    @ResponseBody
    public long divide(@PathVariable int x, @PathVariable int y) {
        return x / y;
    }
}
