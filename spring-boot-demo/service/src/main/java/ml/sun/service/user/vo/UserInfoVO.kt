package ml.sun.service.user.vo

import ml.sun.service.user.repository.UserInfoEntity

data class UserInfoVO(val username: String, val password: String, val email: String) {
    constructor(entity: UserInfoEntity) : this(entity.username, entity.password, entity.email)
}
