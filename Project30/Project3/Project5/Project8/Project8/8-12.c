#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<assert.h>
# if 0
int main()
{
	int a, b, c, d, e;
	for (a = 1; a <= 5; a++)
	{
		for (b = 1; b <= 5; b++)
		{
			for (c = 1; c <= 5; c++)
			{
				for (d = 1; d <= 5; d++)
				{
					for (e = 1; e <= 5; e++)
					{
						if (((a == 3) + (b == 2) == 1)
							&& ((e == 4) + (b == 2) == 1)
							&& ((c == 1) + (d == 2) == 1)
							&& ((d == 3) + (c == 5) == 1)
							&& ((a == 1) + (e == 4) == 1))
						{
							if (a*b*c*d*e == 120)
							{
								printf("a=%d,b=%d,c=%d,d=%d,e=%d", a, b, c, d, e);
							}
						}
					}
				}
			}
		}
	}
	system("pause");
	return 0;
}



int main()
{
	char killer = 0;
	for (killer = 'A'; killer <= 'D'; killer++)
	{
		if ((killer != 'A') + (killer == 'C') + (killer == 'D') + (killer != 'D') == 3)
		{
			printf("%c\n", killer);
		}
	}
	system("pause");
	return 0;
}


/*在屏幕上打印杨辉三角。
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1*/
void Yangangel(int arr[][10], int row, int col)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j <= i; j++)
		{
			if (j == 0 || i == j)
			{
				arr[i][j] = 1;
			}
			else
			{
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}
	}
}
void Show(int arr[][10], int row, int col)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j <= i; j++)
		{
			printf("%-3d ", arr[i][j]);
		}
		printf("\n");
	}
}
int main()
{
	int arr[10][10] = { 0 };
	Yangangel(arr,10,10);
	Show(arr,10,10);
	system("pause");
	return 0;
}


unsigned int reverse_bit(unsigned int value)
{
	int i = 0;
	int ret = 0;
	int bit = 0;
	for (i = 0; i <= 31; i++)
	{
		ret = ret << 1;
		bit = value & 1;
		value = value >> 1;
		ret = bit | ret;
	}
	return ret;
}

int main()
{
	 printf("%u\n", reverse_bit(25));
	system("pause");
	return 0;
}


int add(int x, int y)//①用来实现加法的函数
{
	int tmp = 0;
	do
	{
		tmp = x ^ y;
		y = x & y;
		x = tmp;
		y <<= 1;//进位
	} while (y != 0);
	return x;
}

int avg(int x, int y)//②用来求平均值的函数
{
	return add(((x^y) >> 1), x&y);
}

int main()//主函数
{
	int a = 3;
	int b = 5;
	printf("%d\n", avg(a, b));
	system("pause");
	return 0;
}



void Fun(int arr[])
{
	int i = 0;
	int len = sizeof(arr) / sizeof(arr[0]);
	for (i = 1; i < len; i++)
	{
		arr[0] = arr[0] ^ arr[i];
	}
	printf("%d\n", arr[0]);
}

int main()
{
	int arr[] = { 1,3,6,1,5,3,6 };
    Fun(arr);
	system("pause");
	return 0;
}


int main()
{
	int arr[] = { 1, 5, 5, 1, 7, 6, 7, 8, 8,9,9 };
	int i = 0;
	int len = sizeof(arr) / sizeof(arr[0]);
	for (i = 1; i < len; i++)
	{
		arr[0] = arr[0] ^ arr[i];//^异或运算符，相异为1想用为0.
	}
	printf("%d\n", arr[0]);
	system("pause");
	return 0;
}
#endif

int my_strlen(const char *str)//求字符串长度函数
{
	int count = 0;
	assert(str);
	while (*str != '\0')
	{
		count++;
		str++;
	}
	return count;
}
void reverse(char a[], int left, int right)//逆序函数
{
	while (left < right)
	{
		char tmp = a[left];
		a[left] = a[right];
		a[right] = tmp;
		left++;
		right--;
	}
}
char* reverse_string(char a[])//逆序字符串
{
	int i = 0;
	int left = 0;
	int right = my_strlen(a) - 1;//逆序整个字符串
	reverse(a, left, right);
	//逆序逐个单词
	while (a[i] != '\0')
	{
		left = i;
		while ((a[i] != '\0') && (a[i] != ' '))
		{
			i++;
		}
		right = i - 1;
		reverse(a, left, right);
		if (a[i] != '\0')
			i++;
	}
	return a;
}

int main()
{
	char a[] = "student a am i";
	reverse_string(a);
	printf("%s\n", a);
	system("pause");
	return 0;
}
