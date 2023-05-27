package it.eng.myportal.beans.yg;

import it.eng.myportal.beans.AbstractBaseBean;
import it.eng.myportal.dtos.YgDichiarazioneNeetDTO;
import it.eng.myportal.dtos.YgDichiarazioneNeetFilterDTO;
import it.eng.myportal.entity.enums.YgDichiarazioneNeetStatoEnum;
import it.eng.myportal.entity.home.YgDichiarazioneNeetHome;
import it.eng.myportal.exception.MyPortalException;
import it.eng.myportal.helpers.LazyYgDichiarazioneNeetModel;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ViewScoped
public class YgAziendaDichiarazioneNeetBean extends AbstractBaseBean {
	protected static Log log = LogFactory.getLog(YgAziendaDichiarazioneNeetBean.class);

	@EJB
	private YgDichiarazioneNeetHome ygDichiarazioneNeetHome;

	// Search params and results
	private YgDichiarazioneNeetFilterDTO searchParams;
	private LazyYgDichiarazioneNeetModel searchResults;
	private List<SelectItem> statoSelectItems;
	private StreamedContent dichiarazionePdfFile;

	@PostConstruct
	public void postConstruct() {
		searchParams = new YgDichiarazioneNeetFilterDTO();
		searchParams.setIdPrincipalAzienda(this.getSession().getConnectedAzienda().getId());
		createStatoSelectItems();
		doSearch();
	}

	public StreamedContent getStampaPdf(Integer idYgDichiarazioneNeet) {
		try {
			dichiarazionePdfFile = ygDichiarazioneNeetHome.createStampaPdfFile(idYgDichiarazioneNeet);
		} catch (MyPortalException e) {
			addErrorMessage("pdf.error");
		}
		return dichiarazionePdfFile;
	}

	public StreamedContent getDocumentoIdentitaFile(Integer idYgDichiarazioneNeet) {
		List<YgDichiarazioneNeetDTO> dichiarazioni = (List<YgDichiarazioneNeetDTO>) searchResults.getWrappedData();
		YgDichiarazioneNeetDTO selectedDichiarazione = null;
		for (YgDichiarazioneNeetDTO dichiarazione : dichiarazioni) {
			if (dichiarazione.getId().equals(idYgDichiarazioneNeet))
				selectedDichiarazione = dichiarazione;
		}

		return new DefaultStreamedContent(new ByteArrayInputStream(selectedDichiarazione.getExtDocumentoFile()),
				selectedDichiarazione.getExtDocumentoFileMimeType(), selectedDichiarazione.getExtDocumentoFileName());
	}

	public void createStatoSelectItems() {
		statoSelectItems = new ArrayList<SelectItem>();
		statoSelectItems.add(new SelectItem(null, "Tutti"));
		statoSelectItems.add(new SelectItem(YgDichiarazioneNeetStatoEnum.COMPLETO, "Completa"));
		statoSelectItems.add(new SelectItem(YgDichiarazioneNeetStatoEnum.INCOMPLETO, "Incompleta"));
		statoSelectItems.add(new SelectItem(YgDichiarazioneNeetStatoEnum.CANCELLATO, "Cancellata"));
	}

	public void doSearch() {
		searchResults = new LazyYgDichiarazioneNeetModel(searchParams);
	}

	public String redirectToDetail(Integer dichiarazioneId) {
		return "view?faces-redirect=true&dichiarazioneId=" + dichiarazioneId;
	}

	public YgDichiarazioneNeetFilterDTO getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(YgDichiarazioneNeetFilterDTO searchParams) {
		this.searchParams = searchParams;
	}

	public LazyYgDichiarazioneNeetModel getSearchResults() {
		return searchResults;
	}

	public List<SelectItem> getStatoSelectItems() {
		return statoSelectItems;
	}
}
