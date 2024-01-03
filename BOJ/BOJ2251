import java.io.*;
import java.util.*;

class Main {

    static class Bottle{
        int a, b;
        Bottle(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static boolean[][] visited;
    static boolean[] result;
    static int limitA,limitB,limitC;
    static Queue<Bottle> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limitA = Integer.parseInt(st.nextToken());
        limitB = Integer.parseInt(st.nextToken());
        limitC = Integer.parseInt(st.nextToken());
        visited = new boolean[limitA + 1][limitB + 1];
        result = new boolean[limitC +1];
        queue = new LinkedList<>();
        queue.add(new Bottle(0,0));

        while(!queue.isEmpty()) {
            int a = queue.peek().a;
            int b = queue.poll().b;
            int c = limitC-a-b;

            // a->b
            if (a<=(limitB-b)) {
                if (!visited[0][b + a]) {
                    queue.add(new Bottle(0, b + a));
                    visited[0][b + a] = true;
                    result[c] = true;
                }
            }
            else {
                if (!visited[a - (limitB - b)][limitB]) {
                    queue.add(new Bottle(a - (limitB - b), limitB));
                    visited[a - (limitB - b)][limitB] = true;
                }
            }

            // a->c
            //a+b+c = limitC
            if (a<=(limitC-c)) {
                if (!visited[0][b]) {
                    queue.add(new Bottle(0, b));
                    visited[0][b] = true;
                    result[c+a] = true;
                }
            }
            //c에 완전히 안 들어갈 때
            else {
                if (!visited[a - (limitC - c)][b]) {
                    queue.add(new Bottle(a - (limitC - c), b));
                    visited[a - (limitC - c)][b] = true;
                }
            }

            // b->a
            //완전히 들어갈 때
            if (b<=(limitA-a)) {
                if (!visited[a + b][0]) {
                    queue.add(new Bottle(a + b, 0));
                    visited[a + b][0] = true;
                }
            }
            else {
                //완전히 안 들어갈 때
                if (!visited[limitA][b - (limitA - a)]) {
                    queue.add(new Bottle(limitA, b - (limitA - a)));
                    visited[limitA][b - (limitA - a)] = true;
                }
            }

            // b->c
            //완전히 들어갈 때
            if (b<=(limitC-c)) {
                if (!visited[a][0]) {
                    queue.add(new Bottle(a, 0));
                    visited[a][0] = true;
                    if(a==0) {
                        result[b+c] = true;
                    }
                }
            }
            //완전히 안 들어갈 때
            else {
                if (!visited[a][b - (limitC - c)]) {
                    queue.add(new Bottle(a, b - (limitC - c)));
                    visited[a][b - (limitC - c)] = true;
                    if(a==0) {
                        result[limitC] = true;
                    }
                }
            }

            // c->a
            if (c<=(limitA-a)) {
                if (!visited[a + c][b]) {
                    queue.add(new Bottle(a + c, b));
                    visited[a + c][b]= true;
                }
            }
            //완전히 안 들어갈 때
            else {
                if (!visited[limitA][b]) {
                    queue.add(new Bottle(limitA, b));
                    visited[limitA][b]= true;
                }
            }

            // c->b

            if (c<=(limitB-b)) {
                if (!visited[a][b + c]) {
                    queue.add(new Bottle(a, b + c));
                    visited[a][b + c] = true;
                    if(a==0) {
                        result[0] = true;
                    }
                }
            }
            //완전히 안 들어갈 때
            else {
                if (!visited[a][limitB]) {
                    queue.add(new Bottle(a, limitB));
                    visited[a][limitB] = true;
                    if(a==0) {
                        result[c-(limitB-b)] = true;
                    }
                }
            }
        }

        for (int i = 0; i<=limitC;i++) {
            if (result[i]) {
            System.out.println(i);
            }
        }



    }

}
