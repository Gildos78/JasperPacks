package br.com.nr12.service;

import javax.servlet.http.HttpServletRequest;

public class UtilService {
	
	protected HttpServletRequest request;

	protected String getDiretorioReal(String diretorio){
		return request.getSession().getServletContext().getRealPath(diretorio);
	}
	
	protected String getContextPath(){
		
		return request.getServletContext().getContextPath();
	}
}
