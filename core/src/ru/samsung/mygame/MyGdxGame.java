package ru.samsung.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import ru.samsung.mygame.in2;

public class MyGdxGame extends Game {
    public MainMenuScreen mainMenuScreen;
    public ProtectRoseGameScreen protectRoseGameScreen;
    public DrinkRoseGameScreen drinkRoseGameScreen;
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
    public in19 int19;
    public in20 int20;
    public in21 int21;
    public in22 int22;
    public in23 int23;
    public in24 int24;
    public in24_1 in24_1;

    public in25 int25;
    public in26 int26;
    public in27 int27;
    public in28 int28;
    public in29 int29;
    public in30 int30;

    public in31 int31;
    public in32 int32;
    public in33 int33;
    public in34 int34;
    public in35 int35;
    public in36 int36;
    public in37 int37;
    public in38 int38;
    public FirstDaySun FirstDaySun;
    public FirstDayNight FirstDayNight;
    public SecondDaySun SecondDaySun;
    public SecondDayNight SecondDayNight;
    public ThirdDaySun ThirdDaySun;
    public ThirdDayNight ThirdDayNight;

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
        int19 = new in19(this);
        int20 = new in20(this);
        int21 = new in21(this);
        int22 = new in22(this);
        int23 = new in23(this);
        int24 = new in24(this);
        in24_1 = new in24_1(this);

        int25 = new in25(this);
        int26 = new in26(this);
        int27 = new in27(this);
        int28 = new in28(this);
        int29 = new in29(this);
        int30 = new in30(this);

        int31 = new in31(this);
        int32 = new in32(this);
        int33 = new in33(this);
        int34 = new in34(this);

        int35 = new in35(this);
        int36 = new in36(this);
        int37 = new in37(this);
        int38 = new in38(this);

        FirstDaySun = new FirstDaySun(this);
        FirstDayNight = new FirstDayNight(this);
        SecondDaySun = new SecondDaySun(this);
        SecondDayNight = new SecondDayNight(this);
        ThirdDaySun = new ThirdDaySun(this);
        ThirdDayNight = new ThirdDayNight(this);

        setScreen(mainMenuScreen);
    }
}