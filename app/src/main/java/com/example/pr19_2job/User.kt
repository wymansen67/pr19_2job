package com.example.pr19_2job

class User(var name:String, var age:Int = 0){

    @Override
    fun info() {
        println("Name: $name \nAge: $age")
    }

}