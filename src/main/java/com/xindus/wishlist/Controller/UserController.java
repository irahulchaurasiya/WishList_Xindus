package com.xindus.wishlist.Controller;
import com.xindus.wishlist.Models.Dto.Login;
import com.xindus.wishlist.Models.Dto.SignUp;
import com.xindus.wishlist.Models.User;
import com.xindus.wishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUp signUp){
        if(userRepository.findByUsername(signUp.getUsername()).isPresent()){
            return new ResponseEntity<>("Username already exist.", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(signUp.getUsername());
        user.setEmail(signUp.getEmail());
        user.setPassword(passwordEncoder.encode(signUp.getPassword()));
        user.setRole("user");
        userRepository.save(user);
        return new ResponseEntity<>("User registration success.", HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody Login login) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User login success.", HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Login failed: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }




}
