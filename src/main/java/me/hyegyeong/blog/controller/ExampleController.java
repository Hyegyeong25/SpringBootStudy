package me.hyegyeong.blog.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller // 컨트롤러라는 것을 명시적으로 표시해준다.
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model){ // 뷰로 데이터를 넘겨주는 모델
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("홍길동");
        examplePerson.setAge("11");
        examplePerson.setHobbies(List.of("운동", "독서"));

        model.addAttribute("person", examplePerson); // addAttribute() 메서드로 모델에 Person 객체 저장
        model.addAttribute("today", LocalDate.now());

        return "example"; //example.html라는 뷰 조회
    }

    @Getter
    @Setter
    class Person{
        private Long id;
        private String name;
        private String age;
        private List<String> hobbies;
    }

}
