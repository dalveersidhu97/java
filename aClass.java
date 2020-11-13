
interface SumRequestListener{
    public String onSumRequest(int x, int y);
}

interface Listener{
	public void onListen(String s);
	public void onClick();
}

class OrderToComputer{
    public void doSum(int x, int y, SumRequestListener sumRequestListener){
        System.out.println(sumRequestListener.onSumRequest(x, y));
    }
	public void listenWhatISaid(String word, Listener listener){
		listener.onListen(word);
	}
	public void listenToClick(Listener clickListener){
		clickListener.onClick();
	}
}

public class aClass
{
	public static void main(String[] args) {
		
		SumRequestListener sumRequestListener = (int x, int y) -> "Sum of "+x+" & "+y+" is "+x+y;
		
		Listener listener = new Listener(){
			@Override
			public void onClick(){
				System.out.println("Got a Click");
			}
			@Override
			public void onListen(String word){
				System.out.println("You Said '"+word+"'");
			}
		};
		
        new OrderToComputer().doSum(5, 3, sumRequestListener);
		new OrderToComputer().listenWhatISaid("Hello", listener);
		new OrderToComputer().listenToClick(listener);
	}
}
