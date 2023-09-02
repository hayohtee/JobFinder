package dev.hayohtee.jobfinder.ui.screen.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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

@Composable
fun SignInScreen(
    emailAddress: String,
    onEmailAddressChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onSignInClick: () -> Unit,
    onForgetPasswordClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onFaceBookClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .safeDrawingPadding()
            .padding(dimensionResource(id = R.dimen.medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.large))
    ) {
        SignInHeader(modifier = Modifier.fillMaxWidth(0.7f))
        SignInFields(
            emailAddress = emailAddress,
            onEmailAddressChange = onEmailAddressChange,
            password = password,
            onPasswordChange = onPasswordChange,
            onForgetPasswordClick = onForgetPasswordClick,
            onSignInClick = onSignInClick
        )
        SocialButtonsGroup(
            onGoogleClick = onGoogleClick,
            onFaceBookClick = onFaceBookClick
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(id = R.string.is_new_user),
                style = MaterialTheme.typography.bodyLarge
            )
            TextButton(onClick = onCreateAccountClick) {
                Text(
                    text = stringResource(id = R.string.create_account),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

    }
}

@Composable
fun SignInHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small))
    ) {
        Text(
            text = stringResource(id = R.string.sign_in_screen_title),
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
fun SignInFields(
    emailAddress: String,
    onEmailAddressChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onForgetPasswordClick: () -> Unit,
    onSignInClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.large))
    ) {
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
        Column {
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
            TextButton(
                onClick = onForgetPasswordClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = stringResource(id = R.string.forget_password))
            }
        }
        Button(onClick = onSignInClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.sign_in))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    JobFinderTheme {
        SignInScreen(
            emailAddress = "",
            onEmailAddressChange = {},
            password = "",
            onPasswordChange = {},
            onSignInClick = {},
            onForgetPasswordClick = {},
            onGoogleClick = {},
            onFaceBookClick = {},
            onCreateAccountClick = {},
            modifier = Modifier.padding(dimensionResource(id = R.dimen.medium))
        )
    }
}