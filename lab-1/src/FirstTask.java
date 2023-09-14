import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.Files;

//1. Вывести информацию в консоль о логических дисках, именах, метке тома, размере и типе файловой системы
public class FirstTask {
    public static void printSystemInfo(){
        int count = 0;
        File[] drives = File.listRoots();
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();

        for (File drive : drives) {
            System.out.println("Диск: " + drive);
            System.out.println("Метка тома: " + fileSystemView.getSystemDisplayName(drive));
            System.out.println("Общий объем: " + drive.getTotalSpace() / (1024 * 1024 * 1024) + " ГБ");
            System.out.println("Свободное место: " + drive.getFreeSpace() / (1024 * 1024 * 1024) + " ГБ");
            System.out.println("Доступное место: " + (drive.getTotalSpace() - drive.getFreeSpace()) / (1024 * 1024 * 1024) + " ГБ");

            try {
                FileStore fileStore = Files.getFileStore(drive.toPath());
                System.out.println("Тип файловой системы: " + fileStore.type());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (++count != drives.length){
                System.out.println();
            }
        }
    }
}
