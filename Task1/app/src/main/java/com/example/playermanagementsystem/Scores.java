package com.example.playermanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scores extends AppCompatActivity {

    //All games
    Games allGames = new Games();

    //Current filtered games
    List<String> filteredGames = new ArrayList<String>();

    //Current filtered levels
    List<String> filteredLevels = new ArrayList<String>();

    //Current filtered scores
    List<String> filteredScores = new ArrayList<String>();

    //Debug
    boolean errors = false;
    String errorDesc;

    //Old
    //HashMap<Integer, String[]> scores = new HashMap<Integer, String[]>();

    //List of games
    //List<ArrayList<ArrayList>> games = new ArrayList<ArrayList<ArrayList>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        //Generates default data for spinners
        AssignStaticData();

        if (errors == false) {
            FilterData(0, 0);
        }

        //Setting up the spinners
        Spinner gameSpinner = findViewById(R.id.gameSpinner);
        Spinner levelSpinner = findViewById(R.id.levelSpinner);

        if (errors == false) {
            ArrayAdapter<String> gamesAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, filteredGames);
            gamesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            gameSpinner.setAdapter(gamesAdapter);

            ArrayAdapter<String> levelsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, filteredLevels);
            levelsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            levelSpinner.setAdapter(levelsAdapter);
        }
        else
        {
            TextView errorTextView = findViewById(R.id.rankingsLabel);
            errorTextView.setText(errorDesc);
        }
    }

    //Static info normally drawn from database
    public void AssignStaticData()
    {
        //Adding 'game' objects to 'Games' object
        try {
            allGames.DummyData();
        }
        catch (Exception exc)
        {
            errors = true;
            errorDesc = "Couldn't initiate dummy data";
            return;
        }

        //WIP
        //Game game = new Game();
        //game.DummyData();

        int gameNumber = 0;
        for (int i = 0; i < 4; i++)
        {
            gameNumber++;

            String gameNumberStr = String.valueOf(gameNumber);

            Game game = new Game();
            game.gameTitle = "Game #" + gameNumberStr;

            game.DummyData();
            //Adding levels to individual game
            int levelNumber = 0;
            for (int i2 = 0; i2 < 4; i2++)
            {
                levelNumber++;
                String levelNumberStr = String.valueOf(levelNumber);

                Level level = new Level();
                level.levelTitle = "Level #" + levelNumberStr;

                //Adding scores to individual level
                /*for (int i3 = 0; i3 < 4; i3++)
                {
                    Score score = new Score();
                    score.score = 20;
                    score.player = "John Smith";
                }*/

                try {
                    game.levels.put(levelNumber, level);
                }
                catch (Exception exc) {
                    errors = true;
                    errorDesc = "Couldn't add level to game";
                    return;
                }
            }

            try {
                allGames.games.put(gameNumber, game);
            }
            catch (Exception exc) {
                errors = true;
                errorDesc = "Couldn't add game to allGames";
                return;
            }
        }
    }

    public void FilterData(int gameIndex, int levelIndex)
    {
        try {
            //Gets strings from game, level and object classes for display

            //Game game = (Game)allGames.games.get(0);
            //game.gameTitle = "MODIFIED"; //Try this if else fails
            //String gameTitle = (String)game.gameTitle;

            for (int i = 0; i < allGames.games.size(); i++)
            {
                filteredGames.add(allGames.games.get(i).gameTitle);

                for (int i2 = 0; i2 < allGames.games.get(i).levels.size(); i2++)
                {
                    filteredLevels.add(allGames.games.get(i).levels.get(i2).levelTitle);
                }
            }

            //filteredGames.add(allGames.games.get(gameIndex).gameTitle);
            //filteredLevels.add(allGames.games.get(gameIndex).levels.get(levelIndex).levelTitle);
        }
        catch (Exception exc)
        {
            errors = true;
            errorDesc = "Couldn't add to lists in FilterData()";
            return;
        }
    }

    //Button generated activity transitions
    public void ActivityTransition(View view)
    {
        if (view.getId() == R.id.newScoreButton) //Login button clicked
        {
            Intent activityTransition = new Intent(Scores.this, NewScore.class);
            startActivity(activityTransition);
        }
    }
}