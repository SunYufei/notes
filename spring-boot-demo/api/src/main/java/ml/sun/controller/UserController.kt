package ml.sun.controller

import ml.sun.service.user.UserService
import ml.sun.service.user.vo.UserInfoVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(private val service: UserService) {
    @GetMapping
    fun find(@RequestParam username: String) = service.findByUsername(username)

    @PostMapping("login")
    fun login(username: String, password: String) = service.login(username, password)

    @PostMapping("register")
    fun register(@RequestBody userInfo: UserInfoVO) = service.register(userInfo)
}