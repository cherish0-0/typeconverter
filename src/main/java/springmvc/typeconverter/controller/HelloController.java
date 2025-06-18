package springmvc.typeconverter.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); // 문자 타입 조회
        Integer intData = Integer.valueOf(data); // 문자 -> 숫자 타입 변환
        System.out.println("intData = " + intData);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        // @RequestParam을 사용하여 문자 -> 숫자 타입 변환
        System.out.println("data = " + data);
        return "ok";
    }
}