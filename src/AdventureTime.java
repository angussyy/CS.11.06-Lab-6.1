import java.io.*;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int a = countLinesInFile(fileName);
        int[] b = readFile(fileName);
        int count = 0;
        for (int i = 0; i<a-1; i++) {
            if (b[i]<b[i+1]) {
                count++;
                //increase
            }
        }

        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int a = countLinesInFile(fileName);
        int[] b = readFile(fileName);
        int count = 0;
        for (int i = 0; i<a-3; i++) {
            int sum1 = b[i] + b[i+1] + b[i+2];
            int sum2 = b[i+1] + b[i+2] + b[i+3];
            if (sum2>sum1) {
                count++;
            }
        }

        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int a = countLinesInFile(fileName);
        String[] b = readStrFile(fileName);
        int depth = 0;
        int hoz = 0;
        for (int i = 0; i<a; i++) {
            if (b[i].substring(0,2).equals("up")) {
                depth = depth - parseInt(b[i].substring(3));
            }
            else if (b[i].substring(0,4).equals("down")) {
                depth = depth + parseInt(b[i].substring(5));
            }
            else {
                hoz = hoz + parseInt(b[i].substring(8));
            }
        }

        return hoz*depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int a = countLinesInFile(filename);
        String[] b = readStrFile(filename);
        int depth = 0;
        int hoz = 0;
        int aim = 0;
        for (int i = 0; i<a; i++) {
            if (b[i].substring(0,2).equals("up")) {
                aim = aim - parseInt(b[i].substring(3));
            }
            else if (b[i].substring(0,4).equals("down")) {
                aim = aim + parseInt(b[i].substring(5));
            }
            else {
                depth = depth + aim * parseInt(b[i].substring(8));
                hoz = hoz + parseInt(b[i].substring(8));
            }
        }
        return hoz*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    private static String[] readStrFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

}