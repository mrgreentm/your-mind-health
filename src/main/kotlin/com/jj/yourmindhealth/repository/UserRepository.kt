package com.jj.yourmindhealth.repository

import com.jj.yourmindhealth.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>