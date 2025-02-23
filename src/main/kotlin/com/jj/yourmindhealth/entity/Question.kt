package com.jj.yourmindhealth.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
@Table(name = "questions")
data class Question(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "questionnaire_id", nullable = false)
    val questionnaire: HealthQuestionnaire,

    @Column(nullable = false)
    val questionText: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val questionType: QuestionType,

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = [JoinColumn(name = "question_id")])
    @Column(name = "option_text")
    val options: List<String>? = null
)

enum class QuestionType {
    MULTIPLE_CHOICE, TEXT, NUMERIC, SCALE
}
