package it.beije.cilacap;

import java.util.ArrayList;
import java.util.Scanner;

public class Carte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carte prova = new Carte();
		int G1,G2;
		Scanner sc = new Scanner(System.in);
		System.out.println("G1: scegli una carta da uno a re (sotto forma di numero)j=11,q=12,k=13");
		G1 = sc.nextInt();
		System.out.println("G1: scegli una carta da uno a re (sotto forma di numero)j=11,q=12,k=13");
		G2 = sc.nextInt();
		prova.cartapiualta(G1, G2);
		
	}
	
	void cartapiualta(int g1,int g2) {  //J=11 Q=12 K=13
		int cg1=0,cg2=0;
		int tmp1=g1,tmp2=g2,controllo=0;
		while(true) {
			if(tmp1==g2) {
				break;
			}else {
				if(tmp1>13) {
					tmp1=0;
					controllo=1;
				}else {
					tmp1++;
					cg1++;
				}
			}
		}
		while(true) {
			if(tmp2==g1) {
				break;
			}else {
				if(tmp2>13) {
					tmp2=0;
					controllo=1;
				}else {
					tmp2++;
					cg2++;
				}
			}
		}
		if(controllo==1) {
			if(cg1<cg2) {
				System.out.println("Giocatore 2 vince");
			}else {System.out.println("Giocatore 1 vince");}
		}else if(cg1>cg2) {
			System.out.println("Giocatore 1 vince");
		}else {System.out.println("Giocatore 2 vince");}
		
		}
		
	}


