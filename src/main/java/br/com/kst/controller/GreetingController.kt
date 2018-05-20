package br.com.kst.controller

import br.com.kst.dto.UserDTO
import br.com.kst.model.Address
import br.com.kst.model.Greeting
import br.com.kst.model.User
import br.com.kst.repository.AddressRepository
import br.com.kst.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import javax.annotation.PostConstruct

@RestController
class GreetingController(val userServiceImpl: UserService, val addressRepository: AddressRepository) {


    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @PostConstruct
    fun saveData() {
//        val createAddress : (String,String,Long) -> Address ={street, zipCode, number, user -> Address(null, street, zipCode, number)}
        // save a couple of Users
        val user: User = User(null, "Jack", "Bauer")
        user.addAddress(Address(null,"Olavo Bilac", "96030400", 702))
        user.addAddress(Address(null,"R. Gen. Câmara,", "96200320", 435))
        userServiceImpl.save(user)
        //userServiceImpl.save(User(null, "Jack", "Bauer", listOf(Address(null,"Olavo Bilac", "96030400", 702, null),Address(null,"R. Gen. Câmara,", "96200320", 435, null))))
        userServiceImpl.save(User(null, "Chloe", "O'Brian"))
        userServiceImpl.save(User(null, "Kim", "Bauer"))
        userServiceImpl.save(User(null, "David", "Palmer"))
        userServiceImpl.save(User(null, "Michelle", "Dessler"))
    }

    @GetMapping("/findAllWithAddress")
    fun findAllWithAddress(): MutableIterable<UserDTO> {
        return userServiceImpl.findAllWithAddress()
    }

    @GetMapping("/findAll")
    fun findAll(): MutableIterable<UserDTO> {
        return userServiceImpl.findAll()
    }

    @GetMapping("/findAllAddressess")
    fun findAllAddressess(): MutableIterable<Address>? {
        return addressRepository.findAll()
    }


}