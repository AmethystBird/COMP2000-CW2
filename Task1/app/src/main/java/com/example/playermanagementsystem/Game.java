package com.example.playermanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    //Add level objects to this class
    HashMap<Integer, Level> levels = new HashMap<Integer, Level>();

    //Attributes of game
    String gameTitle = "BASE NAME";
    //int levelAmount = 0;

    void DummyData()
    {
        Level dummyLevel = new Level();
        dummyLevel.levelTitle = "Choose Level";

        levels.put(0, dummyLevel);
    }

    /*List<Level> levels = new ArrayList<Level>()
    {
        {
            //add("Select Level");
        }
    };*/
}
