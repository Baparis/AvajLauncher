/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avajlauncher;

import avajlauncher.Managers.WeatherTower;
import avajlauncher.Vehicles.AircraftFactory;
import java.io.*;

/**
 *
 * @author Stari
 */
public class Simulator {
	// Définition de la fonction main

	public static void main(String[] arg) {
		// Affichage du commentaire Hello world dans la fenêtre de commande

		int iter = 0;
		int i = 0;

		WeatherTower weathertower = new WeatherTower();
		AircraftFactory aircraftFactory = new AircraftFactory();

		if (arg.length < 1) {
			System.out.print("Argument missing !\n");
			return;
		}
		try {
			File file = new File(arg[0]);
			FileInputStream fstream = new FileInputStream(arg[0]);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			int line = 1;
			String[] splitted;

			while ((strLine = br.readLine()) != null) {
				if (line == 1)
					try {
						iter = Integer.parseInt(strLine);
						if (iter < 0) {
							System.out.print("First Line needs to be a positive integer !\n");
							return ;
						}
					} catch (NumberFormatException nfe) {
						System.out.print("Invalid number format.\n" + strLine);
						return;
					} else {
						splitted = strLine.split(" ");
						if (splitted.length < 5) {
							continue;
						}
						if (splitted.length != 5) {
							throw new Exception("Invalid number of parameter in line " + line + ": " + strLine + "\n");
						}
						try {
							aircraftFactory.newAircraft(splitted[0], splitted[1], Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4])).registerTower(weathertower);
						} catch (NumberFormatException nfe) {
							System.out.print("Invalid number in line " + line + ": " + strLine + "n");
							return;
						} catch (Exception e) {
							System.out.print("Error on line " + line +  " : " + strLine + "\n");
							return ;
						}
					}
				line++;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return ;
		}
		while (i++ < iter) {
			weathertower.changeWeather();
		}
	}
}
