import com.fasterxml.jackson.annotation.JsonFormat
import com.wedul.issueservice.domain.issue.Issue
import com.wedul.issueservice.domain.issue.IssuePriority
import com.wedul.issueservice.domain.issue.IssueStatus
import com.wedul.issueservice.domain.issue.IssueType
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus
)

data class IssueResponse(
    val id: Long,
    val summary: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
    val description: String,
    val userId: Long,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?
) {
    companion object {
        operator fun invoke(issueEntity: Issue): IssueResponse =
            with(issueEntity){
                IssueResponse(
                    id = id!!,
                    summary = summary,
                    description = description,
                    userId = userId,
                    type = type,
                    priority = priority,
                    status = status,
                    createdAt = createdAt,
                    updatedAt = updatedAt
                )
            }
    }

}
