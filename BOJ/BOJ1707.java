import java.io.*;
import java.util.*;


class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean[] oxcheck;
    static boolean[] checkedone;
    static int K, V, E;
    static boolean result = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); //테스트 개수

        //테스트 개수만큼 반복
        for (int i = 0; i < K; i++) {
            result = true;
            //정점 개수 V, 간선 개수 E 입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 정점 수 만큼 리스트 만듦
            list = new ArrayList[V+1];

            for (int j = 1; j< V+1; j++) {
                list[j] = new ArrayList<>();
            }
            //간선 수 만큼 정보 입력
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                list[A].add(B);
                list[B].add(A);
            }

            if (V <2) {
                System.out.println("NO");
                return;
            }
            checkedone= new boolean[V+1];
            oxcheck = new boolean[V+1];
            visited = new boolean[V+1];

            for (int j = 1; j < V+1; j++) {
                visited[j] = true;
                checkedone[j] = true;
                DFS(j,oxcheck[j]);
                if(!result) {
                    break;
                }
            }

            if(result) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }

    // OX로 판별
    public static void DFS(int num, boolean OX) {
        for (int i:list[num]) {
            if(!checkedone[i]) {
                checkedone[i] = true;
                oxcheck[i] = !OX;
            }
            if ((oxcheck[i]==OX) || (!result)) {
                result = false;
                return;
            }
            if(!visited[i]) {
                visited[i] = true;
                DFS(i,!OX);
            }
        }
    }
}
