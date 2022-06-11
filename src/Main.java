import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {

            List<Worldcup> world_cups = new ArrayList<>();
            List<Match> matches = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("worldcups.csv"))) {
                String line;

                reader.readLine();

                while ((line = reader.readLine()) != null) {
                    world_cups.add(new Worldcup(line));
                }
            }

            try (BufferedReader reader = new BufferedReader(new FileReader("matches_all.csv"))) {
                String line;

                reader.readLine();

                while ((line = reader.readLine()) != null) {
                    matches.add(new Match(line));
                }
            }

            System.out.println("Number of matches: " + matches.size());

            for (Match match : matches) {
                switch (match.getYear()) {
                    case "2010" -> match.setWorldcup(world_cups.get(0));
                    case "2014" -> match.setWorldcup(world_cups.get(1));
                    case "2018" -> match.setWorldcup(world_cups.get(2));
                }
            }

            Scanner sc = new Scanner(System.in);

            System.out.println("Name of host:");
            String host = sc.nextLine();


            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("selected.csv")))) {
                writer.println("year;stage;date;team_a;team_b;goals_a;goals_b;penalties_a;penalties_b");

                for (Match match : matches) {
                    if (match.getWorldcup().getHost().equalsIgnoreCase(host)) {
                        writer.println(match.getYear() + ";" + match.getStage() +
                                ";" + match.getDate() + ";" + match.getTeam_a() +
                                ";" + match.getTeam_b() + ";" + match.getGoals_a() +
                                ";" + match.getGoals_b() +
                                (match.getPenalties_a() != null?";" + match.getPenalties_a() + ";" + match.getPenalties_b():""));
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            int goal_difference;

            for (Match match : matches) {
                if (match.getWorldcup().getHost().equalsIgnoreCase(host)) {
                    if (match.getGoals_a() > match.getGoals_b()) {
                        goal_difference = match.getGoals_a() - match.getGoals_b();
                        if (max < goal_difference) {
                            max = goal_difference;
                        }
                    } else {
                        goal_difference = match.getGoals_b() - match.getGoals_a();
                        if (max < goal_difference) {
                            max = goal_difference;
                        }
                    }
                }
            }

            System.out.println("2. Maximum goal difference: " + max);

            int bet = 0;

            for (Match match : matches) {
                if (match.getWorldcup().getHost().equalsIgnoreCase(host)) {
                    if (match.getWinnerA()) {
                        bet++;
                    }
                }
            }

            System.out.println("3. The player has won " + bet + " bets.");

            System.out.println("4. Total goals by stage:");

            Map<String, Integer> groups = new TreeMap<>();

            Integer total = 0;

            for (Match match : matches) {
                if (match.getWorldcup().getHost().equalsIgnoreCase(host)) {

                    total = groups.getOrDefault(match.getStage(), 0);
                    groups.put(match.getStage(), match.getTotalGoals() + total);
                }
            }


            for (String group : groups.keySet()) {
                System.out.println(group + ": " + groups.get(group));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
