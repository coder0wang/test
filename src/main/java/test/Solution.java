package test;

public class Solution {
	private boolean doorOpen= false;
	private int floor= 1;
	private int weight= 0;
	final int Y = 1000; // 最大重量
	final int M = 50; // 最高层
	final int BOTTOM_FLOOR = 0; 
	int X = 0;
	//人的总量
	int[] A = {50,89,34,65,78,94,87,71,62,84,59,48,49,65};
	//停靠楼层
	int[] B = {23,12,43,5,6,23,14,35,9,8,43,25,23};
	public Solution(){
		
	}
	public Solution(boolean doorOpen, int floor, int weight, int x, int[] a,
			int[] b) {
		super();
		this.doorOpen = doorOpen;
		this.floor = floor;
		this.weight = weight;
		X = x;
		A = a;
		B = b;
	}
	public void openDoor() {
		doorOpen = true;
	}

	public void closeDoor() {
		checkWeightSensors();
		if (weight <= Y)
			doorOpen = false;
		else
			System.out.println("超重，门不能关！");
	}

	private void checkWeightSensors() {
		weight = (int) (Math.random() * A.length);
		System.out.println("当前乘客总重量是:" + weight + "公斤");
	}

	public void up() {
		if (!doorOpen) {
			if (floor < M) {
				floor++;
				System.out.println("电梯已上到第" + floor + "层");
			} else
				System.out.println("电梯已在顶层，不能再上升");
		} else
			System.out.println("电梯门未关，不能上升！");

	}

	public void down() {
		if (!doorOpen) {
			if (floor > BOTTOM_FLOOR) {
				floor--;
				System.out.println("电梯已下到第" + floor + "层");
			} else
				System.out.println("电梯已在最底层，不能再下降");
		} else
			System.out.println("电梯门未关，不能下降！");

	}

	public void setFloor(int goal) {
		if (goal >= BOTTOM_FLOOR && goal <= M) {
			while (floor != goal) {
				if (floor < goal)
					up();
				else
					down();
			}
			System.out.println("电梯按要求停在第" + goal + "层");
		} else
			System.out.println("没有第" + goal + "层");
	}

	public int getFloor() {
		return floor;
	}

	public boolean isOpen() {
		return doorOpen;
	}

	public int solution(int[] A, int[] B, int M, int X, int Y) {
		Solution e2 = new Solution(); 
		e2.openDoor();    
        e2.closeDoor();    
        e2.up();    
        e2.up();    
        e2.down();    
        System.out.println("电梯在第"+e2.getFloor()+"层");    
        e2.openDoor();    
        e2.closeDoor();    
        e2.down();    
        e2.openDoor();    
        e2.closeDoor();    
        e2.down();    
        e2.down();    
        if(e2.getFloor()!=5&&!e2.isOpen())    
        e2.setFloor(5);    
        e2.openDoor();    
        e2.closeDoor();    
        e2.setFloor(10);
		return  e2.getFloor();
    }
	public static void main(String args[])    
    {    
		int result = 0;
		System.out.println("-------测试开始-------");  
		Solution e2 = new Solution( );    
            
        System.out.println("-------电梯测试结束-------");  
        System.out.println(e2.getFloor());
        result = e2.solution ( e2.A,e2.B,e2.M,e2.X,e2.Y );
        System.out.println(result);
    }   
}