package org.computate.nico.enus.enrollment;

import org.computate.nico.enus.context.SiteContextEnUS;
import org.computate.nico.enus.request.SiteRequestEnUS;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

/**
 * Translate: false
 **/
public class SiteEnrollmentEnUSApiServiceImpl extends SiteEnrollmentEnUSGenApiServiceImpl {

	public SiteEnrollmentEnUSApiServiceImpl(SiteContextEnUS siteContext) {
		super(siteContext);
	}

	@Override
	public void sqlPOSTSiteEnrollment(SiteEnrollment o, Boolean inheritPk, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		JsonObject jsonObject = siteRequest.getJsonObject();
		Long userKey = siteRequest.getUserKey();

		if(userKey != null)
			jsonObject.put("userKey", userKey.toString());

		super.sqlPOSTSiteEnrollment(o, inheritPk, eventHandler);
	}
	@Override
	public void postSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/enrollment");
		siteRequest.setRequestMethod("POST");
		super.postSiteEnrollment(body, operationRequest, eventHandler);
	}
}
