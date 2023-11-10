package principal;

import buscaMinas.BuscaMinas;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuscaMinas bm= new BuscaMinas(24,6);
		Scanner sc=new Scanner(System.in);
		
		while(!bm.esFin()) {
			
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			bm.destapar(x, y);
			
			System.out.println("\n"+bm.getMapa());
		}
		System.out.println("\n"+bm.ganador());
		System.out.println("\n"+bm.getMapa());
	}

}
