import java.util.*;

public class tree {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // 构建邻接表
        List<Integer>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        // 初始化父、左右子节点、坐标数组
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        Node[] coord = new Node[n + 1];
        coord[1] = new Node(0, 0); // 假设根节点为1
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[1] = -1; // 根节点的父节点不存在

        while (!queue.isEmpty()) {
            int u = queue.poll();

            // 收集所有可能的子节点（排除父节点）
            List<Integer> children = new ArrayList<>();
            for (int v : adj[u]) {
                if (parent[u] != v) { // 排除父节点
                    children.add(v);
                }
            }
            // 按编号排序以确定左右子节点
            Collections.sort(children);

            // 处理左子节点
            if (children.size() >= 1) {
                int left = children.get(0);
                if (parent[left] == -1) { // 未被访问过
                    parent[left] = u;
                    coord[left] = new Node(coord[u].x - 1, coord[u].y - 1);
                    queue.add(left);
                }
            }
            // 处理右子节点
            if (children.size() >= 2) {
                int right = children.get(1);
                if (parent[right] == -1) { // 未被访问过
                    parent[right] = u;
                    coord[right] = new Node(coord[u].x + 1, coord[u].y - 1);
                    queue.add(right);
                }
            }
        }

        // 处理查询
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Node nx = coord[x];
            Node ny = coord[y];
            int distance = Math.abs(nx.x - ny.x) + Math.abs(nx.y - ny.y);
            System.out.println(distance);
        }
    }
}