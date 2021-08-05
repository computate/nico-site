package org.computate.nico.enus.pet;

import org.computate.nico.enus.user.SiteUserEnUSApiServiceImpl;
import org.computate.nico.enus.user.SiteUser;
import org.computate.nico.enus.enrollment.SiteEnrollmentEnUSApiServiceImpl;
import org.computate.nico.enus.enrollment.SiteEnrollment;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.computate.nico.enus.user.SiteUser;
import org.computate.nico.enus.request.api.ApiRequest;
import org.computate.nico.enus.search.SearchResult;
import org.computate.nico.enus.vertx.MailVerticle;
import org.computate.nico.enus.config.ConfigKeys;
import org.computate.nico.enus.base.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.pgclient.PgPool;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.core.eventbus.DeliveryOptions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
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
import org.apache.solr.common.SolrInputDocument;
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
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import io.vertx.core.AsyncResult;
import java.net.URLEncoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.CompositeFuture;
import io.vertx.core.http.HttpHeaders;
import org.apache.http.client.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import org.apache.http.NameValuePair;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import java.util.HashMap;
import io.vertx.ext.auth.User;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import org.apache.solr.util.DateMathParser;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.client.solrj.response.PivotField;
import org.apache.solr.client.solrj.response.RangeFacet;
import org.apache.solr.client.solrj.response.FacetField;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Base64;
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
public class SitePetEnUSGenApiServiceImpl extends BaseApiServiceImpl implements SitePetEnUSGenApiService {

	protected static final Logger LOG = LoggerFactory.getLogger(SitePetEnUSGenApiServiceImpl.class);

	public SitePetEnUSGenApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider);
	}

	// PUTImport //

	@Override
	public void putimportSitePet(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putimportSitePet started. "));
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					try {
						ApiRequest apiRequest = new ApiRequest();
						JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
						apiRequest.setRows(jsonArray.size());
						apiRequest.setNumFound(new Integer(jsonArray.size()).longValue());
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
						varsSitePet(siteRequest).onSuccess(d -> {
							listPUTImportSitePet(apiRequest, siteRequest).onSuccess(e -> {
								response200PUTImportSitePet(siteRequest).onSuccess(response -> {
									LOG.debug(String.format("putimportSitePet succeeded. "));
									eventHandler.handle(Future.succeededFuture(response));
								}).onFailure(ex -> {
									LOG.error(String.format("putimportSitePet failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putimportSitePet failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putimportSitePet failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("putimportSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}
			} catch(Exception ex) {
				LOG.error(String.format("putimportSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putimportSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPUTImportSitePet(ApiRequest apiRequest, SiteRequestEnUS siteRequest) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				futures.add(Future.future(promise1 -> {
					JsonObject params = new JsonObject();
					params.put("body", obj);
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					params.put("query", new JsonObject());
					JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.principal()).orElse(null));
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("nico-site-enUS-SitePet", json, new DeliveryOptions().addHeader("action", "putimportSitePetFuture")).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTImportSitePet failed. "), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess(a -> {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTImportSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("listPUTImportSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public void putimportSitePetFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				body.put("inheritPk", body.getValue("pk"));
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}

				SearchList<SitePet> searchList = new SearchList<SitePet>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SitePet.class);
				searchList.addFilterQuery("deleted_indexed_boolean:false");
				searchList.addFilterQuery("archived_indexed_boolean:false");
				searchList.addFilterQuery("inheritPk_indexed_string:" + ClientUtils.escapeQueryChars(body.getString("pk")));
				searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
					try {
						if(searchList.size() >= 1) {
							SitePet o = searchList.getList().stream().findFirst().orElse(null);
							SitePet o2 = new SitePet();
							JsonObject body2 = new JsonObject();
							for(String f : body.fieldNames()) {
								Object bodyVal = body.getValue(f);
								if(bodyVal instanceof JsonArray) {
									JsonArray bodyVals = (JsonArray)bodyVal;
									Collection<?> vals = (Collection<?>)o.obtainForClass(f);
									if(bodyVals.size() == vals.size()) {
										Boolean match = true;
										for(Object val : vals) {
											if(val != null) {
												if(!bodyVals.contains(val.toString())) {
													match = false;
													break;
												}
											} else {
												match = false;
												break;
											}
										}
										if(!match) {
											body2.put("set" + StringUtils.capitalize(f), bodyVal);
										}
									} else {
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									}
								} else {
									o2.defineForClass(f, bodyVal);
									o2.attributeForClass(f, bodyVal);
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
								}
							}
							for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
								if(!body.fieldNames().contains(f)) {
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.putNull("set" + StringUtils.capitalize(f));
								}
							}
							if(body2.size() > 0) {
								siteRequest.setJsonObject(body2);
								patchSitePetFuture(o, true).onSuccess(b -> {
									LOG.info("Import SitePet {} succeeded, modified SitePet. ", body.getValue("pk"));
									eventHandler.handle(Future.succeededFuture());
								}).onFailure(ex -> {
									LOG.error(String.format("putimportSitePetFuture failed. "), ex);
									eventHandler.handle(Future.failedFuture(ex));
								});
							} else {
								eventHandler.handle(Future.succeededFuture());
							}
						} else {
							postSitePetFuture(siteRequest, true).onSuccess(b -> {
								LOG.info("Import SitePet {} succeeded, created new SitePet. ", body.getValue("pk"));
								eventHandler.handle(Future.succeededFuture());
							}).onFailure(ex -> {
								LOG.error(String.format("putimportSitePetFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							});
						}
					} catch(Exception ex) {
						LOG.error(String.format("putimportSitePetFuture failed. "), ex);
						eventHandler.handle(Future.failedFuture(ex));
					}
				}).onFailure(ex -> {
					LOG.error(String.format("putimportSitePetFuture failed. "), ex);
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Exception ex) {
				LOG.error(String.format("putimportSitePetFuture failed. "), ex);
				eventHandler.handle(Future.failedFuture(ex));
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putimportSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200PUTImportSitePet(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTImportSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PUTMerge //

	@Override
	public void putmergeSitePet(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putmergeSitePet started. "));
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					try {
						ApiRequest apiRequest = new ApiRequest();
						JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
						apiRequest.setRows(jsonArray.size());
						apiRequest.setNumFound(new Integer(jsonArray.size()).longValue());
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
						varsSitePet(siteRequest).onSuccess(d -> {
							listPUTMergeSitePet(apiRequest, siteRequest).onSuccess(e -> {
								response200PUTMergeSitePet(siteRequest).onSuccess(response -> {
									LOG.debug(String.format("putmergeSitePet succeeded. "));
									eventHandler.handle(Future.succeededFuture(response));
								}).onFailure(ex -> {
									LOG.error(String.format("putmergeSitePet failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putmergeSitePet failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putmergeSitePet failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("putmergeSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}
			} catch(Exception ex) {
				LOG.error(String.format("putmergeSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putmergeSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putmergeSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPUTMergeSitePet(ApiRequest apiRequest, SiteRequestEnUS siteRequest) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				futures.add(Future.future(promise1 -> {
					JsonObject params = new JsonObject();
					params.put("body", obj);
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					params.put("query", new JsonObject());
					JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.principal()).orElse(null));
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("nico-site-enUS-SitePet", json, new DeliveryOptions().addHeader("action", "putmergeSitePetFuture")).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTMergeSitePet failed. "), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess(a -> {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTMergeSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("listPUTMergeSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public void putmergeSitePetFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				body.put("inheritPk", body.getValue("pk"));
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}

				SearchList<SitePet> searchList = new SearchList<SitePet>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SitePet.class);
				searchList.addFilterQuery("deleted_indexed_boolean:false");
				searchList.addFilterQuery("archived_indexed_boolean:false");
				searchList.addFilterQuery("pk_indexed_long:" + ClientUtils.escapeQueryChars(body.getString("pk")));
				searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
					try {
						if(searchList.size() >= 1) {
							SitePet o = searchList.getList().stream().findFirst().orElse(null);
							SitePet o2 = new SitePet();
							JsonObject body2 = new JsonObject();
							for(String f : body.fieldNames()) {
								Object bodyVal = body.getValue(f);
								if(bodyVal instanceof JsonArray) {
									JsonArray bodyVals = (JsonArray)bodyVal;
									Collection<?> vals = (Collection<?>)o.obtainForClass(f);
									if(bodyVals.size() == vals.size()) {
										Boolean match = true;
										for(Object val : vals) {
											if(val != null) {
												if(!bodyVals.contains(val.toString())) {
													match = false;
													break;
												}
											} else {
												match = false;
												break;
											}
										}
										if(!match) {
											body2.put("set" + StringUtils.capitalize(f), bodyVal);
										}
									} else {
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									}
								} else {
									o2.defineForClass(f, bodyVal);
									o2.attributeForClass(f, bodyVal);
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
								}
							}
							for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
								if(!body.fieldNames().contains(f)) {
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.putNull("set" + StringUtils.capitalize(f));
								}
							}
							if(body2.size() > 0) {
								siteRequest.setJsonObject(body2);
								patchSitePetFuture(o, false).onSuccess(b -> {
									LOG.info("Import SitePet {} succeeded, modified SitePet. ", body.getValue("pk"));
									eventHandler.handle(Future.succeededFuture());
								}).onFailure(ex -> {
									LOG.error(String.format("putmergeSitePetFuture failed. "), ex);
									eventHandler.handle(Future.failedFuture(ex));
								});
							} else {
								eventHandler.handle(Future.succeededFuture());
							}
						} else {
							postSitePetFuture(siteRequest, false).onSuccess(b -> {
								LOG.info("Import SitePet {} succeeded, created new SitePet. ", body.getValue("pk"));
								eventHandler.handle(Future.succeededFuture());
							}).onFailure(ex -> {
								LOG.error(String.format("putmergeSitePetFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							});
						}
					} catch(Exception ex) {
						LOG.error(String.format("putmergeSitePetFuture failed. "), ex);
						eventHandler.handle(Future.failedFuture(ex));
					}
				}).onFailure(ex -> {
					LOG.error(String.format("putmergeSitePetFuture failed. "), ex);
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Exception ex) {
				LOG.error(String.format("putmergeSitePetFuture failed. "), ex);
				eventHandler.handle(Future.failedFuture(ex));
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putmergeSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putmergeSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200PUTMergeSitePet(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTMergeSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PUTCopy //

	@Override
	public void putcopySitePet(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putcopySitePet started. "));
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					response200PUTCopySitePet(siteRequest).onSuccess(response -> {
						eventHandler.handle(Future.succeededFuture(response));
						searchSitePetList(siteRequest, false, true, true, "/api/pet/copy", "PUTCopy").onSuccess(listSitePet -> {
							ApiRequest apiRequest = new ApiRequest();
							apiRequest.setRows(listSitePet.getRows());
							apiRequest.setNumFound(listSitePet.getQueryResponse().getResults().getNumFound());
							apiRequest.setNumPATCH(0L);
							apiRequest.initDeepApiRequest(siteRequest);
							siteRequest.setApiRequest_(apiRequest);
							eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
							listPUTCopySitePet(apiRequest, listSitePet).onSuccess(e -> {
								response200PUTCopySitePet(siteRequest).onSuccess(f -> {
									LOG.debug(String.format("putcopySitePet succeeded. "));
									blockingCodeHandler.complete();
								}).onFailure(ex -> {
									LOG.error(String.format("putcopySitePet failed. "), ex);
									blockingCodeHandler.fail(ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putcopySitePet failed. "), ex);
								blockingCodeHandler.fail(ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putcopySitePet failed. "), ex);
							blockingCodeHandler.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("putcopySitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("putcopySitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putcopySitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putcopySitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPUTCopySitePet(ApiRequest apiRequest, SearchList<SitePet> listSitePet) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listSitePet.getSiteRequest_();
		listSitePet.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = siteRequest.copy();
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			o.setSiteRequest_(siteRequest2);
			futures.add(
				putcopySitePetFuture(siteRequest2, JsonObject.mapFrom(o)).onFailure(ex -> {
					LOG.error(String.format("listPUTCopySitePet failed. "), ex);
					error(siteRequest, null, ex);
				})
			);
		});
		CompositeFuture.all(futures).onSuccess(a -> {
			apiRequest.setNumPATCH(apiRequest.getNumPATCH() + listSitePet.size());
			listSitePet.next().onSuccess(next -> {
				if(next) {
					listPUTCopySitePet(apiRequest, listSitePet);
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTCopySitePet failed. "), ex);
				error(listSitePet.getSiteRequest_(), null, ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listPUTCopySitePet failed. "), ex);
			error(listSitePet.getSiteRequest_(), null, ex);
		});
		return promise.future();
	}

	public Future<SitePet> putcopySitePetFuture(SiteRequestEnUS siteRequest, JsonObject jsonObject) {
		Promise<SitePet> promise = Promise.promise();

		try {

			jsonObject.put("saves", Optional.ofNullable(jsonObject.getJsonArray("saves")).orElse(new JsonArray()));
			JsonObject jsonPatch = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonObject("patch")).orElse(new JsonObject());
			jsonPatch.stream().forEach(o -> {
				if(o.getValue() == null)
					jsonObject.remove(o.getKey());
				else
					jsonObject.put(o.getKey(), o.getValue());
				if(!jsonObject.getJsonArray("saves").contains(o.getKey()))
					jsonObject.getJsonArray("saves").add(o.getKey());
			});

			pgPool.withTransaction(sqlConnection -> {
				Promise<SitePet> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				createSitePet(siteRequest).onSuccess(sitePet -> {
					sqlPUTCopySitePet(sitePet, jsonObject).onSuccess(b -> {
						defineSitePet(sitePet).onSuccess(c -> {
							attributeSitePet(sitePet).onSuccess(d -> {
								indexSitePet(sitePet).onSuccess(e -> {
									promise1.complete(sitePet);
								}).onFailure(ex -> {
									LOG.error(String.format("putcopySitePetFuture failed. "), ex);
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putcopySitePetFuture failed. "), ex);
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putcopySitePetFuture failed. "), ex);
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("putcopySitePetFuture failed. "), ex);
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(String.format("putcopySitePetFuture failed. "), ex);
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				promise.fail(ex);
				error(siteRequest, null, ex);
			}).compose(sitePet -> {
				Promise<SitePet> promise2 = Promise.promise();
				refreshSitePet(sitePet).onSuccess(a -> {
					ApiRequest apiRequest = siteRequest.getApiRequest_();
					if(apiRequest != null) {
						apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
						sitePet.apiRequestSitePet();
						eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
					}
					promise2.complete(sitePet);
				}).onFailure(ex -> {
					LOG.error(String.format("putcopySitePetFuture failed. "), ex);
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(sitePet -> {
				promise.complete(sitePet);
				LOG.debug(String.format("putcopySitePetFuture succeeded. "));
			}).onFailure(ex -> {
				promise.fail(ex);
				error(siteRequest, null, ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("putcopySitePetFuture failed. "), ex);
			promise.fail(ex);
			error(siteRequest, null, ex);
		}
		return promise.future();
	}

	public Future<Void> sqlPUTCopySitePet(SitePet o, JsonObject jsonObject) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE SitePet SET ");
			List<Object> bParams = new ArrayList<Object>();
			SitePet o2 = new SitePet();
			o2.setSiteRequest_(siteRequest);
			Long pk = o.getPk();
			List<Future> futures = new ArrayList<>();

			if(jsonObject != null) {
				JsonArray entityVars = jsonObject.getJsonArray("saves");
				for(Integer i = 0; i < entityVars.size(); i++) {
					String entityVar = entityVars.getString(i);
					switch(entityVar) {
					case SitePet.VAR_inheritPk:
						o2.setInheritPk(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_inheritPk + "=$" + num);
						num++;
						bParams.add(o2.sqlInheritPk());
						break;
					case SitePet.VAR_archived:
						o2.setArchived(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_archived + "=$" + num);
						num++;
						bParams.add(o2.sqlArchived());
						break;
					case SitePet.VAR_deleted:
						o2.setDeleted(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_deleted + "=$" + num);
						num++;
						bParams.add(o2.sqlDeleted());
						break;
					case SitePet.VAR_enrollmentKeys:
						{
							for(Long l : Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray()).stream().map(a -> Long.parseLong((String)a)).collect(Collectors.toList())) {
								futures.add(Future.future(a -> {
									sqlConnection.preparedQuery("INSERT INTO SitePetEnrollmentKeys_SiteEnrollmentPetKeys(pk1, pk2) values($1, $2)")
											.execute(Tuple.of(pk, l)
											, b
									-> {
										if(b.succeeded())
											a.handle(Future.succeededFuture());
										else
											a.handle(Future.failedFuture(new Exception("value SitePet.enrollmentKeys failed", b.cause())));
									});
								}));
								if(!pks.contains(l)) {
									pks.add(l);
									classes.add("SiteEnrollment");
								}
							}
						}
						break;
					case SitePet.VAR_petName:
						o2.setPetName(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petName + "=$" + num);
						num++;
						bParams.add(o2.sqlPetName());
						break;
					case SitePet.VAR_petFoodAmount:
						o2.setPetFoodAmount(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petFoodAmount + "=$" + num);
						num++;
						bParams.add(o2.sqlPetFoodAmount());
						break;
					case SitePet.VAR_petFood:
						o2.setPetFood(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petFood + "=$" + num);
						num++;
						bParams.add(o2.sqlPetFood());
						break;
					case SitePet.VAR_petSick:
						o2.setPetSick(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petSick + "=$" + num);
						num++;
						bParams.add(o2.sqlPetSick());
						break;
					case SitePet.VAR_petMedNote:
						o2.setPetMedNote(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petMedNote + "=$" + num);
						num++;
						bParams.add(o2.sqlPetMedNote());
						break;
					case SitePet.VAR_petTrouble:
						o2.setPetTrouble(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petTrouble + "=$" + num);
						num++;
						bParams.add(o2.sqlPetTrouble());
						break;
					case SitePet.VAR_update:
						o2.setUpdate(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_update + "=$" + num);
						num++;
						bParams.add(o2.sqlUpdate());
						break;
					case SitePet.VAR_petAmount:
						o2.setPetAmount(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petAmount + "=$" + num);
						num++;
						bParams.add(o2.sqlPetAmount());
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
			bParams.add(pk);
			num++;
				futures.add(Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			CompositeFuture.all(futures).onSuccess(a -> {
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPUTCopySitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPUTCopySitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200PUTCopySitePet(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTCopySitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// POST //

	@Override
	public void postSitePet(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("postSitePet started. "));
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					ApiRequest apiRequest = new ApiRequest();
					apiRequest.setRows(1);
					apiRequest.setNumFound(1L);
					apiRequest.setNumPATCH(0L);
					apiRequest.initDeepApiRequest(siteRequest);
					siteRequest.setApiRequest_(apiRequest);
					eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
					JsonObject params = new JsonObject();
					params.put("body", siteRequest.getJsonObject());
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					params.put("query", new JsonObject());
					JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.principal()).orElse(null));
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("nico-site-enUS-SitePet", json, new DeliveryOptions().addHeader("action", "postSitePetFuture")).onSuccess(a -> {
						JsonObject responseMessage = (JsonObject)a.body();
						JsonObject responseBody = new JsonObject(new String(Base64.getDecoder().decode(responseMessage.getString("payload")), Charset.forName("UTF-8")));
						apiRequest.setPk(Long.parseLong(responseBody.getString("pk")));
						eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
						LOG.debug(String.format("postSitePet succeeded. "));
					}).onFailure(ex -> {
						LOG.error(String.format("postSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("postSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("postSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	@Override
	public void postSitePetFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			ApiRequest apiRequest = new ApiRequest();
			apiRequest.setRows(1);
			apiRequest.setNumFound(1L);
			apiRequest.setNumPATCH(0L);
			apiRequest.initDeepApiRequest(siteRequest);
			siteRequest.setApiRequest_(apiRequest);
			if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
				siteRequest.getRequestVars().put( "refresh", "false" );
			}
			postSitePetFuture(siteRequest, false).onSuccess(o -> {
				eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
			}).onFailure(ex -> {
				eventHandler.handle(Future.failedFuture(ex));
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("postSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<SitePet> postSitePetFuture(SiteRequestEnUS siteRequest, Boolean inheritPk) {
		Promise<SitePet> promise = Promise.promise();

		try {
			pgPool.withTransaction(sqlConnection -> {
				Promise<SitePet> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				createSitePet(siteRequest).onSuccess(sitePet -> {
					sqlPOSTSitePet(sitePet, inheritPk).onSuccess(b -> {
						defineSitePet(sitePet).onSuccess(c -> {
							attributeSitePet(sitePet).onSuccess(d -> {
								indexSitePet(sitePet).onSuccess(e -> {
									promise1.complete(sitePet);
								}).onFailure(ex -> {
									LOG.error(String.format("postSitePetFuture failed. "), ex);
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("postSitePetFuture failed. "), ex);
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("postSitePetFuture failed. "), ex);
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("postSitePetFuture failed. "), ex);
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(String.format("postSitePetFuture failed. "), ex);
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				promise.fail(ex);
				error(siteRequest, null, ex);
			}).compose(sitePet -> {
				Promise<SitePet> promise2 = Promise.promise();
				refreshSitePet(sitePet).onSuccess(a -> {
					ApiRequest apiRequest = siteRequest.getApiRequest_();
					if(apiRequest != null) {
						apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
						sitePet.apiRequestSitePet();
						eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
					}
					promise2.complete(sitePet);
				}).onFailure(ex -> {
					LOG.error(String.format("postSitePetFuture failed. "), ex);
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(sitePet -> {
				promise.complete(sitePet);
				LOG.debug(String.format("postSitePetFuture succeeded. "));
			}).onFailure(ex -> {
				promise.fail(ex);
				error(siteRequest, null, ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("postSitePetFuture failed. "), ex);
			promise.fail(ex);
			error(siteRequest, null, ex);
		}
		return promise.future();
	}

	public Future<Void> sqlPOSTSitePet(SitePet o, Boolean inheritPk) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE SitePet SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			SitePet o2 = new SitePet();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(siteRequest.getSessionId() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("sessionId=$" + num);
				num++;
				bParams.add(siteRequest.getSessionId());
			}
			if(siteRequest.getUserKey() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("userKey=$" + num);
				num++;
				bParams.add(siteRequest.getUserKey());
			}

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case SitePet.VAR_inheritPk:
						o2.setInheritPk(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_inheritPk + "=$" + num);
						num++;
						bParams.add(o2.sqlInheritPk());
						break;
					case SitePet.VAR_archived:
						o2.setArchived(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_archived + "=$" + num);
						num++;
						bParams.add(o2.sqlArchived());
						break;
					case SitePet.VAR_deleted:
						o2.setDeleted(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_deleted + "=$" + num);
						num++;
						bParams.add(o2.sqlDeleted());
						break;
					case SitePet.VAR_enrollmentKeys:
						Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray()).stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(SiteEnrollment.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("SiteEnrollment");
									}
									sql(siteRequest).insertInto(SitePet.class, SitePet.VAR_enrollmentKeys, SiteEnrollment.class, SiteEnrollment.VAR_petKeys).values(pk, pk2).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case SitePet.VAR_petName:
						o2.setPetName(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petName + "=$" + num);
						num++;
						bParams.add(o2.sqlPetName());
						break;
					case SitePet.VAR_petFoodAmount:
						o2.setPetFoodAmount(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petFoodAmount + "=$" + num);
						num++;
						bParams.add(o2.sqlPetFoodAmount());
						break;
					case SitePet.VAR_petFood:
						o2.setPetFood(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petFood + "=$" + num);
						num++;
						bParams.add(o2.sqlPetFood());
						break;
					case SitePet.VAR_petSick:
						o2.setPetSick(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petSick + "=$" + num);
						num++;
						bParams.add(o2.sqlPetSick());
						break;
					case SitePet.VAR_petMedNote:
						o2.setPetMedNote(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petMedNote + "=$" + num);
						num++;
						bParams.add(o2.sqlPetMedNote());
						break;
					case SitePet.VAR_petTrouble:
						o2.setPetTrouble(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petTrouble + "=$" + num);
						num++;
						bParams.add(o2.sqlPetTrouble());
						break;
					case SitePet.VAR_update:
						o2.setUpdate(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_update + "=$" + num);
						num++;
						bParams.add(o2.sqlUpdate());
						break;
					case SitePet.VAR_petAmount:
						o2.setPetAmount(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(SitePet.VAR_petAmount + "=$" + num);
						num++;
						bParams.add(o2.sqlPetAmount());
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
			bParams.add(pk);
			num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPOSTSitePet failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPOSTSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPOSTSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200POSTSitePet(SitePet o) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200POSTSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PATCH //

	@Override
	public void patchSitePet(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("patchSitePet started. "));
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					serviceRequest.getParams().getJsonObject("query").put("rows", 100);
					searchSitePetList(siteRequest, false, true, true, "/api/pet", "PATCH").onSuccess(listSitePet -> {
						try {
							List<String> roles2 = Arrays.asList("SiteAdmin");
							if(listSitePet.getQueryResponse().getResults().getNumFound() > 1
									&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles2)
									&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles2)
									) {
								String message = String.format("roles required: " + String.join(", ", roles2));
								LOG.error(message);
								error(siteRequest, eventHandler, new RuntimeException(message));
							} else {

								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listSitePet.getRows());
								apiRequest.setNumFound(listSitePet.getQueryResponse().getResults().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listSitePet.first());
								apiRequest.setPk(listSitePet.first().getPk());
								eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());

								listPATCHSitePet(apiRequest, listSitePet).onSuccess(e -> {
									response200PATCHSitePet(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("patchSitePet succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("patchSitePet failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("patchSitePet failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}
						} catch(Exception ex) {
							LOG.error(String.format("patchSitePet failed. "), ex);
							error(siteRequest, eventHandler, ex);
						}
					}).onFailure(ex -> {
						LOG.error(String.format("patchSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("patchSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("patchSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("patchSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPATCHSitePet(ApiRequest apiRequest, SearchList<SitePet> listSitePet) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listSitePet.getSiteRequest_();
		listSitePet.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequestEnUS(siteRequest.getUser(), siteRequest.getServiceRequest(), siteRequest.getJsonObject());
			o.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				patchSitePetFuture(o, false).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listPATCHSitePet failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			if(apiRequest != null) {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + listSitePet.getQueryResponse().getResults().size());
				if(apiRequest.getNumFound() == 1L)
					listSitePet.first().apiRequestSitePet();
				eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
			}
			listSitePet.next().onSuccess(next -> {
				if(next) {
					listPATCHSitePet(apiRequest, listSitePet);
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listPATCHSitePet failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listPATCHSitePet failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void patchSitePetFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				serviceRequest.getParams().getJsonObject("query").put("rows", 1);
				searchSitePetList(siteRequest, false, true, true, "/api/pet", "PATCH").onSuccess(listSitePet -> {
					try {
						SitePet o = listSitePet.first();
						if(o != null && listSitePet.getQueryResponse().getResults().getNumFound() == 1) {
							ApiRequest apiRequest = new ApiRequest();
							apiRequest.setRows(1);
							apiRequest.setNumFound(1L);
							apiRequest.setNumPATCH(0L);
							apiRequest.initDeepApiRequest(siteRequest);
							siteRequest.setApiRequest_(apiRequest);
							if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
								siteRequest.getRequestVars().put( "refresh", "false" );
							}
							if(apiRequest.getNumFound() == 1L)
								apiRequest.setOriginal(o);
							apiRequest.setPk(listSitePet.first().getPk());
							eventBus.publish("websocketSitePet", JsonObject.mapFrom(apiRequest).toString());
							patchSitePetFuture(o, false).onSuccess(a -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("patchSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("patchSitePet failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("patchSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("patchSitePet failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<SitePet> patchSitePetFuture(SitePet o, Boolean inheritPk) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		Promise<SitePet> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			pgPool.withTransaction(sqlConnection -> {
				Promise<SitePet> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				sqlPATCHSitePet(o, inheritPk).onSuccess(sitePet -> {
					defineSitePet(sitePet).onSuccess(c -> {
						attributeSitePet(sitePet).onSuccess(d -> {
							indexSitePet(sitePet).onSuccess(e -> {
								promise1.complete(sitePet);
							}).onFailure(ex -> {
								LOG.error(String.format("patchSitePetFuture failed. "), ex);
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("patchSitePetFuture failed. "), ex);
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("patchSitePetFuture failed. "), ex);
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(String.format("patchSitePetFuture failed. "), ex);
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				promise.fail(ex);
				error(siteRequest, null, ex);
			}).compose(sitePet -> {
				Promise<SitePet> promise2 = Promise.promise();
				refreshSitePet(sitePet).onSuccess(a -> {
					promise2.complete(sitePet);
				}).onFailure(ex -> {
					LOG.error(String.format("patchSitePetFuture failed. "), ex);
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(sitePet -> {
				promise.complete(sitePet);
				LOG.debug(String.format("patchSitePetFuture succeeded. "));
			}).onFailure(ex -> {
				promise.fail(ex);
				error(siteRequest, null, ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("patchSitePetFuture failed. "), ex);
			promise.fail(ex);
			error(siteRequest, null, ex);
		}
		return promise.future();
	}

	public Future<SitePet> sqlPATCHSitePet(SitePet o, Boolean inheritPk) {
		Promise<SitePet> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE SitePet SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			SitePet o2 = new SitePet();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			for(String entityVar : methodNames) {
				switch(entityVar) {
					case "setInheritPk":
							o2.setInheritPk(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_inheritPk + "=$" + num);
							num++;
							bParams.add(o2.sqlInheritPk());
						break;
					case "setArchived":
							o2.setArchived(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_archived + "=$" + num);
							num++;
							bParams.add(o2.sqlArchived());
						break;
					case "setDeleted":
							o2.setDeleted(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_deleted + "=$" + num);
							num++;
							bParams.add(o2.sqlDeleted());
						break;
					case "setEnrollmentKeys":
						JsonArray setEnrollmentKeysValues = Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray());
						setEnrollmentKeysValues.stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(SiteEnrollment.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("SiteEnrollment");
									}
									sql(siteRequest).insertInto(SitePet.class, SitePet.VAR_enrollmentKeys, SiteEnrollment.class, SiteEnrollment.VAR_petKeys).values(pk, pk2).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						Optional.ofNullable(o.getEnrollmentKeys()).orElse(Arrays.asList()).stream().filter(oVal -> oVal != null && !setEnrollmentKeysValues.contains(oVal.toString())).forEach(pk2 -> {
							if(!pks.contains(pk2)) {
								pks.add(pk2);
								classes.add("SiteEnrollment");
							}
							futures2.add(Future.future(promise2 -> {
								sql(siteRequest).deleteFrom(SitePet.class, SitePet.VAR_enrollmentKeys, SiteEnrollment.class, SiteEnrollment.VAR_petKeys).where(pk, pk2).onSuccess(a -> {
									promise2.complete();
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "addAllEnrollmentKeys":
						JsonArray addAllEnrollmentKeysValues = Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray());
						addAllEnrollmentKeysValues.stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(SiteEnrollment.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("SiteEnrollment");
									}
									sql(siteRequest).insertInto(SitePet.class, SitePet.VAR_enrollmentKeys, SiteEnrollment.class, SiteEnrollment.VAR_petKeys).values(pk, pk2).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "addEnrollmentKeys":
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(SiteEnrollment.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("SiteEnrollment");
									}
									sql(siteRequest).insertInto(SitePet.class, SitePet.VAR_enrollmentKeys, SiteEnrollment.class, SiteEnrollment.VAR_petKeys).values(pk, pk2).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "removeEnrollmentKeys":
						Optional.ofNullable(jsonObject.getString(entityVar)).map(val -> Long.parseLong(val)).ifPresent(pk2 -> {
							if(!pks.contains(pk2)) {
								pks.add(pk2);
								classes.add("SiteEnrollment");
							}
							futures2.add(Future.future(promise2 -> {
								sql(siteRequest).deleteFrom(SitePet.class, SitePet.VAR_enrollmentKeys, SiteEnrollment.class, SiteEnrollment.VAR_petKeys).where(pk, pk2).onSuccess(a -> {
									promise2.complete();
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "setPetName":
							o2.setPetName(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_petName + "=$" + num);
							num++;
							bParams.add(o2.sqlPetName());
						break;
					case "setPetFoodAmount":
							o2.setPetFoodAmount(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_petFoodAmount + "=$" + num);
							num++;
							bParams.add(o2.sqlPetFoodAmount());
						break;
					case "setPetFood":
							o2.setPetFood(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_petFood + "=$" + num);
							num++;
							bParams.add(o2.sqlPetFood());
						break;
					case "setPetSick":
							o2.setPetSick(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_petSick + "=$" + num);
							num++;
							bParams.add(o2.sqlPetSick());
						break;
					case "setPetMedNote":
							o2.setPetMedNote(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_petMedNote + "=$" + num);
							num++;
							bParams.add(o2.sqlPetMedNote());
						break;
					case "setPetTrouble":
							o2.setPetTrouble(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_petTrouble + "=$" + num);
							num++;
							bParams.add(o2.sqlPetTrouble());
						break;
					case "setUpdate":
							o2.setUpdate(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_update + "=$" + num);
							num++;
							bParams.add(o2.sqlUpdate());
						break;
					case "setPetAmount":
							o2.setPetAmount(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(SitePet.VAR_petAmount + "=$" + num);
							num++;
							bParams.add(o2.sqlPetAmount());
						break;
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
				bParams.add(pk);
				num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					SitePet o3 = new SitePet();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					promise.complete(o3);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPATCHSitePet failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPATCHSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPATCHSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200PATCHSitePet(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PATCHSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// GET //

	@Override
	public void getSitePet(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					searchSitePetList(siteRequest, false, true, false, "/api/pet/{id}", "GET").onSuccess(listSitePet -> {
						response200GETSitePet(listSitePet).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("getSitePet succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("getSitePet failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("getSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("getSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("getSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("getSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200GETSitePet(SearchList<SitePet> listSitePet) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listSitePet.getSiteRequest_();
			SolrDocumentList solrDocuments = listSitePet.getSolrDocumentList();

			JsonObject json = JsonObject.mapFrom(listSitePet.getList().stream().findFirst().orElse(null));
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200GETSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// Search //

	@Override
	public void searchSitePet(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					searchSitePetList(siteRequest, false, true, false, "/api/pet", "Search").onSuccess(listSitePet -> {
						response200SearchSitePet(listSitePet).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("searchSitePet succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("searchSitePet failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("searchSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("searchSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("searchSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200SearchSitePet(SearchList<SitePet> listSitePet) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listSitePet.getSiteRequest_();
			QueryResponse responseSearch = listSitePet.getQueryResponse();
			SolrDocumentList solrDocuments = listSitePet.getSolrDocumentList();
			Long searchInMillis = Long.valueOf(responseSearch.getQTime());
			Long transmissionInMillis = responseSearch.getElapsedTime();
			Long startNum = responseSearch.getResults().getStart();
			Long foundNum = responseSearch.getResults().getNumFound();
			Integer returnedNum = responseSearch.getResults().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String transmissionTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis), TimeUnit.MILLISECONDS.toMillis(transmissionInMillis) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis)));
			String nextCursorMark = responseSearch.getNextCursorMark();
			Exception exceptionSearch = responseSearch.getException();
			List<String> fls = listSitePet.getFields();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
				json.put("searchTime", searchTime);
				json.put("transmissionTime", transmissionTime);
			}
			if(nextCursorMark != null) {
				json.put("nextCursorMark", nextCursorMark);
			}
			JsonArray l = new JsonArray();
			listSitePet.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
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

			List<FacetField> facetFields = responseSearch.getFacetFields();
			if(facetFields != null) {
				JsonObject facetFieldsJson = new JsonObject();
				json.put("facet_fields", facetFieldsJson);
				for(FacetField facetField : facetFields) {
					String facetFieldVar = StringUtils.substringBefore(facetField.getName(), "_indexed_");
					JsonObject facetFieldCounts = new JsonObject();
					facetFieldsJson.put(facetFieldVar, facetFieldCounts);
					List<FacetField.Count> facetFieldValues = facetField.getValues();
					for(Integer i = 0; i < facetFieldValues.size(); i+= 1) {
						FacetField.Count count = (FacetField.Count)facetFieldValues.get(i);
						facetFieldCounts.put(count.getName(), count.getCount());
					}
				}
			}

			List<RangeFacet> facetRanges = responseSearch.getFacetRanges();
			if(facetRanges != null) {
				JsonObject rangeJson = new JsonObject();
				json.put("facet_ranges", rangeJson);
				for(RangeFacet rangeFacet : facetRanges) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_indexed_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsMap = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsMap);
					List<?> rangeFacetCounts = rangeFacet.getCounts();
					for(Integer i = 0; i < rangeFacetCounts.size(); i+= 1) {
						RangeFacet.Count count = (RangeFacet.Count)rangeFacetCounts.get(i);
						rangeFacetCountsMap.put(count.getValue(), count.getCount());
					}
				}
			}

			NamedList<List<PivotField>> facetPivot = responseSearch.getFacetPivot();
			if(facetPivot != null) {
				JsonObject facetPivotJson = new JsonObject();
				json.put("facet_pivot", facetPivotJson);
				Iterator<Entry<String, List<PivotField>>> facetPivotIterator = responseSearch.getFacetPivot().iterator();
				while(facetPivotIterator.hasNext()) {
					Entry<String, List<PivotField>> pivotEntry = facetPivotIterator.next();
					List<PivotField> pivotFields = pivotEntry.getValue();
					String[] varsIndexed = pivotEntry.getKey().trim().split(",");
					String[] entityVars = new String[varsIndexed.length];
					for(Integer i = 0; i < entityVars.length; i++) {
						String entityIndexed = varsIndexed[i];
						entityVars[i] = StringUtils.substringBefore(entityIndexed, "_indexed_");
					}
					JsonArray pivotArray = new JsonArray();
					facetPivotJson.put(StringUtils.join(entityVars, ","), pivotArray);
					responsePivotSearchSitePet(pivotFields, pivotArray);
				}
			}
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch.getMessage());
			}
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchSitePet(List<PivotField> pivotFields, JsonArray pivotArray) {
		for(PivotField pivotField : pivotFields) {
			String entityIndexed = pivotField.getField();
			String entityVar = StringUtils.substringBefore(entityIndexed, "_indexed_");
			JsonObject pivotJson = new JsonObject();
			pivotArray.add(pivotJson);
			pivotJson.put("field", entityVar);
			pivotJson.put("value", pivotField.getValue());
			pivotJson.put("count", pivotField.getCount());
			List<RangeFacet> pivotRanges = pivotField.getFacetRanges();
			List<PivotField> pivotFields2 = pivotField.getPivot();
			if(pivotRanges != null) {
				JsonObject rangeJson = new JsonObject();
				pivotJson.put("ranges", rangeJson);
				for(RangeFacet rangeFacet : pivotRanges) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_indexed_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsObject = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsObject);
					List<?> rangeFacetCounts = rangeFacet.getCounts();
					for(Integer i = 0; i < rangeFacetCounts.size(); i+= 1) {
						RangeFacet.Count count = (RangeFacet.Count)rangeFacetCounts.get(i);
						rangeFacetCountsObject.put(count.getValue(), count.getCount());
					}
				}
			}
			if(pivotFields2 != null) {
				JsonArray pivotArray2 = new JsonArray();
				pivotJson.put("pivot", pivotArray2);
				responsePivotSearchSitePet(pivotFields2, pivotArray2);
			}
		}
	}

	// AdminSearch //

	@Override
	public void adminsearchSitePet(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					searchSitePetList(siteRequest, false, true, false, "/api/admin/pet", "AdminSearch").onSuccess(listSitePet -> {
						response200AdminSearchSitePet(listSitePet).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("adminsearchSitePet succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("adminsearchSitePet failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("adminsearchSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("adminsearchSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("adminsearchSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("adminsearchSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200AdminSearchSitePet(SearchList<SitePet> listSitePet) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listSitePet.getSiteRequest_();
			QueryResponse responseSearch = listSitePet.getQueryResponse();
			SolrDocumentList solrDocuments = listSitePet.getSolrDocumentList();
			Long searchInMillis = Long.valueOf(responseSearch.getQTime());
			Long transmissionInMillis = responseSearch.getElapsedTime();
			Long startNum = responseSearch.getResults().getStart();
			Long foundNum = responseSearch.getResults().getNumFound();
			Integer returnedNum = responseSearch.getResults().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String transmissionTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis), TimeUnit.MILLISECONDS.toMillis(transmissionInMillis) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis)));
			String nextCursorMark = responseSearch.getNextCursorMark();
			Exception exceptionSearch = responseSearch.getException();
			List<String> fls = listSitePet.getFields();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
				json.put("searchTime", searchTime);
				json.put("transmissionTime", transmissionTime);
			}
			if(nextCursorMark != null) {
				json.put("nextCursorMark", nextCursorMark);
			}
			JsonArray l = new JsonArray();
			listSitePet.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
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

			List<FacetField> facetFields = responseSearch.getFacetFields();
			if(facetFields != null) {
				JsonObject facetFieldsJson = new JsonObject();
				json.put("facet_fields", facetFieldsJson);
				for(FacetField facetField : facetFields) {
					String facetFieldVar = StringUtils.substringBefore(facetField.getName(), "_indexed_");
					JsonObject facetFieldCounts = new JsonObject();
					facetFieldsJson.put(facetFieldVar, facetFieldCounts);
					List<FacetField.Count> facetFieldValues = facetField.getValues();
					for(Integer i = 0; i < facetFieldValues.size(); i+= 1) {
						FacetField.Count count = (FacetField.Count)facetFieldValues.get(i);
						facetFieldCounts.put(count.getName(), count.getCount());
					}
				}
			}

			List<RangeFacet> facetRanges = responseSearch.getFacetRanges();
			if(facetRanges != null) {
				JsonObject rangeJson = new JsonObject();
				json.put("facet_ranges", rangeJson);
				for(RangeFacet rangeFacet : facetRanges) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_indexed_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsMap = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsMap);
					List<?> rangeFacetCounts = rangeFacet.getCounts();
					for(Integer i = 0; i < rangeFacetCounts.size(); i+= 1) {
						RangeFacet.Count count = (RangeFacet.Count)rangeFacetCounts.get(i);
						rangeFacetCountsMap.put(count.getValue(), count.getCount());
					}
				}
			}

			NamedList<List<PivotField>> facetPivot = responseSearch.getFacetPivot();
			if(facetPivot != null) {
				JsonObject facetPivotJson = new JsonObject();
				json.put("facet_pivot", facetPivotJson);
				Iterator<Entry<String, List<PivotField>>> facetPivotIterator = responseSearch.getFacetPivot().iterator();
				while(facetPivotIterator.hasNext()) {
					Entry<String, List<PivotField>> pivotEntry = facetPivotIterator.next();
					List<PivotField> pivotFields = pivotEntry.getValue();
					String[] varsIndexed = pivotEntry.getKey().trim().split(",");
					String[] entityVars = new String[varsIndexed.length];
					for(Integer i = 0; i < entityVars.length; i++) {
						String entityIndexed = varsIndexed[i];
						entityVars[i] = StringUtils.substringBefore(entityIndexed, "_indexed_");
					}
					JsonArray pivotArray = new JsonArray();
					facetPivotJson.put(StringUtils.join(entityVars, ","), pivotArray);
					responsePivotAdminSearchSitePet(pivotFields, pivotArray);
				}
			}
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch.getMessage());
			}
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200AdminSearchSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotAdminSearchSitePet(List<PivotField> pivotFields, JsonArray pivotArray) {
		for(PivotField pivotField : pivotFields) {
			String entityIndexed = pivotField.getField();
			String entityVar = StringUtils.substringBefore(entityIndexed, "_indexed_");
			JsonObject pivotJson = new JsonObject();
			pivotArray.add(pivotJson);
			pivotJson.put("field", entityVar);
			pivotJson.put("value", pivotField.getValue());
			pivotJson.put("count", pivotField.getCount());
			List<RangeFacet> pivotRanges = pivotField.getFacetRanges();
			List<PivotField> pivotFields2 = pivotField.getPivot();
			if(pivotRanges != null) {
				JsonObject rangeJson = new JsonObject();
				pivotJson.put("ranges", rangeJson);
				for(RangeFacet rangeFacet : pivotRanges) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_indexed_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsObject = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsObject);
					List<?> rangeFacetCounts = rangeFacet.getCounts();
					for(Integer i = 0; i < rangeFacetCounts.size(); i+= 1) {
						RangeFacet.Count count = (RangeFacet.Count)rangeFacetCounts.get(i);
						rangeFacetCountsObject.put(count.getValue(), count.getCount());
					}
				}
			}
			if(pivotFields2 != null) {
				JsonArray pivotArray2 = new JsonArray();
				pivotJson.put("pivot", pivotArray2);
				responsePivotAdminSearchSitePet(pivotFields2, pivotArray2);
			}
		}
	}

	// SearchPage //

	@Override
	public void searchpageSitePetId(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		searchpageSitePet(serviceRequest, eventHandler);
	}

	@Override
	public void searchpageSitePet(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest).onSuccess(siteRequest -> {
			try {
				siteRequest.setRequestUri(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
				siteRequest.setRequestMethod(Optional.ofNullable(serviceRequest.getExtra()).map(extra -> extra.getString("method")).orElse(null));
				{
					searchSitePetList(siteRequest, false, true, false, "/pet", "SearchPage").onSuccess(listSitePet -> {
						response200SearchPageSitePet(listSitePet).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("searchpageSitePet succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("searchpageSitePet failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("searchpageSitePet failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("searchpageSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchpageSitePet failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("searchpageSitePet failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public void searchpageSitePetPageInit(PetPage page, SearchList<SitePet> listSitePet) {
	}
	public Future<ServiceResponse> response200SearchPageSitePet(SearchList<SitePet> listSitePet) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listSitePet.getSiteRequest_();
			Buffer buffer = Buffer.buffer();
			AllWriter w = AllWriter.create(listSitePet.getSiteRequest_(), buffer);
			PetPage page = new PetPage();
			SolrDocument pageSolrDocument = new SolrDocument();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			pageSolrDocument.setField("pageUri_frFR_stored_string", "/pet");
			page.setPageSolrDocument(pageSolrDocument);
			page.setW(w);
			if(listSitePet.size() == 1)
				siteRequest.setRequestPk(listSitePet.get(0).getPk());
			siteRequest.setW(w);
			page.setListSitePet(listSitePet);
			page.setSiteRequest_(siteRequest);
			searchpageSitePetPageInit(page, listSitePet);
			page.promiseDeepPetPage(siteRequest).onSuccess(a -> {
				page.html();
				promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchPageSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public static final String VAR_petKey = "petKey";
	public static final String VAR_enrollmentSearch = "enrollmentSearch";
	public static final String VAR_userKeys = "userKeys";
	public static final String VAR_enrollmentKeys = "enrollmentKeys";
	public static final String VAR_petName = "petName";
	public static final String VAR_petFoodAmount = "petFoodAmount";
	public static final String VAR_petFood = "petFood";
	public static final String VAR_petSick = "petSick";
	public static final String VAR_petMedNote = "petMedNote";
	public static final String VAR_petTrouble = "petTrouble";
	public static final String VAR_update = "update";
	public static final String VAR_petAmount = "petAmount";

	// General //

	public Future<SitePet> createSitePet(SiteRequestEnUS siteRequest) {
		Promise<SitePet> promise = Promise.promise();
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			Long userKey = siteRequest.getUserKey();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of(config.getString("siteZone"))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString("siteZone"))));

			sqlConnection.preparedQuery("INSERT INTO SitePet(created, userKey) VALUES($1, $2) RETURNING pk")
					.collecting(Collectors.toList())
					.execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
				Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
				Long pk = createLine.getLong(0);
				SitePet o = new SitePet();
				o.setPk(pk);
				o.setSiteRequest_(siteRequest);
				promise.complete(o);
			}).onFailure(ex -> {
				LOG.error("createSitePet failed. ", ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("createSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public void searchSitePetQ(String uri, String apiMethod, SearchList<SitePet> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.setQuery(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : ClientUtils.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public String searchSitePetFq(String uri, String apiMethod, SearchList<SitePet> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		if(StringUtils.startsWith(valueIndexed, "[")) {
			String[] fqs = StringUtils.substringBefore(StringUtils.substringAfter(valueIndexed, "["), "]").split(" TO ");
			if(fqs.length != 2)
				throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
			String fq1 = fqs[0].equals("*") ? fqs[0] : SitePet.staticSolrFqForClass(entityVar, searchList.getSiteRequest_(), fqs[0]);
			String fq2 = fqs[1].equals("*") ? fqs[1] : SitePet.staticSolrFqForClass(entityVar, searchList.getSiteRequest_(), fqs[1]);
			 return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
		} else {
			return varIndexed + ":" + ClientUtils.escapeQueryChars(SitePet.staticSolrFqForClass(entityVar, searchList.getSiteRequest_(), valueIndexed)).replace("\\", "\\\\");
		}
	}

	public void searchSitePetSort(String uri, String apiMethod, SearchList<SitePet> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.addSort(varIndexed, ORDER.valueOf(valueIndexed));
	}

	public void searchSitePetRows(String uri, String apiMethod, SearchList<SitePet> searchList, Integer valueRows) {
			searchList.setRows(apiMethod != null ? valueRows : 10);
	}

	public void searchSitePetStart(String uri, String apiMethod, SearchList<SitePet> searchList, Integer valueStart) {
		searchList.setStart(valueStart);
	}

	public void searchSitePetVar(String uri, String apiMethod, SearchList<SitePet> searchList, String var, String value) {
		searchList.getSiteRequest_().getRequestVars().put(var, value);
	}

	public void searchSitePetUri(String uri, String apiMethod, SearchList<SitePet> searchList) {
	}

	public Future<ServiceResponse> varsSitePet(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();

			serviceRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
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
				} catch(Exception ex) {
					LOG.error(String.format("searchSitePet failed. "), ex);
					promise.fail(ex);
				}
			});
			promise.complete();
		} catch(Exception ex) {
			LOG.error(String.format("searchSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<SearchList<SitePet>> searchSitePetList(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify, String uri, String apiMethod) {
		Promise<SearchList<SitePet>> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();
			String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<SitePet> searchList = new SearchList<SitePet>();
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.setQuery("*:*");
			searchList.setC(SitePet.class);
			searchList.setSiteRequest_(siteRequest);
			if(entityList != null)
				searchList.addFields(entityList);

			String id = serviceRequest.getParams().getJsonObject("path").getString("id");
			if(id != null && NumberUtils.isCreatable(id)) {
				searchList.addFilterQuery("(pk_indexed_long:" + ClientUtils.escapeQueryChars(id) + " OR objectId_indexed_string:" + ClientUtils.escapeQueryChars(id) + ")");
			} else if(id != null) {
				searchList.addFilterQuery("objectId_indexed_string:" + ClientUtils.escapeQueryChars(id));
			}

			List<String> roles = Arrays.asList("SiteAdmin");
			List<String> roleReads = Arrays.asList("");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					&& (modify || !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roleReads))
					&& (modify || !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roleReads))
					) {
				searchList.addFilterQuery("sessionId_indexed_string:" + ClientUtils.escapeQueryChars(Optional.ofNullable(siteRequest.getSessionId()).orElse("-----")) + " OR " + "sessionId_indexed_string:" + ClientUtils.escapeQueryChars(Optional.ofNullable(siteRequest.getSessionIdBefore()).orElse("-----"))
						+ " OR userKeys_indexed_longs:" + Optional.ofNullable(siteRequest.getUserKey()).orElse(0L));
			}

			serviceRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Integer valueStart = null;
				Integer valueRows = null;
				String valueCursorMark = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
						Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
						boolean foundFacetPivot = mFacetPivot.find();
						if(foundFacetPivot) {
							String solrLocalParams = mFacetPivot.group(1);
							String[] entityVars = mFacetPivot.group(2).trim().split(",");
							String[] varsIndexed = new String[entityVars.length];
							for(Integer i = 0; i < entityVars.length; i++) {
								entityVar = entityVars[i];
								varsIndexed[i] = SitePet.varIndexedSitePet(entityVar);
							}
							searchList.add("facet.pivot", (solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
						}
					} else if(paramValuesObject != null) {
						for(Object paramObject : paramObjects) {
							switch(paramName) {
								case "q":
									entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
									varIndexed = "*".equals(entityVar) ? entityVar : SitePet.varSearchSitePet(entityVar);
									valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
									valueIndexed = StringUtils.isEmpty(valueIndexed) ? "*" : valueIndexed;
									searchSitePetQ(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
									break;
								case "fq":
									Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
									boolean foundFq = mFq.find();
									if(foundFq) {
										StringBuffer sb = new StringBuffer();
										while(foundFq) {
											entityVar = mFq.group(1).trim();
											valueIndexed = mFq.group(2).trim();
											varIndexed = SitePet.varIndexedSitePet(entityVar);
											String entityFq = searchSitePetFq(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
											mFq.appendReplacement(sb, entityFq);
											foundFq = mFq.find();
										}
										mFq.appendTail(sb);
										searchList.addFilterQuery(sb.toString());
									}
									break;
								case "sort":
									entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
									valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
									varIndexed = SitePet.varIndexedSitePet(entityVar);
									searchSitePetSort(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
									break;
								case "start":
									valueStart = paramObject instanceof Integer ? (Integer)paramObject : Integer.parseInt(paramObject.toString());
									searchSitePetStart(uri, apiMethod, searchList, valueStart);
									break;
								case "rows":
									valueRows = paramObject instanceof Integer ? (Integer)paramObject : Integer.parseInt(paramObject.toString());
									searchSitePetRows(uri, apiMethod, searchList, valueRows);
									break;
								case "facet":
									searchList.add("facet", ((Boolean)paramObject).toString());
									break;
								case "facet.range.start":
									String startMathStr = (String)paramObject;
									Date start = DateMathParser.parseMath(null, startMathStr);
									searchList.add("facet.range.start", start.toInstant().toString());
									break;
								case "facet.range.end":
									String endMathStr = (String)paramObject;
									Date end = DateMathParser.parseMath(null, endMathStr);
									searchList.add("facet.range.end", end.toInstant().toString());
									break;
								case "facet.range.gap":
									String gap = (String)paramObject;
									searchList.add("facet.range.gap", gap);
									break;
								case "facet.range":
									Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
									boolean foundFacetRange = mFacetRange.find();
									if(foundFacetRange) {
										String solrLocalParams = mFacetRange.group(1);
										entityVar = mFacetRange.group(2).trim();
										varIndexed = SitePet.varIndexedSitePet(entityVar);
										searchList.add("facet.range", (solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									}
									break;
								case "facet.field":
									entityVar = (String)paramObject;
									varIndexed = SitePet.varIndexedSitePet(entityVar);
									if(varIndexed != null)
										searchList.addFacetField(varIndexed);
									break;
								case "var":
									entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
									valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
									searchSitePetVar(uri, apiMethod, searchList, entityVar, valueIndexed);
									break;
								case "cursorMark":
									valueCursorMark = (String)paramObject;
									searchList.add("cursorMark", (String)paramObject);
									break;
							}
						}
						searchSitePetUri(uri, apiMethod, searchList);
					}
				} catch(Exception e) {
					ExceptionUtils.rethrow(e);
				}
			});
			if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
				searchList.addSort("created_indexed_date", ORDER.desc);
			}
			searchSitePet2(siteRequest, populate, store, modify, uri, apiMethod, searchList);
			searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
				promise.complete(searchList);
			}).onFailure(ex -> {
				LOG.error(String.format("searchSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("searchSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void searchSitePet2(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify, String uri, String apiMethod, SearchList<SitePet> searchList) {
	}

	public Future<Void> defineSitePet(SitePet o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT * FROM SitePet WHERE pk=$1")
					.collecting(Collectors.toList())
					.execute(Tuple.of(pk)
					).onSuccess(result -> {
				try {
					for(Row definition : result.value()) {
						for(Integer i = 0; i < definition.size(); i++) {
							String columnName = definition.getColumnName(i);
							Object columnValue = definition.getValue(i);
							if(!"pk".equals(columnName)) {
								try {
									o.defineForClass(columnName, columnValue);
								} catch(Exception e) {
									LOG.error(String.format("defineSitePet failed. "), e);
								}
							}
						}
					}
					promise.complete();
				} catch(Exception ex) {
					LOG.error(String.format("defineSitePet failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("defineSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("defineSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> attributeSitePet(SitePet o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT pk2, 'enrollmentKeys' from SitePetenrollmentKeys_SiteEnrollmentpetKeys where pk1=$1")
					.collecting(Collectors.toList())
					.execute(Tuple.of(pk)
					).onSuccess(result -> {
				try {
					if(result != null) {
						for(Row definition : result.value()) {
							o.attributeForClass(definition.getString(1), definition.getLong(0));
						}
					}
					promise.complete();
				} catch(Exception ex) {
					LOG.error(String.format("attributeSitePet failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("attributeSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("attributeSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> indexSitePet(SitePet o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			o.promiseDeepForClass(siteRequest).onSuccess(a -> {
				SolrInputDocument document = new SolrInputDocument();
				o.indexSitePet(document);
				String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest.getConfig().getInteger(ConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
				String solrRequestUri = String.format("/solr/%s/update%s", solrCollection, "?softCommit=true&overwrite=true&wt=json");
				JsonArray json = new JsonArray().add(new JsonObject(document.toMap(new HashMap<String, Object>())));
				webClient.post(solrPort, solrHostName, solrRequestUri).putHeader("Content-Type", "application/json").expect(ResponsePredicate.SC_OK).sendBuffer(json.toBuffer()).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("indexSitePet failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("indexSitePet failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("indexSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> refreshSitePet(SitePet o) {
		Promise<Void> promise = Promise.promise();
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < pks.size(); i++) {
					Long pk2 = pks.get(i);
					String classSimpleName2 = classes.get(i);

					if("SiteEnrollment".equals(classSimpleName2) && pk2 != null) {
						SearchList<SiteEnrollment> searchList2 = new SearchList<SiteEnrollment>();
						searchList2.setStore(true);
						searchList2.setQuery("*:*");
						searchList2.setC(SiteEnrollment.class);
						searchList2.addFilterQuery("pk_indexed_long:" + pk2);
						searchList2.setRows(1);
						futures.add(Future.future(promise2 -> {
							searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
								SiteEnrollment o2 = searchList2.getList().stream().findFirst().orElse(null);
								if(o2 != null) {
									JsonObject params = new JsonObject();
									params.put("body", new JsonObject());
									params.put("cookie", new JsonObject());
									params.put("path", new JsonObject());
									params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + pk2)));
									JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.principal()).orElse(null));
									JsonObject json = new JsonObject().put("context", context);
									eventBus.request("nico-site-enUS-SiteEnrollment", json, new DeliveryOptions().addHeader("action", "patchSiteEnrollmentFuture")).onSuccess(c -> {
						JsonObject responseMessage = (JsonObject)c.body();
										Integer statusCode = responseMessage.getInteger("statusCode");
										if(statusCode.equals(200))
											promise2.complete();
										else
											promise2.fail(new RuntimeException(responseMessage.getString("statusMessage")));
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}
							}).onFailure(ex -> {
								promise2.fail(ex);
							});
						}));
					}
				}

				CompositeFuture.all(futures).onSuccess(b -> {
					JsonObject params = new JsonObject();
					params.put("body", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					params.put("path", new JsonObject());
					params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + o.getPk())));
					JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.principal()).orElse(null));
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("nico-site-enUS-SitePet", json, new DeliveryOptions().addHeader("action", "patchSitePetFuture")).onSuccess(c -> {
						JsonObject responseMessage = (JsonObject)c.body();
						Integer statusCode = responseMessage.getInteger("statusCode");
						if(statusCode.equals(200))
							promise.complete();
						else
							promise.fail(new RuntimeException(responseMessage.getString("statusMessage")));
					}).onFailure(ex -> {
						LOG.error("Refresh relations failed. ", ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error("Refresh relations failed. ", ex);
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(String.format("refreshSitePet failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
