package it.eng.sil.module.agenda;

import java.util.Vector;

import com.engiweb.framework.base.SourceBean;
import com.engiweb.framework.dbaccess.DataConnectionManager;
import com.engiweb.framework.dbaccess.Utils;
import com.engiweb.framework.dbaccess.sql.DataConnection;
import com.engiweb.framework.dbaccess.sql.DataRow;
import com.engiweb.framework.dbaccess.sql.SQLCommand;
import com.engiweb.framework.dbaccess.sql.result.DataResult;
import com.engiweb.framework.dbaccess.sql.result.DataResultInterface;
import com.engiweb.framework.dbaccess.sql.result.ScrollableDataResult;
import com.engiweb.framework.dispatching.module.list.basic.AbstractBasicListModule;
import com.engiweb.framework.paginator.basic.ListIFace;
import com.engiweb.framework.paginator.basic.PaginatorIFace;
import com.engiweb.framework.paginator.basic.impl.GenericList;
import com.engiweb.framework.paginator.basic.impl.GenericPaginator;

/*
 * Ottiene il sommario giornaliero degli appuntamenti
 * Questa classe è la DynamicStatementListModule modificata
 * per restituire una lista di una sola pagina
 * 
 * @author: Stefania Orioli
 * 
 */

import it.eng.afExt.dbaccess.sql.IDynamicStatementProvider;

public class ContattiModule extends AbstractBasicListModule {

	static org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ContattiModule.class.getName());

	public ContattiModule() {
	}

	public ListIFace getList(SourceBean request, SourceBean response) {

		DataConnection dc = null;
		DataConnectionManager dcm = null;
		SQLCommand cmdSelect = null;
		DataResult dr = null;
		String className = this.getClass().getName();

		PaginatorIFace paginator = new GenericPaginator();
		// int pagedRows=Integer.parseInt((String)
		// getConfig().getAttribute("ROWS"));
		/*
		 * Pongo pagedRows = 20 ---> poi più avanti setto il valore corretto in modo da avere solamente una pagina!
		 */
		int pagedRows = 20;
		paginator.setPageSize(pagedRows);

		String pool = (String) getConfig().getAttribute("POOL");
		ListIFace list = new GenericList();

		try {

			// PRENDE IL NOME DELLA CLASSE CHE RITORNA LA STRINGA DELLA
			// QUERY

			SourceBean query = (SourceBean) getConfig().getAttribute("QUERIES.SELECT_QUERY");
			String statementProviderClassName = (String) query.getAttribute("STATEMENT_PROVIDER.CLASS");

			// INSTANZIA LA CLASSE CHE RITORNA LE QUERY
			IDynamicStatementProvider statementProvider = (IDynamicStatementProvider) Class
					.forName(statementProviderClassName).newInstance();

			String statement = statementProvider.getStatement(getRequestContainer(), getConfig());

			dcm = DataConnectionManager.getInstance();
			if (dcm == null) {
				_logger.debug(className + "::getList: dcm null");

			}
			dc = dcm.getConnection(pool);

			if (dc == null) {
				_logger.debug(className + "::getList: dc null");

			}

			cmdSelect = dc.createSelectCommand(statement);

			_logger.debug(className + "::getList: eseguo query " + statement);

			// esegue la query
			dr = cmdSelect.execute();

			// crea la lista con il DataResult
			ScrollableDataResult sdr = null;

			if (dr.getDataResultType().equals(DataResultInterface.SCROLLABLE_DATA_RESULT)) {
				sdr = (ScrollableDataResult) dr.getDataObject();
			}

			SourceBean rowsSourceBean = sdr.getSourceBean();
			Vector rowsVector = null;
			if (rowsSourceBean != null)
				rowsVector = rowsSourceBean.getAttributeAsVector(DataRow.ROW_TAG);

			if ((rowsSourceBean == null) || (rowsVector.size() == 0)) {
				/*
				 * EMFErrorHandler engErrorHandler = getErrorHandler(); engErrorHandler.addError( new
				 * EMFUserError(EMFErrorSeverity.INFORMATION, 10001));
				 */
				getResponseContainer().getServiceResponse().setAttribute("NO_ELEMENTS", "TRUE");
			} // if ((rowsSourceBean == null) || (rowsVector.size() == 0))
			else {
				paginator.setPageSize(rowsVector.size());
				for (int i = 0; i < rowsVector.size(); i++)
					paginator.addRow(rowsVector.elementAt(i));
			}
			list.setPaginator(paginator);

			Vector columnNames = new Vector();
			Vector columnNameBeans = getConfig().getAttributeAsVector("COLUMNS.COLUMN");
			for (int i = 0; i < columnNameBeans.size(); i++) {
				SourceBean columnNameBean = (SourceBean) columnNameBeans.elementAt(i);
				columnNames.addElement((String) columnNameBean.getAttribute("LABEL"));
			} // for (int i = 0; i < columnNameBeans.size(); i++)

			// list.setColumnNames(columnNames);
			// list.addStaticData(firstData);

		} catch (Exception e) {
			_logger.error(className + "::getList: " + e.getMessage());

		} finally {
			Utils.releaseResources(dc, cmdSelect, dr);
		}

		return list;
	} // public ListIFace getList(SourceBean request)

	public void callback(SourceBean request, ListIFace list, int page) {
		// list.addDynamicData(firstData);
	} // public void callback(SourceBean request, ListIFace list, int page)

} // public class ContattiModule extends AbstractListModule
