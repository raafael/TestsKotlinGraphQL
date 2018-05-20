package br.com.kst.repository

import br.com.kst.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByLastName(lastName: String): List<User>

}