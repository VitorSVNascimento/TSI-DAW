package br.tsi.daw.tp1.logica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import br.tsi.daw.tp1.dao.PedidoExameDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RealizacaoDoExame implements Logica{

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoExame = req.getParameter("tipoExame"),
				idDoExame = req.getParameter("id"),
				caminhoDiretorio = "",
				extensions = "",
				caminhoPraSalvar = "";
		
		if(tipoExame.equals("eletrocardiograma")) {
			caminhoDiretorio = "E:\\VitorLenovoBackup\\IF\\TSI\\4° Periodo\\DAW\\TSI-DAW\\TSI-DAW\\workspace\\LeticiaKarendeOliveiraSilva_TP1_DAW\\src\\main\\webapp\\eletrocardiograma";
			extensions = ".jpg";
		}else {
			caminhoDiretorio = "E:\\VitorLenovoBackup\\IF\\TSI\\4° Periodo\\DAW\\TSI-DAW\\TSI-DAW\\workspace\\LeticiaKarendeOliveiraSilva_TP1_DAW\\src\\main\\webapp\\ecocardiograma" ;
			extensions = ".jpeg";
		}	
			caminhoDiretorio =  getRandomImagePath(caminhoDiretorio,extensions);
			caminhoPraSalvar = caminhoDiretorio;
			caminhoPraSalvar = caminhoPraSalvar.replace("eletrocardiograma", "eletrocardiogramaPDF").replace("ecocardiograma", "ecocardiogramaPDF");
			caminhoPraSalvar = caminhoPraSalvar.replace(".jpg", ".pdf").replace(".jpeg", ".pdf");
			try {
				System.out.println(caminhoDiretorio);
				System.out.println(caminhoPraSalvar);
				convertImageToPdf(caminhoDiretorio,caminhoPraSalvar);
	            adicionarPdfNoPedido(caminhoPraSalvar, idDoExame);
				System.out.println("Salvou PDF");
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(caminhoDiretorio);
		return "menu-principal.jsp";
	}
	
	private void adicionarPdfNoPedido(String caminhoPdf, String idDoExame) {
        try {
        	// Convert idDoExame to an integer
            int id = Integer.parseInt(idDoExame);
            
            // Call the DAO method with the converted id
            PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
            pedidoExameDAO.adicionaPdfNoPedido(caminhoPdf, id);
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
	public static String getRandomImagePath(String directoryPath, String extentions) {
        List<String> imagePaths = getImagePaths(directoryPath,extentions);

        if (imagePaths.isEmpty()) {
            throw new RuntimeException("Nenhuma imagem encontrada no diretório.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(imagePaths.size());
        return imagePaths.get(randomIndex);
    }

    public static List<String> getImagePaths(String directoryPath, String extentions) {
        List<String> imagePaths = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(extentions)) {
                    imagePaths.add(file.getAbsolutePath());
                }
            }
        }

        return imagePaths;
    }

    public void convertImageToPdf(String imagePath, String pdfPath) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4,50,50,50,50);
        PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
        document.open();
        System.out.println("Criando imagem");
        Image image = Image.getInstance(imagePath);
        image.scaleToFit(400,400);
        image.setAlignment(Image.MIDDLE);
        document.add(image);
        System.out.println("Passou da imagem");
        document.close();
    }

}
    
