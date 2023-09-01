package dev.hayohtee.jobfinder.ui.screen.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.hayohtee.jobfinder.R
import dev.hayohtee.jobfinder.ui.theme.JobFinderTheme

@Composable
fun SignInScreen(
    emailAddress: String,
    onEmailAddressChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    onSignInClicked: () -> Unit,
    onForgetPasswordClicked: () -> Unit,
    onGoogleClicked: () -> Unit,
    onFaceBookClicked: () -> Unit,
    onCreateAccountClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium))
    ) {
        SignInHeader(modifier = Modifier.fillMaxWidth(0.7f))
        SignInFields(
            emailAddress = emailAddress,
            onEmailAddressChanged = onEmailAddressChanged,
            password = password,
            onPasswordChanged = onPasswordChanged,
            onForgetPasswordClicked = onForgetPasswordClicked,
            onSignInClicked = onSignInClicked
        )
        SocialButtonsGroup(
            onGoogleClicked = onGoogleClicked,
            onFaceBookClicked = onFaceBookClicked
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(id = R.string.is_new_user),
                style = MaterialTheme.typography.bodyLarge
            )
            TextButton(onClick = onCreateAccountClicked) {
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
    onEmailAddressChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    onForgetPasswordClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium))
    ) {
        OutlinedTextField(
            value = emailAddress,
            onValueChange = onEmailAddressChanged,
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
            onValueChange = onPasswordChanged,
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
        TextButton(onClick = onForgetPasswordClicked, modifier = Modifier.align(Alignment.End)) {
            Text(text = stringResource(id = R.string.forget_password))
        }
        Button(onClick = onSignInClicked, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.sign_in))
        }
    }
}

@Composable
fun SocialButtonsGroup(
    onGoogleClicked: () -> Unit,
    onFaceBookClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small))
        ) {
            Divider(modifier = Modifier.width(dimensionResource(id = R.dimen.divider_width)))
            Text(
                text = stringResource(id = R.string.continue_with_label),
                style = MaterialTheme.typography.bodyLarge
            )
            Divider(modifier = Modifier.width(dimensionResource(id = R.dimen.divider_width)))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium))
        ) {
            IconButton(
                onClick = onGoogleClicked,
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Unspecified
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_svgrepo),
                    contentDescription = stringResource(id = R.string.google),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.icon_button_size))
                )
            }
            IconButton(
                onClick = onFaceBookClicked,
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Unspecified,
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook_svgrepo),
                    contentDescription = stringResource(id = R.string.facebook),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.icon_button_size))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    JobFinderTheme {
        SignInScreen(
            emailAddress = "",
            onEmailAddressChanged = {},
            password = "",
            onPasswordChanged = {},
            onSignInClicked = {},
            onForgetPasswordClicked = {},
            onGoogleClicked = {},
            onFaceBookClicked = {},
            onCreateAccountClicked = {},
            modifier = Modifier.padding(dimensionResource(id = R.dimen.medium))
        )
    }
}