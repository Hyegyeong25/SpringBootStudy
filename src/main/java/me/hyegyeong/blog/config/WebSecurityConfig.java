//package me.hyegyeong.blog.config;
//
//import lombok.RequiredArgsConstructor;
//import me.hyegyeong.blog.service.UserDetailService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//@RequiredArgsConstructor
//@Configuration
//public class WebSecurityConfig {
//    private final UserDetailService userService;
//
//    //1. 스프링 시큐리티 기능 비활성화 : 정적 리소스만 시큐리티 사용 비활성화.
//    // H2-console 하위 url과 static 아래 경로에 있는 리소스 대상으로 ignoring() 한다.
//    @Bean
//    public WebSecurityCustomizer configure(){
//        return (web) -> web.ignoring()
//                .requestMatchers(toH2Console()) // 특정 요청과 일치하는 url에 대한 액세스 설정
//                .requestMatchers("/static/**");
//    }
//
//    //2. 특정 HTTP 요청에 대한 웹 기반 보안 구성
//    // permitAll() : 누구나 접근 가능
//    // anyRequest() : 위에서 설정한 url 이외의 요청에 대해서 설정
//    // authenticated() : 인증 성공 상태에서만 접근 가능
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        return http
//                .authorizeRequests() //3. 인증, 인가 설정
//                .requestMatchers("/login", "/signup", "/user").permitAll() //로그인 회원가입 유저는 모두가 접근 가능한 페이지라고 설정해둠
//                .anyRequest().authenticated() //누구나 요청할 수 있음 단 인증을 해야함
//                .and()
//                .formLogin() //4. 폼 기반 로그인 설정
//                .loginPage("/login") // 로그인 페이지 경로 설정
//                .defaultSuccessUrl("/articles") // 로그인 완료 시 이동 경로
//                .and()
//                .logout() //5. 로그아웃설정
//                .logoutSuccessUrl("/login") //로그아웃 성공 시 이동 페이지
//                .invalidateHttpSession(true) // 로그아웃 이후 세션 삭제
//                .and()
//                .csrf().disable() //6. *csrf(Cross-site request forgery) 비활성화
//                .build();
//    }
//    /*
//    * *csrf 공격이란? 사용자가 자신의 의지와 무관하게 공격자가 의도한 행동을 하여
//    * 웹페이지 보안을 취약하게 만들거나 수정, 삭제 등의 작업을 하게 만드는 공격 방법
//    * */
//
//    //7. 인증 관리자 설정 : 사용자 정보를 가져올 서비스 재정의, 인증 방법(LDAP, JDBC) 기반 인증 설정 시 사용
//    @Bean
//    public AuthenticationManager authenticationManager(
//            HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
//            UserDetailService userDetailService) throws Exception{
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                //8. 사용자 정보 서비스 설정. 사용자 정보를 가져올 서비스 설정.
//                // 이때 설정하는 서비스 클래스는 반드시 UserDetailsService 상속 받은 클래스여야 함
//                .userDetailsService(userService)
//                .passwordEncoder(bCryptPasswordEncoder) // 비밀번호를 암호화하기 위한 인코더를 설정
//                .and()
//                .build();
//    }
//
//    //9. 패스워드 인코더로 사용할 빈 등록 (빈 = 객체)
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
