package com.wedul.userservice.controller

import com.wedul.userservice.model.SignUpRequest
import com.wedul.userservice.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    suspend fun signup(@RequestBody request: SignUpRequest) {
        userService.signUp(request)
    }

}
