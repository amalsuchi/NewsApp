package com.example.mynews.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

import com.example.mynews.Domain.Response
import com.example.mynews.ViewModel.NewsViewModel

@Composable
fun HomeScreen(navController: NavController, country: String,catagory:String) {
    val viewModel: NewsViewModel = hiltViewModel()
    val newsResponse by viewModel.news.collectAsState()


    remember(country,catagory) {
        viewModel.getNews(country,catagory)
        true // Remember the lambda result to prevent recomposition loop
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        when (val response = newsResponse) {
            is Response.Loading -> {
                CircularProgressIndicator()
            }
            is Response.Success -> {
                response.data?.articles?.let { articles ->
                    if (articles.isNotEmpty()) {

                        LazyColumn (modifier = Modifier.padding(8.dp)){
                            items(articles) { article ->
                                Card (modifier = Modifier
                                    .padding(8.dp, 4.dp)
                                    .fillMaxWidth()
                                    ,
                                    shape = RoundedCornerShape(10.dp),
                                    elevation = CardDefaults.cardElevation(10.dp)
                                ){
                                    Column(modifier = Modifier.fillMaxSize()) {
                                        Row(
                                            Modifier.padding(4.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween){
                                            Text(modifier = Modifier
                                                .weight(2f)
                                                .padding(4.dp),
                                                text = article.title,
                                                textAlign = TextAlign.Left,
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.SemiBold)

                                            Box(modifier = Modifier
                                                .weight(1f)
                                                .height(100.dp)
                                                .width(100.dp)
                                                .clip(RoundedCornerShape(10.dp)),
                                                contentAlignment = Alignment.Center
                                            ){
                                                Column(modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(10.dp))){

                                                    Log.d("image","${article.urlToImage}")
                                                    AsyncImage(
                                                        modifier = Modifier
                                                            .clip(RoundedCornerShape(10.dp))
                                                            .padding(4.dp),
                                                        model = article.urlToImage,
                                                        contentDescription ="",
                                                        contentScale = ContentScale.FillBounds,
                                                        //oaceholder for our image
                                                    )
                                                }

                                            }
                                        }
                                        Row (modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(4.dp)
                                            .clip(
                                                RoundedCornerShape(10.dp)
                                            )
                                            .background(Color.LightGray)){
                                            Text(text = article.description, modifier = Modifier.padding(8.dp),
                                                fontSize = 16.sp)
                                        }
                                    }

                                }

                            }
                        }
                    } else {
                        Text("No articles found.")
                    }
                }
            }
            is Response.Error -> {
                Text(text = response.message ?: "An error occurred")
            }
        }
    }
}