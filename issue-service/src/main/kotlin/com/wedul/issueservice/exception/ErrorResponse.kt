package com.wedul.issueservice.exception

data class ErrorResponse(
    val code: Int,
    val message: String
) {
}
