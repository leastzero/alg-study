import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/kotlin/input.txt"));

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int comNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        int start, dst;

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        int currentNode;

        //TODO : edges 초기화
        List<List<Integer>> edges = new ArrayList<>();

        for(int i = 0; i < comNum; i++) {
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            dst = Integer.parseInt(st.nextToken());
            edges.get(start - 1).add(dst - 1);
            edges.get(dst - 1).add(start - 1);
        }

        deque.add(0);

        //TODO : BFS로 연결되어 있는 컴퓨터 개수 계산
        while(!deque.isEmpty()) {
            currentNode = deque.removeLast();
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                answer++;
                edges.get(currentNode).stream()
                        .sorted()
                        .filter(it -> !visited.contains(it))
                        .forEach(deque::addFirst);
            }
        }

        //1번 노드는 계산에서 제외
        System.out.println(answer - 1);

        bw.flush();
        br.close();
    }
}