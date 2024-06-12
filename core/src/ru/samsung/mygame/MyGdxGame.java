package ru.samsung.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;

import ru.samsung.mygame.in2;

public class MyGdxGame extends Game {
    Music music;

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

    public asteroud325 asteroud325;
    public asteroud326 asteroud326;
    public asteroud329 asteroud329;
    public asteroud330 asteroud330;
    public earth earth;

    public king king;

    public ambitious ambitious;
    public ambitious1 ambitious1;
    public ambitious2 ambitious2;

    public fonar fonar;
    public fonar1 fonar1;
    public fonar2 fonar2;
    public fonar3 fonar3;

    public geograf geograf;
    public geograf1 geograf1;
    public geograf2 geograf2;
    public geograf3 geograf3;
    public geograf4 geograf4;
    public geograf5 geograf5;
    public geograf6 geograf6;
    public geograf7 geograf7;

    public FourthDaySun FourthDaySun; //первая встреча со змеей

    public snake snake;
    public snake1 snake1;
    public snake2 snake2;
    public snake3 snake3;
    public snake4 snake4;
    public snake5 snake5;
    public snake6 snake6;
    public snake7 snake7;
    public snake8 snake8;
    public snake9 snake9;
    public snake10 snake10;
    public snake11 snake11;
    public snake12 snake12;

    public FourthDayNight FourthDayNight;

    public next4 next4;

    public FifthDaySun FifthDaySun;

    public fox fox; //before
    public fox1 fox1;
    public fox2 fox2;
    public fox3 fox3;
    public fox4 fox4;
    public fox5 fox5;
    public fox6 fox6;
    public fox7 fox7;
    public fox8 fox8;

    public FifthDaySunTwo FifthDaySunTwo;

    public gamefox gamefox;

    public fx fx; //after
    public fx1 fx1;
    public fx2 fx2;
    public fx3 fx3;
    public fx4 fx4;
    public fx5 fx5;
    public fx6 fx6;
    public fx7 fx7;
    public fx8 fx8;
    public fx9 fx9;
    public fx10 fx10;
    public fx11 fx11;

    public FifthDayNight FifthDayNight;

    public next5 next5;

    public SixthDaySun SixthDaySun; // вторая встреча со змеей

    public snk snk;
    public snk1 snk1;
    public snk2 snk2;
    public snk3 snk3;
    public snk4 snk4;
    public snk5 snk5;

    public gamesnake gamesnake;


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

        asteroud325 = new asteroud325(this); //король
        asteroud326 = new asteroud326(this); //честолюбец
        asteroud329 = new asteroud329(this); //фонарщик
        asteroud330 = new asteroud330(this); //географ
        earth = new earth(this);

        king = new king(this);

        ambitious = new ambitious(this);
        ambitious1 = new ambitious1(this);
        ambitious2 = new ambitious2(this);

        fonar = new fonar(this);
        fonar1 = new fonar1(this);
        fonar2 = new fonar2(this);
        fonar3 = new fonar3(this);

        geograf = new geograf(this);
        geograf1 = new geograf1(this);
        geograf2 = new geograf2(this);
        geograf3 = new geograf3(this);
        geograf4 = new geograf4(this);
        geograf5 = new geograf5(this);
        geograf6 = new geograf6(this);
        geograf7 = new geograf7(this);

        FourthDaySun = new FourthDaySun(this);

        snake = new snake(this);
        snake1 = new snake1(this);
        snake2 = new snake2(this);
        snake3 = new snake3(this);
        snake4 = new snake4(this);
        snake5 = new snake5(this);
        snake6 = new snake6(this);
        snake7 = new snake7(this);
        snake8 = new snake8(this);
        snake9 = new snake9(this);
        snake10 = new snake10(this);
        snake11 = new snake11(this);
        snake12 = new snake12(this);

        FourthDayNight = new FourthDayNight(this);

        next4 = new next4(this);

        FifthDaySun = new FifthDaySun(this); // встреча с лисом

        fox = new fox(this);
        fox1 = new fox1(this);
        fox2 = new fox2(this);
        fox3 = new fox3(this);
        fox4 = new fox4(this);
        fox5 = new fox5(this);
        fox6 = new fox6(this);
        fox7 = new fox7(this);
        fox8 = new fox8(this);

        FifthDaySunTwo = new FifthDaySunTwo(this);

        gamefox = new gamefox(this);

        fx = new fx(this);
        fx1 = new fx1(this);
        fx2 = new fx2(this);
        fx3 = new fx3(this);
        fx4 = new fx4(this);
        fx5 = new fx5(this);
        fx6 = new fx6(this);
        fx7 = new fx7(this);
        fx8 = new fx8(this);
        fx9 = new fx9(this);
        fx10 = new fx10(this);
        fx11 = new fx11(this);

        FifthDayNight = new FifthDayNight(this);

        next5 = new next5(this);

        SixthDaySun = new SixthDaySun(this);

        snk = new snk(this);
        snk1 = new snk1(this);
        snk2 = new snk2(this);
        snk3 = new snk3(this);
        snk4 = new snk4(this);
        snk5 = new snk5(this);

        gamesnake = new gamesnake(this);

        setScreen(mainMenuScreen);

    }

    public void playMenuMusic(){
        music = Gdx.audio.newMusic(Gdx.files.internal("music/7. November Sun (ft. Claudia Lessing) (MASTER).mp3")); //одна для всех music
        music.setLooping(true);
        music.play();
    }
    public void stopMenuMusic(){
        music.setLooping(false);
        music.stop();
    }
    public void playGameMusic(){

    }
    public void stopGameMusic(){

    }
}