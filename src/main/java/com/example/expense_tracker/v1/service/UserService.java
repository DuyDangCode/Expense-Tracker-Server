package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.dto.CreateUserDto;
import com.example.expense_tracker.v1.dto.SignInUserDto;
import com.example.expense_tracker.v1.model.UserModel;
import com.example.expense_tracker.v1.repo.UserRepo;
import com.example.expense_tracker.v1.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    public UserModel getUserById(long id) {
        Optional<UserModel> foundUser = userRepo.findById(id);
        if (foundUser.isEmpty()) {
            return null;
        }
        return foundUser.get();
    }

    public UserModel signUp(CreateUserDto userInfo) throws Exception {
        String hashPassword = passwordEncoder.encode(userInfo.getPassword());

        UserModel newUser = UserModel.builder()
                .email(userInfo.getEmail())
                .name(userInfo.getEmail().split("@")[0])
                .password(hashPassword)
                .build();
        userRepo.save(newUser);
        System.out.println();
        System.out.println("newUser" + newUser);
        System.out.println();
        return newUser;
    }

    @Override
    public String signIn(SignInUserDto userInfo) throws Exception {
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(userInfo.getEmail(), userInfo.getPassword());
        authenticationManager.authenticate(authentication);

        Optional<UserModel> foundUser = userRepo.findByEmail(userInfo.getEmail());
        if (foundUser.isEmpty())
            throw new UsernameNotFoundException("Not found user");
        //TODO: erros in below code
        String token = jwtUtil.generateToken(foundUser.get());
        return token;
    }

    @Override
    public String refreshToken(String token) throws Exception {
        return null;
    }


}
