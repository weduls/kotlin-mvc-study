package com.wedul.issueservice.service

import IssueRequest
import IssueResponse
import com.wedul.issueservice.domain.issue.Issue
import com.wedul.issueservice.domain.issue.IssueRepository
import com.wedul.issueservice.domain.issue.IssueStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository
) {

    @Transactional
    fun create(userId: Long, request: IssueRequest): IssueResponse {
        val issue = Issue (
            summary = request.summary,
            description = request.description,
            type = request.type,
            userId = userId,
            priority = request.priority,
            status = request.status
        )
        return IssueResponse(issueRepository.save(issue))
    }

    @Transactional(readOnly = true)
    fun getAll(status: IssueStatus) = issueRepository.findAllByStatusOrderByCreatedAtDesc(status)
        ?.map { IssueResponse(it) }
}
