package data;

import java.util.Vector;

public class Person {
	public int flighttype;		//�������͡�����
	public int seattype;		//���ҡ���λ����
	public int special;        	//�ر��ÿ�(�Ϻ�����𿨻�Ա��������˳�����Ӣ,�Ϻ�����������Ա��������˾�Ӣ,��ѧ�������񡢺�Ա)
	public float eairfare;     	//���ò�Ʊ��
	public int isUSA;          	//�����Ƿ��漰����
	
	public Person()
	{
		this.flighttype=-1;
		this.seattype=-1;
		this.special=-1;
		this.eairfare=-1;
		this.isUSA=-1;
	}
	
	public Person(int f, int se, int sp, float ea, int is)
	{
		this.flighttype=f;
		this.seattype=se;
		this.special=sp;
		this.eairfare=ea;
		this.isUSA=is;
	}
}
