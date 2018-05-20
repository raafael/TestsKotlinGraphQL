package br.com.kst.service

import br.com.kst.dto.AddressDTO
import br.com.kst.model.Address
import br.com.kst.repository.AddressRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class AddressServiceImpl(val addressRepository: AddressRepository) : AddressService{

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    override fun findByUserId(id: Long): List<AddressDTO> {
        val addresses: List<Address> =addressRepository.findByUserId(id)
        var ret: MutableList<AddressDTO> = mutableListOf()

        addresses.forEach{ a: Address -> ret.add(a.toDto())}
        return ret
    }

}