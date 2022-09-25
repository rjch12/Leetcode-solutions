// import java.util.concurrent.Callable;

// interface Reptile {
//     ReptileEgg lay();
// }

// class FireDragon implements Reptile{
//     ReptileEgg r;
    
//     public FireDragon() {
//     }
//     public ReptileEgg lay() {
//         return this.lay();

//     }

//     public static void main(String[] args) throws Exception {
//         FireDragon fireDragon = new FireDragon();
//         System.out.println(fireDragon instanceof Reptile);
//     }
// }

// class ReptileEgg {
//     public ReptileEgg(Callable<Reptile> createReptile) {
//         throw new UnsupportedOperationException("Waiting to be implemented.");
//     }

//     public Reptile hatch() throws Exception {
//         throw new UnsupportedOperationException("Waiting to be implemented.");
//     }
// }

// import java.util.Collection;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Map;
// import java.util.HashMap;
// import java.util.List;

// class UniqueNumbers {
//     public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
//         Map<Integer, Integer> freq = new HashMap<>();
//         List<Integer> res = new ArrayList<>();
//         for (int number : numbers) {
//             freq.put(number, freq.getOrDefault(number, 0) + 1);
//         }
        
//         for(int i: freq.keySet()) {
//             if(freq.get(i) == 1)
//             res.add(i);
//         }
//         return res;
//     }

//     public static void main(String[] args) {
//         Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
//         for (int number : findUniqueNumbers(numbers))
//             System.out.println(number);
//     }
// }

// import java.util.stream.*;
// import java.util.*;

// class TestResults
// {
//     public static class Student {
//         private String name;
//         private int score;
        
//         public Student(String name, int score) {
//             this.name = name;
//             this.score = score;
//         }
        
//         public int getScore() {
//             return score;
//         }
        
//         public String getName() {
//             return name;
//         }
//     }
    
//     public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
//         Queue<Student> pq = new PriorityQueue<>((a,b) -> b.getScore() - a.getScore());

//         List<String> res = new ArrayList<>();
//         students.filter(student -> student.getScore() > passingScore).forEach(student -> pq.offer(student));
//         for(Student s: pq) {
//             res.add(s.getName());
//         }
//         return res;
//     }
    
//     public static void main(String[] args) {
        
//         List<Student> students = new ArrayList<Student>();

//         students.add(new Student("Mike", 80));
//         students.add(new Student("James", 57));
//         students.add(new Student("Alan", 21));

//         studentsThatPass(students.stream(), 50).forEach(System.out::println);        
//     }
// }

class NNode {
    private NNode leftChild, rightChild;
    
    public NNode(NNode leftChild, NNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public NNode getLeftChild() {
        return this.leftChild;
    }
    
    public NNode getRightChild() {
        return this.rightChild;
    }

    public int height() {
        return dfs(this, new int[]{0}, 0);
        
    }

    public int dfs(NNode root, int []height, int localheight) {
        if(root == null)
            return 0;
        
            dfs(root.getLeftChild(), height, localheight + 1);
            dfs(root.getRightChild(), height, localheight + 1); 

            height[0] = Math.max(height[0], localheight);

        return height[0];
    }

    public static void main(String[] args) {
        NNode leaf1 = new NNode(null, null);
        NNode leaf2 = new NNode(null, null);
        NNode NNode = new NNode(leaf1, null);
        NNode root = new NNode(NNode, leaf2);

        System.out.println(root.height());
    }
}