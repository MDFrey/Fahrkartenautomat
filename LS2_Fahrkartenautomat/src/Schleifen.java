
public class Schleifen {

	public static void main(String[] args) {
		/*for(int i=1; i<=20; i=i+1) {
		      System.out.printf("%d ", i*i);
		}*/
		
		int i = 1;
		while(i <= 20) {
			
			if (i == 18) {
				break;
			}
			if (i == 11) {
				i++;
				continue;
				
			}
			System.out.printf("%d |", i*i);
		    i = i+1;
		    
		}

	}

}
