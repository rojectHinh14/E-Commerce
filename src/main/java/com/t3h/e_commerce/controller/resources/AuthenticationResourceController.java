package com.t3h.e_commerce.controller.resources;

import com.t3h.e_commerce.dto.ApiResponse;
import com.t3h.e_commerce.dto.requests.AuthenticationRequest;
import com.t3h.e_commerce.dto.responses.AuthenticationResponse;
import com.t3h.e_commerce.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationResourceController {
    private final IAuthenticationService iAuthenticationService;

    @PostMapping("/authenticate")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ApiResponse.<AuthenticationResponse>builder()
               .result(iAuthenticationService.authenticate(request))
               .build();
    }

}