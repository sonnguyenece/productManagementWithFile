import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement();
        ProductManagement pm = new ProductManagement();

        if (!fileManagement.getFileTxt().exists()) {
            fileManagement.creatNewFile();
            System.out.println(fileManagement.getFileTxt().getAbsolutePath());
        } else {
            System.out.println("This file exists.Do you want to change? " +
                    "(Press \"o\" to override,\"i\" to insert)");
            Scanner scn = new Scanner(System.in);
            String confirm = scn.nextLine();
            if (confirm.equalsIgnoreCase("i")) {
                fileManagement.creatNewFile();
                System.out.println("Export to txt completed");
                System.out.println(fileManagement.getFileTxt().getAbsolutePath());
            } else if (confirm.equalsIgnoreCase("o")) {
                fileManagement.deleteFile();
                fileManagement.creatNewFile();
                System.out.println("Export to txt completed");
                System.out.println(fileManagement.getFileTxt().getAbsolutePath());

            } else {
                System.out.println("------------------------------ End Program ------------------------------");
                System.exit(0);
            }
        }

        Product product1 = new Product("psi", "Pepsi", "Coca", 5f, "for kid");
        Product product2 = new Product("ft1", "Fanta", "Coca", 5.3f, "for kid");
        Product product3 = new Product("cc1", "Coca", "Coca", 5.5f, "for adult");
        pm.addProduct(product1);
        pm.addProduct(product2);
        pm.addProduct(product3);

        //Hien thi danh sach san pham
        fileManagement.writeStringToTextFile("Danh sach san pham\n");
        fileManagement.writeStringToTextFile(pm.toString());

        //Them san pham
        Product product4 = new Product("cci", "Cocain", "Coca", 4.5f, "for dog only");
        pm.addProduct(product4);
        fileManagement.writeStringToTextFile("\nDanh sach san pham sau khi them san pham \"Cocain\"\n");
        fileManagement.writeStringToTextFile(pm.toString());

        //Sap xep lai theo ten
        fileManagement.writeStringToTextFile("\nSap xep theo ten\n");
        pm.sortByName();
        fileManagement.writeStringToTextFile(pm.toString());

        //Xoa file co id "ft1"
        fileManagement.writeStringToTextFile("\nXoa file co id \"ft1\"\n");
        pm.removeWithId("ft1");
        fileManagement.writeStringToTextFile(pm.toString());

        //Sap xep lai theo gia tu cao len xuong thap
        fileManagement.writeStringToTextFile("\nSap xep theo gia tu cao xuong thap \n");
        pm.sortFromHighestPrice();
        fileManagement.writeStringToTextFile(pm.toString());

        //Tim kiem voi tu khoa "a"
        fileManagement.writeStringToTextFile("\nTim kiem ten co chua \"a\"\n");
        fileManagement.writeStringToTextFile(pm.searchByName("a"));

        //Sap xep lai theo gia tu thap len cao
        fileManagement.writeStringToTextFile("\nSap xep theo gia tu thap len cao\n");
        pm.sortFromLowestPrice();
        fileManagement.writeStringToTextFile(pm.toString());

        //Tim kiem theo ID
        fileManagement.writeStringToTextFile("\nTim kiem theo id(\"psi\")\n");
        fileManagement.writeStringToTextFile(pm.searchByID("psi"));

        //Tim kiem 1 ten khong ton tai
        fileManagement.writeStringToTextFile("\nTim kiem ten co chua \"a4\"\n");
        fileManagement.writeStringToTextFile(pm.searchByName("a4"));

        //Tim kiem voi tu khoa "Co"
        fileManagement.writeStringToTextFile("\nTim kiem ten co chua \"Co\"\n");
        fileManagement.writeStringToTextFile(pm.searchByName("Co"));

//        Tim kiem voi tu khoa "co"
        fileManagement.writeStringToTextFile("\nTim kiem ten co chua \"co\"\n");
        fileManagement.writeStringToTextFile(pm.searchByName("co"));
    }
}
