package com.wedul.userservice.domain.repository

import com.wedul.userservice.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository: CoroutineCrudRepository<User, Long> {

    suspend fun findByEmail(email: String): User?
}
