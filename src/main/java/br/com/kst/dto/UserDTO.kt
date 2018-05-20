package br.com.kst.dto

/**
 * DTO class that represents user
 */
data class UserDTO(
        val id:Long? = null,
        val name: String,
        val lastName: String,
        var addressess : MutableList<AddressDTO>?= mutableListOf()
)