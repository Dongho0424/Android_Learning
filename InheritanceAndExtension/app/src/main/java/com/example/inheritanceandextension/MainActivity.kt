package com.example.inheritanceandextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. parent class
        var parent = Parent()
        parent.sayHello()

        var child = Child()
        child.childHello()

        textStringExtension()
    }

    fun textStringExtension() {
        var original = "Hello"
        var added = " Guys"
        Log.d("Extension", "added를 더한 값은 ${original.plus(added)}입니다.")
    }

    open class Parent {
        var hello: String = "안녕하세요"
        fun sayHello() {
            Log.d("Extension", hello)
        }
    }

    class Child: Parent() {
        fun childHello() {
            hello = "Hello"
            sayHello()
        }
    }

    open class BaseClass {
        open fun opended() {

        }
        fun notOpended(){

        }
    }

    class ChildClass: BaseClass() {
        override fun opended() {
            super.opended()
        }
    }

    open class BaseClass2 {
        open var opened: String = "I am"
    }
    class ChildClass2: BaseClass2() {
        override var opened: String = "You are"

    }

    // String extension
    fun String.plus(word: String): String {
        return this + word
    }

}