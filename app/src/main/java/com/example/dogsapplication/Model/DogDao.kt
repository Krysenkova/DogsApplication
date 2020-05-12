package com.example.dogsapplication.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao  ///Data access object
interface DogDao {
    @Insert //inserts parametrs of type DogBreed into data base
    //returns List of Long(primary keys)
    //suspend - for running on a backend thread? TODO
    suspend fun insertAll(vararg dogs: DogBreed): List<Long>

    @Query("SELECT * FROM dogbreed")
    suspend fun getAllDogs(): List<DogBreed>

    @Query("SELECT * FROM dogbreed WHERE uuid = :dogId")
    suspend fun getDog(dogId: Int): DogBreed //allows to retrieve DogBreed according to uuid

    @Query("DELETE FROM dogbreed")
    suspend fun deleteAllDogs()

}