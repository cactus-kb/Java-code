#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#if 0
//дһ���������ز����������� 1 �ĸ��� 
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


// ���һ��������ÿһλ�� 
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


//��ȡһ�������������������е�ż��λ������λ,�ֱ�������������С�
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
	printf("�������У�");
	/*for (i = 0; i <= count - 1; i = i + 2)
	{
		printf("%d ", arr[i]);
	}*/
	for (i = count-1; i >= 0; i = i - 2)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
	printf("ż�����У�");
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


//����int��32λ������m��n�Ķ����Ʊ���У��ж��ٸ�λ(bit)��ͬ
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

//5λ�˶�Ա�μ���10��̨��ˮ����������������Ԥ�������� 
//Aѡ��˵��B�ڶ����ҵ�����
//Bѡ��˵���ҵڶ���E���ģ�
//Cѡ��˵���ҵ�һ��D�ڶ���
//Dѡ��˵��C����ҵ�����
//Eѡ��˵���ҵ��ģ�A��һ��
//����������ÿλѡ�ֶ�˵����һ�룬����ȷ������������
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

/*�ձ�ĳ�ط�����һ��ıɱ��������ͨ���Ų�ȷ��ɱ�����ֱ�Ϊ4���� 
���ɷ���һ��������Ϊ4�����ɷ��Ĺ��ʡ�
A˵�������ҡ�
B˵����C��
C˵����D��
D˵��C�ں�˵
��֪3����˵���滰��1����˵���Ǽٻ���
�����������Щ��Ϣ��дһ��������ȷ������˭�����֡�
*/
int main()
{
	
	int i;
	int A = 0, B = 0, C = 0, D = 0;
	int FD;//��Ϊc��d�Ĺ��ʸպö��� ��ʾ������
	for (i = 1; i <= 4; i++)
	{

		if (i == 1)//A˵�ļ�
		{
			A = 1; C = 1; FD = 1; D = 0;
		}
		if (i == 2)//B˵�ļ�
		{
			A = 0; C = 0; FD = 1; D = 0;
		}
		if (i == 3)//C˵�ļ�
		{
			A = 0; C = 1; FD = 0; D = 0;
		}
		if (i == 4)//D��˵�ļ�
		{
			A = 0; C = 1; FD = 1; D = 0;
		}
		if (A + B + C + D + FD == 1 && FD == D)//ֻ��һ���������� ����Ϊ1ʱһ�����ֳ��� 
			//��ΪCD�����Ƴ��Ķ���D�ǲ��� ����FD==D��Ϊ���ų�D��D���ǵ���� 
			printf("A=%d B=%d C=%d D=%d\n", A, B, C, D);
	}


	system("pause");
	return 0;
}


