package repository

import api.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import model.RandomUserResponse

class RandomUserRepository {

    private suspend fun getRandomUsers(): RandomUserResponse {
        val response = httpClient.get("https://randomuser.me/api/?results=20")
        return response.body()
    }

    fun getUsersList() = flow {
        emit(getRandomUsers().results)
    }
}