package com.hzjytech.hades.desginpattern.proxypattern.kt

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by zhanghehe on 2017/10/8.
 */
class SecuredFileTest{

    @Test
    fun testProtectionProxy(){
        val securedFile =SecuredFile()
        securedFile.read("readme.md")

        securedFile.password="secret"
        securedFile.read("readme.md")

    }
}