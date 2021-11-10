package br.com.nr12.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.nr12.dao.jpa.ClienteJPADAO;
import br.com.nr12.dao.jpa.ConfiguracoesJPADAO;

import br.com.nr12.dao.jpa.DisposicaoFinalJPADAO;
import br.com.nr12.dao.jpa.InstalacoesDispEletricoJPADAO;
import br.com.nr12.dao.jpa.LaudoJPADAO;
import br.com.nr12.dao.jpa.ManualJPADAO;
import br.com.nr12.dao.jpa.MaquinaJPADAO;
import br.com.nr12.dao.jpa.NormaTecnicaJPADAO;
import br.com.nr12.model.Cliente;
import br.com.nr12.model.Configuracoes;
import br.com.nr12.model.DisposicaoFinal;
import br.com.nr12.model.Dispositivo;
import br.com.nr12.model.InstalacoesDispEletrico;
import br.com.nr12.model.Intervencao;
import br.com.nr12.model.Laudo;
import br.com.nr12.model.Manual;
import br.com.nr12.model.Maquina;
import br.com.nr12.model.NormaTecnica;
import br.com.nr12.model.PontoPerigo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PdfService extends UtilService{
	
	private String saida; 
	
	public PdfService(HttpServletRequest request){
		super.request = request;
	}
	
	public String geraRelatorio(int idLaudo){
		
		saida = null;
		
		String pagina1 = getDiretorioReal("/report/Pagina1.jasper");
		String pagina2 = getDiretorioReal("/report/Pagina2.jasper");
		String pagina3 = getDiretorioReal("/report/Pagina3.jasper");
		String pagina4 = getDiretorioReal("/report/Pagina4.jasper");
		String pagina5 = getDiretorioReal("/report/Pagina5.jasper");
		String pagina6 = getDiretorioReal("/report/Pagina6.jasper");
		String pagina7 = getDiretorioReal("/report/Pagina7.jasper");
		String pagina8 = getDiretorioReal("/report/Pagina8.jasper");
		String pagina9 = getDiretorioReal("/report/Pagina9.jasper");
		String pagina10 = getDiretorioReal("/report/Pagina10.jasper");
		String pagina11 = getDiretorioReal("/report/Pagina11.jasper");
		String pagina12 = getDiretorioReal("/report/Pagina12.jasper");
		String pagina13 = getDiretorioReal("/report/Pagina13.jasper");
		String pagina14 = getDiretorioReal("/report/Pagina14.jasper");
		String pagina15 = getDiretorioReal("/report/Pagina15.jasper");
		String pagina16 = getDiretorioReal("/report/Pagina16.jasper");
		String pagina17 = getDiretorioReal("/report/Pagina17.jasper");
		String pagina18 = getDiretorioReal("/report/Pagina18.jasper");
		
		ArrayList<Laudo> laudo = buscarPrimeiraPagina(idLaudo);
		
		String laudoPdf = "/pdf/"+laudo.get(0).getCodigo()+".pdf";
		
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			// pagina1 - Titulos
			
			map.put("laudo", laudo.get(0));
			map.put("maquina", laudo.get(0).getMaquina().getNome());

			
			System.out.println(laudo.get(0).getMaquina().getTipoMaquina().getNome());
			JRBeanCollectionDataSource ds1 = new JRBeanCollectionDataSource(laudo);
			JasperPrint print1 = JasperFillManager.fillReport(pagina1, map, ds1);
			preencherPdf(print1, 1);
			
			// pagina2 - 1. Portaria Vigente
			ArrayList<Configuracoes> config = buscarConfiguracoes();
			JRBeanCollectionDataSource ds2 = new JRBeanCollectionDataSource(config);
			JasperPrint print2 = JasperFillManager.fillReport(pagina2, map, ds2);
			preencherPdf(print2, 2);
			
			// pagina3 - 2. IdentificaÃ§Ã£o da Empresa
			//ArrayList<Cliente> cliente = buscarCliente(idLaudo);
			JRBeanCollectionDataSource ds3 = new JRBeanCollectionDataSource(laudo);
			JasperPrint print3 = JasperFillManager.fillReport(pagina3, map, ds3);
			preencherPdf(print3, 3);
			
			// pagina4 - 3. IdentificaÃ§Ã£o da mÃ¡quina
			//ArrayList<Maquina> maquina = buscarMaquina(idLaudo);
			JRBeanCollectionDataSource ds4 = new JRBeanCollectionDataSource(laudo);
			JasperPrint print4 = JasperFillManager.fillReport(pagina4, map, ds4);
			preencherPdf(print4, 4);
			
			
			// pagina  - Limites da MÃ¡quina
			
			
			
			// pagina5 - 4. Pontos de perigo e sistemas de seguranÃ§a
			
			List<PontoPerigo> pontosPerigo = buscarPontosPerigo(idLaudo);
			JRBeanCollectionDataSource ds5 = new JRBeanCollectionDataSource(pontosPerigo);
			JasperPrint print5 = JasperFillManager.fillReport(pagina5, map, ds5);
			preencherPdf(print5, 5);
						
			// pagina6 - 5. Dispositivos de partida, acionamento e parada
			map.put("dispositivos", config.get(0).getDispositivos());
			List<Dispositivo> dispositivos = buscarDispositivos(idLaudo);
			JRBeanCollectionDataSource ds6 = new JRBeanCollectionDataSource(dispositivos);
			JasperPrint print6 = JasperFillManager.fillReport(pagina6, map, ds6);
			preencherPdf(print6, 6);
			
			// pagina18 - 5. Dispositivos de parada de emergência
			map.put("dispositivos", config.get(0).getDispositivos());
			List<Dispositivo> dispositivos2 = buscarDispositivos(idLaudo);
			JRBeanCollectionDataSource ds18 = new JRBeanCollectionDataSource(dispositivos2);
			JasperPrint print18 = JasperFillManager.fillReport(pagina18, map, ds18);
			preencherPdf(print18, 18);
			
			// pagina7 - 6. CapacitaÃ§Ã£o
			JRBeanCollectionDataSource ds7 = new JRBeanCollectionDataSource(laudo);
			JasperPrint print7 = JasperFillManager.fillReport(pagina7, map, ds7);
			preencherPdf(print7, 7);
			
			// pagina8 - 7. Normas tÃ©cnicas aplicadas
			//List<NormaTecnica> normaTecnica = buscarNormaTecnicaLaudo(idLaudo);
			JRBeanCollectionDataSource ds8 = new JRBeanCollectionDataSource(laudo);
			JasperPrint print8 = JasperFillManager.fillReport(pagina8, map, ds8);
			preencherPdf(print8, 8);
			
			// pagina9 - 8. DisposiÃ§Ãµes Finais
			JRBeanCollectionDataSource ds9 = new JRBeanCollectionDataSource(config);
			JasperPrint print9 = JasperFillManager.fillReport(pagina9, map, ds9);
			preencherPdf(print9, 9);
			
			// pagina10 - 9. Responsabilidade tÃ©cnica
			JRBeanCollectionDataSource ds10 = new JRBeanCollectionDataSource(config);
			JasperPrint print10 = JasperFillManager.fillReport(pagina10, map, ds10);
			preencherPdf(print10, 10);
			
			// pagina10 - 9. Responsabilidade tÃ©cnica
			JRBeanCollectionDataSource ds11 = new JRBeanCollectionDataSource(laudo);
			JasperPrint print11 = JasperFillManager.fillReport(pagina11, map, ds11);
			preencherPdf(print11, 11);
			
			List<InstalacoesDispEletrico> instalacoesdispeletrico = buscarInstalacoesDispEletrico(idLaudo);
			map.put("instalacoesdispeletrico", instalacoesdispeletrico.get(0));
			JRBeanCollectionDataSource ds12 = new JRBeanCollectionDataSource(instalacoesdispeletrico);
			JasperPrint print12 = JasperFillManager.fillReport(pagina12, map, ds12);
			preencherPdf(print12, 12);
			
			List<Intervencao> intervencao = buscarIntervencao(idLaudo);
			
			JRBeanCollectionDataSource ds13 = new JRBeanCollectionDataSource(intervencao);
			JasperPrint print13 = JasperFillManager.fillReport(pagina13, map, ds13);
			preencherPdf(print13, 13);
	
			JRBeanCollectionDataSource ds14 = new JRBeanCollectionDataSource(intervencao);
			JasperPrint print14 = JasperFillManager.fillReport(pagina14, map, ds14);
			preencherPdf(print14, 14);
			
			JRBeanCollectionDataSource ds15 = new JRBeanCollectionDataSource(intervencao);
			JasperPrint print15 = JasperFillManager.fillReport(pagina15, map, ds15);
			preencherPdf(print15, 15);
			
			List<Manual> manual = buscarManual(idLaudo);
			map.put("manual", manual.get(0));
			JRBeanCollectionDataSource ds16 = new JRBeanCollectionDataSource(manual);
			JasperPrint print16 = JasperFillManager.fillReport(pagina16, map, ds16);
			preencherPdf(print16, 16);
			
			JRBeanCollectionDataSource ds17 = new JRBeanCollectionDataSource(laudo);
			JasperPrint print17 = JasperFillManager.fillReport(pagina17, map, ds17);
			preencherPdf(print17, 17);
						
			
			
			/*
			List<InputStream> inputPdfList = new ArrayList<InputStream>();
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina1.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina2.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina3.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina4.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina11.pdf")));
			
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina5.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina6.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina7.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina8.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina9.pdf")));
			inputPdfList.add(new FileInputStream(getDiretorioReal("/pdf/pagina10.pdf")));
			
			OutputStream outputStream = new FileOutputStream(getDiretorioReal(laudoPdf));
			
			mergePdfFiles(inputPdfList, outputStream);

			*/
			Document document = new Document();
			PdfCopy merge = new PdfCopy(document, new FileOutputStream(getDiretorioReal(laudoPdf)));
			merge.setMergeFields();
			document.open();
			PdfReader pag1 = new PdfReader(getDiretorioReal("/pdf/pagina1.pdf"));
			merge.addDocument(pag1);
			PdfReader pag2 = new PdfReader(getDiretorioReal("/pdf/pagina2.pdf"));
			merge.addDocument(pag2);
			PdfReader pag3 = new PdfReader(getDiretorioReal("/pdf/pagina3.pdf"));
			merge.addDocument(pag3);
			PdfReader pag4 = new PdfReader(getDiretorioReal("/pdf/pagina4.pdf"));
			merge.addDocument(pag4);
			PdfReader pag11 = new PdfReader(getDiretorioReal("/pdf/pagina11.pdf"));
			merge.addDocument(pag11);
			PdfReader pag5 = new PdfReader(getDiretorioReal("/pdf/pagina5.pdf"));
			merge.addDocument(pag5);
			PdfReader pag14 = new PdfReader(getDiretorioReal("/pdf/pagina14.pdf"));
			merge.addDocument(pag14);
			PdfReader pag15 = new PdfReader(getDiretorioReal("/pdf/pagina15.pdf"));
			merge.addDocument(pag15);
			PdfReader pag13 = new PdfReader(getDiretorioReal("/pdf/pagina13.pdf"));
			merge.addDocument(pag13);
			PdfReader pag12 = new PdfReader(getDiretorioReal("/pdf/pagina12.pdf"));
			merge.addDocument(pag12);
			PdfReader pag6 = new PdfReader(getDiretorioReal("/pdf/pagina6.pdf"));
			merge.addDocument(pag6);
			PdfReader pag18 = new PdfReader(getDiretorioReal("/pdf/pagina18.pdf"));
			merge.addDocument(pag18);
			PdfReader pag7 = new PdfReader(getDiretorioReal("/pdf/pagina7.pdf"));
			merge.addDocument(pag7);
			PdfReader pag16 = new PdfReader(getDiretorioReal("/pdf/pagina16.pdf"));
			merge.addDocument(pag16);
			PdfReader pag8 = new PdfReader(getDiretorioReal("/pdf/pagina8.pdf"));
			merge.addDocument(pag8);
			//PdfReader pag9 = new PdfReader(getDiretorioReal("/pdf/pagina9.pdf"));
			//merge.addDocument(pag9);
			PdfReader pag17 = new PdfReader(getDiretorioReal("/pdf/pagina17.pdf"));
			merge.addDocument(pag17);
			PdfReader pag10 = new PdfReader(getDiretorioReal("/pdf/pagina10.pdf"));
			merge.addDocument(pag10);	
			
			document.close();
			pag1.close(); //capa
			pag2.close(); //portaria vigente
			pag3.close(); //empresa contratante
			pag4.close(); //identificação da maquina
			pag11.close(); //limites da maquina
			pag5.close(); //pontos de perigo e sistemas de segurança
			pag14.close(); //miparl 6.0
			pag15.close(); //intervenções
			pag13.close(); //miparl 6.1
			pag12.close(); //instalações e dispositivos eletricos
			pag6.close(); //dispositivos de parada, acionamento e partida
			pag18.close(); //dispositivos de parada de emergencia
			pag7.close(); //capacitação
			pag16.close(); //manuais
			pag8.close(); //normas técnicas aplicadas
			//pag9.close();
			pag17.close(); //disposições finais
			pag10.close(); //responsabilidade técnica
			
		
			saida = getContextPath() + laudoPdf;
			//saida = getContextPath() + "/pdf/pagina5.pdf";
			
			//saida = "NR12" + laudoPdf;
			System.out.println("saida: " + saida);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return saida;
	}
	
	static void mergePdfFiles(List<InputStream> inputPdfList,
	        OutputStream outputStream) throws Exception{
	    //Create document and pdfReader objects.
	    Document document = new Document();
	    List<PdfReader> readers = 
	            new ArrayList<PdfReader>();
	    int totalPages = 0;

	    //Create pdf Iterator object using inputPdfList.
	    Iterator<InputStream> pdfIterator = inputPdfList.iterator();

	    // Create reader list for the input pdf files.
	    while (pdfIterator.hasNext()) {
	            InputStream pdf = pdfIterator.next();
	            PdfReader pdfReader = new PdfReader(pdf);
	            readers.add(pdfReader);
	            totalPages = totalPages + pdfReader.getNumberOfPages();
	    }

	    // Create writer for the outputStream
	    PdfWriter writer = PdfWriter.getInstance(document, outputStream);

	    //Open document.
	    document.open();

	    //Contain the pdf data.
	    PdfContentByte pageContentByte = writer.getDirectContent();

	    PdfImportedPage pdfImportedPage;
	    int currentPdfReaderPage = 1;
	    Iterator<PdfReader> iteratorPDFReader = readers.iterator();

	    // Iterate and process the reader list.
	    while (iteratorPDFReader.hasNext()) {
	            PdfReader pdfReader = iteratorPDFReader.next();
	            //Create page and add content.
	            while (currentPdfReaderPage <= pdfReader.getNumberOfPages()) {
	                  document.newPage();
	                  pdfImportedPage = writer.getImportedPage(pdfReader,currentPdfReaderPage);
	                  pageContentByte.addTemplate(pdfImportedPage, 0, 0);
	                  currentPdfReaderPage++;
	            }
	            currentPdfReaderPage = 1;
	    }

	    //Close document and outputStream.
	    outputStream.flush();
	    document.close();
	    outputStream.close();

	    System.out.println("Pdf files merged successfully.");
	}
	
	private List<PontoPerigo> buscarPontosPerigo(int idLaudo) {
		List<PontoPerigo> array = null;
		LaudoJPADAO dao = new LaudoJPADAO();
		array = dao.buscarPontosPerigo(idLaudo);
		return array;
	}
	
	private List<Dispositivo> buscarDispositivos(int idLaudo) {
		List<Dispositivo> array = null;
		LaudoJPADAO dao = new LaudoJPADAO();
		array = dao.buscarDispositivos(idLaudo);
		return array;
	}

	private void preencherPdf(JasperPrint print, int numPag) throws JRException{
		String path = "/pdf/pagina"+numPag+".pdf";
		String caminho = getDiretorioReal(path);
		JasperExportManager.exportReportToPdfFile(print, caminho);
		caminho = getContextPath() + path;
		System.out.println("PDF: " + caminho);
	}
	
	private ArrayList<Laudo> buscarPrimeiraPagina(int idLaudo) {
		ArrayList<Laudo> arrayLaudo = new ArrayList<Laudo>();
		Laudo laudo = new Laudo();
		LaudoJPADAO dao = new LaudoJPADAO();
		//laudo = dao.buscarPrimeiraPagina(idLaudo);
		laudo = dao.buscarPrimeiraPagina(idLaudo);
		arrayLaudo.add(laudo);
		return arrayLaudo;
	}
	
	private ArrayList<Configuracoes> buscarConfiguracoes() {
		ArrayList<Configuracoes> arrayCfg = new ArrayList<Configuracoes>();
		Configuracoes cfg = new Configuracoes();
		ConfiguracoesJPADAO dao = new ConfiguracoesJPADAO();
		cfg = dao.buscarConfiguracoes();
		arrayCfg.add(cfg);
		return arrayCfg;
	}
	
	
	private List<InstalacoesDispEletrico> buscarInstalacoesDispEletrico(int idLaudo) {
		List<InstalacoesDispEletrico> arrayInstalacoesDispEletrico = new ArrayList<InstalacoesDispEletrico>();
		InstalacoesDispEletricoJPADAO dao = new InstalacoesDispEletricoJPADAO();
		arrayInstalacoesDispEletrico = dao.buscarInstalacoesDispEletricoLaudo(idLaudo);
		return arrayInstalacoesDispEletrico;
	}
	
	private List<Intervencao> buscarIntervencao(int idLaudo) {
		List<Intervencao> array = null;
		LaudoJPADAO dao = new LaudoJPADAO();
		array = dao.buscarIntervencao(idLaudo);
		return array;
	}
	
	private ArrayList<Cliente> buscarCliente(int idLaudo) {
		ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		ClienteJPADAO dao = new ClienteJPADAO();
		cliente = dao.buscarCliente(idLaudo);
		arrayCliente.add(cliente);
		return arrayCliente;
	}
	
	private List<NormaTecnica> buscarNormaTecnicaLaudo(int idLaudo) {
		List<NormaTecnica> arrayNormaTecnica = new ArrayList<NormaTecnica>();
		NormaTecnicaJPADAO dao = new NormaTecnicaJPADAO();
		arrayNormaTecnica = dao.buscarNormaTecnicaLaudo(idLaudo);
		return arrayNormaTecnica;
	}
	
	private ArrayList<Maquina> buscarMaquina(int idLaudo) {
		ArrayList<Maquina> arrayMaquina = new ArrayList<Maquina>();
		Maquina maquina = new Maquina();
		MaquinaJPADAO dao = new MaquinaJPADAO();
		maquina = dao.buscarMaquina(idLaudo);
		arrayMaquina.add(maquina);
		return arrayMaquina;
	}	
	
	private List<Manual> buscarManual(int idLaudo) {
		List<Manual> arrayManual = new ArrayList<Manual>();
		ManualJPADAO dao = new ManualJPADAO();
		arrayManual = dao.buscarManualLaudo(idLaudo);
		return arrayManual;
	}
	
	private List<DisposicaoFinal> buscarDisposicaoFinal(int idLaudo) {
		List<DisposicaoFinal> arrayDisposicaoFinal = new ArrayList<DisposicaoFinal>();
		DisposicaoFinalJPADAO dao = new DisposicaoFinalJPADAO();
		arrayDisposicaoFinal = dao.buscarDisposicaoFinalLaudo(idLaudo);
		return arrayDisposicaoFinal;
	}
	
	
}
