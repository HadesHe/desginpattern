package com.hzjytech.hades.desginpattern.proxypattern.kt

/**
 * Created by zhanghehe on 2017/10/8.
 */
interface File{
    fun read(name:String)
}

class NormalFile:File{
    override fun read(name: String)= println("Read file:$name")
}

class SecuredFile:File{
    val normalFile=NormalFile()
    var password:String=""
    override fun read(name: String) {
        if(password=="secret"){
            println("Password is correct:$password")
            normalFile.read(name);
        }else{
            println("Incorrect password. Access denied")
        }
    }



}




