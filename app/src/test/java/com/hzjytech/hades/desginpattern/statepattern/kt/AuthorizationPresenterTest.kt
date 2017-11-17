package com.hzjytech.hades.desginpattern.statepattern.kt

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Hades on 2017/11/17.
 */
class AuthorizationPresenterTest{



    @Test
    fun testState() {
        val authorzation=AuthorizationPresenter()
        authorzation.loginUser("Admin")
        println(authorzation)
        authorzation.logoutUser()
        println(authorzation)
    }
}