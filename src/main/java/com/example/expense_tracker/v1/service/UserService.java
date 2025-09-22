package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.core.AuthFailException;
import com.example.expense_tracker.v1.core.UserAlreadyExistsException;
import com.example.expense_tracker.v1.core.UserNotFoundException;
import com.example.expense_tracker.v1.dto.CreateUserDto;
import com.example.expense_tracker.v1.dto.SignInUserDto;
import com.example.expense_tracker.v1.dto.TokensPairDto;
import com.example.expense_tracker.v1.model.UserModel;
import com.example.expense_tracker.v1.repo.UserRepo;
import com.example.expense_tracker.v1.util.JwtUtil;
import io.jsonwebtoken.Claims;
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
            throw new UserNotFoundException();
        }
        return foundUser.get();
    }

    public UserModel signUp(CreateUserDto userInfo) throws Exception {
        String hashPassword = passwordEncoder.encode(userInfo.password());
        Optional<UserModel> foundUser = userRepo.findByEmail(userInfo.email());
        if (foundUser.isPresent())
            throw new UserAlreadyExistsException();
        UserModel newUser = UserModel.builder()
                .email(userInfo.email())
                .name(userInfo.email().split("@")[0])
                .password(hashPassword)
                .build();
        userRepo.save(newUser);
        return newUser;
    }

    private UserModel getUserByEmail(String email) {
        Optional<UserModel> foundUser = userRepo.findByEmail(email);
        if (foundUser.isEmpty())
            throw new UserNotFoundException();
        return foundUser.get();
    }

    @Override
    public TokensPairDto signIn(SignInUserDto userInfo) throws Exception {
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(userInfo.email(), userInfo.password());
        authenticationManager.authenticate(authentication);
        UserModel foundUser = getUserByEmail(userInfo.email());
        //TODO: erros in below code
        String accessToken = jwtUtil.generateAccessToken(foundUser);
        String refreshToken = jwtUtil.generateRefreskToken(foundUser);
        return new TokensPairDto(accessToken, refreshToken);
    }

    @Override
    public TokensPairDto refreshToken(String token) {
        if (!jwtUtil.isTokenValid(token))
            throw new AuthFailException();
        String email = jwtUtil.extractClaim(token, Claims::getSubject);
        Optional<UserModel> userModel = userRepo.findByEmail(email);
        if (userModel.isEmpty()) throw new AuthFailException();
        UserModel user = userModel.get();
        String accessToken = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreskToken(user);

        return new TokensPairDto(accessToken, refreshToken);
    }


}
