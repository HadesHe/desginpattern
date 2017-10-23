package com.hzjytech.hades.desginpattern.singlepattern.example

import android.os.Environment
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.io.RandomAccessFile
import java.nio.charset.Charset

/**
 * Created by Hades on 2017/9/25.
 */
class PrinterDriverTest{
    @Test
    fun main(){
        println("Start")
        PrinterDriver.print()
        PrinterDriver.print()
    }

    @Test
    fun testSon() {

        Son().showI();
    }
}

open class Only{
    val i:Int=5
}

class Son: Only() {

    fun showI():Unit{
        println("your son is "+i+" years old")
    }

}


class LogFilePlugin {
    companion object {
        var OPEN = false

        private val ABSOLUTE_CRASH_LOG_PATH = "${Environment.getExternalStorageDirectory().absolutePath}/log/alltest.log"
        private val lock: Any = Any()
        private val fileThreadHandler: Handler by lazy { Handler(HandlerThread("log_file_thread").apply { start() }.looper) }

        init {
            if (!File(ABSOLUTE_CRASH_LOG_PATH).parentFile.exists()) File(ABSOLUTE_CRASH_LOG_PATH).parentFile.mkdirs()
        }

        private fun appendLog(content: String) {
            synchronized(lock) {
                val file = RandomAccessFile(ABSOLUTE_CRASH_LOG_PATH, "rw")
                try {
                    Log.e("LOG R APPEND", content)
                    file.seek(file.length()?:0)
                    file.write("$content\n".toByteArray(Charset.defaultCharset()))
                    file.close()
                    Log.e("LOG R APPEND-ok", content)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }

        fun AppendLog(content: String) {
            if (!OPEN) return
            Log.e("LOG R", content)
            fileThreadHandler.post { appendLog("${content}") }
        }

        fun AppendLog(key: String, content: String) {
            if (!OPEN) return
            fileThreadHandler.post { appendLog("$key:$content") }
        }

        fun RLog(tag: String, msg: String) {
            if (!OPEN) return
            fileThreadHandler.post { appendLog("Log/R$tag:$msg") }
        }

        fun asyncAllText(succ: (content: String) -> Unit) {
            fileThreadHandler.post {
                synchronized(lock) {
                    val file = RandomAccessFile(ABSOLUTE_CRASH_LOG_PATH, "rw")
                    val bs: ByteArray = kotlin.ByteArray(file.length().toInt())
                    if (file.length() > 0) {
                        file.readFully(bs)
//                        Framework._MAIN_HANDLER.post { succ(String(bs, Charset.defaultCharset())) }
                    }
                }
            }
        }

        fun clear() {
            fileThreadHandler.post {
                val file = File(ABSOLUTE_CRASH_LOG_PATH)
                synchronized(lock) {
                    if (file.exists()) file.delete()
                }
            }
        }

    }

}

