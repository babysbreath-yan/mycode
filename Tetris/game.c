#include "game.h"
#include "data.h"
#include "mywindows.h"
#include <conio.h>
#include <mmsystem.h>
#pragma comment(lib,"winmm.lib")   //播放音乐头文件

int k = 0;
int grade = 0;       //分数
int level = 0;       //等级
double falltime;     //方块掉落速度选择
int fallcolor;       //保存方块时的颜色
int a = 0,b = 0, c = 0,d = 0;
int gameMode = 0;        //游戏模式

BLOCK cur_block;     //当前方块
BLOCK next_block;    //下一个方块

void windowPrint(int x,int y)
{
    int i,j;
    for(i = 0;i < 25;i++)
    {
        for(j = 0;j < 26;j++)
        {
            if(windowShape[i][j] == 1)
            {
                setColor(0x70);      ///游戏池边框颜色
                setPos(x+j,y+i);
                printf("%2s","");    //输出两个空格
            }
        }
    }
}

void printInfo()
{
    setColor(0x0b);      ///操作规则颜色
    setPos(31,9);
    printf("操作规则：");
    setPos(31,11);
    printf("按 a 或 A 左移");
    setPos(31,12);
    printf("按 d 或 D 右移");
    setPos(31,13);
    printf("按 s 或 S 下移");
    setPos(31,14);
    printf("按 w 或 W 变形");
    setPos(31,15);
    printf("按 回车 直接下落");
    setPos(31,16);
    printf("按  空格 暂停");
    setPos(31,18);
    printf("还有更多隐藏功能~");
}

void printGradeLevel(int num)
{
    switch(num)
    {
    case 0:
        break;
    case 1:
        grade += 10;break;
    case 2:
        grade += 30;break;
    case 3:
        grade += 50;break;
    case 4:
        grade += 80;break;
    }
    //根据成绩显示等级
    if(grade < 30)
        level = 0;
    else if(grade >= 30 && grade < 60)
        level = 1;
    else if(grade >= 60 && grade < 100)
        level = 2;
    else if(grade >= 100 && grade < 150)
        level = 3;
    else if(grade >=150 && grade < 300)
        level = 4;
    else if(grade >=300 && grade < 500)
        level = 5;
    else
        level = 6;
    //统计一次消1、2、3、4行分别有几次
    if(num == 1)
        a++;
    if(num == 2)
        b++;
    if(num == 3)
        c++;
    if(num == 4)
        d++;
    setColor(0x0e);     ///分数等级颜色
    setPos(3,6);
    printf("分数：%d",grade);
    setPos(3,7);
    printf("等级：%d",level);
    setPos(3,9);
    printf("单次消除一行:%d 次", a);
    setPos(3,10);
    printf("单次消除两行:%d 次", b);
    setPos(3,11);
    printf("单次消除三行:%d 次", c);
    setPos(3,12);
    printf("单次消除四行:%d 次", d);
}

void gameTime(clock_t start_time)
{
    setColor(0x0a);      ///运行时间打印颜色
    setPos(3,3);
    printf("本次游戏已运行：%ld s",(clock() - start_time) / CLOCKS_PER_SEC);
}

void printBlock(int x,int y,int shape,int status,int color)
{
    int i,j;
    for(i = 0;i < 4;i++)
    {
        for(j = 0;j < 4;j++)
        {
            if(block[shape][status][i][j] == 1)
            {
                setColor(color);
                setPos(x+j,y+i);
                printf("■");
            }
        }
    }
}

void deleteBlock(int x,int y,int shape,int status)
{
    int i,j;
    for(i = 0;i < 4;i++)
    {
        for(j = 0;j < 4;j++)
        {
            if(block[shape][status][i][j] == 1)
            {
                setPos(x+j,y+i);
                printf("  ");
            }
        }
    }
}

void startBlock()
{
    //第一个方块：形状/形态/颜色->随机  位置(x,y)固定
    //初始化cur_block变量
    //设置随机数种子（时间永远不一样）
    srand((unsigned)time(NULL));
    cur_block.x = 22;
    cur_block.y = 1;
    cur_block.shape = rand() % 7;
    cur_block.status = rand() % 4;
    cur_block.color = rand() % 0x10;
    if(cur_block.color == 0x00)
    {
        cur_block.color = 0x0f;
    }
    printBlock(cur_block.x,cur_block.y,cur_block.shape,
               cur_block.status,cur_block.color);
}

void nextBlock()
{
    //形状/形态/颜色->随机  位置(x,y)固定
    //初始化next_block
    deleteBlock(next_block.x,next_block.y,next_block.shape,
                next_block.status);
    next_block.x = 34;
    next_block.y = 2;
    next_block.shape = rand() % 7;
    next_block.status = rand() % 4;
    next_block.color = rand() % 0x10;
    if(next_block.color == 0x00)
    {
        next_block.color = 0x0f;
    }
    printBlock(next_block.x,next_block.y,next_block.shape,
               next_block.status,next_block.color);
}

void copyBlock()
{
    //当前方块=下一个方块，并且产生新的“下一个方块”
    cur_block = next_block;
    cur_block.x = 22;
    cur_block.y = 1;
    printBlock(cur_block.x,cur_block.y,cur_block.shape,
               cur_block.status,cur_block.color);
    nextBlock();
}

int downBlock()
{
    //原理：删除正在显示的方块，纵坐标+1，重新打印
    if(crash(cur_block.x,cur_block.y + 1,cur_block.shape,
               cur_block.status) == -1)
    {
        //发生碰撞，方块落到游戏池底部
        //产生新的方块：下一个方块值->当前正在下落的方块，重新产生下一个方块
        //保存方块->检测消行->打印游戏池->产生新方块
        save();
        lineClear();
        updateGame();
        copyBlock();
        return -1;
    }else if(crash(cur_block.x,cur_block.y + 1,cur_block.shape,
               cur_block.status) == -2)
    {
        //游戏结束
        return -2;
    }else{
        deleteBlock(cur_block.x,cur_block.y,cur_block.shape,
                    cur_block.status);
        cur_block.y += 1;
        printBlock(cur_block.x,cur_block.y,cur_block.shape,
                   cur_block.status,cur_block.color);
        return 0;
    }
}

void leftBlock()
{
    if(crash(cur_block.x - 1,cur_block.y,cur_block.shape,
                cur_block.status) == -1)
    {
        //如果发生碰撞，什么都不做，直接返回
        return;
    }
    deleteBlock(cur_block.x,cur_block.y,cur_block.shape,
                cur_block.status);
    cur_block.x -= 1;
    printBlock(cur_block.x,cur_block.y,cur_block.shape,
               cur_block.status,cur_block.color);
}

void rightBlock()
{
    if(crash(cur_block.x + 1,cur_block.y,cur_block.shape,
                cur_block.status) == -1)
    {
        //如果发生碰撞，什么都不做，直接返回
        return;
    }
    deleteBlock(cur_block.x,cur_block.y,cur_block.shape,
                cur_block.status);
    cur_block.x += 1;
    printBlock(cur_block.x,cur_block.y,cur_block.shape,
               cur_block.status,cur_block.color);
}

void changeBlock()
{
    if(crash(cur_block.x,cur_block.y,cur_block.shape,
             (cur_block.status + 1) % 4) == -1)
    {
        return 0;
    }
    deleteBlock(cur_block.x,cur_block.y,cur_block.shape,
                cur_block.status);
    cur_block.status += 1;
    if(cur_block.status == 4)      //status取值范围是0到3
        cur_block.status = 0;
    //cur_block.status = (cur_block.status + 1) % 4;
    printBlock(cur_block.x,cur_block.y,cur_block.shape,
               cur_block.status,cur_block.color);
}

void bottomBlock()
{
    while(1)
    {
        if(crash(cur_block.x,cur_block.y+1,cur_block.shape,cur_block.status) == -1)
        {
            return;
        }else if(crash(cur_block.x,cur_block.y+1,cur_block.shape,cur_block.status) == -2)
        {
            return;
        }else{
            cur_block.y++;
        }
    }
}

int crash(int x,int y,int shape,int status)
{
    //基于下一个位置的检测，参数为下一个位置或下一个形态
    int i,j;
    for(i = 0;i < 4;i++)
    {
        for(j = 0;j < 4;j++)
        {
            if(block[shape][status][i][j] == 1)
            {
                if(windowShape[i + y][j + x -15] == 1)
                {
                    //发生了碰撞
                    if(cur_block.x == 22 && cur_block.y == 1)
                    {
                        //方块产生就发生碰撞，游戏结束
                        return -2;
                    }
                    //方块落到游戏池底部
                    return -1;
                }
            }
        }
    }
    return 0;
}

void save()
{
    //根据方块在界面上的坐标，把坐标对应到游戏池下标的对应位置
    //把方块为1的保存到windowShape数组
    int i,j;
    for(i = 0;i < 4;i++)
    {
        for(j = 0;j < 4;j++)
        {
            if(block[cur_block.shape][cur_block.status][i][j] == 1)
                windowShape[i + cur_block.y][j + cur_block.x - 15] = 1;
        }
    }
}

void updateGame()
{
    int i,j;
    for(i = 23;i > 0;i--)
    {
        for(j = 1;j < 15;j++)
        {
            if(windowShape[i][j] == 1)
            {
                setColor(fallcolor);
                setPos(15 + j,i);
                printf("■");
            }else{
                setColor(0x00);
                setPos(15 + j,i);
                printf("  ");
            }

        }
    }
}

void pause()
{
    while(1)
    {
        if(getch() == 32)
        {
            break;
        }
    }
}

void lineClear()
{
    //遍历windowShape，判断是否有满行：这行所有值加起来为14
    int i,j;
    int number = 0;
    for(i = 23;i > 0;i--)
    {
        int total = 0;
        for(j = 1;j < 15;j++)
        {
            total += windowShape[i][j];
        }
        if(14 == total)
        {
            lineDown(i);
            i += 1;
            //统计一次消几行
            number += 1;
        }
    }
    printGradeLevel(number);
}

void lineDown(int line)
{
    //从第line行开始，i = i - 1
    int i,j;
    for(i = line; i > 1;i--)     //i>1，保证边界不会被下移
    {
        for(j = 1;j < 15;j++)
        {
            windowShape[i][j] = windowShape[i - 1][j];
        }
    }
}

void printOver()
{
    int i,j;
    for(i = 23;i > 0;i--)
    {
        for(j = 1;j < 15;j++)
        {
            setColor(0x76);
            setPos(j + 15,i);
            printf("★");
            Sleep(5);
        }
    }
}

void printFinish()
{
    setColor(0xf2);
    setPos(17,8);
    printf("=======游戏  结束=======");
    setPos(18,10);
    printf(" 您的最终得分为:  %d ",grade);
    setPos(19,12);
    printf(" 按 Y :重新开始 ");
    setPos(19,14);
    printf(" 按 N :结束游戏 ");

    switch(getch())
    {
    case 'y':
    case 'Y':
        againGame();break;
    default:
        printFinish();break;
    }
}

void againGame()
{
    //重置分数、等级、游戏池数据->开始游戏
    k = 0;
    level = 0;
    grade = 0;
    a = 0,b = 0,c = 0,d = 0;
    int i,j;
    for(i = 1;i < 24;i++)
    {
        for(j = 1;j < 15;j++)
        {
            windowShape[i][j] = 0;
        }
    }
    setColor(0x00);
    system("cls");      //清屏
    gameInit();
}

void printStart(int x,int y)
{
    //随机图案颜色
    int color = rand() % 0x10;
    if(color == 0x00)
    {
        color = 0x0f;
    }
    //绘制图案
    setColor(color);
    setPos(x,y);
    printf("■■■■■  ■■■■■  ■■■■■  ■■■■  ■■■    ■■■■");
    setPos(x,y + 1);
    printf("    ■      ■              ■      ■    ■    ■    ■");
    setPos(x,y + 2);
    printf("    ■      ■■■■        ■      ■■■■    ■      ■■■");
    setPos(x,y + 3);
    printf("    ■      ■              ■      ■  ■      ■            ■");
    setPos(x,y + 4);
    printf("    ■      ■■■■■      ■      ■    ■  ■■■  ■■■■");

    setPos(30,20);
    printf("按 空格键 开始游戏！");
}

void deleteStart(int x,int y)
{
    int i,j;
    for(i = y;i <= y+4;i++)
    {
        for(j = x;j <= x+33;j++)
        {
            setPos(j,i);
            printf("  ");
        }
    }
}

void printAnimation()
{
    clock_t time1,time2;
    time1 = clock();
    int x = 5;
    printStart(x,5);
    while(1)
    {
        time2 = clock();
        if(time2 - time1 > 300)       //时间间隔300
        {
            time1 = time2;
            deleteStart(x,5);
            printStart(++x,5);
            if(25 == x)               //重新开始打印
            {
                deleteStart(x,5);
                x = 5;
            }
        }
        //按空格键退出
        if(kbhit())
        {
            switch(getch())
            {
            case 32:
                break;
            }
            break;
        }
    }
    system("cls");          //清屏
}

void change()
{
    int newShape;
    newShape = (cur_block.shape + 1) % 7;      //取值范围0到6
    if(crash(cur_block.x, cur_block.y,newShape,cur_block.status) == -1)       //检测新产生的方块会不会发生碰撞
    {
        return;      //如果碰撞，就返回
    }
    deleteBlock(cur_block.x,cur_block.y,cur_block.shape,cur_block.status);         //已经检测过不会碰撞，就删除原有方块
    cur_block.shape = newShape;
    cur_block.color = rand() % 0x10;
    if(cur_block.color == 0x00)
    {
        cur_block.color = 0x0f;
    }
    printBlock(cur_block.x,cur_block.y,cur_block.shape,cur_block.status,cur_block.color);         //打印新方块
}

void see(int fallcolor)
{
    int i,j;
    for(i=23;i>0;i--)
    {
        for(j=1;j<15;j++)
        {
            if(windowShape[i][j] == 1)
            {
                setColor(fallcolor);
                setPos(15+j,i);
                printf("■");
            }else{
                setColor(0x00);
                setPos(15+j,i);
                printf("  ");
            }
        }
    }
}

void printExplain()
{
    setColor(0x07);
    setPos(20,4);
    printf("■□■□■□■□■□■□■□■□");
    setPos(20,6);
    setColor(0x0e);
    printf("◇模式选择：");
    setPos(20,7);
    setColor(0x06);
    printf("正常模式（按 b 或 B ）");
    setPos(20,8);
    printf("魔鬼模式（按 n 或 N ）");
    setPos(20,9);
    printf("隐形模式（按 m 或 M ）");
    setPos(20,11);
    setColor(0x0e);
    printf("◇玩法介绍：");
    setPos(20,12);
    setColor(0x06);
    printf("按 a 或 A 左移");
    setPos(20,13);
    printf("按 d 或 D 右移");
    setPos(20,14);
    printf("按 s 或 S 下移");
    setPos(20,15);
    printf("按 w 或 W 变形");
    setPos(20,16);
    printf("按 回车 直接下落");
    setPos(20,17);
    printf("按  空格 暂停");
    setPos(20,19);
    setColor(0x0e);
    printf("◇隐藏功能透露：");
    setColor(0x06);
    setPos(20,20);
    printf("按 e 或 E 减速");
    setPos(20,21);
    printf("按 q 或 Q 更换下落方块");
    setPos(20,22);
    printf("按 r 或 R 在隐形模式下显示0.5秒");
    setPos(30,24);
    setColor(0x0e);
    printf("快选择模式开始游戏吧~");
}

void printPicture()
{
    setColor(0x02);
    setPos(3,15);
    printf("    _    _");
    setPos(3,16);
    printf("   (o)--(o)");
    setPos(3,17);
    printf("  /.______.\\");
    setPos(3,18);
    printf("  \\________/");
    setPos(3,19);
    printf(" ./        \\.");
    setPos(3,20);
    printf("( .        , )");
    setPos(3,21);
    printf(" \\ \\_\\\\//_/ /");
    setPos(3,22);
    printf("  ~~  ~~  ~~");
}

void gameInit()
{
    //初始化句柄，必须放到最开始
    initHandle();
    //开始动画
    printAnimation();
    //选择模式以及介绍规则
    printExplain();
    while(1)
    {
        if(kbhit())
        {
            switch(getch())
            {
            //正常模式
            case 'b':
            case 'B':
                falltime = 0.45;
                fallcolor = 0x6e;
                gameMode = 1;
                break;
            //魔鬼模式
            case 'n':
            case 'N':
                falltime = 0.2;
                fallcolor = 0x6e;
                gameMode = 2;
                break;
            //隐形模式
            case 'm':
            case 'M':
                falltime = 0.45;
                fallcolor = 0x00;
                gameMode = 3;
                break;
            //默认选择正常模式
            default:
                falltime = 0.45;
                fallcolor = 0x6e;
                gameMode = 1;
                break;
            }
            break;
        }
    }
    system("cls");
    windowPrint(15,0);
    printInfo();
    printGradeLevel(0);
    //打印当前模式
    switch(gameMode)
    {
    case 1:
        setColor(0x0d);
        setPos(3,1);
        printf("当前模式：正常模式");
        break;
    case 2:
        setColor(0x05);
        setPos(3,1);
        printf("当前模式：魔鬼模式");
        break;
    case 3:
        setColor(0x05);
        setPos(3,1);
        printf("当前模式：隐形模式");
        break;
    }
    printPicture();
    //游戏开始时间
    clock_t startTime = clock();

    //定时器
    clock_t time1,time2;
    time1 = clock();

    startBlock();
    nextBlock();
    while(1)
    {
        //检测是否有按键按下
        if(kbhit())
        {
            switch(getch())  //获取按下的按键
            {
                //方块变形
            case 'w':
            case'W':
            case 72:
                changeBlock();break;
                //方块左移
            case 'a':
            case 'A':
            case 75:
                leftBlock();break;
                //方块右移
            case 'd':
            case 'D':
            case 77:
                rightBlock();break;
                //方块下移
            case 's':
            case 'S':
            case 80:
                downBlock();break;
                //暂停
            case 32:
                pause();break;
                //方块落底
            case 13:
                bottomBlock();break;
                //（作弊键）更换方块
            case 'Q':
            case 'q':
                change();break;
                //（作弊键）速度变慢
            case 'e':
            case 'E':
                falltime += 0.05;break;
                //（作弊键）隐形模式可以看0.5秒已经落下的方块
            case 'r':
            case 'R':
                fallcolor = 0x6e;
                see(fallcolor);
                Sleep(500);
                fallcolor = 0x00;
                see(fallcolor);
                break;
            }
        }
        time2 = clock();
        //每0.45s下落一次
        //(time2 - time1) / CLOCKS_PER_SEC > 0.45
        if(time2 - time1 > falltime * CLOCKS_PER_SEC)
        {
            //游戏计时
            gameTime(startTime);
            if(downBlock() == -2)
                break;
            time1 = time2;
        }
        //得分越高，速度越快
        if(grade > 30 && k == 0)
            falltime -= 0.05,k++;
        else if(grade > 90 && k == 1)
            falltime -= 0.05,k++;
        else if(grade > 120 && k ==2)
            falltime -= 0.05,k++;
        else if(grade > 200 && k ==3)
            falltime -= 0.05,k++;
    }
    printOver();
    printFinish();
}
