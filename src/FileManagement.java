import java.io.*;


public class FileManagement {
    private String sourcePath = "ListProducts.txt";
    private File fileTxt = new File(sourcePath);

    public void FileManagement() {

    }

    public File getFileTxt() {
        return fileTxt;
    }

    void creatNewFile() {
        try {
            fileTxt.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void deleteFile() {
        fileTxt.delete();
    }

    void writeStringToTextFile(String string) {
        String display = null;
        try {
            display = readTextFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(sourcePath);
            string = display + string;
            fileWriter.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String readTextFile() throws IOException {
        FileReader reader = new FileReader(fileTxt);
        BufferedReader fileReader = new BufferedReader(reader);
        String line = "";
        String display = "";
        while ((line = fileReader.readLine()) != null) {
            display += line + "\n";
        }
        fileReader.close();
        reader.close();
        return display;
    }
}
