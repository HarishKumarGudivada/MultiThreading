
public class Thread2 implements Runnable{

	public static void main(String[] args) {
		Thread2 t=new Thread2();
		Thread t1=new Thread(t,"thread1");
		Thread t2=new Thread(t,"thread2");
		t1.start();
		t2.start();
		
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+": "+i);
			}
		}
	} 
	
	
}
