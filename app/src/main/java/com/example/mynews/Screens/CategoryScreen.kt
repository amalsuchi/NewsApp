package com.example.mynews.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.Locale.Category


@Composable
fun CategoryContainer(country: String,category:String,navController: NavController){
    Text(
        text = category,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate("homescreen/$country/$category")
            }
            .clip(RoundedCornerShape(10.dp))
            .padding(16.dp)

    )
}

@Composable
fun CategoryScreen(navController: NavController,country:String){
    Column {

        Row(modifier = Modifier
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Card(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            { Text(text = "Select Catagory",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )}
        }

        Row(modifier = Modifier
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Card(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CategoryContainer(country,"general",navController)}
        }
        Row(modifier = Modifier
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Card(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CategoryContainer(country,"technology",navController)}
            Card(modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CategoryContainer(country,"sports", navController)}
        }
        Row(modifier = Modifier
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Card(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CategoryContainer(country,"business",navController)}
            Card(modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CategoryContainer(country,"entertainment", navController)}
        }
        Row(modifier = Modifier
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Card(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CategoryContainer(country,"health",navController)}
            Card(modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CategoryContainer(country,"science", navController)}
        }
    }

}