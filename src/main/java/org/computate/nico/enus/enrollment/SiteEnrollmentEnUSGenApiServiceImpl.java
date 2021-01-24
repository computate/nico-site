package org.computate.nico.enus.enrollment;

import org.computate.nico.enus.config.SiteConfig;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.computate.nico.enus.context.SiteContextEnUS;
import org.computate.nico.enus.user.SiteUser;
import org.computate.nico.enus.request.api.ApiRequest;
import org.computate.nico.enus.search.SearchResult;
import io.vertx.core.WorkerExecutor;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailMessage;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrDocument;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.api.validation.HTTPRequestValidationHandler;
import io.vertx.ext.web.api.validation.ParameterTypeValidator;
import io.vertx.ext.web.api.validation.ValidationException;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.http.CaseInsensitiveHeaders;
import io.vertx.core.AsyncResult;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.core.CompositeFuture;
import org.apache.http.client.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import org.apache.http.NameValuePair;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.auth.oauth2.KeycloakHelper;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.time.ZonedDateTime;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.computate.nico.enus.user.SiteUserEnUSApiServiceImpl;
import org.computate.nico.enus.search.SearchList;
import org.computate.nico.enus.writer.AllWriter;


/**
 * Translate: false
 **/
public class SiteEnrollmentEnUSGenApiServiceImpl implements SiteEnrollmentEnUSGenApiService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteEnrollmentEnUSGenApiServiceImpl.class);

	protected static final String SERVICE_ADDRESS = "SiteEnrollmentEnUSApiServiceImpl";

	protected SiteContextEnUS siteContext;

	public SiteEnrollmentEnUSGenApiServiceImpl(SiteContextEnUS siteContext) {
		this.siteContext = siteContext;
	}

	// PUTImport //

	@Override
	public void putimportSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/enrollment/import");
		siteRequest.setRequestMethod("PUTImport");
		try {
			LOGGER.info(String.format("putimportSiteEnrollment started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						putimportSiteEnrollmentResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											ApiRequest apiRequest = new ApiRequest();
											JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
											apiRequest.setRows(jsonArray.size());
											apiRequest.setNumFound(new Integer(jsonArray.size()).longValue());
											apiRequest.setNumPATCH(0L);
											apiRequest.initDeepApiRequest(siteRequest);
											siteRequest.setApiRequest_(apiRequest);
											siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
											varsSiteEnrollment(siteRequest, d -> {
												if(d.succeeded()) {
													listPUTImportSiteEnrollment(apiRequest, siteRequest, e -> {
														if(e.succeeded()) {
															putimportSiteEnrollmentResponse(siteRequest, f -> {
																if(e.succeeded()) {
																	LOGGER.info(String.format("putimportSiteEnrollment succeeded. "));
																	blockingCodeHandler.handle(Future.succeededFuture(e.result()));
																} else {
																	LOGGER.error(String.format("putimportSiteEnrollment failed. ", f.cause()));
																	errorSiteEnrollment(siteRequest, null, f);
																}
															});
														} else {
															LOGGER.error(String.format("putimportSiteEnrollment failed. ", e.cause()));
															errorSiteEnrollment(siteRequest, null, e);
														}
													});
												} else {
													LOGGER.error(String.format("putimportSiteEnrollment failed. ", d.cause()));
													errorSiteEnrollment(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("putimportSiteEnrollment failed. ", ex));
											errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("putimportSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("putimportSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("putimportSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPUTImportSiteEnrollment(ApiRequest apiRequest, SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				JsonObject json = (JsonObject)obj;

				json.put("inheritPk", json.getValue("pk"));

				json.put("created", json.getValue("created"));

				SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteEnrollment(siteContext, siteRequest.getOperationRequest(), json);
				siteRequest2.setApiRequest_(apiRequest);
				siteRequest2.setRequestVars(siteRequest.getRequestVars());

				SearchList<SiteEnrollment> searchList = new SearchList<SiteEnrollment>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SiteEnrollment.class);
				searchList.addFilterQuery("deleted_indexed_boolean:false");
				searchList.addFilterQuery("archived_indexed_boolean:false");
				searchList.addFilterQuery("inheritPk_indexed_long:" + json.getString("pk"));
				searchList.initDeepForClass(siteRequest2);

				if(searchList.size() == 1) {
					SiteEnrollment o = searchList.getList().stream().findFirst().orElse(null);
					JsonObject json2 = new JsonObject();
					for(String f : json.fieldNames()) {
						json2.put("set" + StringUtils.capitalize(f), json.getValue(f));
					}
					if(o != null) {
						for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
							if(!json.fieldNames().contains(f))
								json2.putNull("set" + StringUtils.capitalize(f));
						}
						siteRequest2.setJsonObject(json2);
						futures.add(
							patchSiteEnrollmentFuture(o, true, a -> {
								if(a.succeeded()) {
								} else {
									LOGGER.error(String.format("listPUTImportSiteEnrollment failed. ", a.cause()));
									errorSiteEnrollment(siteRequest2, eventHandler, a);
								}
							})
						);
					}
				} else {
					futures.add(
						postSiteEnrollmentFuture(siteRequest2, true, a -> {
							if(a.succeeded()) {
							} else {
								LOGGER.error(String.format("listPUTImportSiteEnrollment failed. ", a.cause()));
								errorSiteEnrollment(siteRequest2, eventHandler, a);
							}
						})
					);
				}
			});
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
					response200PUTImportSiteEnrollment(siteRequest, eventHandler);
				} else {
					LOGGER.error(String.format("listPUTImportSiteEnrollment failed. ", a.cause()));
					errorSiteEnrollment(apiRequest.getSiteRequest_(), eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("listPUTImportSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}

	public void putimportSiteEnrollmentResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PUTImportSiteEnrollment(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("putimportSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("putimportSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PUTImportSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PUTImportSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// PUTMerge //

	@Override
	public void putmergeSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/enrollment/merge");
		siteRequest.setRequestMethod("PUTMerge");
		try {
			LOGGER.info(String.format("putmergeSiteEnrollment started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						putmergeSiteEnrollmentResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											ApiRequest apiRequest = new ApiRequest();
											JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
											apiRequest.setRows(jsonArray.size());
											apiRequest.setNumFound(new Integer(jsonArray.size()).longValue());
											apiRequest.setNumPATCH(0L);
											apiRequest.initDeepApiRequest(siteRequest);
											siteRequest.setApiRequest_(apiRequest);
											siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
											varsSiteEnrollment(siteRequest, d -> {
												if(d.succeeded()) {
													listPUTMergeSiteEnrollment(apiRequest, siteRequest, e -> {
														if(e.succeeded()) {
															putmergeSiteEnrollmentResponse(siteRequest, f -> {
																if(e.succeeded()) {
																	LOGGER.info(String.format("putmergeSiteEnrollment succeeded. "));
																	blockingCodeHandler.handle(Future.succeededFuture(e.result()));
																} else {
																	LOGGER.error(String.format("putmergeSiteEnrollment failed. ", f.cause()));
																	errorSiteEnrollment(siteRequest, null, f);
																}
															});
														} else {
															LOGGER.error(String.format("putmergeSiteEnrollment failed. ", e.cause()));
															errorSiteEnrollment(siteRequest, null, e);
														}
													});
												} else {
													LOGGER.error(String.format("putmergeSiteEnrollment failed. ", d.cause()));
													errorSiteEnrollment(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("putmergeSiteEnrollment failed. ", ex));
											errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("putmergeSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("putmergeSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("putmergeSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPUTMergeSiteEnrollment(ApiRequest apiRequest, SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				JsonObject json = (JsonObject)obj;

				json.put("inheritPk", json.getValue("pk"));

				SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteEnrollment(siteContext, siteRequest.getOperationRequest(), json);
				siteRequest2.setApiRequest_(apiRequest);
				siteRequest2.setRequestVars(siteRequest.getRequestVars());

				SearchList<SiteEnrollment> searchList = new SearchList<SiteEnrollment>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SiteEnrollment.class);
				searchList.addFilterQuery("deleted_indexed_boolean:false");
				searchList.addFilterQuery("archived_indexed_boolean:false");
				searchList.addFilterQuery("pk_indexed_long:" + json.getString("pk"));
				searchList.initDeepForClass(siteRequest2);

				if(searchList.size() == 1) {
					SiteEnrollment o = searchList.getList().stream().findFirst().orElse(null);
					JsonObject json2 = new JsonObject();
					for(String f : json.fieldNames()) {
						json2.put("set" + StringUtils.capitalize(f), json.getValue(f));
					}
					if(o != null) {
						for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
							if(!json.fieldNames().contains(f))
								json2.putNull("set" + StringUtils.capitalize(f));
						}
						siteRequest2.setJsonObject(json2);
						futures.add(
							patchSiteEnrollmentFuture(o, false, a -> {
								if(a.succeeded()) {
								} else {
									LOGGER.error(String.format("listPUTMergeSiteEnrollment failed. ", a.cause()));
									errorSiteEnrollment(siteRequest2, eventHandler, a);
								}
							})
						);
					}
				} else {
					futures.add(
						postSiteEnrollmentFuture(siteRequest2, false, a -> {
							if(a.succeeded()) {
							} else {
								LOGGER.error(String.format("listPUTMergeSiteEnrollment failed. ", a.cause()));
								errorSiteEnrollment(siteRequest2, eventHandler, a);
							}
						})
					);
				}
			});
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
					response200PUTMergeSiteEnrollment(siteRequest, eventHandler);
				} else {
					LOGGER.error(String.format("listPUTMergeSiteEnrollment failed. ", a.cause()));
					errorSiteEnrollment(apiRequest.getSiteRequest_(), eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("listPUTMergeSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}

	public void putmergeSiteEnrollmentResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PUTMergeSiteEnrollment(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("putmergeSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("putmergeSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PUTMergeSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PUTMergeSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// PUTCopy //

	@Override
	public void putcopySiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/enrollment/copy");
		siteRequest.setRequestMethod("PUTCopy");
		try {
			LOGGER.info(String.format("putcopySiteEnrollment started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						putcopySiteEnrollmentResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											aSearchSiteEnrollment(siteRequest, false, true, "/api/enrollment/copy", "PUTCopy", d -> {
												if(d.succeeded()) {
													SearchList<SiteEnrollment> listSiteEnrollment = d.result();
													ApiRequest apiRequest = new ApiRequest();
													apiRequest.setRows(listSiteEnrollment.getRows());
													apiRequest.setNumFound(listSiteEnrollment.getQueryResponse().getResults().getNumFound());
													apiRequest.setNumPATCH(0L);
													apiRequest.initDeepApiRequest(siteRequest);
													siteRequest.setApiRequest_(apiRequest);
													siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
													try {
														listPUTCopySiteEnrollment(apiRequest, listSiteEnrollment, e -> {
															if(e.succeeded()) {
																putcopySiteEnrollmentResponse(siteRequest, f -> {
																	if(f.succeeded()) {
																		LOGGER.info(String.format("putcopySiteEnrollment succeeded. "));
																		blockingCodeHandler.handle(Future.succeededFuture(f.result()));
																	} else {
																		LOGGER.error(String.format("putcopySiteEnrollment failed. ", f.cause()));
																		errorSiteEnrollment(siteRequest, null, f);
																	}
																});
															} else {
																LOGGER.error(String.format("putcopySiteEnrollment failed. ", e.cause()));
																errorSiteEnrollment(siteRequest, null, e);
															}
														});
													} catch(Exception ex) {
														LOGGER.error(String.format("putcopySiteEnrollment failed. ", ex));
														errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
													}
												} else {
													LOGGER.error(String.format("putcopySiteEnrollment failed. ", d.cause()));
													errorSiteEnrollment(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("putcopySiteEnrollment failed. ", ex));
											errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("putcopySiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("putcopySiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("putcopySiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPUTCopySiteEnrollment(ApiRequest apiRequest, SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
		listSiteEnrollment.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteEnrollment(siteContext, siteRequest.getOperationRequest(), siteRequest.getJsonObject());
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			o.setSiteRequest_(siteRequest2);
			futures.add(
				putcopySiteEnrollmentFuture(siteRequest2, JsonObject.mapFrom(o), a -> {
					if(a.succeeded()) {
					} else {
						LOGGER.error(String.format("listPUTCopySiteEnrollment failed. ", a.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, a);
					}
				})
			);
		});
		CompositeFuture.all(futures).setHandler( a -> {
			if(a.succeeded()) {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + listSiteEnrollment.size());
				if(listSiteEnrollment.next()) {
					listPUTCopySiteEnrollment(apiRequest, listSiteEnrollment, eventHandler);
				} else {
					response200PUTCopySiteEnrollment(siteRequest, eventHandler);
				}
			} else {
				LOGGER.error(String.format("listPUTCopySiteEnrollment failed. ", a.cause()));
				errorSiteEnrollment(listSiteEnrollment.getSiteRequest_(), eventHandler, a);
			}
		});
	}

	public Future<SiteEnrollment> putcopySiteEnrollmentFuture(SiteRequestEnUS siteRequest, JsonObject jsonObject, Handler<AsyncResult<SiteEnrollment>> eventHandler) {
		Promise<SiteEnrollment> promise = Promise.promise();
		try {

			jsonObject.put("saves", Optional.ofNullable(jsonObject.getJsonArray("saves")).orElse(new JsonArray()));
			JsonObject jsonPatch = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonObject("patch")).orElse(new JsonObject());
			jsonPatch.stream().forEach(o -> {
				if(o.getValue() == null)
					jsonObject.remove(o.getKey());
				else
					jsonObject.put(o.getKey(), o.getValue());
				jsonObject.getJsonArray("saves").add(o.getKey());
			});

			sqlConnectionSiteEnrollment(siteRequest, a -> {
				if(a.succeeded()) {
					sqlTransactionSiteEnrollment(siteRequest, b -> {
						if(b.succeeded()) {
							createSiteEnrollment(siteRequest, c -> {
								if(c.succeeded()) {
									SiteEnrollment siteEnrollment = c.result();
									sqlPUTCopySiteEnrollment(siteEnrollment, jsonObject, d -> {
										if(d.succeeded()) {
											defineIndexSiteEnrollment(siteEnrollment, e -> {
												if(e.succeeded()) {
													ApiRequest apiRequest = siteRequest.getApiRequest_();
													if(apiRequest != null) {
														apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
														if(apiRequest.getNumFound() == 1L) {
															siteEnrollment.apiRequestSiteEnrollment();
														}
														siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
													}
													eventHandler.handle(Future.succeededFuture(siteEnrollment));
													promise.complete(siteEnrollment);
												} else {
													LOGGER.error(String.format("putcopySiteEnrollmentFuture failed. ", e.cause()));
													eventHandler.handle(Future.failedFuture(e.cause()));
												}
											});
										} else {
											LOGGER.error(String.format("putcopySiteEnrollmentFuture failed. ", d.cause()));
											eventHandler.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									LOGGER.error(String.format("putcopySiteEnrollmentFuture failed. ", c.cause()));
									eventHandler.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							LOGGER.error(String.format("putcopySiteEnrollmentFuture failed. ", b.cause()));
							eventHandler.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					LOGGER.error(String.format("putcopySiteEnrollmentFuture failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("putcopySiteEnrollmentFuture failed. ", e));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(e));
		}
		return promise.future();
	}

	public void sqlPUTCopySiteEnrollment(SiteEnrollment o, JsonObject jsonObject, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			List<Future> futures = new ArrayList<>();

			if(jsonObject != null) {
				JsonArray entityVars = jsonObject.getJsonArray("saves");
				for(Integer i = 0; i < entityVars.size(); i++) {
					String entityVar = entityVars.getString(i);
					switch(entityVar) {
					case "inheritPk":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "inheritPk", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteEnrollment.inheritPk failed", b.cause())));
							});
						}));
						break;
					case "archived":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "archived", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteEnrollment.archived failed", b.cause())));
							});
						}));
						break;
					case "deleted":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "deleted", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteEnrollment.deleted failed", b.cause())));
							});
						}));
						break;
					}
				}
			}
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture());
				} else {
					LOGGER.error(String.format("sqlPUTCopySiteEnrollment failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("sqlPUTCopySiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void putcopySiteEnrollmentResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PUTCopySiteEnrollment(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("putcopySiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("putcopySiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PUTCopySiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PUTCopySiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// POST //

	@Override
	public void postSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/enrollment");
		siteRequest.setRequestMethod("POST");
		try {
			LOGGER.info(String.format("postSiteEnrollment started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						ApiRequest apiRequest = new ApiRequest();
						apiRequest.setRows(1);
						apiRequest.setNumFound(1L);
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
						postSiteEnrollmentFuture(siteRequest, false, c -> {
							if(c.succeeded()) {
								SiteEnrollment siteEnrollment = c.result();
								apiRequest.setPk(siteEnrollment.getPk());
								postSiteEnrollmentResponse(siteEnrollment, d -> {
										if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("postSiteEnrollment succeeded. "));
									} else {
										LOGGER.error(String.format("postSiteEnrollment failed. ", d.cause()));
										errorSiteEnrollment(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("postSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("postSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("postSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public Future<SiteEnrollment> postSiteEnrollmentFuture(SiteRequestEnUS siteRequest, Boolean inheritPk, Handler<AsyncResult<SiteEnrollment>> eventHandler) {
		Promise<SiteEnrollment> promise = Promise.promise();
		try {
			sqlConnectionSiteEnrollment(siteRequest, a -> {
				if(a.succeeded()) {
					sqlTransactionSiteEnrollment(siteRequest, b -> {
						if(b.succeeded()) {
							createSiteEnrollment(siteRequest, c -> {
								if(c.succeeded()) {
									SiteEnrollment siteEnrollment = c.result();
									sqlPOSTSiteEnrollment(siteEnrollment, inheritPk, d -> {
										if(d.succeeded()) {
											defineIndexSiteEnrollment(siteEnrollment, e -> {
												if(e.succeeded()) {
													ApiRequest apiRequest = siteRequest.getApiRequest_();
													if(apiRequest != null) {
														apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
														siteEnrollment.apiRequestSiteEnrollment();
														siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
													}
													eventHandler.handle(Future.succeededFuture(siteEnrollment));
													promise.complete(siteEnrollment);
												} else {
													LOGGER.error(String.format("postSiteEnrollmentFuture failed. ", e.cause()));
													eventHandler.handle(Future.failedFuture(e.cause()));
												}
											});
										} else {
											LOGGER.error(String.format("postSiteEnrollmentFuture failed. ", d.cause()));
											eventHandler.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									LOGGER.error(String.format("postSiteEnrollmentFuture failed. ", c.cause()));
									eventHandler.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							LOGGER.error(String.format("postSiteEnrollmentFuture failed. ", b.cause()));
							eventHandler.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					LOGGER.error(String.format("postSiteEnrollmentFuture failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("postSiteEnrollmentFuture failed. ", e));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(e));
		}
		return promise.future();
	}

	public void sqlPOSTSiteEnrollment(SiteEnrollment o, Boolean inheritPk, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			List<Future> futures = new ArrayList<>();

			if(siteRequest.getSessionId() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "sessionId", siteRequest.getSessionId())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			if(siteRequest.getUserId() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "userId", siteRequest.getUserId())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			if(siteRequest.getUserKey() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "userKey", siteRequest.getUserKey().toString())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case "inheritPk":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "inheritPk", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteEnrollment.inheritPk failed", b.cause())));
							});
						}));
						break;
					case "archived":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "archived", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteEnrollment.archived failed", b.cause())));
							});
						}));
						break;
					case "deleted":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "deleted", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteEnrollment.deleted failed", b.cause())));
							});
						}));
						break;
					}
				}
			}
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture());
				} else {
					LOGGER.error(String.format("sqlPOSTSiteEnrollment failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("sqlPOSTSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void postSiteEnrollmentResponse(SiteEnrollment siteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = siteEnrollment.getSiteRequest_();
		try {
			response200POSTSiteEnrollment(siteEnrollment, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("postSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("postSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200POSTSiteEnrollment(SiteEnrollment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200POSTSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// PATCH //

	@Override
	public void patchSiteEnrollment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/enrollment");
		siteRequest.setRequestMethod("PATCH");
		try {
			LOGGER.info(String.format("patchSiteEnrollment started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						patchSiteEnrollmentResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											aSearchSiteEnrollment(siteRequest, false, true, "/api/enrollment", "PATCH", d -> {
												if(d.succeeded()) {
													SearchList<SiteEnrollment> listSiteEnrollment = d.result();

													if(listSiteEnrollment.getQueryResponse().getResults().getNumFound() > 1) {
														List<String> roles2 = Arrays.asList("SiteAdmin");
														if(
																!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles2)
																&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles2)
																) {
															eventHandler.handle(Future.succeededFuture(
																new OperationResponse(401, "UNAUTHORIZED", 
																	Buffer.buffer().appendString(
																		new JsonObject()
																			.put("errorCode", "401")
																			.put("errorMessage", "roles required: " + String.join(", ", roles2))
																			.encodePrettily()
																		), new CaseInsensitiveHeaders()
																)
															));
														}
													}

													ApiRequest apiRequest = new ApiRequest();
													apiRequest.setRows(listSiteEnrollment.getRows());
													apiRequest.setNumFound(listSiteEnrollment.getQueryResponse().getResults().getNumFound());
													apiRequest.setNumPATCH(0L);
													apiRequest.initDeepApiRequest(siteRequest);
													siteRequest.setApiRequest_(apiRequest);
													siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
													SimpleOrderedMap facets = (SimpleOrderedMap)Optional.ofNullable(listSiteEnrollment.getQueryResponse()).map(QueryResponse::getResponse).map(r -> r.get("facets")).orElse(null);
													Date date = null;
													if(facets != null)
														date = (Date)facets.get("max_modified");
													String dt;
													if(date == null)
														dt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneId.of("UTC")).minusNanos(1000));
													else
														dt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
													listSiteEnrollment.addFilterQuery(String.format("modified_indexed_date:[* TO %s]", dt));

													try {
														listPATCHSiteEnrollment(apiRequest, listSiteEnrollment, dt, e -> {
															if(e.succeeded()) {
																patchSiteEnrollmentResponse(siteRequest, f -> {
																	if(f.succeeded()) {
																		LOGGER.info(String.format("patchSiteEnrollment succeeded. "));
																		blockingCodeHandler.handle(Future.succeededFuture(f.result()));
																	} else {
																		LOGGER.error(String.format("patchSiteEnrollment failed. ", f.cause()));
																		errorSiteEnrollment(siteRequest, null, f);
																	}
																});
															} else {
																LOGGER.error(String.format("patchSiteEnrollment failed. ", e.cause()));
																errorSiteEnrollment(siteRequest, null, e);
															}
														});
													} catch(Exception ex) {
														LOGGER.error(String.format("patchSiteEnrollment failed. ", ex));
														errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
													}
										} else {
													LOGGER.error(String.format("patchSiteEnrollment failed. ", d.cause()));
													errorSiteEnrollment(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("patchSiteEnrollment failed. ", ex));
											errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("patchSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("patchSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("patchSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPATCHSiteEnrollment(ApiRequest apiRequest, SearchList<SiteEnrollment> listSiteEnrollment, String dt, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
		listSiteEnrollment.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteEnrollment(siteContext, siteRequest.getOperationRequest(), siteRequest.getJsonObject());
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			o.setSiteRequest_(siteRequest2);
			futures.add(
				patchSiteEnrollmentFuture(o, false, a -> {
					if(a.succeeded()) {
					} else {
						errorSiteEnrollment(siteRequest2, eventHandler, a);
					}
				})
			);
		});
		CompositeFuture.all(futures).setHandler( a -> {
			if(a.succeeded()) {
				if(listSiteEnrollment.next(dt)) {
					listPATCHSiteEnrollment(apiRequest, listSiteEnrollment, dt, eventHandler);
				} else {
					response200PATCHSiteEnrollment(siteRequest, eventHandler);
				}
			} else {
				LOGGER.error(String.format("listPATCHSiteEnrollment failed. ", a.cause()));
				errorSiteEnrollment(listSiteEnrollment.getSiteRequest_(), eventHandler, a);
			}
		});
	}

	public Future<SiteEnrollment> patchSiteEnrollmentFuture(SiteEnrollment o, Boolean inheritPk, Handler<AsyncResult<SiteEnrollment>> eventHandler) {
		Promise<SiteEnrollment> promise = Promise.promise();
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			if(apiRequest != null && apiRequest.getNumFound() == 1L) {
				apiRequest.setOriginal(o);
				apiRequest.setPk(o.getPk());
			}
			sqlConnectionSiteEnrollment(siteRequest, a -> {
				if(a.succeeded()) {
					sqlTransactionSiteEnrollment(siteRequest, b -> {
						if(b.succeeded()) {
							sqlPATCHSiteEnrollment(o, inheritPk, c -> {
								if(c.succeeded()) {
									SiteEnrollment siteEnrollment = c.result();
									defineIndexSiteEnrollment(siteEnrollment, d -> {
										if(d.succeeded()) {
											if(apiRequest != null) {
												apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
												if(apiRequest.getNumFound() == 1L) {
													siteEnrollment.apiRequestSiteEnrollment();
												}
												siteRequest.getVertx().eventBus().publish("websocketSiteEnrollment", JsonObject.mapFrom(apiRequest).toString());
											}
											eventHandler.handle(Future.succeededFuture(siteEnrollment));
											promise.complete(siteEnrollment);
										} else {
											LOGGER.error(String.format("patchSiteEnrollmentFuture failed. ", d.cause()));
											eventHandler.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									LOGGER.error(String.format("patchSiteEnrollmentFuture failed. ", c.cause()));
									eventHandler.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							LOGGER.error(String.format("patchSiteEnrollmentFuture failed. ", b.cause()));
							eventHandler.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					LOGGER.error(String.format("patchSiteEnrollmentFuture failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("patchSiteEnrollmentFuture failed. ", e));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(e));
		}
		return promise.future();
	}

	public void sqlPATCHSiteEnrollment(SiteEnrollment o, Boolean inheritPk, Handler<AsyncResult<SiteEnrollment>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			SiteEnrollment o2 = new SiteEnrollment();
			List<Future> futures = new ArrayList<>();

			if(o.getUserId() == null && siteRequest.getUserId() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
							, Tuple.of(pk, "userId", siteRequest.getUserId())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			if(o.getUserKey() == null && siteRequest.getUserKey() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "userKey", siteRequest.getUserKey().toString())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}

			for(String methodName : methodNames) {
				switch(methodName) {
					case "setInheritPk":
						if(jsonObject.getString(methodName) == null) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_removeD
										, Tuple.of(pk, "inheritPk")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteEnrollment.inheritPk failed", b.cause())));
								});
							}));
						} else {
							o2.setInheritPk(jsonObject.getString(methodName));
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_setD
										, Tuple.of(pk, "inheritPk", o2.jsonInheritPk())
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteEnrollment.inheritPk failed", b.cause())));
								});
							}));
						}
						break;
					case "setArchived":
						if(jsonObject.getBoolean(methodName) == null) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_removeD
										, Tuple.of(pk, "archived")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteEnrollment.archived failed", b.cause())));
								});
							}));
						} else {
							o2.setArchived(jsonObject.getBoolean(methodName));
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_setD
										, Tuple.of(pk, "archived", o2.jsonArchived())
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteEnrollment.archived failed", b.cause())));
								});
							}));
						}
						break;
					case "setDeleted":
						if(jsonObject.getBoolean(methodName) == null) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_removeD
										, Tuple.of(pk, "deleted")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteEnrollment.deleted failed", b.cause())));
								});
							}));
						} else {
							o2.setDeleted(jsonObject.getBoolean(methodName));
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_setD
										, Tuple.of(pk, "deleted", o2.jsonDeleted())
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteEnrollment.deleted failed", b.cause())));
								});
							}));
						}
						break;
				}
			}
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					SiteEnrollment o3 = new SiteEnrollment();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					eventHandler.handle(Future.succeededFuture(o3));
				} else {
					LOGGER.error(String.format("sqlPATCHSiteEnrollment failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("sqlPATCHSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void patchSiteEnrollmentResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PATCHSiteEnrollment(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("patchSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("patchSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PATCHSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PATCHSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// GET //

	@Override
	public void getSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest);
		siteRequest.setRequestUri("/api/enrollment/{id}");
		siteRequest.setRequestMethod("GET");
		try {
			{
				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteEnrollment(siteRequest, false, true, "/api/enrollment/{id}", "GET", c -> {
							if(c.succeeded()) {
								SearchList<SiteEnrollment> listSiteEnrollment = c.result();
								getSiteEnrollmentResponse(listSiteEnrollment, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("getSiteEnrollment succeeded. "));
									} else {
										LOGGER.error(String.format("getSiteEnrollment failed. ", d.cause()));
										errorSiteEnrollment(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("getSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("getSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("getSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void getSiteEnrollmentResponse(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
		try {
			response200GETSiteEnrollment(listSiteEnrollment, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("getSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("getSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200GETSiteEnrollment(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
			SolrDocumentList solrDocuments = listSiteEnrollment.getSolrDocumentList();

			JsonObject json = JsonObject.mapFrom(listSiteEnrollment.getList().stream().findFirst().orElse(null));
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200GETSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// Search //

	@Override
	public void searchSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest);
		siteRequest.setRequestUri("/api/enrollment");
		siteRequest.setRequestMethod("Search");
		try {
			{
				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteEnrollment(siteRequest, false, true, "/api/enrollment", "Search", c -> {
							if(c.succeeded()) {
								SearchList<SiteEnrollment> listSiteEnrollment = c.result();
								searchSiteEnrollmentResponse(listSiteEnrollment, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("searchSiteEnrollment succeeded. "));
									} else {
										LOGGER.error(String.format("searchSiteEnrollment failed. ", d.cause()));
										errorSiteEnrollment(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("searchSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("searchSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("searchSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void searchSiteEnrollmentResponse(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
		try {
			response200SearchSiteEnrollment(listSiteEnrollment, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("searchSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("searchSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200SearchSiteEnrollment(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
			QueryResponse responseSearch = listSiteEnrollment.getQueryResponse();
			SolrDocumentList solrDocuments = listSiteEnrollment.getSolrDocumentList();
			Long searchInMillis = Long.valueOf(responseSearch.getQTime());
			Long transmissionInMillis = responseSearch.getElapsedTime();
			Long startNum = responseSearch.getResults().getStart();
			Long foundNum = responseSearch.getResults().getNumFound();
			Integer returnedNum = responseSearch.getResults().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String transmissionTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis), TimeUnit.MILLISECONDS.toMillis(transmissionInMillis) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis)));
			Exception exceptionSearch = responseSearch.getException();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			json.put("searchTime", searchTime);
			json.put("transmissionTime", transmissionTime);
			JsonArray l = new JsonArray();
			listSiteEnrollment.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				List<String> fls = listSiteEnrollment.getFields();
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					fieldNames.addAll(json2.fieldNames());
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk");
						fieldNames.remove("created");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch.getMessage());
			}
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200SearchSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// AdminSearch //

	@Override
	public void adminsearchSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest);
		siteRequest.setRequestUri("/api/admin/enrollment");
		siteRequest.setRequestMethod("AdminSearch");
		try {
			{
				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteEnrollment(siteRequest, false, true, "/api/admin/enrollment", "AdminSearch", c -> {
							if(c.succeeded()) {
								SearchList<SiteEnrollment> listSiteEnrollment = c.result();
								adminsearchSiteEnrollmentResponse(listSiteEnrollment, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("adminsearchSiteEnrollment succeeded. "));
									} else {
										LOGGER.error(String.format("adminsearchSiteEnrollment failed. ", d.cause()));
										errorSiteEnrollment(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("adminsearchSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("adminsearchSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("adminsearchSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void adminsearchSiteEnrollmentResponse(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
		try {
			response200AdminSearchSiteEnrollment(listSiteEnrollment, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("adminsearchSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("adminsearchSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200AdminSearchSiteEnrollment(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
			QueryResponse responseSearch = listSiteEnrollment.getQueryResponse();
			SolrDocumentList solrDocuments = listSiteEnrollment.getSolrDocumentList();
			Long searchInMillis = Long.valueOf(responseSearch.getQTime());
			Long transmissionInMillis = responseSearch.getElapsedTime();
			Long startNum = responseSearch.getResults().getStart();
			Long foundNum = responseSearch.getResults().getNumFound();
			Integer returnedNum = responseSearch.getResults().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String transmissionTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis), TimeUnit.MILLISECONDS.toMillis(transmissionInMillis) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis)));
			Exception exceptionSearch = responseSearch.getException();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			json.put("searchTime", searchTime);
			json.put("transmissionTime", transmissionTime);
			JsonArray l = new JsonArray();
			listSiteEnrollment.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				List<String> fls = listSiteEnrollment.getFields();
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					fieldNames.addAll(json2.fieldNames());
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk");
						fieldNames.remove("created");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch.getMessage());
			}
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200AdminSearchSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// SearchPage //

	@Override
	public void searchpageSiteEnrollmentId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		searchpageSiteEnrollment(operationRequest, eventHandler);
	}

	@Override
	public void searchpageSiteEnrollment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest);
		siteRequest.setRequestUri("/enrollment");
		siteRequest.setRequestMethod("SearchPage");
		try {
			{
				userSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteEnrollment(siteRequest, false, true, "/enrollment", "SearchPage", c -> {
							if(c.succeeded()) {
								SearchList<SiteEnrollment> listSiteEnrollment = c.result();
								searchpageSiteEnrollmentResponse(listSiteEnrollment, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("searchpageSiteEnrollment succeeded. "));
									} else {
										LOGGER.error(String.format("searchpageSiteEnrollment failed. ", d.cause()));
										errorSiteEnrollment(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("searchpageSiteEnrollment failed. ", c.cause()));
								errorSiteEnrollment(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("searchpageSiteEnrollment failed. ", b.cause()));
						errorSiteEnrollment(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("searchpageSiteEnrollment failed. ", ex));
			errorSiteEnrollment(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void searchpageSiteEnrollmentPageInit(EnrollmentPage page, SearchList<SiteEnrollment> listSiteEnrollment) {
	}
	public void searchpageSiteEnrollmentResponse(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
		try {
			Buffer buffer = Buffer.buffer();
			AllWriter w = AllWriter.create(siteRequest, buffer);
			siteRequest.setW(w);
			response200SearchPageSiteEnrollment(listSiteEnrollment, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("searchpageSiteEnrollmentResponse failed. ", a.cause()));
					errorSiteEnrollment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("searchpageSiteEnrollmentResponse failed. ", ex));
			errorSiteEnrollment(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200SearchPageSiteEnrollment(SearchList<SiteEnrollment> listSiteEnrollment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteEnrollment.getSiteRequest_();
			Buffer buffer = Buffer.buffer();
			AllWriter w = AllWriter.create(listSiteEnrollment.getSiteRequest_(), buffer);
			EnrollmentPage page = new EnrollmentPage();
			SolrDocument pageSolrDocument = new SolrDocument();
			CaseInsensitiveHeaders requestHeaders = new CaseInsensitiveHeaders();
			siteRequest.setRequestHeaders(requestHeaders);

			pageSolrDocument.setField("pageUri_frFR_stored_string", "/enrollment");
			page.setPageSolrDocument(pageSolrDocument);
			page.setW(w);
			if(listSiteEnrollment.size() == 1)
				siteRequest.setRequestPk(listSiteEnrollment.get(0).getPk());
			siteRequest.setW(w);
			page.setListSiteEnrollment(listSiteEnrollment);
			page.setSiteRequest_(siteRequest);
			searchpageSiteEnrollmentPageInit(page, listSiteEnrollment);
			page.initDeepEnrollmentPage(siteRequest);
			page.html();
			eventHandler.handle(Future.succeededFuture(new OperationResponse(200, "OK", buffer, requestHeaders)));
		} catch(Exception e) {
			LOGGER.error(String.format("response200SearchPageSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// General //

	public Future<SiteEnrollment> defineIndexSiteEnrollment(SiteEnrollment siteEnrollment, Handler<AsyncResult<SiteEnrollment>> eventHandler) {
		Promise<SiteEnrollment> promise = Promise.promise();
		SiteRequestEnUS siteRequest = siteEnrollment.getSiteRequest_();
		defineSiteEnrollment(siteEnrollment, c -> {
			if(c.succeeded()) {
				attributeSiteEnrollment(siteEnrollment, d -> {
					if(d.succeeded()) {
						indexSiteEnrollment(siteEnrollment, e -> {
							if(e.succeeded()) {
								sqlCommitSiteEnrollment(siteRequest, f -> {
									if(f.succeeded()) {
										sqlCloseSiteEnrollment(siteRequest, g -> {
											if(g.succeeded()) {
												refreshSiteEnrollment(siteEnrollment, h -> {
													if(h.succeeded()) {
														eventHandler.handle(Future.succeededFuture(siteEnrollment));
														promise.complete(siteEnrollment);
													} else {
														LOGGER.error(String.format("refreshSiteEnrollment failed. ", h.cause()));
														errorSiteEnrollment(siteRequest, null, h);
													}
												});
											} else {
												LOGGER.error(String.format("defineIndexSiteEnrollment failed. ", g.cause()));
												errorSiteEnrollment(siteRequest, null, g);
											}
										});
									} else {
										LOGGER.error(String.format("defineIndexSiteEnrollment failed. ", f.cause()));
										errorSiteEnrollment(siteRequest, null, f);
									}
								});
							} else {
								LOGGER.error(String.format("defineIndexSiteEnrollment failed. ", e.cause()));
								errorSiteEnrollment(siteRequest, null, e);
							}
						});
					} else {
						LOGGER.error(String.format("defineIndexSiteEnrollment failed. ", d.cause()));
						errorSiteEnrollment(siteRequest, null, d);
					}
				});
			} else {
				LOGGER.error(String.format("defineIndexSiteEnrollment failed. ", c.cause()));
				errorSiteEnrollment(siteRequest, null, c);
			}
		});
		return promise.future();
	}

	public void createSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<SiteEnrollment>> eventHandler) {
		try {
			Transaction tx = siteRequest.getTx();
			String userId = siteRequest.getUserId();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of(siteRequest.getSiteConfig_().getSiteZone())))).orElse(ZonedDateTime.now(ZoneId.of(siteRequest.getSiteConfig_().getSiteZone())));

			tx.preparedQuery(
					SiteContextEnUS.SQL_create
					, Tuple.of(SiteEnrollment.class.getCanonicalName(), userId, created.toOffsetDateTime())
					, Collectors.toList()
					, createAsync
			-> {
				if(createAsync.succeeded()) {
					Row createLine = createAsync.result().value().stream().findFirst().orElseGet(() -> null);
					Long pk = createLine.getLong(0);
					SiteEnrollment o = new SiteEnrollment();
					o.setPk(pk);
					o.setSiteRequest_(siteRequest);
					eventHandler.handle(Future.succeededFuture(o));
				} else {
					LOGGER.error(String.format("createSiteEnrollment failed. ", createAsync.cause()));
					eventHandler.handle(Future.failedFuture(createAsync.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("createSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void errorSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler, AsyncResult<?> resultAsync) {
		Throwable e = resultAsync.cause();
		JsonObject json = new JsonObject()
				.put("error", new JsonObject()
				.put("message", Optional.ofNullable(e).map(Throwable::getMessage).orElse(null))
				.put("userName", siteRequest.getUserName())
				.put("userFullName", siteRequest.getUserFullName())
				.put("requestUri", siteRequest.getRequestUri())
				.put("requestMethod", siteRequest.getRequestMethod())
				.put("params", Optional.ofNullable(siteRequest.getOperationRequest()).map(o -> o.getParams()).orElse(null))
				);
		ExceptionUtils.printRootCauseStackTrace(e);
		OperationResponse responseOperation = new OperationResponse(400, "BAD REQUEST", 
				Buffer.buffer().appendString(json.encodePrettily())
				, new CaseInsensitiveHeaders().add("Content-Type", "application/json")
		);
		SiteConfig siteConfig = siteRequest.getSiteConfig_();
		SiteContextEnUS siteContext = siteRequest.getSiteContext_();
		MailClient mailClient = siteContext.getMailClient();
		MailMessage message = new MailMessage();
		message.setFrom(siteConfig.getEmailFrom());
		message.setTo(siteConfig.getEmailAdmin());
		if(e != null)
			message.setText(String.format("%s\n\n%s", json.encodePrettily(), ExceptionUtils.getStackTrace(e)));
		message.setSubject(String.format(siteConfig.getSiteBaseUrl() + " " + Optional.ofNullable(e).map(Throwable::getMessage).orElse(null)));
		WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
		workerExecutor.executeBlocking(
			blockingCodeHandler -> {
				mailClient.sendMail(message, result -> {
					if (result.succeeded()) {
						LOGGER.info(result.result());
					} else {
						LOGGER.error(result.cause());
					}
				});
			}, resultHandler -> {
			}
		);
		sqlRollbackSiteEnrollment(siteRequest, a -> {
			if(a.succeeded()) {
				LOGGER.info(String.format("sql rollback. "));
				sqlCloseSiteEnrollment(siteRequest, b -> {
					if(b.succeeded()) {
						LOGGER.info(String.format("sql close. "));
						if(eventHandler != null)
							eventHandler.handle(Future.succeededFuture(responseOperation));
					} else {
						if(eventHandler != null)
							eventHandler.handle(Future.succeededFuture(responseOperation));
					}
				});
			} else {
				if(eventHandler != null)
					eventHandler.handle(Future.succeededFuture(responseOperation));
			}
		});
	}

	public void sqlConnectionSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			PgPool pgPool = siteRequest.getSiteContext_().getPgPool();

			if(pgPool == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				pgPool.getConnection(a -> {
					if(a.succeeded()) {
						SqlConnection sqlConnection = a.result();
						siteRequest.setSqlConnection(sqlConnection);
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("sqlConnectionSiteEnrollment failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlTransactionSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();

			if(sqlConnection == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				Transaction tx = sqlConnection.begin();
				siteRequest.setTx(tx);
				eventHandler.handle(Future.succeededFuture());
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlTransactionSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlCommitSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			Transaction tx = siteRequest.getTx();

			if(tx == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				tx.commit(a -> {
					if(a.succeeded()) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else if("Transaction already completed".equals(a.cause().getMessage())) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("sqlCommitSiteEnrollment failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlRollbackSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			Transaction tx = siteRequest.getTx();

			if(tx == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				tx.rollback(a -> {
					if(a.succeeded()) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else if("Transaction already completed".equals(a.cause().getMessage())) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("sqlRollbackSiteEnrollment failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlCloseSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();

			if(sqlConnection == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				sqlConnection.close();
				siteRequest.setSqlConnection(null);
				eventHandler.handle(Future.succeededFuture());
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlCloseSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public SiteRequestEnUS generateSiteRequestEnUSForSiteEnrollment(SiteContextEnUS siteContext, OperationRequest operationRequest) {
		return generateSiteRequestEnUSForSiteEnrollment(siteContext, operationRequest, null);
	}

	public SiteRequestEnUS generateSiteRequestEnUSForSiteEnrollment(SiteContextEnUS siteContext, OperationRequest operationRequest, JsonObject body) {
		Vertx vertx = siteContext.getVertx();
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
		siteRequest.setJsonObject(body);
		siteRequest.setVertx(vertx);
		siteRequest.setSiteContext_(siteContext);
		siteRequest.setSiteConfig_(siteContext.getSiteConfig());
		siteRequest.setOperationRequest(operationRequest);
		siteRequest.initDeepSiteRequestEnUS(siteRequest);

		return siteRequest;
	}

	public void userSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			String userId = siteRequest.getUserId();
			if(userId == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				sqlConnectionSiteEnrollment(siteRequest, a -> {
					if(a.succeeded()) {
						sqlTransactionSiteEnrollment(siteRequest, b -> {
							if(b.succeeded()) {
								Transaction tx = siteRequest.getTx();
								tx.preparedQuery(
										SiteContextEnUS.SQL_selectC
										, Tuple.of("org.computate.nico.enus.user.SiteUser", userId)
										, Collectors.toList()
										, selectCAsync
								-> {
									if(selectCAsync.succeeded()) {
										try {
											Row userValues = selectCAsync.result().value().stream().findFirst().orElse(null);
											SiteUserEnUSApiServiceImpl userService = new SiteUserEnUSApiServiceImpl(siteContext);
											if(userValues == null) {
												JsonObject userVertx = siteRequest.getOperationRequest().getUser();
												JsonObject jsonPrincipal = KeycloakHelper.parseToken(userVertx.getString("access_token"));

												JsonObject jsonObject = new JsonObject();
												jsonObject.put("userName", jsonPrincipal.getString("preferred_username"));
												jsonObject.put("userFirstName", jsonPrincipal.getString("given_name"));
												jsonObject.put("userLastName", jsonPrincipal.getString("family_name"));
												jsonObject.put("userCompleteName", jsonPrincipal.getString("name"));
												jsonObject.put("userId", jsonPrincipal.getString("sub"));
												jsonObject.put("userEmail", jsonPrincipal.getString("email"));
												userSiteEnrollmentDefine(siteRequest, jsonObject, false);

												SiteRequestEnUS siteRequest2 = new SiteRequestEnUS();
												siteRequest2.setTx(siteRequest.getTx());
												siteRequest2.setSqlConnection(siteRequest.getSqlConnection());
												siteRequest2.setJsonObject(jsonObject);
												siteRequest2.setVertx(siteRequest.getVertx());
												siteRequest2.setSiteContext_(siteContext);
												siteRequest2.setSiteConfig_(siteContext.getSiteConfig());
												siteRequest2.setUserId(siteRequest.getUserId());
												siteRequest2.initDeepSiteRequestEnUS(siteRequest);

												ApiRequest apiRequest = new ApiRequest();
												apiRequest.setRows(1);
												apiRequest.setNumFound(1L);
												apiRequest.setNumPATCH(0L);
												apiRequest.initDeepApiRequest(siteRequest2);
												siteRequest2.setApiRequest_(apiRequest);

												userService.createSiteUser(siteRequest2, c -> {
													if(c.succeeded()) {
														SiteUser siteUser = c.result();
														userService.sqlPOSTSiteUser(siteUser, false, d -> {
															if(d.succeeded()) {
																userService.defineIndexSiteUser(siteUser, e -> {
																	if(e.succeeded()) {
																		siteRequest.setSiteUser(siteUser);
																		siteRequest.setUserName(jsonPrincipal.getString("preferred_username"));
																		siteRequest.setUserFirstName(jsonPrincipal.getString("given_name"));
																		siteRequest.setUserLastName(jsonPrincipal.getString("family_name"));
																		siteRequest.setUserId(jsonPrincipal.getString("sub"));
																		siteRequest.setUserKey(siteUser.getPk());
																		eventHandler.handle(Future.succeededFuture());
																	} else {
																		errorSiteEnrollment(siteRequest, eventHandler, e);
																	}
																});
															} else {
																errorSiteEnrollment(siteRequest, eventHandler, d);
															}
														});
													} else {
														errorSiteEnrollment(siteRequest, eventHandler, c);
													}
												});
											} else {
												Long pkUser = userValues.getLong(0);
												SearchList<SiteUser> searchList = new SearchList<SiteUser>();
												searchList.setQuery("*:*");
												searchList.setStore(true);
												searchList.setC(SiteUser.class);
												searchList.addFilterQuery("userId_indexed_string:" + ClientUtils.escapeQueryChars(userId));
												searchList.addFilterQuery("pk_indexed_long:" + pkUser);
												searchList.initDeepSearchList(siteRequest);
												SiteUser siteUser1 = searchList.getList().stream().findFirst().orElse(null);

												JsonObject userVertx = siteRequest.getOperationRequest().getUser();
												JsonObject jsonPrincipal = KeycloakHelper.parseToken(userVertx.getString("access_token"));

												JsonObject jsonObject = new JsonObject();
												jsonObject.put("setUserName", jsonPrincipal.getString("preferred_username"));
												jsonObject.put("setUserFirstName", jsonPrincipal.getString("given_name"));
												jsonObject.put("setUserLastName", jsonPrincipal.getString("family_name"));
												jsonObject.put("setUserCompleteName", jsonPrincipal.getString("name"));
												jsonObject.put("setUserId", jsonPrincipal.getString("sub"));
												jsonObject.put("setUserEmail", jsonPrincipal.getString("email"));
												Boolean define = userSiteEnrollmentDefine(siteRequest, jsonObject, true);
												if(define) {
													SiteUser siteUser;
													if(siteUser1 == null) {
														siteUser = new SiteUser();
														siteUser.setPk(pkUser);
														siteUser.setSiteRequest_(siteRequest);
													} else {
														siteUser = siteUser1;
													}

													SiteRequestEnUS siteRequest2 = new SiteRequestEnUS();
													siteRequest2.setTx(siteRequest.getTx());
													siteRequest2.setSqlConnection(siteRequest.getSqlConnection());
													siteRequest2.setJsonObject(jsonObject);
													siteRequest2.setVertx(siteRequest.getVertx());
													siteRequest2.setSiteContext_(siteContext);
													siteRequest2.setSiteConfig_(siteContext.getSiteConfig());
													siteRequest2.setUserId(siteRequest.getUserId());
													siteRequest2.setUserKey(siteRequest.getUserKey());
													siteRequest2.initDeepSiteRequestEnUS(siteRequest);
													siteUser.setSiteRequest_(siteRequest2);

													ApiRequest apiRequest = new ApiRequest();
													apiRequest.setRows(1);
													apiRequest.setNumFound(1L);
													apiRequest.setNumPATCH(0L);
													apiRequest.initDeepApiRequest(siteRequest2);
													siteRequest2.setApiRequest_(apiRequest);

													userService.sqlPATCHSiteUser(siteUser, false, d -> {
														if(d.succeeded()) {
															SiteUser siteUser2 = d.result();
															userService.defineIndexSiteUser(siteUser2, e -> {
																if(e.succeeded()) {
																	siteRequest.setSiteUser(siteUser2);
																	siteRequest.setUserName(siteUser2.getUserName());
																	siteRequest.setUserFirstName(siteUser2.getUserFirstName());
																	siteRequest.setUserLastName(siteUser2.getUserLastName());
																	siteRequest.setUserId(siteUser2.getUserId());
																	siteRequest.setUserKey(siteUser2.getPk());
																	eventHandler.handle(Future.succeededFuture());
																} else {
																	errorSiteEnrollment(siteRequest, eventHandler, e);
																}
															});
														} else {
															errorSiteEnrollment(siteRequest, eventHandler, d);
														}
													});
												} else {
													siteRequest.setSiteUser(siteUser1);
													siteRequest.setUserName(siteUser1.getUserName());
													siteRequest.setUserFirstName(siteUser1.getUserFirstName());
													siteRequest.setUserLastName(siteUser1.getUserLastName());
													siteRequest.setUserId(siteUser1.getUserId());
													siteRequest.setUserKey(siteUser1.getPk());
													sqlRollbackSiteEnrollment(siteRequest, c -> {
														if(c.succeeded()) {
															eventHandler.handle(Future.succeededFuture());
														} else {
															eventHandler.handle(Future.failedFuture(c.cause()));
															errorSiteEnrollment(siteRequest, eventHandler, c);
														}
													});
												}
											}
										} catch(Exception e) {
											LOGGER.error(String.format("userSiteEnrollment failed. ", e));
											eventHandler.handle(Future.failedFuture(e));
										}
									} else {
										LOGGER.error(String.format("userSiteEnrollment failed. ", selectCAsync.cause()));
										eventHandler.handle(Future.failedFuture(selectCAsync.cause()));
									}
								});
							} else {
								LOGGER.error(String.format("userSiteEnrollment failed. ", b.cause()));
								eventHandler.handle(Future.failedFuture(b.cause()));
							}
						});
					} else {
						LOGGER.error(String.format("userSiteEnrollment failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("userSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public Boolean userSiteEnrollmentDefine(SiteRequestEnUS siteRequest, JsonObject jsonObject, Boolean patch) {
		if(patch) {
			return false;
		} else {
			return false;
		}
	}

	public void aSearchSiteEnrollmentQ(String uri, String apiMethod, SearchList<SiteEnrollment> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.setQuery(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : ClientUtils.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public void aSearchSiteEnrollmentFq(String uri, String apiMethod, SearchList<SiteEnrollment> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		if(StringUtils.startsWith(valueIndexed, "[")) {
			String[] fqs = StringUtils.substringBefore(StringUtils.substringAfter(valueIndexed, "["), "]").split(" TO ");
			if(fqs.length != 2)
				throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
			String fq1 = fqs[0].equals("*") ? fqs[0] : SiteEnrollment.staticSolrFqForClass(entityVar, searchList.getSiteRequest_(), fqs[0]);
			String fq2 = fqs[1].equals("*") ? fqs[1] : SiteEnrollment.staticSolrFqForClass(entityVar, searchList.getSiteRequest_(), fqs[1]);
			searchList.addFilterQuery(varIndexed + ":[" + fq1 + " TO " + fq2 + "]");
		} else {
			searchList.addFilterQuery(varIndexed + ":" + SiteEnrollment.staticSolrFqForClass(entityVar, searchList.getSiteRequest_(), valueIndexed));
		}
	}

	public void aSearchSiteEnrollmentSort(String uri, String apiMethod, SearchList<SiteEnrollment> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.addSort(varIndexed, ORDER.valueOf(valueIndexed));
	}

	public void aSearchSiteEnrollmentRows(String uri, String apiMethod, SearchList<SiteEnrollment> searchList, Integer valueRows) {
			searchList.setRows(apiMethod != null && apiMethod.contains("Search") ? valueRows : 10);
	}

	public void aSearchSiteEnrollmentStart(String uri, String apiMethod, SearchList<SiteEnrollment> searchList, Integer valueStart) {
		searchList.setStart(valueStart);
	}

	public void aSearchSiteEnrollmentVar(String uri, String apiMethod, SearchList<SiteEnrollment> searchList, String var, String value) {
		searchList.getSiteRequest_().getRequestVars().put(var, value);
	}

	public void aSearchSiteEnrollmentUri(String uri, String apiMethod, SearchList<SiteEnrollment> searchList) {
	}

	public void varsSiteEnrollment(SiteRequestEnUS siteRequest, Handler<AsyncResult<SearchList<OperationResponse>>> eventHandler) {
		try {
			OperationRequest operationRequest = siteRequest.getOperationRequest();

			operationRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						switch(paramName) {
							case "var":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								siteRequest.getRequestVars().put(entityVar, valueIndexed);
								break;
						}
					}
				} catch(Exception e) {
					LOGGER.error(String.format("aSearchSiteEnrollment failed. ", e));
					eventHandler.handle(Future.failedFuture(e));
				}
			});
			eventHandler.handle(Future.succeededFuture());
		} catch(Exception e) {
			LOGGER.error(String.format("aSearchSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void aSearchSiteEnrollment(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, String uri, String apiMethod, Handler<AsyncResult<SearchList<SiteEnrollment>>> eventHandler) {
		try {
			OperationRequest operationRequest = siteRequest.getOperationRequest();
			String entityListStr = siteRequest.getOperationRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<SiteEnrollment> searchList = new SearchList<SiteEnrollment>();
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.setQuery("*:*");
			searchList.setC(SiteEnrollment.class);
			searchList.setSiteRequest_(siteRequest);
			if(entityList != null)
				searchList.addFields(entityList);
			searchList.add("json.facet", "{max_modified:'max(modified_indexed_date)'}");

			String id = operationRequest.getParams().getJsonObject("path").getString("id");
			if(id != null) {
				searchList.addFilterQuery("(id:" + ClientUtils.escapeQueryChars(id) + " OR objectId_indexed_string:" + ClientUtils.escapeQueryChars(id) + ")");
			}

			operationRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Integer valueStart = null;
				Integer valueRows = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						switch(paramName) {
							case "q":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								varIndexed = "*".equals(entityVar) ? entityVar : SiteEnrollment.varSearchSiteEnrollment(entityVar);
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								valueIndexed = StringUtils.isEmpty(valueIndexed) ? "*" : valueIndexed;
								aSearchSiteEnrollmentQ(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
								break;
							case "fq":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								varIndexed = SiteEnrollment.varIndexedSiteEnrollment(entityVar);
								aSearchSiteEnrollmentFq(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
								break;
							case "sort":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
								valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
								varIndexed = SiteEnrollment.varIndexedSiteEnrollment(entityVar);
								aSearchSiteEnrollmentSort(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
								break;
							case "start":
								valueStart = (Integer)paramObject;
								aSearchSiteEnrollmentStart(uri, apiMethod, searchList, valueStart);
								break;
							case "rows":
								valueRows = (Integer)paramObject;
								aSearchSiteEnrollmentRows(uri, apiMethod, searchList, valueRows);
								break;
							case "var":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								aSearchSiteEnrollmentVar(uri, apiMethod, searchList, entityVar, valueIndexed);
								break;
						}
					}
					aSearchSiteEnrollmentUri(uri, apiMethod, searchList);
				} catch(Exception e) {
					LOGGER.error(String.format("aSearchSiteEnrollment failed. ", e));
					eventHandler.handle(Future.failedFuture(e));
				}
			});
			if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
				searchList.addSort("created_indexed_date", ORDER.desc);
			}
			searchList.initDeepForClass(siteRequest);
			eventHandler.handle(Future.succeededFuture(searchList));
		} catch(Exception e) {
			LOGGER.error(String.format("aSearchSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void defineSiteEnrollment(SiteEnrollment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			tx.preparedQuery(
					SiteContextEnUS.SQL_define
					, Tuple.of(pk)
					, Collectors.toList()
					, defineAsync
			-> {
				if(defineAsync.succeeded()) {
					try {
						for(Row definition : defineAsync.result().value()) {
							try {
								o.defineForClass(definition.getString(0), definition.getString(1));
							} catch(Exception e) {
								LOGGER.error(String.format("defineSiteEnrollment failed. ", e));
								LOGGER.error(e);
							}
						}
						eventHandler.handle(Future.succeededFuture());
					} catch(Exception e) {
						LOGGER.error(String.format("defineSiteEnrollment failed. ", e));
						eventHandler.handle(Future.failedFuture(e));
					}
				} else {
					LOGGER.error(String.format("defineSiteEnrollment failed. ", defineAsync.cause()));
					eventHandler.handle(Future.failedFuture(defineAsync.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("defineSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void attributeSiteEnrollment(SiteEnrollment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			tx.preparedQuery(
					SiteContextEnUS.SQL_attribute
					, Tuple.of(pk, pk)
					, Collectors.toList()
					, attributeAsync
			-> {
				try {
					if(attributeAsync.succeeded()) {
						if(attributeAsync.result() != null) {
							for(Row definition : attributeAsync.result().value()) {
								if(pk.equals(definition.getLong(0)))
									o.attributeForClass(definition.getString(2), definition.getLong(1));
								else
									o.attributeForClass(definition.getString(3), definition.getLong(0));
							}
						}
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("attributeSiteEnrollment failed. ", attributeAsync.cause()));
						eventHandler.handle(Future.failedFuture(attributeAsync.cause()));
					}
				} catch(Exception e) {
					LOGGER.error(String.format("attributeSiteEnrollment failed. ", e));
					eventHandler.handle(Future.failedFuture(e));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("attributeSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void indexSiteEnrollment(SiteEnrollment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			o.initDeepForClass(siteRequest);
			o.indexForClass();
			eventHandler.handle(Future.succeededFuture());
		} catch(Exception e) {
			LOGGER.error(String.format("indexSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void refreshSiteEnrollment(SiteEnrollment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && BooleanUtils.isFalse(Optional.ofNullable(siteRequest.getApiRequest_()).map(ApiRequest::getEmpty).orElse(true))) {
				SearchList<SiteEnrollment> searchList = new SearchList<SiteEnrollment>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SiteEnrollment.class);
				searchList.addFilterQuery("modified_indexed_date:[" + DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(siteRequest.getApiRequest_().getCreated().toInstant(), ZoneId.of("UTC"))) + " TO *]");
				searchList.setRows(1000);
				searchList.initDeepSearchList(siteRequest);
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < pks.size(); i++) {
					Long pk2 = pks.get(i);
					String classSimpleName2 = classes.get(i);
				}

				CompositeFuture.all(futures).setHandler(a -> {
					if(a.succeeded()) {
						SiteEnrollmentEnUSApiServiceImpl service = new SiteEnrollmentEnUSApiServiceImpl(siteRequest.getSiteContext_());
						List<Future> futures2 = new ArrayList<>();
						for(SiteEnrollment o2 : searchList.getList()) {
							SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteEnrollment(siteContext, siteRequest.getOperationRequest(), new JsonObject());
							o2.setSiteRequest_(siteRequest2);
							futures2.add(
								service.patchSiteEnrollmentFuture(o2, false, b -> {
									if(b.succeeded()) {
									} else {
										LOGGER.info(String.format("SiteEnrollment %s failed. ", o2.getPk()));
										eventHandler.handle(Future.failedFuture(b.cause()));
									}
								})
							);
						}

						CompositeFuture.all(futures2).setHandler(b -> {
							if(b.succeeded()) {
								eventHandler.handle(Future.succeededFuture());
							} else {
								LOGGER.error("Refresh relations failed. ", b.cause());
								errorSiteEnrollment(siteRequest, eventHandler, b);
							}
						});
					} else {
						LOGGER.error("Refresh relations failed. ", a.cause());
						errorSiteEnrollment(siteRequest, eventHandler, a);
					}
				});
			} else {
				eventHandler.handle(Future.succeededFuture());
			}
		} catch(Exception e) {
			LOGGER.error(String.format("refreshSiteEnrollment failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}
}
