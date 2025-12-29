import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("src/main/kotlin/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();

        //인접 행렬 대신 인접 리스트 사용
        List<List<Integer>> edges = new ArrayList<>();

        int start, dst;

        int currentNode;

        //TODO : edges 초기화
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            dst = Integer.parseInt(st.nextToken());
            //양방향 그래프이므로 양방향의 간선 추가
            edges.get(start - 1).add(dst - 1);
            edges.get(dst - 1).add(start - 1);
        }

        //TODO : DFS
        stack.addFirst(v - 1);
        while (!stack.isEmpty()) {
            currentNode = stack.removeFirst();
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                System.out.print((currentNode + 1) + " ");
                edges.get(currentNode).stream()
                        //작은 것을 먼저 방문하는 제약 조건이 존재하므로
                        //LIFO 구조를 만족시키기 위해 역순으로 정렬
                        .sorted(Collections.reverseOrder())
                        //이미 방문한 노드가 중복되어 들어가면 안 되므로 필터링
                        .filter(it -> !visited.contains(it))
                        //stack에 추가
                        .forEach(stack::addFirst);
            }
        }

        System.out.println();
        visited.clear();

        //TODO : BFS
        queue.addFirst(v - 1);
        while (!queue.isEmpty()) {
            currentNode = queue.removeLast();
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                System.out.print((currentNode + 1) + " ");
                edges.get(currentNode).stream()
                        //FIFO구조기 때문에 정순 정렬
                        .sorted()
                        //DFS경우와 동일하게 필터링
                        .filter(it -> !visited.contains(it))
                        //queue에 추가
                        .forEach(queue::addFirst);
            }
        }

        bw.flush();
        br.close();
    }
}
