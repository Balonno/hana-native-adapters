package com.sap.hsc.voraadapter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sap.hana.dp.adapter.sdk.Adapter;
import com.sap.hana.dp.adapter.sdk.AdapterException;
import com.sap.hana.dp.adapter.sdk.AdapterFactory;
import com.sap.hana.dp.adapter.sdk.RemoteSourceDescription;

public class VoraAdapterFactory implements AdapterFactory{
	
	static Logger logger = LogManager.getLogger(VoraAdapter.class.getName());

	@Override
	public Adapter createAdapterInstance() {
		return new VoraAdapter();
	}

	@Override
	public String getAdapterType() {
		logger.info("Adapter getAdapterType() VoraAdapter called");
		return "VoraAdapter";
		
	}

	@Override
	public String getAdapterDisplayName() {
		return "VoraAdapter";
	}

	@Override
	public String getAdapterDescription() {
		return "SAP Vora Adapter Data Provisioning Adapter";
	}
	
	@Override
	public RemoteSourceDescription getAdapterConfig() throws AdapterException {
		return null;
	}
	
	@Override
	public boolean validateAdapterConfig(RemoteSourceDescription remoteSourceDescription)
			throws AdapterException {
		try{
		Integer.parseInt(remoteSourceDescription
				.getConnectionProperties().getPropertyEntry("port").getValue());
		}
		catch(NumberFormatException e)
		{
			throw new AdapterException("Port number should be an unsigned integer. eg: 3306, 65000, etc.");
		}
		return true;
	}

	@Override
	public RemoteSourceDescription upgrade(RemoteSourceDescription arg0)
			throws AdapterException {
		// TODO Auto-generated method stub
		return null;
	}

}