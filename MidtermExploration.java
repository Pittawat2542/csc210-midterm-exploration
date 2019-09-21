package midterm.exploration;

import java.util.ArrayList;
import java.util.Stack;

public class MidtermExploration {

    public static void main(String[] args) {
        System.out.println("Implement program to test each function here!");
    }

    /* --------------- Chapter 1 ---------------- */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[currentMinIndex]) {
                    currentMinIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[currentMinIndex];
            arr[currentMinIndex] = temp;
        }
    }

    public static int euclidGCD(int m, int n) {
        if (n == 0) {
            return m;
        }

        int max = Math.max(m, n);
        int min = Math.min(m, n);

        return euclidGCD(min, max % min);
    }

    public static int consecutiveGCD(int m, int n) {
        int min = Math.min(m, n);

        while (min >= 2) {
            if (m % min == 0 && n % min == 0) {
                return min;
            }

            min -= 1;
        }

        return 2;
    }

    public static int middleSchoolGCD(int m, int n) {
        ArrayList<Integer> prime = sieveOfEratosthenes(Math.max(m, n));
        int gcd = 1;

        for (Integer integer : prime) {
            while (m % integer == 0 && n % integer == 0) {
                m /= integer;
                n /= integer;
                gcd *= integer;
            }
        }

        return gcd;
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        int[] arr = new int[n + 1];
        ArrayList<Integer> prime = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.floor(Math.sqrt(n)); i++) {
            if (arr[i] != 0) {
                int j = i * i;
                while (j <= n) {
                    arr[j] = 0;
                    j += i;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                prime.add(arr[i]);
            }
        }

        return prime;
    }

    /* --------------- Chapter 2 ---------------- */
    public static int sequentialSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static int maxElement(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static boolean uniqueElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    public static void gaussianElimination(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = i; k <= arr.length; k++) {
                    arr[j][k] = arr[j][k] - arr[i][k] * arr[j][i] / arr[i][i];
                }

            }
        }
    }

    public static int countBinaryDigit(int n) {
        int count = 1;

        while (n > 1) {
            count += 1;
            n = n / 2;
        }

        return count;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return factorial(n - 1) * n;
    }

    public static void towerOfHanoi(int diskNumber, char fromPeg, char toPeg, char otherPeg) {
        if (diskNumber == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }
        
        towerOfHanoi(diskNumber - 1, fromPeg, otherPeg, toPeg); // Move every above disk n to the middle peg
        System.out.println("Move disk " + diskNumber + " from rod " +  fromPeg + " to rod " + toPeg);  // Move the n disk to destination peg
        towerOfHanoi(diskNumber - 1, otherPeg, toPeg, fromPeg); // Move every disk from middle pef to the destination peg
    }
    
    public static int countBinaryDigitRecursion(int n) {
        if (n == 1) return 1;
        return countBinaryDigitRecursion(n / 2) + 1;
    }
    
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /* --------------- Chapter 3 ---------------- */
    // selectionSort - See in chapter 1
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // sequentialSearch - See in chapter 2
    public static int bruteForceStringMatching(String str, String pattern) {
        char[] text = str.toCharArray();
        char[] patternChar = pattern.toCharArray();
        int patternIndex = 0;

        for (int i = 0; i < str.length() - pattern.length(); i++) {
            patternIndex = 0;
            while (patternIndex < pattern.length() && text[i + patternIndex] == patternChar[patternIndex]) {
                patternIndex++;
            }

            if (patternIndex == pattern.length()) {
                return i;
            }
        }

        return -1;
    }

    public static int polynomialEvaluation(int[] coefficientList, int x) {
        int result = coefficientList[0];
        int power = 1;
        for (int i = 1; i < coefficientList.length; i++) {
            power = power * x;
            result += coefficientList[i] * power;
        }

        return result;
    }

    public static PairOfPoints clostestPair(Point[] pointList) {
        double minDistance = Double.MAX_VALUE;
        PairOfPoints closestPairs = null;

        for (int i = 0; i < pointList.length - 1; i++) {
            for (int j = i + 1; j < pointList.length; j++) {
                if (PairOfPoints.getDistance(pointList[i], pointList[j]) < minDistance) {
                    closestPairs = new PairOfPoints(pointList[i], pointList[j]);
                    minDistance = closestPairs.getDistance();
                }
            }
        }

        return closestPairs;
    }

    public static ArrayList<PairOfPoints> convexHull(Point[] pointList) {
        ArrayList<PairOfPoints> boundary = new ArrayList<>();

        for (int i = 0; i < pointList.length - 1; i++) {
            for (int j = i + 1; j < pointList.length; j++) {
                int a = pointList[j].y - pointList[i].y;
                int b = pointList[i].x - pointList[j].x;
                int c = pointList[i].x * pointList[j].y - pointList[j].x * pointList[i].y;

                int left = 0;
                int right = 0;
                for (int k = 0; k < pointList.length; k++) {
                    int currentC = a * pointList[k].x + b * pointList[k].y;

                    if (currentC <= c) {
                        left++;
                    }
                    if (currentC >= c) {
                        right++;
                    }
                }

                if (left == pointList.length || right == pointList.length) {
                    boundary.add(new PairOfPoints(pointList[i], pointList[j]));
                }
            }
        }

        return boundary;
    }

    public static void travelingSalesman(int[][] cities) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities.length; j++) {
                int distance = 0;
                if (i != j) {
                    distance += cities[i][j];

                    for (int k = 0; k < cities.length; k++) {
                        if (i != k && j != k) {
                            distance += cities[j][k];

                            for (int l = 0; l < cities.length; l++) {
                                if (i != l && j != l && k != l) {
                                    distance += (cities[k][l] + cities[l][i]);
                                    if (distance < minDistance) {
                                        minDistance = distance;
                                    }
                                    System.out.println("Cities " + i + " " + j + " " + k + " " + l + " " + i + " = " + distance);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(minDistance);
    }

    // Same idea as traveling salesman
//    public static void knapsack() {
//
//    }
//
//    public static void assignment() {
//
//    }
    /* --------------- Chapter 5 ---------------- */
    public static int summation(int start, int stop) {
        if (start == stop) {
            return start;
        }

        return summation(start, (start + stop) / 2) + summation((start + stop) / 2 + 1, stop);
    }

    public static void mergeSort(int left, int right, int[] arr) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid, arr);
            mergeSort(mid + 1, right, arr);
            merge(left, right, arr);
        }
    }

    public static void merge(int begin, int end, int[] arr) {
        int start = begin;
        int startMiddle = (begin + end) / 2 + 1;
        int[] temp = new int[end - begin + 1];
        int tempCounter = 0;
        while (start <= (begin + end) / 2 && startMiddle <= end) {
            if (arr[start] <= arr[startMiddle]) {
                temp[tempCounter++] = arr[start++];
            } else {
                temp[tempCounter++] = arr[startMiddle++];
            }
        }

        while (start <= (begin + end) / 2) {
            temp[tempCounter++] = arr[start++];
        }

        while (startMiddle <= end) {
            temp[tempCounter++] = arr[startMiddle++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[begin + i] = temp[i];
        }
    }

    public static void quickSort(int left, int right, int[] arr) {
        if (left < right) {
            int pivot = arr[left];
            int leftPointer = left + 1;
            int rightPointer = right;

            while (leftPointer <= rightPointer) {
                while (leftPointer < rightPointer && arr[leftPointer] < pivot) {
                    leftPointer++;
                }

                while (rightPointer >= leftPointer && arr[rightPointer] >= pivot) {
                    rightPointer--;
                }

                if (leftPointer < rightPointer) {
                    int temp = arr[leftPointer];
                    arr[leftPointer++] = arr[rightPointer];
                    arr[rightPointer--] = temp;
                } else {
                    leftPointer++;
                }
            }

            int temp = arr[left];
            arr[left] = arr[rightPointer];
            arr[rightPointer] = temp;

            quickSort(left, rightPointer - 1, arr);
            quickSort(rightPointer + 1, right, arr);
        }
    }

    public static int binarySearch(int[] arr, int key) {
        quickSort(0, arr.length - 1, arr);

        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;
        while (middle < arr.length) {
            if (key < arr[middle]) {
                right = middle - 1;
            } else if (key > arr[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }

            middle = (left + right) / 2;
        }

        return -1;
    }

    // Can't use without implementation of Binary Tree
//    public static void preorder(Node node) {
//        if (node != null) {
//            System.out.println(node.data);
//            preorder(node.left);
//            preorder(node.right);
//        }
//    }
//
//    public static void inorder(Node node) {
//        if (node != null) {
//            inorder(node.left);
//            System.out.println(node.data);
//            inorder(node.right);
//        }
//    }
//
//    public static void postorder(Node node) {
//        if (node != null) {
//            postorder(node.left);
//            postorder(node.right);
//            System.out.println(node.data);
//        }
//    }
//    
//    public static int height(Node node) {
//        if (node == null) return 0;
//        return Math.max(height(node.left), height(node.right)) + 1;
//    }
    public static int divideAndConquerGCD(int a, int b, int c, int d) {
        return euclidGCD(euclidGCD(a, b), euclidGCD(c, d));
    }

    public static int divideAndConquerGCD(int a, int b, int c) {
        return euclidGCD(a, euclidGCD(b, c));
    }

    // Can improve furthur by implementation of subtractLargeNumber
    public static String multiplyLargeNumber(String a, String b) {
        if (a.length() == 1 || b.length() == 1) {
            return (Integer.parseInt(a) * Integer.parseInt(b)) + "";
        }

        a = addPrefixZeroToTheNextTwoPowerByN(a);
        b = addPrefixZeroToTheNextTwoPowerByN(b);
        a = addPrefixZero(a, Math.max(a.length(), b.length()) - a.length());
        b = addPrefixZero(b, Math.max(a.length(), b.length()) - b.length());

        String a1, a0, b1, b0;
        a1 = a.substring(0, a.length() / 2);
        a0 = a.substring(a.length() / 2);
        b1 = b.substring(0, b.length() / 2);
        b0 = b.substring(b.length() / 2);

        String c0, c1, c2, c;
        c2 = multiplyLargeNumber(a1, b1);
        c0 = multiplyLargeNumber(a0, b0);
        c1 = (Long.parseLong(multiplyLargeNumber(addLargeNumber(a1, a0), addLargeNumber(b1, b0))) - Long.parseLong(addLargeNumber(c2, c0))) + "";

        c = addLargeNumber(addLargeNumber(addSuffixZero(c2, a.length()), addSuffixZero(c1, a.length() / 2)), c0);

        return c;
    }

    public static String addPrefixZeroToTheNextTwoPowerByN(String n) {
        String str = n.concat("");
        int twoPowerByN = (int) Math.pow(2, Math.floor(Math.log10(n.length()) / Math.log10(2)));
        if (n.length() == twoPowerByN) {
            return n;
        }

        for (int i = n.length(); i < twoPowerByN * 2; i++) {
            str = "0" + str;
        }

        return str;
    }

    public static String addPrefixZero(String n, int numberOfZero) {
        String str = n.concat("");
        for (int i = 0; i < numberOfZero; i++) {
            str = "0" + str;
        }

        return str;
    }

    public static String addSuffixZero(String n, int numberOfZero) {
        String str = n.concat("");
        for (int i = 0; i < numberOfZero; i++) {
            str += "0";
        }

        return str;
    }

    public static String addLargeNumber(String a, String b) {
        Stack<Character> n1 = new Stack<>();
        Stack<Character> n2 = new Stack<>();
        Stack<Character> result = new Stack<>();

        for (int i = 0; i < a.length(); i++) {
            n1.push(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            n2.push(b.charAt(i));
        }

        int carry = 0;
        while (!n1.isEmpty() && !n2.isEmpty()) {
            int num1 = Integer.parseInt(n1.pop().toString());
            int num2 = Integer.parseInt(n2.pop().toString());

            int r = num1 + num2 + carry;
            if (r >= 10) {
                r %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(Character.forDigit(r, 10));
        }

        while (!n1.isEmpty()) {
            int num = Integer.parseInt(n1.pop().toString());
            int r = num + carry;
            if (r >= 10) {
                r %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(Character.forDigit(r, 10));
        }

        while (!n2.isEmpty()) {
            int num = Integer.parseInt(n2.pop().toString());
            int r = num + carry;
            if (r >= 10) {
                r %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(Character.forDigit(r, 10));
        }

        String res = "";
        if (carry != 0) {
            res = "1";
        }
        while (!result.isEmpty()) {
            res += result.pop();
        }

        return res;
    }

    // Brute Force Matrix Multiplication - See in chapter 2
    // Starssenn's Matrix Multiplication - See in lecture
    // Closest Pair Divide and Conquer - See in lecture
    // Quickhull - See in lecture

    /* --------------- Utilities ---------------- */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printArrayList(ArrayList<PairOfPoints> arr) {
        for (PairOfPoints i : arr) {
            System.out.println(i.toString());
        }
    }
}
