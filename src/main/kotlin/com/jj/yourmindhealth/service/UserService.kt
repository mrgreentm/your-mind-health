package com.jj.yourmindhealth.service

import com.jj.yourmindhealth.dto.UserDTO
import com.jj.yourmindhealth.repository.UserRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getAllUsers(): List<UserDTO> {
        return userRepository.findAll().map { it.toDTO() }
    }

    fun getUserById(id: Long): UserDTO {
        return userRepository
            .findById(id)
            .map { it.toDTO() }
            .orElseThrow{ RuntimeException("Usuário não encontrado") }
    }

    fun createUser(userDTO: UserDTO): UserDTO {
        val userEntity = userDTO.toEntity();
        userRepository.save(userEntity);
        return userEntity.toDTO();
    }

    fun updateUser(id: Long, user: UserDTO): UserDTO {
        val userToUpdate = userRepository
            .findById(id)
            .orElseThrow{ RuntimeException("Usuário não encontrado") };

        userToUpdate.name = user.name;
        userToUpdate.email = user.email;
        userRepository.save(userToUpdate);
        return userToUpdate.toDTO();
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

}