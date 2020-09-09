package com.leudroid.jsonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leudroid.mistplay.POJO.Category
import com.leudroid.mistplay.POJO.Game

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById(R.id.text) as TextView

        var gson = Gson()
        var jsonString = """[{
    "list_title": "Mistplay Favorites",
    "games": [
      {
        "title": "RAID: Shadow Legends",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/g ames/raid-shadow-legends/RAID_Portrait.jpg"
      },
      {
        "title": "YAHTZEE® With Buddies Dice Game",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/game s/yahtzeewithbuddies/Yahtzee_Portrait.jpg"
      },
      {
        "title": "Solitaire Grand Harvest - Free Tripeaks Solitaire",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay /games/solitaire-grand-harvest/SolitaireGrandHarvest_Portrait.jpg"
      },
      {
        "title": "Bingo BlitzTM - Bingo Games",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/gam es/bingo-blitz/9726_GenericBanners_pack2_290x420.jpg"
      },
      {
        "title": "SlotomaniaTM Free Slots: Casino Slot Machine Games",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/gam es/slotomania/Slotomania_Portrait.jpg"
      },
      {
        "title": "Caesars Casino: Free Slots Games",
        "img": "https://assets.mistplay.com/images/timeplay/games/caesars/Ca esarsSlots_Portrait.jpg"
      },
      {
        "title": "Bingo Pop - Live Multiplayer Bingo Games for Free",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/game s/bingo-pop/BingoPop_Portrait.jpg"
      },
      {
        "title": "Big Farm: Mobile Harvest – Free Farming Game",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/game s/big-farm-mobile-harvest/BigFarmMobileHarvest_Portrait.jpg"
      },
      {
        "title": "Word Life - Connect crosswords puzzle",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/ga mes/word-life/WorldLife-Portrait.jpg"
      },
      {
        "title": "Wheel of Fortune: Free Play",
        "img": "https://assets.mistplay.com/images/timeplay/games/wheel-of-fo rtune/WOF-portrait.jpg"
      }
    ]
  },
  {
    "list_title": "Fantasy",
    "games": [
      {
        "title": "Monster Legends",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/g ames/monster-legends/Portrait_290x420.png"
      },
      {
        "title": "Park of Monster",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/g ames/parkofmonster/POM-Portrait.png"
      },
      {
        "title": "Wizard of Oz Free Slots Casino",
        "img": "https://assets.mistplay.com/images/timeplay/games/wizard-of -oz-slots/WoZ_Portrait.jpg"
      },
      {
        "title": "Game of Thrones Slots Casino - Free Slot Machines",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/ games/got-slots/GoTSlots_Portrait.jpg"
      },
      {
        "title": "Dragon Mania Legends",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/g ames/dragon-mania/DragonMania_Portrait.jpg"
      },
      {
        "title": "Lords Mobile: Kingdom Wars",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/game s/Lords-Mobile/LordsMobile-Portrait.jpg"
      },
      {
        "title": "The Wizard of Oz Magic Match 3 Puzzles & Games",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/gam es/wizzard-of-oz/WizardOfOz_Portrait.jpg"
      },
      {
        "title": "Romancing SaGa Re;univerSe",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timepl ay/games/romancing-saga/RomancingSaga_Portrait.jpg"
      },
      {
        "title": "RAID: Shadow Legends",
        "img": "https://mistplay-static.s3.amazonaws.com/images/timeplay/g ames/raid-shadow-legends/RAID_Portrait.jpg"
      }
    ]
  }]"""
        //var testModel = gson.fromJson(jsonString, Category::class.java)
        val listType = object : TypeToken<List<Category>>() { }.type
        val newList = gson.fromJson<List<Category>>(jsonString, listType)
        if("RAID: Shadow Legends".equals(newList[0].games[0].title)){
            textView.setText("Match")
        }else{
            textView.setText("Not Match")
        }
    }
}