package org.computate.nico.enus.pet;

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
public interface SitePetEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("nico-site-enUS-SitePet").register(SitePetEnUSGenApiService.class, new SitePetEnUSApiServiceImpl(siteContext));
	}

	static SitePetEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new SitePetEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static SitePetEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new SitePetEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void putimportSitePet(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void putmergeSitePet(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void putcopySitePet(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void postSitePet(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void patchSitePet(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void getSitePet(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchSitePet(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void adminsearchSitePet(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageSitePetId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageSitePet(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}
