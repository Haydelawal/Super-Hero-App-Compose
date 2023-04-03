package com.hayde117.superheroesappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayde117.superheroesappcompose.data.Hero
import com.hayde117.superheroesappcompose.model.HeroesRepository
import com.hayde117.superheroesappcompose.ui.theme.SuperHeroesAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperheroesApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) {
        /* Important: It is not a good practice to access data source directly from the UI.
        In later units you will learn how to use ViewModel in such scenarios that takes the
        data source as a dependency and exposes heroes.
         */
        val heroes = HeroesRepository.heroes
        HeroesList(heroes = heroes, Modifier.padding(it))

    }
}

/**
 * Composable that displays a Top Bar with an icon and text.
 *
 * @param modifier modifiers to set to this composable
 */
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .size(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroesPreview() {
    SuperHeroesAppComposeTheme {
        SuperheroesApp()
    }
}

//@Composable
//fun SuperHeroApp() {
//
//    Scaffold(
//        topBar = {
//            HeroTopAppBar()
//        }
//    ) {
//        HeroList(heroList = HeroesRepository.heroes)
//    }
//
//}
//
//@Composable
//private fun HeroList(heroList: List<Hero>, modifier: Modifier = Modifier) {
//
//    LazyColumn(
//        modifier =
//        modifier.background(MaterialTheme.colors.background)
//    ) {
//        items(heroList) { hero ->
//            HeroItem(hero = hero)
//        }
//    }
//
//}
//
//@Composable
//fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
//    Card(
//        modifier = modifier
//            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
//            .clip(RoundedCornerShape(16.dp))
//            .height(72.dp),
//        elevation = 2.dp
//
//    ) {
//
//        Row(
//            modifier = modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .padding(end = 8.dp, start = 8.dp, top = 8.dp, bottom =8.dp)
//        ) {
//
//            Column(modifier.fillMaxWidth()) {
//                Text(
//                    style = MaterialTheme.typography.h3,
//                    text = stringResource(id = hero.nameRes)
//                )
//                Text(
//                    style = MaterialTheme.typography.body1,
//                    text = stringResource(id = hero.descriptionRes),
//                )
//
//            }
//
//            Spacer(modifier = Modifier.weight(1f))
//
//            Image(
//                modifier = modifier
//                    .size(56.dp)
//                    .padding(8.dp)
//                    .clip(RoundedCornerShape(8.dp)),
//                painter = painterResource(id = hero.imageRes), contentDescription = stringResource(
//                    id = hero.nameRes
//                ),
//                contentScale = ContentScale.Crop
//            )
//
//        }
//
//    }
//}
//
//@Composable
//fun HeroTopAppBar(modifier: Modifier = Modifier) {
//
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//
//            .background(color = MaterialTheme.colors.surface),
//        verticalAlignment = Alignment.CenterVertically
//
//    ) {
//
//        Text(
//            style = MaterialTheme.typography.h1,
//            text = stringResource(R.string.app_name)
//        )
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SuperHeroesAppComposeTheme {
//        SuperHeroApp()
//    }
//}