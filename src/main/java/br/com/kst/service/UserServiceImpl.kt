package br.com.kst.service

import br.com.kst.dto.UserDTO
import br.com.kst.model.Address
import br.com.kst.model.User
import br.com.kst.repository.AddressRepository
import br.com.kst.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * User service
 */
@Service
class UserServiceImpl(val userRepository: UserRepository, val addressRepository: AddressRepository) : UserService{

    override fun findById(id: Long): UserDTO {

        val user: User = userRepository.getOne(id)
        if(user != null)
            return user.toDto()

        return UserDTO(null, "","",null)
    }

    override fun findAll(): MutableIterable<UserDTO> {
        val ret: MutableList<UserDTO> = mutableListOf()
        this.userRepository.findAll().forEach{u:User ->
            u.addressess
            ret.add(u.toDto())}
        return ret
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    //(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor= Exception.class)
    override fun findAllWithAddress(): MutableIterable<UserDTO> {
        val ret: MutableList<UserDTO> = mutableListOf()
        val users: MutableIterable<User> = this.userRepository.findAll()
        //não precisa chamar se estiver com a transação anotada no método
//        users.forEach{u:User -> this.addressRepository.findByUserId(u.id!!).forEach{a: Address -> u.addAddress(a)}}
        // estando em uma transação ao fazer a requisição a lista lazy hibernate se encarrega de disparar a query para carregar relacionamento
        users.forEach{u:User ->
            u.addressess
            ret.add(u.toDto())}
        return ret
    }

    override fun findAddressess(userId: Long): List<Address> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(user : User){
        userRepository.save(user)
    }

}