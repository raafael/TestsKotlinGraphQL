package br.com.kst.model

import br.com.kst.dto.AddressDTO
import javax.persistence.*

@Entity
data class Address(
        @Id @GeneratedValue(strategy= GenerationType.AUTO) val id:Long? = null,
        val street: String,
        val zipCode: String,
        val number: Long) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    var user: User?=null

    fun toDto(): AddressDTO = AddressDTO(
                id = this.id!!,
                street = this.street,
                zipCode = this.zipCode,
                number = this.number)


    companion object {

        fun fromDto(dto: AddressDTO) = Address(
                id = dto.id,
                street = dto.street,
                zipCode = dto.zipCode,
                number = dto.number)

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