package it.beije.cilacap.esercizi;

import java.util.ArrayList;

public class MetodiArrayList
{
	public static void main (String args[])
	{
		ArrayList<String> list = new ArrayList<>();
		boolean removed = false;
		
		list.add("La capra");
		list.add(1, "campa");
		list.add("Sopra la panca");
		
		System.out.println(list);
		
		removeIt(list, removed); //metodo remove()
	}
	
	public static void removeIt(ArrayList<String> lista, boolean remove)
	{
		ArrayList<String> copia = new ArrayList<String>(lista);
		remove = copia.remove("La capra");
		System.out.println(copia);
		System.out.println(remove);
	}

}
