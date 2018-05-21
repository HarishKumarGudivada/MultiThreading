

public class Threads{

	public static void main(String[] args) {
		Threads th=new Threads();
		Printer p=new Printer();
		Thread t1=new Thread(new printEvenOdd(p,false,10));
		Thread t2=new Thread(new printEvenOdd(p,true,10));
		t1.start();
		t2.start();
	}

}

class printEvenOdd implements Runnable{
	
	Printer p=null;
	int max=0;
	boolean odd=false;

	 printEvenOdd(Printer print,boolean isOdd,int max){
		p=print;
		odd=isOdd;
		this.max=max;
	}
	
	@Override
	public void run() {
		 int number = odd == false ? 2 : 1;		
		while(max>=number){
			if (odd) {
				try {
					p.threadExecute1(number);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					p.threadExecute2(number);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			number+=2;
		}
	}
	
}


class Printer{

	boolean isOdd = false;
	public void threadExecute1(int number) throws InterruptedException{
		synchronized (this) {
			if (isOdd) {
				wait();
			}
			System.out.println("Odd :"+number);
			isOdd=true;
			notifyAll();
		}
		
	}

	public void threadExecute2(int number) throws InterruptedException{
		synchronized (this) {
			if(!isOdd){	
				wait();
			}
			System.out.println("Even :"+number);
			isOdd=false;
			notifyAll();
		}
		
	}
}
