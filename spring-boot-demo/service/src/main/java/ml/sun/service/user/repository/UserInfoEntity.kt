package ml.sun.service.user.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import ml.sun.service.user.vo.UserInfoVO
import java.time.LocalDateTime

@Entity
@Table(name = "user_info")
data class UserInfoEntity(
    @Id @GeneratedValue var id: Int,
    @Column var username: String,
    @Column var password: String,
    @Column var createDate: LocalDateTime,
    @Column var email: String
) {
    constructor(vo: UserInfoVO) : this(0, vo.username, vo.password, LocalDateTime.now(), vo.email)
}
