package com.player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nameTeam;
        boolean exit=false;
        int choice=0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Player> foundedPlayers = new ArrayList<>();
        while(!exit){
            printMenu();
            System.out.println("Do your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    exit=true;
                    System.out.println("See you soon");
                    break;

                case 1:
                    System.out.println ("INSERT NEW TEAM");
                    System.out.println ("Name :");
                    String name = scanner.next();

                    System.out.println ("Year Of Foundation ");
                    try {int year = scanner.nextInt();
                        Team team = new Team(name, year);
                        teams.add(team);
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error Value");
                        choice = 0;
                    }
                    break;
                case 2:
                    System.out.println ("INSERT NEW PLAYER");
                    System.out.println("Name Team :");
                    nameTeam = scanner.next();

                    for(int i = 0; i < teams.size(); i++) {
                        if(teams.get(i).getName().equalsIgnoreCase(nameTeam)) {

                            System.out.println ("INFO PLAYER");
                            System.out.println ("Name :");
                            String namePlayer = scanner.next();

                            System.out.println ("Surname :");
                            String surname = scanner.next();

                            System.out.println ("Andress :");
                            String address = scanner.next();

                            System.out.println ("Fiscal Code :");
                            String fiscalCode = scanner.next();

                            System.out.println (" Role :");
                            String role = scanner.next();

                            System.out.println ("T-shirt number :");
                            int numberShirt = 0;
                            try {numberShirt = scanner.nextInt();}
                            catch (InputMismatchException e) {
                                System.out.println("Error Value ");
                                choice = 0;
                            }

                            Player player = new Player(role, numberShirt, namePlayer, surname, address, fiscalCode);
                            teams.get(i).addPlayer(player);
                        }
                    }

                        System.out.println("Error team not found");
                    break;
                case 3:
                    System.out.println ("SEARCH PLAYER BY NAME OR SURNAME");
                    System.out.println ("Name Team :");
                    nameTeam = scanner.next();

                    for(int i = 0; i < teams.size(); i++) {
                        if(teams.get(i).getName().equalsIgnoreCase(nameTeam)) {
                            System.out.println ("::> Name or Surname Player <::");
                            System.out.print ("::> ");
                            String namePlayer = scanner.next();

                            foundedPlayers = teams.get(i).findPlayerByName(namePlayer);

                            System.out.println("Players Found");
                            break;
                        }
                    }

                    for(int i = 0; i < foundedPlayers.size(); i++)
                        System.out.println(foundedPlayers.get(i).toString());

                        System.out.println("Team not found");
                    break;
                case 4:

                    System.out.println ("SEARCH PLAYER BY ROLE ");
                    System.out.println ("Name Team :");
                    nameTeam = scanner.next();

                    for(int i = 0; i < teams.size(); i++) {
                        if(teams.get(i).getName().equalsIgnoreCase(nameTeam)) {
                            System.out.println ("Role Player :");
                            String rolePlayer = scanner.next();

                            foundedPlayers = teams.get(i).findPlayerByRole(rolePlayer);

                            System.out.println("Players Found :");
                            break;
                        }
                    }

                    for(int i = 0; i < foundedPlayers.size(); i++)
                        System.out.println(foundedPlayers.get(i).toString());

                        System.out.println("Role not found");
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println ("Press:");
        System.out.println ("0: Quit");
        System.out.println ("1: Insert new team");
        System.out.println ("2: Insert new player");
        System.out.println ("3: Search player by name/surname");
        System.out.println ("4: Search player by role");
    }
}
