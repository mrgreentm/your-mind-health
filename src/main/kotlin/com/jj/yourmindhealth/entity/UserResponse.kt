package com.jj.yourmindhealth.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
@Table(name = "user_responses")
data class UserResponse(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    val question: Question,

    @ManyToOne
    @JoinColumn(name = "questionnaire_id", nullable = false)
    val questionnaire: HealthQuestionnaire,

    val responseText: String? = null,
    val responseNumeric: Int? = null,

    @Column(nullable = true)
    val responseScale: Int? = null, // Exemplo: 1 a 10

    @ElementCollection
    @CollectionTable(name = "response_options", joinColumns = [JoinColumn(name = "response_id")])
    @Column(name = "selected_option")
    val responseOptions: List<String>? = null,

    @Column(nullable = false, updatable = false)
    val createdAt: Date = Date()
)
