package br.com.kst.service

import br.com.kst.dto.UserDTO
import br.com.kst.model.Address
import br.com.kst.model.User

interface UserService{

    fun findAddressess(userId: Long):List<Address>

    fun findAllWithAddress(): MutableIterable<UserDTO>

    fun save(user: User)
    fun findAll(): MutableIterable<UserDTO>

    fun findById(id: Long): UserDTO
}