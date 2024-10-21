package modulo_05.sprint.shoes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(
    title: String,
    viewModel: ViewModel? = null,
    navController: NavController,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,

    ) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    navigationIconContentColor = Color.White,
                ),
                title = {
                    Text(
                        text = title,
                        color = Color.White
                    )
                },
                navigationIcon = navigationIcon,
                actions = actions                         )
        },
    )
    { innerPadding ->
        content(innerPadding)
    }
}

@Composable
fun AddButton(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}





















@Composable
fun MyText(text: String){
    Text(
        text = text,
        modifier = Modifier
            .shadow(
                elevation = 2.dp,shape = RoundedCornerShape(8.dp),
                clip = true
            )
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .padding(8.dp)

    )
}

@Composable
fun MyTextField(
    text: String,
    onValueChange: (String) -> Unit,
    label: String
) {
   TextField(
        maxLines = 1,
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
    )
}

@Composable
fun MyButton(
        text: String,
        onClick: () -> Unit)
    {
    Button(
        onClick = onClick,
        colors= ButtonDefaults.buttonColors(containerColor = Color.Blue.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()

    ) {
        Text( text = text, color = Color.White)

    }
}

@Composable
fun MainButton(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Alert(
    title: String,
    msj: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = title) },
        text = { Text(text = msj) },
        shape = CutCornerShape(10.dp),
        confirmButton = {
            Button(onClick = onConfirmClick) {
                Text(text = confirmText)
            }
        }
    )
}