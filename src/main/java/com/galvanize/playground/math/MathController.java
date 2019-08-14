package com.galvanize.playground.math;

import org.springframework.util.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/math")
public class MathController {
    @PostMapping("/sum")
    public String doSum( @RequestParam MultiValueMap<String, String> queryString){
        MathService sumDoer = new MathService(queryString);
        return sumDoer.doSum();
    }
    @GetMapping("/calculate")
    public String doMath(@RequestParam(value = "operation", defaultValue = "add") String operation, @RequestParam String x, @RequestParam String y ) {
        MathService operationDoer = new MathService(operation, x, y);
        return operationDoer.doOperation();
    }
    @GetMapping("/pi")
    public String MyPi(){
        return "3.141592653589793";
    }


}

