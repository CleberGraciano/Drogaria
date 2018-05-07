package br.pro.delfino.drogaria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.pro.delfino.drogaria.bean.AutenticacaoBean;
import br.pro.delfino.drogaria.domain.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent event) {
		//System.out.println("DEPOIS DA FASE"+event.getPhaseId());
		
		String paginaAtual = Faces.getViewId();
		System.out.println("Pagina Atual"+paginaAtual);
		
		boolean  ehPaginaDeAutenticacao = paginaAtual.contains("autenticacao.xhtml");
		// Verifica se está na tela publica ou bloqueada 
		if(!ehPaginaDeAutenticacao) {
			
			//Pego o Bean da autenticação
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");
			
			//Se o Bean não foi criado quer dizer que eu nunca entrei na Tela então eu navego para a tela de login 
			if(autenticacaoBean == null) {
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}
			
			// Se o Bean já foi criado eu pego o Usuario 
			Usuario usuario = autenticacaoBean.getUsuarioLogado();
			
			// Se o usuario for Nulo eu tambem não consegui logar e navego para a tela de autenticação novamente
			if(usuario == null) {
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}
			
		
			
		}
				
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		//System.out.println("ANTES DA FASE"+event.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	

}
