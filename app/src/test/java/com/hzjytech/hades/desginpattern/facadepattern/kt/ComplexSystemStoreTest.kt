package com.hzjytech.hades.desginpattern.facadepattern.kt

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by zhanghehe on 2017/10/2.
 */
class ComplexSystemStoreTest{

    @Test
    fun testComplextSystem(){
        val userRepository=UserRepository()
        val user=User("dbacinski")
        userRepository.save(user)
        val resultUser=userRepository.findFirst()
        println("Found stored user:$resultUser")
    }
}