#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#if 0
//写一个函数返回参数二进制中 1 的个数 
int count_one_bits(unsigned int n)
{
	int count = 0;
	while (n != 0)
	{
		n = n & (n - 1);
		count++;
	}
	return count;
}
int main()
{
	printf("%d\n", count_one_bits(-1));
	system("pause");
	return 0;

}


// 输出一个整数的每一位。 
void print(int n)
{
	if (n > 9)
	{
		print(n / 10);
	}
	printf("%d ", n % 10);
}

int main()
{
	int num = 12345;
	print(num);
	system("pause");
	return 0;
}


//获取一个数二进制序列中所有的偶数位和奇数位,分别输出二进制序列。
void Print(int n)
{
	int count = 0;
	int i = 0;	
	int arr[32] = { 0 };
	while (n)
	{
		arr[i++] = n % 2;
		n = n / 2;
		count++;
	}
	printf("奇数序列：");
	/*for (i = 0; i <= count - 1; i = i + 2)
	{
		printf("%d ", arr[i]);
	}*/
	for (i = count-1; i >= 0; i = i - 2)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
	printf("偶数序列：");
	/*for (i = 1; i <= count - 1; i = i + 2)
	{
		printf("%d ", arr[i]);
	}*/
	for (i = count - 1; i >= 0; i = i - 2)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
int main()
{
	Print(8);
	system("pause");
	return 0;
}


//两个int（32位）整数m和n的二进制表达中，有多少个位(bit)不同
int BitDiffer(int m, int n)
{
	int i = 0;
	int count = 0;
	for (i = 0; i < 32; i++)    
	{
		if (m % 2 != n % 2)
		{
			count++;
		}
		m /= 2;
		n /= 2;
	}
	return count;
}

int main()
{
	int ret = BitDiffer(1999,2299);
	printf("%d\n", ret);
	system("pause");
	return  0;
}
#endif

//5位运动员参加了10米台跳水比赛，有人让他们预测比赛结果 
//A选手说：B第二，我第三；
//B选手说：我第二，E第四；
//C选手说：我第一，D第二；
//D选手说：C最后，我第三；
//E选手说：我第四，A第一；
//比赛结束后，每位选手都说对了一半，请编程确定比赛的名次
/*
int main()
{
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int e = 0;
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
						if ((2 == b && 3 != a) || (2 != b && 3 == a) == 1)
						{
							if ((2 == b && 4 != e) || (2 != b && 4 == e) == 1)
							{
								if ((1 == c && 3 != d) || (1 != c && 3 == d) == 1)
								{
									if ((5 == c && 3 != d) || (5 != c && 3 == d) == 1)
									{
										if ((1 == a && 4 != e) || (1 != a && 4 == e) == 1)
										{
											if (((a != b) && (a != c) && (a != d) && (a != e))
												&&((b != c) && (b != d) && (b != e))
													&& ((c != d) && (c != e))
													&& ((d != e)))
											{
												printf("a= %d, b= %d,c= %d,d= %d,e= %d\n", a, b, c, d, e);
											}
										}
									}
								}
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
*/

/*日本某地发生了一件谋杀案，警察通过排查确定杀人凶手必为4个中 
嫌疑犯的一个。以下为4个嫌疑犯的供词。
A说：不是我。
B说：是C。
C说：是D。
D说：C在胡说
已知3个人说了真话，1个人说的是假话。
现在请根据这些信息，写一个程序来确定到底谁是凶手。
*/
int main()
{
	
	int i;
	int A = 0, B = 0, C = 0, D = 0;
	int FD;//因为c和d的供词刚好对立 表示对立的
	for (i = 1; i <= 4; i++)
	{

		if (i == 1)//A说的假
		{
			A = 1; C = 1; FD = 1; D = 0;
		}
		if (i == 2)//B说的假
		{
			A = 0; C = 0; FD = 1; D = 0;
		}
		if (i == 3)//C说的假
		{
			A = 0; C = 1; FD = 0; D = 0;
		}
		if (i == 4)//D的说的假
		{
			A = 0; C = 1; FD = 1; D = 0;
		}
		if (A + B + C + D + FD == 1 && FD == D)//只有一个人是凶手 当和为1时一个凶手出现 
			//因为CD供词推出的都是D是不是 与上FD==D是为了排除D是D不是的情况 
			printf("A=%d B=%d C=%d D=%d\n", A, B, C, D);
	}


	system("pause");
	return 0;
}


