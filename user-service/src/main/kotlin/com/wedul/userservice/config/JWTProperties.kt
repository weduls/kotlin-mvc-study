package com.wedul.userservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import javax.security.auth.Subject

@ConfigurationProperties(prefix = "jwt")
class JWTProperties(
    val issuer:String,
    val subject: String,
    val expireTime: Long,
    val secret: String,
) {
}
