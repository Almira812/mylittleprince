package ru.samsung.mygame;

import com.badlogic.gdx.Game;
import ru.samsung.mygame.in2;

public class MyGdxGame extends Game {
    public MainMenuScreen mainMenuScreen;
    public ProtectRoseGameScreen protectRoseGameScreen;
    public DrinkRoseGameScreen drinkRoseGameScreen;
    ///public MainMenuScreen planetgame;
    public IntroductionScreen introduction;
    public CleanPlanetScreen cleanPlanetScreen;
    public in2 int2;
    public in3 int3;
    public in4 int4;
    public in5 int5;
    public in6 int6;
    public in7 int7;
    public in8 int8;
    public in9 int9;
    public in10 int10;
    public in11 int11;
    public in12 int12;
    public in13 int13;
    public in14 int14;
    public in15 int15;
    public in16 int16;
    public in17 int17;
    public in18 int18;
    @Override

    public void create() {
        mainMenuScreen = new MainMenuScreen(this);
        protectRoseGameScreen = new ProtectRoseGameScreen(this);
        drinkRoseGameScreen = new DrinkRoseGameScreen(this);
        introduction = new IntroductionScreen(this);
        cleanPlanetScreen = new CleanPlanetScreen(this);
        int2 = new in2(this);
        int3 = new in3(this);
        int4 = new in4(this);
        int5 = new in5(this);
        int6 = new in6(this);
        int7 = new in7(this);
        int8 = new in8(this);
        int9 = new in9(this);
        int10 = new in10(this);
        int11 = new in11(this);
        int12 = new in12(this);
        int13 = new in13(this);
        int14 = new in14(this);
        int15 = new in15(this);
        int16 = new in16(this);
        int17 = new in17(this);
        int18 = new in18(this);
        setScreen(mainMenuScreen);
    }
}