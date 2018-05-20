package br.com.kst.service

import br.com.kst.dto.AddressDTO

interface AddressService{
    fun findByUserId(id: Long): List<AddressDTO>
}