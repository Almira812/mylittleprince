package ru.samsung.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import ru.samsung.mygame.in2;

public class MyGdxGame extends Game {
    public MainMenuScreen mainMenuScreen;
    public ProtectRoseGameScreen protectRoseGameScreen;
    public DrinkRoseGameScreen drinkRoseGameScreen; //SecondDayNight
    public DrinkRoseGameScreen1 drinkRoseGameScreen1;
    public DrinkRoseGameScreen2 drinkRoseGameScreen2;
    public DrinkRoseGameScreen3 drinkRoseGameScreen3;
    public DrinkRoseGameScreen4 drinkRoseGameScreen4;
    public IntroductionScreen introduction; //Это планета - астероид
    public CleanPlanetScreen cleanPlanetScreen;

    public volcanooo1 volcanooo1;
    public volcanooo2 volcanooo2;
    public volcanooo3 volcanooo3;
    public volcanooo4 volcanooo4;


    public in2 int2; //Она была чуть больше
    public in3 int3; //И совершено один смотрел
    public in4 int4; // Встал поутру, умылся
    public in5 int5; // И сразу же приведи в порядок
    public in6 int6; // Пора спать

    public in7 int7; // Следующий

    public in8 int8; // Что за крохотный
    public in9 int9; // на все остальные ростки
    public in10 int10; // ...
    public in11 int11;// Пора спать

    public in12 int12; // Следующий

    public in13 int13; // Ах, я насилу проснулась...
    public in14 int14; // Я еще совсем
    public in15 int15; // Как вы прекрасны
    public in16 int16; // Да, правда?
    public in17 int17; // с солнцем
    public in18 int18; //Когда настанет вечер
    public in19 int19; // У вас тут очень холодно
    public in20 int20; // Там, откуда я родом
    public in21 int21; // Подул ветер
    public in22 int22; // Кхе...
    public in23 int23; // Где же ширма?
    public in24 int24; // Я хотел ее принести

    public in24_1 in24_1; // Следующий

    public in25 int25;  // Прощайте
    public in26 int26; // ...
    public in27 int27; // Прощайте
    public in28 int28; // Кхе...
    public in29 int29; // Я была глупа.
    public in30 int30; // Да, да я люблю тебя
    public in31 int31; // Да это было не важно
    public in32 int32; // Как и я
    public in33 int33; // Постарайся быть счастливым
    public in34 int34; // он мне больше не нужен
    public in35 int35; // Но ветер
    public in36 int36; // Не так уж я простужена...
    public in37 int37; // Пойдет мне на пользу
    public in38 int38; // Ведь я цветок

    public FirstDaySun FirstDaySun;
    public FirstDayNight FirstDayNight;
    public SecondDaySun SecondDaySun;
    public SecondDayNight SecondDayNight;
    public ThirdDaySun ThirdDaySun;
    public ThirdDayNight ThirdDayNight;
    public sunset sunset;
    public Tobecontinued Tobecontinued;


    @Override

    public void create() {
        mainMenuScreen = new MainMenuScreen(this);
        protectRoseGameScreen = new ProtectRoseGameScreen(this);
        drinkRoseGameScreen = new DrinkRoseGameScreen(this);
        drinkRoseGameScreen1 = new DrinkRoseGameScreen1(this);
        drinkRoseGameScreen2 = new DrinkRoseGameScreen2(this);
        drinkRoseGameScreen3 = new DrinkRoseGameScreen3(this);
        drinkRoseGameScreen4 = new DrinkRoseGameScreen4(this);
        introduction = new IntroductionScreen(this);
        cleanPlanetScreen = new CleanPlanetScreen(this);

        volcanooo1 = new volcanooo1(this);
        volcanooo2  = new volcanooo2(this);
        volcanooo3 = new volcanooo3(this);
        volcanooo4 = new volcanooo4(this);

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
        sunset = new sunset(this);

        Tobecontinued = new Tobecontinued(this);

        setScreen(mainMenuScreen);
    }
}