package com.sap.hsc.voraadapter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.sap.hana.dp.adapter.sdk.AdapterFactory;

public class Activator  implements BundleActivator {

	private static BundleContext context;
	
	static Logger logger = LogManager.getLogger(VoraAdapter.class.getName());

	static BundleContext getContext() {
		return context;
	}

	ServiceRegistration<?> adapterRegistration;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		logger.info("Adapter VoraAdapter Started");
		VoraAdapterFactory srv = new VoraAdapterFactory();
		adapterRegistration = context.registerService(AdapterFactory.class.getName(),srv ,null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		logger.info("Adapter "+ "VoraAdapter" +" stopped");
		adapterRegistration.unregister();
	}

}