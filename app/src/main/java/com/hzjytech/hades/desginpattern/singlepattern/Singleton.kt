package com.hzjytech.hades.desginpattern.singlepattern

import kotlin.reflect.KProperty

/**
 * Created by Hades on 2017/9/18.
 */

fun main(args: Array<String>) {

    val fooVal = 10
    var fooVar = 10
    fooVar = 20

    val foo: Int = 7

    val fooString = "My String Is Here!"
    val barString = "Printing on a new line?\n No Problem!"
    val bazString = "Do you want to add a tab?\tNo Problem"
    println(fooString)
    println(barString)
    println(bazString)

    val fooRawString = """
    fun helloWorld(val name:String){
    println("Hello,World")
    }
"""
    println(fooRawString)

    val fooTemplateString="$fooString has ${fooString.length} characters"
    println(fooTemplateString)

    /**
     * For a variable hold null it must be explicitly specified as nullable
     * a variable can be specified as nullable by appending a ? to its type
     * We can access a nullable variable by using the ?. operator.
     * We can use the ?: operator to specify an alternative value to use
     * if a variable is null
     */
    var fooNullable:String?="abc"
    println(fooNullable?.length)
    println(fooNullable?.length?:-1)
    fooNullable=null
    println(fooNullable?.length)    //=>null
    println(fooNullable?.length?:-1) //=>-1


    fun parseInt(str:String): Int? {
        try {
            return str.toInt()
        } catch(e: Exception) {
            println("One of the argument isn't Int")
        }

        return null
    }


    /**
     * Function can be declare using the "fun" keyword.
     * Function arguments are specified in brackets after the function name
     * Function arguments can optionally have a default value
     * The function return type, if required, is specified after the arguments
     *
     */
    fun hello(name:String="world"):String{
        return "Hello,$name!";
    }

    println(hello("foo")) //=>Hello,foo!
    println(hello(name="bar"))  //=>Hello,bar!
    println(hello())           //=>Hello,world!

    /**
     * A function parameter may be marked with the "vararg" keyword
     * to allow a variable number of arguments to be passed to the function.
     */
    fun varargExample(vararg names:Int){
        println("Argument has ${names.size} elements")
    }

    varargExample()              //=>Argument has 0 elements
    varargExample(1)  //=>Argument has 1 elements
    varargExample(1,2,3)//=>Argument has 3 elements

    /**
     * When a function consists of a single expression then the curly brackets can be ommitted.
     * The body is specified after a =symbol
     */
    fun odd(x:Int):Boolean =x%2==1
    println(odd(6))  //=>false
    println(odd(7))  //=>true

    /**
     * If the return type can be inferred then we don't need to specify it.
     */
    fun even(x:Int)=x%2==0
    println(even(6)) //=>true
    println(even(7)) //=>false

    /**
     * Functions can take functions as arguments and return functions
     */
    fun not(f:(Int)->Boolean):(Int)->Boolean{
        return {n->!f.invoke(n)}
    }

    /**
     * Named functions can be specofied as arguments using the:: operator.
     */
    val notOdd=not(::odd)
    val notEven=not(::even)

    /**
     * If a lambda has only one parameter
     * then its declaration can be be ommitted (along with the ->)
     * The name of the single parameter will be "it".
     */
    val notZero=not{n->n==0}

    val notPositive=not{it>0}

    for(i in 0..4){
        println("${notOdd(i)} ${notEven(i)} ${notZero(i)} ${notPositive(i)}")
    }

    class ExampleClass(val x:Int){
        fun memberFunction(y:Int):Int{
            return x + y
        }

        infix fun infixMemberFunction(y:Int):Int{
            return x*y
        }

    }


    /**
     * To create a new instance we call the constructor
     * Note that Kotlin does not has a "new" keyword
     */
    val fooExampleClass =ExampleClass(7)
    //Member functions can be called using dot notation
    println(fooExampleClass.memberFunction(4)) //=>11
    /**
     * If a function has been marked with "infix" keyword
     * then it can be called using infix notation
     */
    println(fooExampleClass infixMemberFunction 4)  //=>28

    /**
     * Data classes are a concise way to create classes that just hold data
     * The "hashCode"/"equals" and "toString" methods are automatically generated
     */
data class DataClassExample(val x :Int,val y:Int,val z:Int)
    val fooData=DataClassExample(1,2,4)
    println(fooData) //=> DataClassExmaple(x=1,y=2,z=4)

    val fooCopy=fooData.copy(y=100)
    println(fooCopy)//=>DataClassExample(x=1,y=100,z=4)

    //Objects can be destructured into multiple variables
    val (a,b,c)=fooCopy
    println("$a $b $c")

    for((a,b,c) in listOf(fooData)){
        println("$a $b $c") //-> 1 100 4
    }

    val mapData= mapOf("a" to 1,"b" to 2)
    for ((key, value) in mapData) {
        println("$key -> $value")
    }

    data class MutableDataClassExample(var x:Int,var y:Int,var z:Int)
    val fooMutableData=MutableDataClassExample(7,4,9)
    with(fooMutableData){
        x-=2
        y+=2
        z--
    }
    println(fooMutableData) //=>MutableDataClassExample(x=5,y=6,z=8)

    /**
     * We can create a list using the "listOf" function.
     * The list will be immutable - elements cannot be added or removed
     */
    val fooList= listOf<String>("a","b","c")
    println(fooList.size) //=>3
    println(fooList.first()) //=>a
    println(fooList.last()) //=>c
    println(fooList[1]) //=>c

    val fooMutableList= mutableListOf("a","b","c")
    fooMutableList.add("d")
    println(fooMutableList.last())//=>d
    println(fooMutableList.size)//=>4

    val fooSet= setOf("a","b","c")
    println(fooSet.contains("a")) //=>true
    println(fooSet.contains("z")) //=>false

    val fooMap= mapOf("a" to 8,"b" to 7,"c" to 9)
    println(fooMap["a"])  //=>8


    val fooSequence= generateSequence(1,{it+1})
    val x=fooSequence.take(10).toList();
    println(x)  //=> [1,2,3,4,5,6,7,8,9,10]

    fun fibonacciSequence(): Sequence<Long> {
        var a=0L;
        var b=0L;

        fun next():Long{
            val result=a+b;
            a=b
            b=result
            return a

        }

        return generateSequence(::next)
    }
    val y=fibonacciSequence().take(10).toList()
    println(y)  //=>[1,1,2,3,5,8,13,21,34,55]

    val z=(1..9).map(){it*3}
            .filter(){it<20}
            .groupBy(){it%2==0}
            .mapKeys { if(it.key) "even" else "odd" }
    println(z)   //{odd=[3,9,15],even=[6,12,18]}

    for(c in "hello"){
        println(c)
    }

    var ctr=0
    while (ctr<5){
        println(ctr)
        ctr++
    }

    do {
        println(ctr)
        ctr++
    }while(ctr<10)

    /**
     * "if" can be used as an expression that returns a value
     * For this reason the ternary ?: operator is not needed in Kotlin
     */
    val num=6
    val message=if(num%2==0) "even" else "odd"
    println("$num is $message")  //=>5 is odd

    //"when" can be used as an alternative to "if-else if" chains
    val i=10
    when {
        i<7-> println("first block")
        fooString.startsWith("hello")-> println("second block")
        else -> println("else block")
    }

    //"when" can be used with an argument
    when(i){
        0,21 -> println("0 or 21")
        in 1..20-> println("in the range 1 to 20")
        else -> println("none of the above")
    }

    //"when" can be used as a function that returns a value
    var result= when(i){
        0,21->"0 or 21"
        in 1..20 -> "in the range 1 to 20"
        else -> "none of the above"
    }
    println(result)

    /**
     * We can check if an object is a particular type by using the "is" operator.
     * If an object passes a type check then it can be used as that type without
     * explicitly casting it
     */
    fun smartCastExmaple(x:Any) :Boolean{
        if (x is Boolean) {
            return x
        }else if(x is Int){
            return x > 0
        }else if(x is String){
            return x.isNotEmpty()
        }else{
            return false
        }
    }

    println(smartCastExmaple("Hello,World!")) //=>true
    println(smartCastExmaple("")) //=>false
    println(smartCastExmaple(5)) //=>true
    println(smartCastExmaple(0)) //=>false
    println(smartCastExmaple(true)) //=>true

    fun smartCastWhenExample(x:Any)=when(x){
        is Boolean ->x
        is Int ->x>0
        is String ->x.isNotEmpty()
        else ->false
    }


    /**
     * Extensions are a way to add new functionality to a class
     * This is similar to C# extension methods
     */
    fun String.remove(c:Char):String{
        return this.filter { it!=c }
    }

    println("Hello, world！".remove('l'))  //=>Heo,word!

    println(EnumExample.A) //=>A
    println(ObjectExample.hello()) //=>hello

}

enum class EnumExample{
    A,B,C
}

/**
 * The "object" keyword can be used to create singleton objects
 * We cannot instantiate it but we can refer to its unique instance by its name.
 * This is similar to Scale singleton objects
 */
object ObjectExample{
    fun hello():String{
        return "hello"
    }
}

fun useObject(){
    ObjectExample.hello()
    val someRef:Any=ObjectExample // we use objects name just as is
}

class Pair<K,V>(val first:K,val second:V){
    operator fun component1():K{
        return first
    }

    operator fun component2(): V {
        return second;
    }
}

/**
 * KeyWord By
 */

class ByExmaple{
    val p:String by ByDelegate()
}

class ByDelegate  {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef,thank you for delegating '${property.name}' to me"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>,value: String) {
        println("1 $value has been assigned to ${property.name} in $thisRef")
    }
}

/**
 * KeyWord By lazy
 * blockingLazy()  thread safety
 */

class LazeExample{
    val lazyVar:String by lazy{
        println("computed!")
        "my lazy"
    }


}







