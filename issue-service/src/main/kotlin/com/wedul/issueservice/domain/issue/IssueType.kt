package com.wedul.issueservice.domain.issue

enum class IssueType {
    BUG, TASK;


    companion object {
        // operator를 사용하면 생성자를 사용하는 것 처럼 사용 가능 IssueType("BUG")
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}
