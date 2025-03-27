//package Sheet7;

import java.util.*;

public class BuildingTeams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a - 1).add(b - 1);
            arr.get(b - 1).add(a - 1);

        }
        int[] teams = new int[n];
        Arrays.fill(teams, -1);
        boolean possible = true;
        for (int i = 0; i < n; i++) {
            if (teams[i] == -1) {
                if (!dfs(i, 0, teams, arr)) {
                    possible = false;
                    break;
                }

            }
        }
        if (possible) {
            for (int team : teams) {
                System.out.print(team + 1 + " ");
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
    }

    private static boolean dfs(int v, int team, int[] teams, ArrayList<ArrayList<Integer>> arr) {
        teams[v] = team;
        for (int neighbor : arr.get(v)) {
            if (teams[neighbor] == -1) {
                if (!dfs(neighbor, 1 - team, teams, arr)) {
                    return false;
                }

            } else if (teams[neighbor] == team) {
                return false;
            }
        }

        return true;
    }
}
