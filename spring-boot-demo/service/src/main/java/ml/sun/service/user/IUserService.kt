package ml.sun.service.user

import ml.sun.service.user.vo.UserInfoVO

interface IUserService {
    fun login(username: String, password: String): String

    fun register(vo: UserInfoVO): String
}