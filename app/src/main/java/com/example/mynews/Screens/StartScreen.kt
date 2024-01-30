package com.example.mynews.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mynews.ViewModel.NewsViewModel

// StartScreen Composable
@Composable
fun StartScreen(navController: NavController) {
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
            { Text(text = "Select Country",
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
            {CountryContainer("in", navController)}
            Card(modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CountryContainer("us", navController)}
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
            {CountryContainer("ua", navController)}
            Card(modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CountryContainer("ch", navController)}
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
            {CountryContainer("uk", navController)}
            Card(modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
                elevation = CardDefaults.cardElevation(10.dp))
            {CountryContainer("ae", navController)}
        }
    }
}

@Composable
fun CountryContainer(country: String, navController: NavController) {

            Text(
                text = country,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate("categoryscreen/$country")
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
}

