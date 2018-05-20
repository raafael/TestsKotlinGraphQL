package br.com.kst.graphql.resolver

import br.com.kst.service.AddressService
import br.com.kst.service.UserService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

/**
 * Query resolver
 */
@Component
class UserQueryResolver(
        val userService: UserService,
        val addressService: AddressService
) : GraphQLQueryResolver {

    /**
     * Get user by id
     */
    fun getUserById(id: Long) = userService.findById(id)
}