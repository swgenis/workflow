package za.ac.nwu.workflow.backbone;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jbpm.formModeler.api.client.FormRenderContext;
import org.jbpm.formModeler.api.model.Field;
import org.jbpm.formModeler.core.config.SelectValuesProvider;

public class CampusSelector implements SelectValuesProvider {

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getSelectOptions(Field field, String value,
			FormRenderContext renderContext, Locale locale) {
		Map<String, String> campusList = new HashMap<String, String>();
		campusList.put("1", "Potchefstroom");
		campusList.put("2", "Mafikeng");
		campusList.put("3", "Vaaldriehoek");
		return campusList;
	}

}
