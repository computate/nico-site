package org.computate.nico.enus.enrollment;

import org.computate.nico.enus.context.SiteContextEnUS;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.ext.web.api.generator.WebApiServiceGen;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

/**
 * Translate: false
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface SiteEnrollmentEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("nico-site-enUS-SiteEnrollment").register(SiteEnrollmentEnUSGenApiService.class, new SiteEnrollmentEnUSApiServiceImpl(siteContext));
	}

	static SiteEnrollmentEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new SiteEnrollmentEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static SiteEnrollmentEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new SiteEnrollmentEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void putimportSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void putmergeSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void putcopySiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void postSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void patchSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void getSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void adminsearchSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageSiteEnrollmentId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}
