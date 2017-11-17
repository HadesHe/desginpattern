package com.hzjytech.hades.desginpattern.statepattern.kt

/**
 * Created by Hades on 2017/11/17.
 */
sealed class AuthorizationState

class Unauthorized:AuthorizationState()

class Authorized(val userName:String):AuthorizationState()

class AuthorizationPresenter{
    private var state:AuthorizationState=Unauthorized();

    fun loginUser(userLogin:String){
        state=Authorized(userLogin)
    }

    fun logoutUser(){
        state=Unauthorized()
    }

    val isAuthorized:Boolean
    get() = when(state){
        is Authorized->true
        is Unauthorized->false
    }

    val userLogin:String
    get() = when(state){
        is Authorized->(state as Authorized).userName
        is  Unauthorized->"Unknown"
    }

    override fun toString(): String =
         "User '$userLogin' is logged in: $isAuthorized"
}