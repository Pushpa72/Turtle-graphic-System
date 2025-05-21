public class PlayerStats {
    class Player {
        String name;
        int age;
        String team;
        Player(String name, int age, String team) {
            this.name = name;
            this.age = age;
            this.team = team;
        }
        void displayInfo() {
            System.out.println(name + ", Age: " + age + ", Team: " + team);
        }
    }

    // FootballkoStats
    class FootballStats extends Player {
        int goals;
        int assists;
        FootballStats(String name, int age, String team, int goals, int assists) {
            super(name, age, team);
            this.goals = goals;
            this.assists = assists;
        }
        void showFootballStats() {
            displayInfo();
            System.out.println("Football Stats: Goals: " + goals + ", Assists: " + assists);
        }
    }

    // Cricket Stats
    class CricketStats extends Player {
        int runs;
        int wickets;
        CricketStats(String name, int age, String team, int runs, int wickets) {
            super(name, age, team);
            this.runs = runs;
            this.wickets = wickets;
        }
        void showCricketStats() {
            displayInfo();
            System.out.println("Cricket Stats: Runs: " + runs + ", Wickets: " + wickets);
        }
    }

    // Driver (main method)
    public static void main(String[] args) {
        PlayerStats app = new PlayerStats();

        FootballStats footballPlayer = app.new FootballStats("Messi", 36, "Inter Miami", 30, 10);
        CricketStats cricketPlayer = app.new CricketStats("Virat", 35, "India", 100000, 4);

        footballPlayer.showFootballStats();
        cricketPlayer.showCricketStats();
    }
}
