#ifndef GAME_H_INCLUDED
#define GAME_H_INCLUDED

/* 游戏逻辑模块 */

#include <stdio.h>
#include <time.h>

//方块结构体
typedef struct{
    int x;
    int y;
    int shape;
    int status;
    int color;
}BLOCK;

//绘制游戏池边框
void windowPrint(int x,int y);

//游戏初始化
void gameInit();

//打印操作说明
void printInfo();

//打印分数等级
void printGradeLevel();

//游戏计时
void gameTime(clock_t start_time);

//打印方块
void printBlock(int x,int y,int shape,int status,int color);

//删除方块
void deleteBlock(int x,int y,int shape,int status);

//产生游戏第一个方块
void startBlock();

//产生下一个方块
void nextBlock();

//拷贝方块
void copyBlock();

//方块下移
//返回值：标志方块是否下落到游戏池底部
int downBlock();

//方块左移
void leftBlock();

//方块右移
void rightBlock();

//方块变形
void changeBlock();

//方块直接落底
void bottomBlock();

//碰撞检测
int crash(int x,int y,int shape,int status);

//保存方块
void save();

//刷新游戏池
void updateGame();

//暂停
void pause();

//消行检测
void lineClear();

//消行下移
void lineDown(int line);

//游戏结束动画
void printOver();

//重新开始提示
void printFinish();

//重新开始游戏
void againGame();

//打印开始图案
void printStart(int x,int y);

//清除开始动画
void deleteStart(int x,int y);

//动画效果->定时（边界控制）
void printAnimation();

//作弊键：Q/q，更换方块形状
void change();

//作弊键：R/r，隐形模式可以看0.5秒已经落下的方块
void see(int fallcolor);

//开始动画后，模式的选择，以及游戏规则的打印
void printExplain();

//打印图案
void printPicture();

#endif // GAME_H_INCLUDED
