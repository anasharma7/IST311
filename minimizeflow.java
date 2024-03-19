import java.util.*;
import java.util.Map.Entry;

public class minimizeflow {
    //number of roommates (number of vertices in the graph)
    public static final int N = 3;

    
    static Location getMin(Map<Location, Double> map) {
        double min = (Collections.min(map.values()));
        for (Entry<Location, Double> entry : map.entrySet()) {
            if (entry.getValue() == min){
                return entry.getKey();
            }
        }
        return null;
    }

    
    static Location getMax(Map<Location, Double> map) {
        double max = (Collections.max(map.values()));
        for (Entry<Location, Double> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        return null;  
    }

   
    public static double minOf2(double x, double y) {
        return (x < y) ? x : y;
    }


    
    static void minCashFlowRec(Map<Location, Double> netowed) {
      
        Location mxCredit = getMax(netowed), mxDebit = getMin(netowed);

        
        if (netowed.get(mxCredit) == 0 && netowed.get(mxDebit) == 0){
            return;
        }

        double min = minOf2(-netowed.get(mxDebit), netowed.get(mxCredit));
        netowed.replace(mxCredit, netowed.get(mxCredit) - min);
        //amount[mxCredit] -= min;
        netowed.replace(mxDebit, netowed.get(mxDebit) + min);
        //amount[mxDebit] += min;

        
        System.out.println("Person " + mxDebit.getLabel() + " pays " + min
                + " to " + "Person " + mxCredit.getLabel());

        minCashFlowRec(netowed);
    }

    
    static void minCashFlow(Graph graph) {
        Map<Location, Double> creditamount = new HashMap<>();
        Map<Location, Double> debitamount = new HashMap<>();
        Map<Location, Double> netowed = new HashMap<>();
        //double amount[] = new double[N];

        for(Location v: graph.getVertices()){
                double totalcredit = 0;
                for(Distance e: v.getEdges()){
                totalcredit = totalcredit + e.getWeight();
            }
            creditamount.put(v, totalcredit);
        }
       for(Location v: graph.getVertices()){
        System.out.println("Amount owed by " + v.getLabel() + " " + creditamount.get(v));
       }
    

        double totaldebit = 0;
        for (Location v : graph.getVertices()) {
            for (Distance e : v.getEdges()) {
                totaldebit = e.getWeight();
                if(debitamount.containsKey(e.getvertex())){
                    debitamount.replace(e.getvertex(), debitamount.get(e.getvertex()) + totaldebit);
                }
                else{
                    debitamount.put(e.getvertex(), totaldebit);
                }
            }
        }
        for (Location v : graph.getVertices()) {
            if(debitamount.get(v) == null){
                debitamount.put(v, 0.0);
            }
            System.out.println("Amount owed to " + v.getLabel() + " " + debitamount.get(v));
        }
        for (Location v : graph.getVertices()) {
            netowed.put(v, (debitamount.get(v)-creditamount.get(v)));
            System.out.println("Net amount owed to " + v.getLabel() + " " + netowed.get(v));
        }

        getMax(netowed);
        getMin(netowed);
        minCashFlowRec(netowed);
    }

  
    

    public static void main(String[] args) {
      
        
        Graph main = new Graph();
        
        main.addVertex("John");
        main.addVertex("Nelly");
        main.addVertex("Sebastian");
        main.getVertex("John").addEdge(new Distance(main.getVertex("Nelly"), 1000));
        main.getVertex("John").addEdge(new Distance(main.getVertex("Sebastian"), 2000));
        main.getVertex("Nelly").addEdge(new Distance(main.getVertex("Sebastian"), 5000));

        //Print the graph
        for (Location v : main.getVertices()) {
            System.out.println(v.getLabel() + " owes: ");
            for (Distance e : v.getEdges()) {
                System.out.println(e.getvertex().getLabel() + " " + e.getWeight());
            }
        }
        
        minCashFlow(main);
            
        }
    }


