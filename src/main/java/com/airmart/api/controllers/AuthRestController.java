package com.airmart.api.controllers;

import com.airmart.api.config.JwtTokenProvider;
import com.airmart.api.models.AuthBody;
import com.airmart.api.models.LoginResponse;
import com.airmart.api.domains.User;
import com.airmart.api.models.UserInfo;
import com.airmart.api.services.FileStorageService;
import com.airmart.api.services.ProductService;
import com.airmart.api.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class AuthRestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    FileStorageService fileStorageService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

//    @SuppressWarnings("rawtypes")
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody AuthBody data) {
//        try {
//            String username = data.getUsername();
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
//            String token = jwtTokenProvider.createToken(username, this.userService.findUserByUsername(username).getRoles());
//            LoginResponse loginResponse = new LoginResponse();
//            loginResponse.setUsername(username);
//            loginResponse.setToken(token);
//            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
//        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username/password supplied");
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestParam(value="username") String username,
                                               @RequestParam(value="password") String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtTokenProvider.createToken(username, this.userService.findUserByUsername(username).getRoles());
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUsername(username);
            loginResponse.setToken(token);
            loginResponse.setExpirationDate(jwtTokenProvider.getExpirationDate(token));
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @PostMapping(path="/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity register(@RequestParam(value="userJson") String userJson,
                                   @RequestParam(required = false, value="image") MultipartFile file) throws IOException {
        String fileDownloadUri =  ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/profilePic/").path("default.png").toUriString();
        if(file != null){
            String fileName = fileStorageService.storeFile(file);
            fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/profilePic/").path(fileName).toUriString();
        }
        User user = objectMapper.readValue(userJson,User.class);
        user.setProfilePicture(fileDownloadUri);
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getUsername() + " already exists");
        }
        userService.save(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }
    @GetMapping("/users/info")
    public ResponseEntity<UserInfo> getLoggedInUserInfo(@RequestHeader(value = "Authorization" ,required = true ) String bearerToken){
        String username= jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
        User user= userService.findUserByUsername(username);
        String numberofPosts = Integer.toString(productService.getByUsername(username).size());
        UserInfo userInfo = new UserInfo(user.getName(),username,user.getPhone(),user.getEmail(),user.getProfilePicture(),numberofPosts);
        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }
    @GetMapping("/users/profilePic/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Resource resource  = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment;filename=\"%s\"", resource.getFilename()))
                .body(resource);

    }
}