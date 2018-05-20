package br.com.kst.dto

data class AddressDTO(
        val id:Long? = null,
        val street: String,
        val zipCode: String,
        val number: Long)