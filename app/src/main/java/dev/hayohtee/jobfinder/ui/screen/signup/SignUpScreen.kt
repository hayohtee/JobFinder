package dev.hayohtee.jobfinder.ui.screen.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.hayohtee.jobfinder.R
import dev.hayohtee.jobfinder.ui.component.SocialButtonsGroup
import dev.hayohtee.jobfinder.ui.theme.JobFinderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    userName: String,
    onUserNameChange: (String) -> Unit,
    emailAddress: String,
    onEmailAddressChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
    onNavigateBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onNavigateBackClick) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = stringResource(id = R.string.navigate_back)
                        )
                    }
                }
            )
        },
        modifier = modifier.safeDrawingPadding()
    ) { innerPadding ->
        Surface(
            modifier = modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.large))
            ) {
                SignUpHeader(modifier = Modifier.fillMaxWidth(0.7f))
                SignUpFields(
                    userName = userName,
                    onUserNameChange = onUserNameChange,
                    emailAddress = emailAddress,
                    onEmailAddressChange = onEmailAddressChange,
                    password = password,
                    onPasswordChange = onPasswordChange,
                    onSignUpClick = onSignUpClick
                )
                SocialButtonsGroup(
                    onGoogleClick = onGoogleClick,
                    onFaceBookClick = onFacebookClick
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = stringResource(id = R.string.already_have_an_account),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    TextButton(onClick = onSignInClick) {
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun SignUpHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small))
    ) {
        Text(
            text = stringResource(id = R.string.sign_up_screen_title),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 32.sp
            )
        )
        Text(
            text = stringResource(id = R.string.sign_in_screen_subtitle),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SignUpFields(
    userName: String,
    onUserNameChange: (String) -> Unit,
    emailAddress: String,
    onEmailAddressChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.large))
    ) {
        OutlinedTextField(
            value = userName,
            onValueChange = onUserNameChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(text = stringResource(id = R.string.username))
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.user_svgrepo),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.textfield_icon_size))
                )
            }
        )
        OutlinedTextField(
            value = emailAddress,
            onValueChange = onEmailAddressChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(text = stringResource(id = R.string.email_address))
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.email_svgrepo),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.textfield_icon_size))
                )
            }
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            placeholder = {
                Text(text = stringResource(id = R.string.password))
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock_keyhole_svgrepo),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.textfield_icon_size))
                )
            }
        )
        Button(onClick = onSignUpClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.sign_up))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    JobFinderTheme {
        SignUpScreen(
            userName = "",
            onUserNameChange = {},
            emailAddress = "",
            onEmailAddressChange = {},
            password = "",
            onPasswordChange = {},
            onSignUpClick = {},
            onGoogleClick = {},
            onFacebookClick = {},
            onSignInClick = {},
            onNavigateBackClick = {}
        )
    }
}