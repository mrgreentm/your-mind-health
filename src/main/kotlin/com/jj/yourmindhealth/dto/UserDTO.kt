package com.jj.yourmindhealth.dto

import com.jj.yourmindhealth.entity.User

data class UserDTO(
    val id: Long? = null,
    var name: String,
    var email: String
) {
    fun toEntity(): User {
        return User(
            id = this.id,
            name = this.name,
            email = this.email
        )
    }

}