package za.ac.nwu.workflow.leave;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author SW Genis
 *
 */
public class LeavePeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    private String typeKey;

    private Date startDate;

    private Date endDate;

    public String getTypeKey() {
	return typeKey;
    }

    public void setTypeKey(String typeKey) {
	this.typeKey = typeKey;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

}
