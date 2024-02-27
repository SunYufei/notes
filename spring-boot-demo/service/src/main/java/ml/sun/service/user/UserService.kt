package ml.sun.service.user

import ml.sun.service.user.repository.UserInfoEntity
import ml.sun.service.user.repository.UserRepository
import ml.sun.service.user.vo.UserInfoVO
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    fun findByUsername(username: String): UserInfoVO? {
        val entity = repository.findByUsername(username) ?: return null
        return UserInfoVO(entity)
    }


    fun login(username: String, password: String) =
        when (repository.findByUsernameAndPassword(username, password)) {
            null -> "username / password ERROR"
            else -> "login success"
        }

    fun register(vo: UserInfoVO) =
        when (checkUserExists(vo.username)) {
            true -> "user already registered"
            false -> let {
                repository.save(UserInfoEntity(vo))
                return "register success"
            }
        }

    private fun checkUserExists(username: String) =
        repository.findByUsername(username) != null
}