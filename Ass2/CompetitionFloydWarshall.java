/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */
import java.io.*;
import java.util.Scanner;

public class CompetitionFloydWarshall {
    private int numStreets; // number of streets
    private int numIntsec; // number of intersections in the graph
    private int sA, sB, sC; // 3 contestants
    private EdgeWeightedDigraph.Digraph G; // edge weighted digraph G (dijkstra)
    private double[][] d; // matrix array from floydWarshall

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC) {
        // will be used in timeRequiredforCompetition
        this.sA = sA;
        this.sB = sB;
        this.sC = sC;
        if (filename == null) { // prevent errors with try catch not working
            G = null;
            return;
        }
        try {
            File inputFile = new File(filename); // read in file
            Scanner input = new Scanner(inputFile); // read file into Scanner, called input

            numIntsec = input.nextInt(); // obtain first line for intersections
            numStreets = input.nextInt(); // obtain second line for streets
            if (numStreets == 0) {
                G = null;
                return;
            }
            //input.nextLine(); // put cursor on next line

            G = new EdgeWeightedDigraph.Digraph(numStreets, numIntsec); // created new EdgeWeight Digraph
            d = new double[numIntsec][numIntsec]; // create d matrix with num of intersects * intersects

            int N = G.e;
            // set all indexes of matrix to infinity before mapping floyd
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    d[i][j] = Double.POSITIVE_INFINITY; // assign to infinity as shown in lectures
                }
            }
            // initialise before entering loop and mapping to 2d matrix for floyd (prevent reinitialising variables)
            int currentStreet = 0, newStreet = 0;
            double weight = 0;
            // line 3 onwards, representing streets -> streets + weight
            while(input.hasNextLine()) {
                try {
                    currentStreet = input.nextInt(); // parse first street as int
                    newStreet = input.nextInt(); // parse the second street as int
                    weight = input.nextDouble(); // parse weight as double
                    d[currentStreet][currentStreet] = 0; // diagonal's must be zero's
                    d[currentStreet][newStreet] = weight; // assign the weight in the 2d matrix
                } catch (Exception ex) {
                    return;
                }
            }
            //input.close(); // close scanner, no use for it anymore
        } catch (IOException fileNotFound) { // fileNotFound errors
            G = null;
        }
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
        int min = 0, max = 0; // initialise min and max
        double maxDist = 0, maxTime = 0, tempDist = 0; // initialise maximum distance, maximum time and temporary dist variable
        double[][] sp;
        min = Math.min(sA, sB);
        min = Math.min(min, sC); // minimum between sA, sB, sC (speeds)

        max = Math.max(sA, sB);
        max = Math.max(max, sC); // maximum between sA, sB, sC (speeds)

        if ((G == null) || (max > 100 || min < 50)) {
            return -1;
        }
        sp = floydWarshall(); // shortest path graph floydWarshall (using mapped matrix and using floyd) after G check null
        int N = G.e;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                tempDist = sp[i][j];
                if(tempDist == Double.POSITIVE_INFINITY) {
                    return -1;
                }
                maxDist = Math.max(maxDist, tempDist);
            }
        }
        maxTime = ((maxDist * 1000) / min); // in meters

        return (int) Math.ceil(maxTime); // return the rounded up of maxTime needed
    }

    public double[][] floydWarshall() {
        int N = G.e;
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(d[i][k] + d[k][j] < d[i][j]) {
                       d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        return d;
    }
}
