import java.io.*;
import java.util.Scanner;

//2. Работа  с файлами ( класс File, FileInfo, FileStream и другие)
//        - Создать файл
//        - Записать в файл строку, введённую пользователем
//        - Прочитать файл в консоль
//        - Удалить файл
public class SecondTask {
    public static void fileHanding(){

        String fileName = "biber.txt";

        try{
            File file = new File("C:\\IntelliJProjects\\operation-systems\\lab-1\\src\\FilesFolder\\" + fileName);

            if (file.createNewFile()) {
                System.out.println("Файл '" + fileName + "' успешно создан\n");

                fileInput(fileName, file);
                fileReader(fileName, file);
                fileDelete(fileName, file);

            } else {
                System.out.println("Файл '" + fileName + "' уже существует");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void fileInput(String fileName, File file){
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            System.out.print("Введите строку для записи в файл: ");
            String userInput = scanner.nextLine();

            writer.write(userInput);

            System.out.println("Строка успешно записана в файл '" + fileName + "'\n");

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void fileReader(String fileName, File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Содержимое файла '" + fileName + "':");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void fileDelete(String fileName, File file){
        if (file.delete()){
            System.out.println("\nФайл '" + fileName + "' успешно удален.");
        } else {
            System.out.println("\nНе удалось удалить файл '" + fileName + "'.");
        }
    }
}
