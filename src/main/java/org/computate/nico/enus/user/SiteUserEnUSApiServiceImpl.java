package org.computate.nico.enus.user;

import org.computate.nico.enus.request.SiteRequestEnUS;

import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.pgclient.PgPool;

/**
 * Translate: false
 **/
public class SiteUserEnUSApiServiceImpl extends SiteUserEnUSGenApiServiceImpl {

	public SiteUserEnUSApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	@Override
	public Boolean userDefine(SiteRequestEnUS siteRequest, JsonObject jsonObject, Boolean patch) {
		if("/user".equals(siteRequest.getRequestUri()))
			return true;
		else
			return super.userDefine(siteRequest, jsonObject, patch);
	}
}
