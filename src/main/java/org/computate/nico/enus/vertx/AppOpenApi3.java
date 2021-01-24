package org.computate.nico.enus.vertx;

import org.computate.nico.enus.context.SiteContextEnUS;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.computate.nico.enus.wrap.Wrap;

public class AppOpenApi3 extends AppOpenApi3Gen<AppSwagger2> {

	@Override()
	protected void  _apiVersion(Wrap<String> c) {
		c.o("3.0.0");
	}

	public static void  main(String[] args) {
		AppOpenApi3 api = new AppOpenApi3();
		SiteContextEnUS siteContext = new SiteContextEnUS();
		siteContext.initDeepSiteContextEnUS(null);
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
		siteRequest.setSiteContext_(siteContext);
		siteRequest.setSiteConfig_(siteContext.getSiteConfig());
		siteRequest.initDeepSiteRequestEnUS();
		api.initDeepAppOpenApi3(siteRequest);
		api.writeOpenApi();
	}
}
