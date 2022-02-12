package com.example.account.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.account.db.dao.InvoiceDao
import com.example.account.db.dao.InvoiceItemDao
import com.example.account.model.Invoice
import com.example.account.model.InvoiceItem
import com.example.account.model.converter.AddressConverter
import com.example.account.model.converter.InvoiceItemConverter

@Database(entities = [Invoice::class, InvoiceItem::class], version = 1)
@TypeConverters(AddressConverter::class, InvoiceItemConverter::class)
abstract class InvoiceDatabase : RoomDatabase() {
    abstract fun getInvoiceDao(): InvoiceDao
    abstract fun getInvoiceItemDao(): InvoiceItemDao
}