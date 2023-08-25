import java.util.LinkedList;

public class EdgeWeightedDigraph {

    static class DirectedEdge {

        int v; // tail vertex
        int w; // head vertex
        double weight; // weight of the edge

        /**
         * Initialises a directed edge from vertex v to vertex w with
         * the given weight.
         * @param v the tail vertex
         * @param w the head vertex
         * @param weight the weight of the directed edge
         */
        public DirectedEdge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

    }
    static class Digraph {

        int v; // number of vertices
        int e; // number of edges
        LinkedList<DirectedEdge>[] adj;

        /**
         * Initialises a directed graph from
         */
        @SuppressWarnings("unchecked") // warning suppression
        Digraph(int v, int e) {
            this.v = v;
            this.e = e;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList<>();
        }

        public void addEdge(int v, int w, double weight) {
            DirectedEdge edge = new DirectedEdge(v, w, weight);
            adj[v].addFirst(edge);
        }
    }
}
