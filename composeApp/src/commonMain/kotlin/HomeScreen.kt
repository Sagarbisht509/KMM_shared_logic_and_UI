import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val users by viewModel.users.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (users.isEmpty()) {
            Text(text = "Empty", textAlign = TextAlign.Center)
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(users) { user ->
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(text = "${user.name.first} ${user.name.last}")

                            // Coil is not available in IOS
                            /*Image(
                                painter = rememberAsyncImagePainter(model = user.picture.thumbnail),
                                contentDescription = "User Profile",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(50.dp)
                            )*/
                        }
                    }
                }
            }
        }
    }

}