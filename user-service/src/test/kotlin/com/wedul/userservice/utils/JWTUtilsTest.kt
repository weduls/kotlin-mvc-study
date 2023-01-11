package com.wedul.userservice.utils

import com.wedul.userservice.config.JWTProperties
import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class JWTUtilsTest {
    private val  logger = KotlinLogging.logger{}

    @Test
    fun createTokenTest() {
        // given
        val jwtClaim = JWTClaim(userId = "1", email = "wedul.chul@gmail.com", profileUrl = "1.jpg", username = "개발자")
        val properties = JWTProperties(
            issuer = "JARA",
            subject = "auth",
            expireTime = 3600,
            secret = "my-secret"
        )

        // when
        val token = JWTUtils.createToken(jwtClaim, properties)

        // then
        assertNotNull(token)
        logger.info { token }
    }

    @Test
    fun decodeTest() {
        // given
        val jwtClaim = JWTClaim(userId = "1", email = "wedul.chul@gmail.com", profileUrl = "1.jpg", username = "개발자")
        val properties = JWTProperties(
            issuer = "JARA",
            subject = "auth",
            expireTime = 3600,
            secret = "my-secret"
        )
        val token = JWTUtils.createToken(jwtClaim, properties)

        // when
        val decode = JWTUtils.decode(token, secret = properties.secret, issuer = properties.issuer)

        // then
        with (decode) {
            logger.info { claims }

            val userId = claims["userId"]
            logger.info { userId }
            assertThat(userId).isNotNull
        }
    }
}
