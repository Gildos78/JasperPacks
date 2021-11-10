package br.com.nr12.rest;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.nr12.exception.MyException;
import br.com.nr12.service.PdfService;


@Path("relatorio")
public class PdfRest extends UtilRest{
	@Context
	private HttpServletRequest request;

	@GET
	@Path("/gerar/{idLaudo}")
	@Consumes("application/*")
	//ssss@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // Define os tipos de dados retornados
	public Response gerarRelatorio(@PathParam("idLaudo") int idLaudo) {
		
		System.out.println("## PdfRest/gerarRelatorio ##");
		System.out.println("ID Laudo = "+idLaudo);
		
		try{
							
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
			
			try {
				PdfService pdfService = new PdfService(request);
				String resposta = pdfService.geraRelatorio(idLaudo);
				
				System.out.println(resposta);
				return this.buildResponse(resposta);
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Erro na leitura dos dados!", e);
			}
		}catch(MyException e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
}
