package dev.hayohtee.jobfinder.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.jobfinder.R
import dev.hayohtee.jobfinder.ui.theme.JobFinderTheme
import dev.hayohtee.jobfinder.ui.theme.Rubik

@Composable
fun OnBoardingScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(dimensionResource(id = R.dimen.medium)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium))
        ) {
            Image(
                painter = painterResource(id = R.drawable.undraw_co_workers),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.large))
            )
            Text(
                text = stringResource(id = R.string.onboarding_title),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = stringResource(id = R.string.onboarding_label),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = Rubik,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            )
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30)
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_button_label),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    JobFinderTheme {
        OnBoardingScreen(
            onClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}