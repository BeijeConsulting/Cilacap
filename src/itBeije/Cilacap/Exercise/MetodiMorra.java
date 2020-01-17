package itBeije.Cilacap.Exercise;

public class MetodiMorra {
	
	public static void cinesiamo(MorraCinese players)
	{
		players.p1=players.p1.toLowerCase();
		switch(players.p1) {
		
		case "sasso":
				if(players.p2.equalsIgnoreCase("carta"))
					{
						System.out.println(players.p2 + " batte " + players.p1 + " Il vincitore è il giocatore 2");
					}
				else
				{
					if(players.p2.equalsIgnoreCase("forbice"))
					{
						System.out.println(players.p1 + " batte " + players.p2 + " Il vincitore è il giocatore 1");
					}
					else
						System.out.println("pareggio");
				}
				break;
		case "carta":
				if(players.p2.equalsIgnoreCase("forbice"))
				{
					System.out.println(players.p2 + " batte " + players.p1 + " Il vincitore è il giocatore 2");
				}
				else
				{
					if(players.p2.equalsIgnoreCase("sasso"))
					{
						System.out.println(players.p1 + " batte " + players.p2 + " Il vincitore è il giocatore 1");
					}
					else
						System.out.println("pareggio");
				}
				break;
		case "forbice":
				if(players.p2.equalsIgnoreCase("sasso"))
				{
					System.out.println(players.p2 + " batte " + players.p1 + " Il vincitore è il giocatore 2");
				}
				else
				{
					if(players.p2.equalsIgnoreCase(" carta"))
					{
						System.out.println(players.p1 + " batte " + players.p2 + "Il vincitore è il giocatore 1");
					}
					else
						System.out.println("pareggio");
				}
				break;
	}
	
	}
}
