package ml.sun.service.user.impl

import ml.sun.service.user.IUserService
import ml.sun.service.user.repository.UserInfoEntity
import ml.sun.service.user.repository.UserRepository
import ml.sun.service.user.vo.UserInfoVO
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val repository: UserRepository) : IUserService {
    override fun login(username: String, password: String): String =
        when (repository.findByUsernameAndPassword(username, password)) {
            null -> "username / password ERROR"
            else -> "login success"
        }

    override fun register(vo: UserInfoVO): String {
        if (checkUserExists(vo.username)) {
            return "user already registered"
        }
        repository.save(UserInfoEntity(vo))
        return "register success"
    }

    fun checkUserExists(username: String): Boolean = repository.findByUsername(username) != null
}