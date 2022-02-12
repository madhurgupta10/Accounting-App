package com.example.account.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.account.model.InvoiceAndInvoiceItems
import com.example.account.model.InvoiceItem

@Dao
interface InvoiceItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item: InvoiceItem)

    @Transaction
    @Query("SELECT * FROM invoices WHERE id = :id")
    fun readAllItems(id: String): LiveData<List<InvoiceAndInvoiceItems>>

    @Update
    suspend fun updateItem(item: InvoiceItem)

    @Delete
    suspend fun deleteItem(item: InvoiceItem)
}