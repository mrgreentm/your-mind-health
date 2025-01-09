package com.jj.yourmindhealth.entity

import com.jj.yourmindhealth.dto.UserDTO
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    var email: String
) {
    fun toDTO(): UserDTO {
        return UserDTO(
            id = this.id,
            name = this.name,
            email = this.email
        )
    }
}