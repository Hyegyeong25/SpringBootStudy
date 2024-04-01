package me.hyegyeong.blog.service;

import lombok.RequiredArgsConstructor;
import me.hyegyeong.blog.domain.User;
import me.hyegyeong.blog.dto.AddUserRequest;
import me.hyegyeong.blog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final 선언된 또는 @NotNull인 어노테이션의 생성자 주입
@Service //서비스임을 나타냄
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화 : 패스워드 저장 시 시큐리티 설정하며 encode()를 사용하여 등록한 빈을 이용해 암호화 후 저장
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

}
