package com.hzjytech.hades.desginpattern.chainresponsibitlity

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by zhanghehe on 2017/10/15.
 */
class BodyPayLoadTest{

    @Test
    fun name() {
        val authenticaitonHeader=AuthenticationHeader("123456")
        val contentTypeHeader=ContentTypeHeader("json")
        val messageBody=BodyPayLoad("{\"username\"=\"dbacinski\"}")

        val messageChainWithAuthorization=messageChainWithAuthorization(authenticaitonHeader,contentTypeHeader,messageBody)
        val messageWithAuthentication=messageChainWithAuthorization.addLines("Message with Authenticaiton:\n")

        println(messageWithAuthentication)
        
        val messageChainUnauthenticated=messageChainUnauthenticated(contentTypeHeader,messageBody)
        val message=messageChainUnauthenticated.addLines("Message:\n")
        println(message)
                
                
                
                
                
                
                
                
                
                
                
                
    }

    private fun messageChainUnauthenticated(contentTypeHeader: ContentTypeHeader, messageBody: BodyPayLoad): MessageChain {
        contentTypeHeader.next=messageBody
        return contentTypeHeader
    }

    private fun  messageChainWithAuthorization(authenticaitonHeader: AuthenticationHeader, contentTypeHeader: ContentTypeHeader, messageBody: BodyPayLoad): MessageChain {
        authenticaitonHeader.next=contentTypeHeader
        contentTypeHeader.next=messageBody
        return authenticaitonHeader
    }
}