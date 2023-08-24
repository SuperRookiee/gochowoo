package kr.co.chunjae.gochowoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GochowooApplication {

    public static void main(String[] args) {
        SpringApplication.run(GochowooApplication.class, args);
    }

    @GetMapping("/")
    public String index(Model model){
        return "/index";
    }
}
