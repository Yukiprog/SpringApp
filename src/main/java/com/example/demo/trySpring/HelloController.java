package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//ポイント①：@Contolloer
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
    //ポイント②：@GetMapping
    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    //ポイント①：@PostMapping
    //ポイント②：@RequestParam
    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str,Model model) {
        //ポイント③：model.addAttribute
        //画面から受け取った文字列をModelに変換
        model.addAttribute("sample",str);
        //helloResponse.htmlに画面遷移
        return "helloResponse";
    }

    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2")String str,Model model) {
        //String型からint型に変更
        int id=Integer.parseInt(str);

        //1件検索
        Employee employee = helloService.findOne(id);

        //検索結果をModelに格納
        model.addAttribute("id",employee.getEmployeeId());
        model.addAttribute("name",employee.getEmployeeName());
        model.addAttribute("age",employee.getAge());

        //helloResponseDB.htmlに画面遷移
        return "helloResponseDB";
    }
}
