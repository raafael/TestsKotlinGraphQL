package br.com.kst.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

open class BaseEntity(
        @Id @GeneratedValue(strategy= GenerationType.AUTO) val id:Long? = null,
        val createDate : LocalDateTime,
        val updateDate : LocalDateTime
)