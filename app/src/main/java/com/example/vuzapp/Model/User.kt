package com.example.vuzapp.model

data class User (
    var login:String?="",
    var password:String?="",
    var full_name:String?="",
    var overall:String?="",
    var first_bill:String?="",
    var first_pay_date:String?="",
    var first_ispaid:String?="",
    var second_bill:String?="",
    var second_pay_date:String?="",
    var second_ispaid:String?=""
)