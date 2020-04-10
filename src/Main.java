import com.sun.xml.internal.ws.handler.ServerSOAPHandlerTube;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Float price = null;
        Scanner scn = new Scanner(System.in);

        System.out.print("Input products's code : ");
        String productID = scn.nextLine();
        System.out.print("Input products's name : ");
        String productName = scn.nextLine();
        System.out.print("Input production : ");
        String production = scn.nextLine();
        System.out.print("Price(input number): ");

        try {
            price = scn.nextFloat();
        } catch (Exception e) {
            System.out.println("Wrong input");
            e.getMessage();
            price=-1f;
        }
        scn.nextLine();
        System.out.print("Description : ");
        String otherDescription = scn.nextLine();
        String path = "Products.txt";
        File txt = new File(path);
        creatFileTxt(txt, path);

        String content = "Thông tin sản phẩm gồm : "
                + "\n- Mã sản phẩm : " + productID
                + "\n- Tên sản phẩm : " + productName
                + "\n- Hãng sản phẩm : " + production
                + "\n- Giá sản phẩm : " +
                (price==-1 ? "Not update" :
                        price.toString() + "$")
                + "\n- Các mô tả khác : " + otherDescription;
        writeTxt(txt, content, scn, path);
    }

    static void creatFileTxt(File file, String path) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void writeTxt(File file, String content, Scanner scn, String path) {
        FileWriter fileWriter = null;
        if (file.exists()) {
            if (file.length() == 0) {
                try {
                    fileWriter = new FileWriter(file, true);
                    fileWriter.write(content);
                    System.out.println("Write Completed");
                } catch (Exception e) {
                    e.getMessage();
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("This file contain a content.Do you want to override?(Y)");
                String answer = scn.next().toLowerCase();
                if (answer.equals("y")) {
                    file.delete();
                    creatFileTxt(file, path);
                    writeTxt(file, content, scn, path);
                    return;
                } else return;
            }
        } else System.out.println("You need to creat a file first!");
    }
}
