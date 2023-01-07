package com.wedul.issueservice.web

import IssueRequest
import com.wedul.issueservice.config.AuthUser
import com.wedul.issueservice.service.IssueService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/issues")
@RestController
class IssueController(
    private val issueService: IssueService
) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request:IssueRequest
    ) = issueService.create(authUser.userId, request)
}
