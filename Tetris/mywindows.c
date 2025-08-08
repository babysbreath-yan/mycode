#include "mywindows.h"

HANDLE handle;

void initHandle()
{
    handle = GetStdHandle(STD_OUTPUT_HANDLE);
    hideCursor();
}

void setColor(int color)
{
    SetConsoleTextAttribute(handle,color);
}

void setPos(int x,int y)
{
    COORD coord = {x*2,y};        //һ������ռ�����ַ���һ����ĸռһ���ַ�
    SetConsoleCursorPosition(handle,coord);
}

void hideCursor()
{
    CONSOLE_CURSOR_INFO info;
    info.bVisible = FALSE;       //���ù���Ƿ�ɼ������ɼ�
    info.dwSize = 1;             //���ù��Ŀ�ȣ�1����100��
    SetConsoleCursorInfo(handle,&info);
}
