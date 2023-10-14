package vsvn.tsi.daw.cardio.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfExame {

	private String imgs_path,new_pdf_path;
	
	public PdfExame(String imgs_path, String new_pdf_path) {
		this.imgs_path = imgs_path;
		this.new_pdf_path = new_pdf_path;
	}

	public String getImgs_path() {
		return imgs_path;
	}

	public void setImgs_path(String imgs_path) {
		this.imgs_path = imgs_path;
	}

	public String getNew_pdf_path() {
		return new_pdf_path;
	}

	public void setNew_pdf_path(String new_pdf_path) {
		this.new_pdf_path = new_pdf_path;
	}
	
    public static void generatePDFWithRandomImages(String imageFolderPath, String pdfPath, int numberOfImages) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try {
            File pdfFile = new File(pdfPath);
            File pdfFolder = pdfFile.getParentFile();

            if (!pdfFolder.exists()) 
                pdfFolder.mkdirs(); 

            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            List<File> imageFiles = listImageFiles(imageFolderPath);
            shuffleAndSelectImages(imageFiles, numberOfImages); // Embaralhe e selecione imagens

            for (File imageFile : imageFiles) {
                Image image = Image.getInstance(imageFile.getAbsolutePath());
                // Ajuste o tamanho da imagem aqui (largura x altura)
                image.scaleToFit(400, 400);  // Substitua as dimensões conforme necessário
                image.setAlignment(Image.MIDDLE);
                document.add(image);

                document.newPage(); // Crie uma nova página para a próxima imagem
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	    private static List<File> listImageFiles(String folderPath) {
	        List<File> imageFiles = new ArrayList<>();
	        File folder = new File(folderPath);
	        if (folder.exists() && folder.isDirectory()) {
	            File[] files = folder.listFiles();
	            if (files != null) {
	                for (File file : files) {
	                    if (file.isFile() && isImageFile(file.getName())) {
	                        imageFiles.add(file);
	                    }
	                }
	            }
	        }
	        return imageFiles;
	    }

	    private static boolean isImageFile(String fileName) {
	        return fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".jpeg") ||
	                fileName.toLowerCase().endsWith(".png") || fileName.toLowerCase().endsWith(".gif");
	    }
	    
	    private static void shuffleAndSelectImages(List<File> imageFiles, int numberOfImages) {
	        Collections.shuffle(imageFiles); // Embaralhe a lista de imagens
	        if (imageFiles.size() > numberOfImages) {
	            imageFiles.subList(numberOfImages, imageFiles.size()).clear(); // Mantenha apenas o número desejado de imagens
	        }
	    }
	
	
}
