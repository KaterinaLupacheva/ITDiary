package by.mycompany.diary.helper;

import org.springframework.core.io.FileSystemResource;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskList {

    public static Set<String> readTasks()  {
        Set<String> tasks = new HashSet<>();
        FileSystemResource resource = new FileSystemResource("C:\\Users\\kater\\Documents\\IdeaProjects\\ItDiaryNew\\src\\main\\java\\by.mycompany.diary\\helper\\taskList.txt");
        File file = resource.getFile();

        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {
            while(scanner.hasNextLine()) {
                String s = scanner.nextLine();
                tasks.add(s);
            }
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return tasks;
    }
}
