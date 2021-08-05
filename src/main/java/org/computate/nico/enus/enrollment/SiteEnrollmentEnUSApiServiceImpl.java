package org.computate.nico.enus.enrollment;

import org.computate.nico.enus.request.SiteRequestEnUS;

import io.vertx.core.Future;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.pgclient.PgPool;

/**
 * Translate: false
 **/
public class SiteEnrollmentEnUSApiServiceImpl extends SiteEnrollmentEnUSGenApiServiceImpl {


	public SiteEnrollmentEnUSApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider);
	}

	@Override
	public Future<Void> sqlPOSTSiteEnrollment(SiteEnrollment o, Boolean inheritPk) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		JsonObject jsonObject = siteRequest.getJsonObject();
		Long userKey = siteRequest.getUserKey();

		if(userKey != null)
			jsonObject.put("userKey", userKey.toString());

		return super.sqlPOSTSiteEnrollment(o, inheritPk);
	}
}
