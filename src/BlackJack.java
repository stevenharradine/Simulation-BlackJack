/*
 *      author:  Steven J. Harradine
 *
 *    filename:  BlackJack.java
 *
 *     started:  20060305
 *    finished:  200603xx
 *
 * description:  This program will simulation the effectiveness of counting cards
 *               in black jack including: high / low count
 *
 *    features:  seating position
 *               number of decks
 *               number of players
 *
 */
import java.util.*;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BlackJack {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);	// input stream
		JSONParser parser = new JSONParser();

		// Configuration with default vaules
		// this should be overwritten with the configuration.json file
		Integer number_of_hands_to_simulate  = 1;
		int     number_of_seats_at_the_table = 1;
		int     number_of_decks_in_shoe      = 1;
		float   playerChips                  = 10;
		
		System.out.println ("\t\tBlack Jack Sim");
		System.out.println ("\t\t~~~~~~~~~~~~~~");

		try {
			Object obj = parser.parse(new FileReader("configuration.json"));
			JSONObject jsonObject = (JSONObject) obj;

			number_of_hands_to_simulate = Integer.parseInt (jsonObject.get("number_of_hands_to_simulate").toString());
			number_of_seats_at_the_table = Integer.parseInt (jsonObject.get("number_of_seats_at_the_table").toString());
			number_of_decks_in_shoe = Integer.parseInt (jsonObject.get("number_of_decks_in_shoe").toString());
			playerChips = Float.parseFloat (jsonObject.get("playerChips").toString());
		} catch (Exception exception) {
			System.out.println ("Error reading configuration" + exception.getMessage());
		}

		Table table = new Table (
			number_of_seats_at_the_table,
			number_of_decks_in_shoe
		);

		table.addPlayer (new Player13 (playerChips), 0);
		table.addPlayer (new Player14 (playerChips), 1);
		table.addPlayer (new Player15 (playerChips), 2);
		table.addPlayer (new Player16 (playerChips), 3);
		table.addPlayer (new Player17 (playerChips), 4);
		table.addPlayer (new Player18 (playerChips), 5);

		table.play(number_of_hands_to_simulate);
	}
}
