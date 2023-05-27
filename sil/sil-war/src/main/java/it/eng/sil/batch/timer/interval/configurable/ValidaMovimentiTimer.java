package it.eng.sil.batch.timer.interval.configurable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;

import it.eng.sil.util.batch.mdb.BatchMDBHelper;
import it.eng.sil.util.batch.mdb.BatchObject;

/**
 * Timer per la validazione dei movimenti
 * 
 * @author OMenghini
 *
 */
@Singleton
@Startup
@Named(ValidaMovimentiTimer.TIMER_NAME)
public class ValidaMovimentiTimer extends ConfigurableTimerBatch {

	static final String TIMER_NAME = "validaMovimentiTimer";
	private static final String CLASS_EXECUTE_BATCH = "it.eng.sil.util.batch.BatchValidaMovimenti";
	
	@Resource
	private TimerService timerService;

	@PostConstruct
	public void initScheduling() {
		this.init(TIMER_NAME, CLASS_EXECUTE_BATCH, timerService);
		this.scheduleTimer();
	}

	@Timeout
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void sendMessage(Timer timer) throws Exception {
		log.info(TIMER_NAME + ": inizio sendMessage()");

		// Recupero le informazioni del timer
		InfoTimer info = (InfoTimer) timer.getInfo();
		
		String comando = info.getClassExecuteBatch();
		comando += " " + info.getBatchUserInfo() + " " + this.getCpiCompetenza() + " " + this.getNumMovimentiDaValidare()
				+ " " + this.getNumMaxGiorniPrimaValidazione() + " " + info.getOraInterruzione();

		BatchMDBHelper batchHelper = new BatchMDBHelper();
		batchHelper.enqueue(new BatchObject(comando, false));

		log.info(TIMER_NAME + ": fine sendMessage()");
	}

	private String getCpiCompetenza() {
		return System.getProperty("batch.validaMovimentiTimer.cpiCompetenza");
	}

	private String getNumMovimentiDaValidare() {
		return System.getProperty("batch.validaMovimentiTimer.numMovimentiDaValidare");
	}

	private String getNumMaxGiorniPrimaValidazione() {
		return System.getProperty("batch.validaMovimentiTimer.numMaxGiorniPrimaValidazione");
	}
}
