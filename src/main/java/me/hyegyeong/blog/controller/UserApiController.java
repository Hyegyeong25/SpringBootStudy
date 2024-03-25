package me.hyegyeong.blog.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.hyegyeong.blog.dto.AddUserRequest;
import me.hyegyeong.blog.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request); // 회원 가입 메서드 호출
        //회원가입이 완료된 이후에 로그인 페이지로 이동
        return "redirect:/login"; // 회원 가입 처리가 된 다음 이동하기 위해 redirect:접두사 사용
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        // 로그아웃 GET 요청 시 로그아웃을 담당하는 SecurityContextLogoutHandler의 logout() 메서드를 호출
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:login";
    }

}
