package com.hzjytech.hades.desginpattern.chainresponsibitlity

/**
 * Created by zhanghehe on 2017/10/15.
 */
interface MessageChain{

    fun addLines(inputHeader:String):String
}

class AuthenticationHeader(val token:String?,var next: MessageChain?=null):MessageChain{
    override fun addLines(inputHeader: String): String {
        token?:throw IllegalStateException("Token should be not null")

        return "$inputHeader Authorization:Bearer $token\n".let { next?.addLines(it)?:it }
    }

}

class ContentTypeHeader(val contentType:String,var next:MessageChain?=null):MessageChain{
    override fun addLines(inputHeader: String): String
    ="$inputHeader ContentType:$contentType\n".let { next?.addLines(it)?: it}
}

class BodyPayLoad(val body:String,var next:MessageChain?=null):MessageChain{
    override fun addLines(inputHeader: String): String
    ="$inputHeader $body \n".let { next?.addLines(it)?:it }

}
