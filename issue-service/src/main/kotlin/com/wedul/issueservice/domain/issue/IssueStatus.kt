package com.wedul.issueservice.domain.issue

enum class IssueStatus {
    TODO, IN_PROGRESS, RESOLVED;

    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}
