package dev.hayohtee.jobfinder.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.jobfinder.R
import dev.hayohtee.jobfinder.ui.theme.JobFinderTheme

@Composable
fun SocialButtonsGroup(
    onGoogleClick: () -> Unit,
    onFaceBookClick: () -> Unit,
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
                onClick = onGoogleClick,
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
                onClick = onFaceBookClick,
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
fun SocialButtonsGroupPreview() {
    JobFinderTheme {
        SocialButtonsGroup(
            onGoogleClick = { },
            onFaceBookClick = { }
        )
    }
}