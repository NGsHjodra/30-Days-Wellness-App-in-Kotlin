package kekw.ngs.a30daysapp

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kekw.ngs.a30daysapp.model.Day
import kekw.ngs.a30daysapp.ui.theme._30DaysAppTheme

@Composable
fun WellnessItem(
    days: Day,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card (
        modifier = modifier.padding(dimensionResource(R.dimen.padding_small)),
    ){
        Column (
            modifier = Modifier
                .clickable { expanded = !expanded }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ){
            Column (
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            ){
                Text(
                    text = "day ${days.day}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(days.title),
                    style = MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(days.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f) // this does not look good for some image...
                        .clip(MaterialTheme.shapes.medium)
                )

            }
            if (expanded) {
                Text(
                    text = stringResource(days.description),
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysAppTheme {
        WellnessItem(
            days = Day(
                image = R.drawable.day1,
                day = 1,
                title = R.string.day1,
                description = R.string.description1
            )
        )
    }
}