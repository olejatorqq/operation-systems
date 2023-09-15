public class Main {
    public static void main(String[] args) {

        lineSeparator();
        FirstTask.printSystemInfo();
        lineSeparator();

        SecondTask.fileHanding();
        lineSeparator();
    }


    public static void lineSeparator(){
        for(int i = 0; i < 40; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}