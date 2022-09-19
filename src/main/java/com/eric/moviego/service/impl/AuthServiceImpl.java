package com.eric.moviego.service.impl;

import com.eric.moviego.advice.exceptions.EmailDuplicatedException;
import com.eric.moviego.advice.exceptions.NameDuplicatedException;
import com.eric.moviego.advice.exceptions.RoleNotSetException;
import com.eric.moviego.common.CommonResult;
import com.eric.moviego.common.SingleResult;
import com.eric.moviego.config.jwt.JwtTokenProvider;
import com.eric.moviego.dto.SignInRequestDTO;
import com.eric.moviego.dto.SignUpRequestDTO;
import com.eric.moviego.model.member.Member;
import com.eric.moviego.model.role.Role;
import com.eric.moviego.model.role.RoleName;
import com.eric.moviego.repository.MemberRepository;
import com.eric.moviego.repository.RoleRepository;
import com.eric.moviego.service.AuthService;
import com.eric.moviego.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final ResponseService responseService;
    private final AuthenticationManager authenticationManager;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public SingleResult<String> signIn(SignInRequestDTO signInRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequestDTO.getUsernameOrEmail(), signInRequestDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return responseService.getSingleResult(jwt);
    }

    @Override
    public CommonResult signUp(SignUpRequestDTO signUpRequestDTO) {
        if (Boolean.TRUE.equals(memberRepository.existsByUsername(signUpRequestDTO.getUsername()))) {
            throw new NameDuplicatedException();
        }

        if (Boolean.TRUE.equals(memberRepository.existsByEmail(signUpRequestDTO.getEmail()))) {
            throw new EmailDuplicatedException();
        }
        String username = signUpRequestDTO.getUsername().toLowerCase();

        String email = signUpRequestDTO.getEmail().toLowerCase();

        String password = passwordEncoder.encode(signUpRequestDTO.getPassword());

//        Set<Role> roles = new HashSet<>();
//
//        if (memberRepository.count() == 0) {
//            roles.add(roleRepository.findByName(RoleName.ROLE_USER)
//                    .orElseThrow(RoleNotSetException::new));
//            roles.add(roleRepository.findByName(RoleName.ROLE_ADMIN)
//                    .orElseThrow(RoleNotSetException::new));
//        } else {
//            roles.add(roleRepository.findByName(RoleName.ROLE_USER)
//                    .orElseThrow(RoleNotSetException::new));
//        }

        List<Role> roles = Collections.singletonList(roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(RoleNotSetException::new));
        //Member member = Member.builder().username(username).email(email).password(password).roles(roles).build();
        Member member = new Member(username,email,password,roles,true);

        memberRepository.save(member);

        return responseService.getSuccessResult();
    }

}
