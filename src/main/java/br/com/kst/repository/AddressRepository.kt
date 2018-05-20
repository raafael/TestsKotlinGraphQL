package br.com.kst.repository

import br.com.kst.model.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AddressRepository : JpaRepository<Address, Long>{
    @Query("SELECT a FROM Address a WHERE a.user.id = :userId")
    fun findByUserId(@Param("userId")id: Long): List<Address>
}