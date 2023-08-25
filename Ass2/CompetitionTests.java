import org.junit.Test;
import static org.junit.Assert.*;

public class CompetitionTests {

    EdgeWeightedDigraph callMainClass = new EdgeWeightedDigraph(); // just to call this class that never get's called

    @Test
    public void testDijkstraConstructor() {
        // Null filename
        CompetitionDijkstra G = new CompetitionDijkstra(null, 50, 60, 70);
        assertEquals("Testing a null filename", -1, G.timeRequiredforCompetition());

        // fileName does not exist
        G = new CompetitionDijkstra("this-file-name-does-not-exist", 50, 60, 70);
        assertEquals("Testing a with a non existing filename", -1, G.timeRequiredforCompetition());


        // Below min speed of sA 50
        G = new CompetitionDijkstra("tinyEWD.txt", 49, 60, 70);
        assertEquals("Testing speed sA below 50", -1, G.timeRequiredforCompetition());

        // Below min speed of sB 50
        G = new CompetitionDijkstra("tinyEWD.txt", 50, 49, 70);
        assertEquals("Testing speed sB below 50", -1, G.timeRequiredforCompetition());

        // Below min speed of sC 50
        G = new CompetitionDijkstra("tinyEWD.txt", 50, 60, 49);
        assertEquals("Testing speed sC below 50", -1, G.timeRequiredforCompetition());


        // Above max speed of sA 100
        G = new CompetitionDijkstra("tinyEWD.txt", 101, 60, 70);
        assertEquals("Testing speed sA above 100", -1, G.timeRequiredforCompetition());

        // Above max speed of sA 100
        G = new CompetitionDijkstra("tinyEWD.txt", 50, 101, 70);
        assertEquals("Testing speed sB above 100", -1, G.timeRequiredforCompetition());

        // Above max speed of sA 100
        G = new CompetitionDijkstra("tinyEWD.txt", 50, 60, 101);
        assertEquals("Testing speed sC above 100", -1, G.timeRequiredforCompetition());

        // Test with an edge that doesn't go to a vertex
        G = new CompetitionDijkstra("input-A.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-A.txt", -1, G.timeRequiredforCompetition());

        // Test with input-B.txt
        G = new CompetitionDijkstra("input-B.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-B.txt", 10000, G.timeRequiredforCompetition());

        // Test with input-C.txt
        G = new CompetitionDijkstra("input-C.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-C.txt", -1, G.timeRequiredforCompetition());


        // Test with input-J.txt
        G = new CompetitionDijkstra("input-J.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-C.txt", -1, G.timeRequiredforCompetition());

        // Test with tinyEWD.txt
        G = new CompetitionDijkstra("tinyEWD.txt", 50, 60, 70);
        assertEquals("Testing proper speed with tinyEWD.txt", 38, G.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor() {
        // Null filename
        CompetitionFloydWarshall G = new CompetitionFloydWarshall(null, 50, 60, 70);
        assertEquals("Testing a null filename", -1, G.timeRequiredforCompetition());

        // fileName does not exist
        G = new CompetitionFloydWarshall("this-file-name-does-not-exist", 50, 60, 70);
        assertEquals("Testing a with a non existing filename", -1, G.timeRequiredforCompetition());


        // Below min speed of sA 50
        G = new CompetitionFloydWarshall("tinyEWD.txt", 49, 60, 70);
        assertEquals("Testing speed sA below 50", -1, G.timeRequiredforCompetition());

        // Below min speed of sB 50
        G = new CompetitionFloydWarshall("tinyEWD.txt", 50, 49, 70);
        assertEquals("Testing speed sB below 50", -1, G.timeRequiredforCompetition());

        // Below min speed of sC 50
        G = new CompetitionFloydWarshall("tinyEWD.txt", 50, 60, 49);
        assertEquals("Testing speed sC below 50", -1, G.timeRequiredforCompetition());


        // Above max speed of sA 100
        G = new CompetitionFloydWarshall("tinyEWD.txt", 101, 60, 70);
        assertEquals("Testing speed sA above 100", -1, G.timeRequiredforCompetition());

        // Above max speed of sA 100
        G = new CompetitionFloydWarshall("tinyEWD.txt", 50, 101, 70);
        assertEquals("Testing speed sB above 100", -1, G.timeRequiredforCompetition());

        // Above max speed of sA 100
        G = new CompetitionFloydWarshall("tinyEWD.txt", 50, 60, 101);
        assertEquals("Testing speed sC above 100", -1, G.timeRequiredforCompetition());


        // Test with an edge that doesn't go to a vertex
        G = new CompetitionFloydWarshall("input-A.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-A.txt", -1, G.timeRequiredforCompetition());

        // Test with input-B.txt
        G = new CompetitionFloydWarshall("input-B.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-B.txt", 10000, G.timeRequiredforCompetition());

        // Test with input-C.txt
        G = new CompetitionFloydWarshall("input-C.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-C.txt", -1, G.timeRequiredforCompetition());

        // Test with input-J.txt
        G = new CompetitionFloydWarshall("input-J.txt", 50, 60, 70);
        assertEquals("Testing proper speed with input-C.txt", -1, G.timeRequiredforCompetition());


        // Test with tinyEWD.txt
        G = new CompetitionFloydWarshall("tinyEWD.txt", 50, 60, 70);
        assertEquals("Testing proper speed with tinyEWD.txt", 38, G.timeRequiredforCompetition());

    }

    //TODO - more tests

}
