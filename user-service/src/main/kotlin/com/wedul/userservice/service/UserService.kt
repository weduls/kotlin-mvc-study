package com.wedul.userservice.service

import com.wedul.userservice.domain.entity.User
import com.wedul.userservice.domain.repository.UserRepository
import com.wedul.userservice.exception.UserExistException
import com.wedul.userservice.model.SignUpRequest
import jdk.jshell.spi.ExecutionControl.UserException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    suspend fun signUp(signUpRequest: SignUpRequest) {
        with(signUpRequest) {
            userRepository.findByEmail(this.email)?.let {
                throw UserExistException()
            }
            val user = User (
                email = email,
                password = password,
                username = username
            )
            userRepository.save(user)
        }
    }

}
