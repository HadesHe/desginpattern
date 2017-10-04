package com.hzjytech.hades.desginpattern.facadepattern.kt

/**
 * Created by zhanghehe on 2017/10/2.
 */
class ComplexSystemStore(val filePath:String){
    init {
        println("Reading data form file :$filePath")
    }

    val store=HashMap<String,String>()

    fun store(key:String,payload :String){
        store.put(key,payload)
    }

    fun read(key:String):String=store[key]?:""

    fun commit()= println("Storing cache data:$store to file:$filePath")

}

data class User(val login:String)

class UserRepository{
    val systemPreferences=ComplexSystemStore("/data/default.prefs")

    fun save(user:User){
        systemPreferences.store("USER_KEY",user.login)
        systemPreferences.commit()
    }

    fun findFirst():User=User(systemPreferences.read("USER_KEY"))


}