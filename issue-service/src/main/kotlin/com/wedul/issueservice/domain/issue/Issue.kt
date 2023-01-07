package com.wedul.issueservice.domain.issue

import com.wedul.issueservice.domain.BaseEntity
import javax.persistence.*

@Entity
@Table
class Issue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val userId: Long,
    var summary: String,
    var description: String,

    @Enumerated(value = EnumType.STRING)
    var type: IssueType,

    @Enumerated(value = EnumType.STRING)
    var priority: IssuePriority,

    @Enumerated(value = EnumType.STRING)
    var status: IssueStatus
): BaseEntity() {
}
