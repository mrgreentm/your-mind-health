package com.jj.yourmindhealth.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
@Table(name = "health_questionnaires")
data class HealthQuestionnaire(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID? = null,

    val title: String,
    val description: String? = null,

    @OneToMany(mappedBy = "questionnaire", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val questions: List<Question> = emptyList(),

    @Column(nullable = false, updatable = false)
    val createdAt: Date = Date()
)
