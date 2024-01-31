import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.RandomUser
import repository.RandomUserRepository

class HomeViewModel: ViewModel() {

    private val _users = MutableStateFlow<List<RandomUser>>(listOf())
    val users = _users.asStateFlow()

    private val userRepository: RandomUserRepository = RandomUserRepository()

    init {
        fetchData()
    }

    private fun fetchData() = viewModelScope.launch {
        userRepository.getUsersList().collectLatest { users ->
            _users.update { it + users }
        }
    }
}