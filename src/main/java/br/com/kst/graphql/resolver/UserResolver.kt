package br.com.kst.graphql.resolver

import br.com.kst.dto.UserDTO
import br.com.kst.service.AddressService
import br.com.kst.service.UserService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

/**
 * User resolver
 */
@Component
class UserResolver(private val userService: UserService, private val addressService: AddressService): GraphQLResolver<UserDTO>{
    /**
     * Resolver for address by user id
     */
    fun addressess(user: UserDTO) = addressService.findByUserId(user.id!!)
}