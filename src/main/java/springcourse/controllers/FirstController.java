package springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String hello(){
        return "firset/hello";
    }
    @GetMapping("/goodbye")
    public String goodbye(){
        return "firset/goodbye";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("method") String method, Model model){
        double result ;
        switch (method){
            case "multi":
                result = a * b ;
                break;
            case "sub":
                result = a - b;
                break;
            case "div":
                result = a / (double) b;
                break;
            case "add":
                result = a + b;
                break;
            default:
                result = 0;
        }

        model.addAttribute("result", result);

        return "firset/calculate";

    }
}
