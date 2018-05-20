package br.com.kst.model

import br.com.kst.dto.UserDTO
import javax.persistence.*

data class Greeting(val id: Long, val content: String)

/**
 * Entity that represents a user in the system
 */
@Entity
@Table(name="\"user\"") // escape for postgres, user is a reserverd word
data class User(
        @Id @GeneratedValue(strategy=GenerationType.AUTO) val id:Long? = null,
        val name: String,
        val lastName: String
){
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true) private var _addressess : MutableList<Address>?=mutableListOf()

    val addressess get() = _addressess!!.toList()
    fun addAddress(address: Address) {
        if (_addressess == null) {
            _addressess = mutableListOf()
        }
        _addressess!!.add(address)
        address.user =this
    }

    fun toDto(): UserDTO {
        val u:UserDTO = UserDTO(
                id = this.id!!,
                name = this.name,
                lastName = this.lastName)
//        this.addressess.forEach{a: Address -> u.addressess?.add(a.toDto()) }

        return u
    }

    companion object {

        fun fromDto(dto: UserDTO) = User(
                id = dto.id,
                name = dto.name,
                lastName = dto.lastName)

//        fun fromDto(dto: CreateUserDTO) = User(
//                name = dto.name,
//                lastName = dto.lastName)
//
//        fun fromDto(dto: UpdateUserDTO, defaultCity: User) = User(
//                id = defaultCity.id!!,
//                name = dto.name ?: defaultCity.name,
//                lastName = dto.lastName ?: defaultCity.lastName)
    }
}