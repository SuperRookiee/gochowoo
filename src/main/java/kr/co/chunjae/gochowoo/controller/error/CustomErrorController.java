package kr.co.chunjae.gochowoo.controller.error;

import lombok.SneakyThrows;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
        @SneakyThrows
        @RequestMapping(value = "/error")
        public String handleError(HttpServletRequest request, Model model) {
            Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
            int statusCode = Integer.parseInt(status.toString());

            String errorMessage;
            switch (statusCode) {
                case 400:
                    errorMessage = "서버가 요청을 이해할 수 없어요";
                    break;
                case 404:
                    errorMessage = "요청한 페이지를 찾을 수 없어요";
                    break;
                case 500:
                    errorMessage = "서버가 예상치 못한 상황을 마주했어요";
                    break;
                default:
                    errorMessage = "오류가 발생했어요 ㅠ.ㅠ";
            }

            model.addAttribute("status", statusCode);
            model.addAttribute("message", errorMessage);

            return "error/error";
        }
}