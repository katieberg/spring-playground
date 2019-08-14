package com.galvanize.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class PlaygroundApplication {
	@RestController
	@RequestMapping("/math")
	public class MyController {
		@PostMapping("/sum")
		public String doSum( @RequestParam MultiValueMap<String, String> queryString){
			int sum=0;
//			for (Object entry : queryMap.entrySet()) {
//				sum = sum + Integer.parseInt(entry.);
//			}
			List<String> list1 = queryString.get("n");
			for(String str : list1){

				String current = ""+str;
				sum = sum+Integer.parseInt(current);
			}
			return "" + sum;
		}
		@GetMapping("/calculate")
		public String doMath(@RequestParam String operation, @RequestParam String x, @RequestParam String y ) {
			int xValue = Integer.parseInt(x);
			int yValue = Integer.parseInt(y);
			int toReturn;
			switch(operation){
				case "add":
					toReturn=xValue+yValue;
					return String.format("%s + %s = %s",xValue, yValue, toReturn);
				case "subtract":
					toReturn = xValue-yValue;
					return String.format("%s - %s = %s",xValue, yValue, toReturn);
				case "multiply":
					toReturn = xValue*yValue;
					return String.format("%s * %s = %s",xValue, yValue, toReturn);
				case "divide":
					if(yValue==0){
						return "ERROR - DIVIDE BY 0";
					}
					toReturn = xValue/yValue;
					return String.format("%s / %s = %s", xValue, yValue, toReturn);

			}
			return "invalid operator";

		}
		@GetMapping("/pi")
		public String MyPi(){
			return "3.141592653589793";
		}


	}




	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

}

