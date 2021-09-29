package org.computate.nico.enus.page;

import org.computate.nico.enus.java.ZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import org.computate.nico.enus.writer.AllWriter;
import org.computate.nico.enus.java.ZonedDateTimeDeserializer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import org.computate.nico.enus.base.BaseModel;
import org.computate.nico.enus.wrap.Wrap;
import java.math.RoundingMode;
import org.computate.nico.enus.java.LocalDateSerializer;
import java.lang.Void;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.request.api.ApiRequest;
import io.vertx.core.Future;
import io.vertx.ext.web.api.service.ServiceRequest;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class PageLayoutGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(PageLayout.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SiteRequestEnUS siteRequest_;

	/**	<br/> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<SiteRequestEnUS> w);

	public SiteRequestEnUS getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(SiteRequestEnUS siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static SiteRequestEnUS staticSetSiteRequest_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected PageLayout siteRequest_Init() {
		Wrap<SiteRequestEnUS> siteRequest_Wrap = new Wrap<SiteRequestEnUS>().var("siteRequest_").o(siteRequest_);
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		siteRequest_Wrap.o(null);
		return (PageLayout)this;
	}

	////////////////////
	// serviceRequest //
	////////////////////

	/**	 The entity serviceRequest
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ServiceRequest serviceRequest;

	/**	<br/> The entity serviceRequest
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:serviceRequest">Find the entity serviceRequest in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _serviceRequest(Wrap<ServiceRequest> w);

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	public static ServiceRequest staticSetServiceRequest(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected PageLayout serviceRequestInit() {
		Wrap<ServiceRequest> serviceRequestWrap = new Wrap<ServiceRequest>().var("serviceRequest").o(serviceRequest);
		if(serviceRequest == null) {
			_serviceRequest(serviceRequestWrap);
			setServiceRequest(serviceRequestWrap.o);
		}
		serviceRequestWrap.o(null);
		return (PageLayout)this;
	}

	///////////////////
	// staticBaseUrl //
	///////////////////

	/**	 The entity staticBaseUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String staticBaseUrl;

	/**	<br/> The entity staticBaseUrl
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:staticBaseUrl">Find the entity staticBaseUrl in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _staticBaseUrl(Wrap<String> w);

	public String getStaticBaseUrl() {
		return staticBaseUrl;
	}
	public void setStaticBaseUrl(String o) {
		this.staticBaseUrl = PageLayout.staticSetStaticBaseUrl(siteRequest_, o);
	}
	public static String staticSetStaticBaseUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout staticBaseUrlInit() {
		Wrap<String> staticBaseUrlWrap = new Wrap<String>().var("staticBaseUrl").o(staticBaseUrl);
		if(staticBaseUrl == null) {
			_staticBaseUrl(staticBaseUrlWrap);
			setStaticBaseUrl(staticBaseUrlWrap.o);
		}
		staticBaseUrlWrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrStaticBaseUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrStaticBaseUrl(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStaticBaseUrl(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrStaticBaseUrl(siteRequest_, PageLayout.staticSolrStaticBaseUrl(siteRequest_, PageLayout.staticSetStaticBaseUrl(siteRequest_, o)));
	}

	public String solrStaticBaseUrl() {
		return PageLayout.staticSolrStaticBaseUrl(siteRequest_, staticBaseUrl);
	}

	public String strStaticBaseUrl() {
		return staticBaseUrl == null ? "" : staticBaseUrl;
	}

	public String sqlStaticBaseUrl() {
		return staticBaseUrl;
	}

	public String jsonStaticBaseUrl() {
		return staticBaseUrl == null ? "" : staticBaseUrl;
	}

	/////////////
	// pageUri //
	/////////////

	/**	 The entity pageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUri;

	/**	<br/> The entity pageUri
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> w);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = PageLayout.staticSetPageUri(siteRequest_, o);
	}
	public static String staticSetPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout pageUriInit() {
		Wrap<String> pageUriWrap = new Wrap<String>().var("pageUri").o(pageUri);
		if(pageUri == null) {
			_pageUri(pageUriWrap);
			setPageUri(pageUriWrap.o);
		}
		pageUriWrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUri(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrPageUri(siteRequest_, PageLayout.staticSolrPageUri(siteRequest_, PageLayout.staticSetPageUri(siteRequest_, o)));
	}

	public String solrPageUri() {
		return PageLayout.staticSolrPageUri(siteRequest_, pageUri);
	}

	public String strPageUri() {
		return pageUri == null ? "" : pageUri;
	}

	public String sqlPageUri() {
		return pageUri;
	}

	public String jsonPageUri() {
		return pageUri == null ? "" : pageUri;
	}

	////////////////
	// pageMethod //
	////////////////

	/**	 The entity pageMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageMethod;

	/**	<br/> The entity pageMethod
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageMethod">Find the entity pageMethod in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageMethod(Wrap<String> w);

	public String getPageMethod() {
		return pageMethod;
	}
	public void setPageMethod(String o) {
		this.pageMethod = PageLayout.staticSetPageMethod(siteRequest_, o);
	}
	public static String staticSetPageMethod(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout pageMethodInit() {
		Wrap<String> pageMethodWrap = new Wrap<String>().var("pageMethod").o(pageMethod);
		if(pageMethod == null) {
			_pageMethod(pageMethodWrap);
			setPageMethod(pageMethodWrap.o);
		}
		pageMethodWrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrPageMethod(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageMethod(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageMethod(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrPageMethod(siteRequest_, PageLayout.staticSolrPageMethod(siteRequest_, PageLayout.staticSetPageMethod(siteRequest_, o)));
	}

	public String solrPageMethod() {
		return PageLayout.staticSolrPageMethod(siteRequest_, pageMethod);
	}

	public String strPageMethod() {
		return pageMethod == null ? "" : pageMethod;
	}

	public String sqlPageMethod() {
		return pageMethod;
	}

	public String jsonPageMethod() {
		return pageMethod == null ? "" : pageMethod;
	}

	///////////
	// long0 //
	///////////

	/**	 The entity long0
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long long0;

	/**	<br/> The entity long0
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:long0">Find the entity long0 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _long0(Wrap<Long> w);

	public Long getLong0() {
		return long0;
	}

	public void setLong0(Long long0) {
		this.long0 = long0;
	}
	@JsonIgnore
	public void setLong0(String o) {
		this.long0 = PageLayout.staticSetLong0(siteRequest_, o);
	}
	public static Long staticSetLong0(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected PageLayout long0Init() {
		Wrap<Long> long0Wrap = new Wrap<Long>().var("long0").o(long0);
		if(long0 == null) {
			_long0(long0Wrap);
			setLong0(long0Wrap.o);
		}
		long0Wrap.o(null);
		return (PageLayout)this;
	}

	public static Long staticSolrLong0(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrLong0(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLong0(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrLong0(siteRequest_, PageLayout.staticSolrLong0(siteRequest_, PageLayout.staticSetLong0(siteRequest_, o)));
	}

	public Long solrLong0() {
		return PageLayout.staticSolrLong0(siteRequest_, long0);
	}

	public String strLong0() {
		return long0 == null ? "" : long0.toString();
	}

	public Long sqlLong0() {
		return long0;
	}

	public String jsonLong0() {
		return long0 == null ? "" : long0.toString();
	}

	///////////
	// long1 //
	///////////

	/**	 The entity long1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long long1;

	/**	<br/> The entity long1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:long1">Find the entity long1 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _long1(Wrap<Long> w);

	public Long getLong1() {
		return long1;
	}

	public void setLong1(Long long1) {
		this.long1 = long1;
	}
	@JsonIgnore
	public void setLong1(String o) {
		this.long1 = PageLayout.staticSetLong1(siteRequest_, o);
	}
	public static Long staticSetLong1(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected PageLayout long1Init() {
		Wrap<Long> long1Wrap = new Wrap<Long>().var("long1").o(long1);
		if(long1 == null) {
			_long1(long1Wrap);
			setLong1(long1Wrap.o);
		}
		long1Wrap.o(null);
		return (PageLayout)this;
	}

	public static Long staticSolrLong1(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrLong1(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLong1(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrLong1(siteRequest_, PageLayout.staticSolrLong1(siteRequest_, PageLayout.staticSetLong1(siteRequest_, o)));
	}

	public Long solrLong1() {
		return PageLayout.staticSolrLong1(siteRequest_, long1);
	}

	public String strLong1() {
		return long1 == null ? "" : long1.toString();
	}

	public Long sqlLong1() {
		return long1;
	}

	public String jsonLong1() {
		return long1 == null ? "" : long1.toString();
	}

	//////////
	// int0 //
	//////////

	/**	 The entity int0
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer int0;

	/**	<br/> The entity int0
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:int0">Find the entity int0 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _int0(Wrap<Integer> w);

	public Integer getInt0() {
		return int0;
	}

	public void setInt0(Integer int0) {
		this.int0 = int0;
	}
	@JsonIgnore
	public void setInt0(String o) {
		this.int0 = PageLayout.staticSetInt0(siteRequest_, o);
	}
	public static Integer staticSetInt0(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected PageLayout int0Init() {
		Wrap<Integer> int0Wrap = new Wrap<Integer>().var("int0").o(int0);
		if(int0 == null) {
			_int0(int0Wrap);
			setInt0(int0Wrap.o);
		}
		int0Wrap.o(null);
		return (PageLayout)this;
	}

	public static Integer staticSolrInt0(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrInt0(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInt0(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrInt0(siteRequest_, PageLayout.staticSolrInt0(siteRequest_, PageLayout.staticSetInt0(siteRequest_, o)));
	}

	public Integer solrInt0() {
		return PageLayout.staticSolrInt0(siteRequest_, int0);
	}

	public String strInt0() {
		return int0 == null ? "" : int0.toString();
	}

	public Integer sqlInt0() {
		return int0;
	}

	public String jsonInt0() {
		return int0 == null ? "" : int0.toString();
	}

	//////////
	// int1 //
	//////////

	/**	 The entity int1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer int1;

	/**	<br/> The entity int1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:int1">Find the entity int1 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _int1(Wrap<Integer> w);

	public Integer getInt1() {
		return int1;
	}

	public void setInt1(Integer int1) {
		this.int1 = int1;
	}
	@JsonIgnore
	public void setInt1(String o) {
		this.int1 = PageLayout.staticSetInt1(siteRequest_, o);
	}
	public static Integer staticSetInt1(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected PageLayout int1Init() {
		Wrap<Integer> int1Wrap = new Wrap<Integer>().var("int1").o(int1);
		if(int1 == null) {
			_int1(int1Wrap);
			setInt1(int1Wrap.o);
		}
		int1Wrap.o(null);
		return (PageLayout)this;
	}

	public static Integer staticSolrInt1(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrInt1(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInt1(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrInt1(siteRequest_, PageLayout.staticSolrInt1(siteRequest_, PageLayout.staticSetInt1(siteRequest_, o)));
	}

	public Integer solrInt1() {
		return PageLayout.staticSolrInt1(siteRequest_, int1);
	}

	public String strInt1() {
		return int1 == null ? "" : int1.toString();
	}

	public Integer sqlInt1() {
		return int1;
	}

	public String jsonInt1() {
		return int1 == null ? "" : int1.toString();
	}

	///////////////////
	// promiseBefore //
	///////////////////

	/**	 The entity promiseBefore
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseBefore;

	/**	<br/> The entity promiseBefore
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseBefore(Promise<Void> promise);

	public Void getPromiseBefore() {
		return promiseBefore;
	}

	public void setPromiseBefore(Void promiseBefore) {
		this.promiseBefore = promiseBefore;
	}
	public static Void staticSetPromiseBefore(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseBeforePromise() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		_promiseBefore(promise2);
		promise2.future().onSuccess(o -> {
			setPromiseBefore(o);
			promise.complete(o);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	////////////
	// pageH1 //
	////////////

	/**	 The entity pageH1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH1;

	/**	<br/> The entity pageH1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Find the entity pageH1 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}
	public void setPageH1(String o) {
		this.pageH1 = PageLayout.staticSetPageH1(siteRequest_, o);
	}
	public static String staticSetPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout pageH1Init() {
		Wrap<String> pageH1Wrap = new Wrap<String>().var("pageH1").o(pageH1);
		if(pageH1 == null) {
			_pageH1(pageH1Wrap);
			setPageH1(pageH1Wrap.o);
		}
		pageH1Wrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH1(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrPageH1(siteRequest_, PageLayout.staticSolrPageH1(siteRequest_, PageLayout.staticSetPageH1(siteRequest_, o)));
	}

	public String solrPageH1() {
		return PageLayout.staticSolrPageH1(siteRequest_, pageH1);
	}

	public String strPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	public String sqlPageH1() {
		return pageH1;
	}

	public String jsonPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	////////////
	// pageH2 //
	////////////

	/**	 The entity pageH2
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH2;

	/**	<br/> The entity pageH2
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH2">Find the entity pageH2 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH2(Wrap<String> c);

	public String getPageH2() {
		return pageH2;
	}
	public void setPageH2(String o) {
		this.pageH2 = PageLayout.staticSetPageH2(siteRequest_, o);
	}
	public static String staticSetPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout pageH2Init() {
		Wrap<String> pageH2Wrap = new Wrap<String>().var("pageH2").o(pageH2);
		if(pageH2 == null) {
			_pageH2(pageH2Wrap);
			setPageH2(pageH2Wrap.o);
		}
		pageH2Wrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH2(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrPageH2(siteRequest_, PageLayout.staticSolrPageH2(siteRequest_, PageLayout.staticSetPageH2(siteRequest_, o)));
	}

	public String solrPageH2() {
		return PageLayout.staticSolrPageH2(siteRequest_, pageH2);
	}

	public String strPageH2() {
		return pageH2 == null ? "" : pageH2;
	}

	public String sqlPageH2() {
		return pageH2;
	}

	public String jsonPageH2() {
		return pageH2 == null ? "" : pageH2;
	}

	////////////
	// pageH3 //
	////////////

	/**	 The entity pageH3
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH3;

	/**	<br/> The entity pageH3
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH3">Find the entity pageH3 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH3(Wrap<String> c);

	public String getPageH3() {
		return pageH3;
	}
	public void setPageH3(String o) {
		this.pageH3 = PageLayout.staticSetPageH3(siteRequest_, o);
	}
	public static String staticSetPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout pageH3Init() {
		Wrap<String> pageH3Wrap = new Wrap<String>().var("pageH3").o(pageH3);
		if(pageH3 == null) {
			_pageH3(pageH3Wrap);
			setPageH3(pageH3Wrap.o);
		}
		pageH3Wrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH3(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrPageH3(siteRequest_, PageLayout.staticSolrPageH3(siteRequest_, PageLayout.staticSetPageH3(siteRequest_, o)));
	}

	public String solrPageH3() {
		return PageLayout.staticSolrPageH3(siteRequest_, pageH3);
	}

	public String strPageH3() {
		return pageH3 == null ? "" : pageH3;
	}

	public String sqlPageH3() {
		return pageH3;
	}

	public String jsonPageH3() {
		return pageH3 == null ? "" : pageH3;
	}

	///////////////
	// pageTitle //
	///////////////

	/**	 The entity pageTitle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageTitle;

	/**	<br/> The entity pageTitle
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> c);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = PageLayout.staticSetPageTitle(siteRequest_, o);
	}
	public static String staticSetPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout pageTitleInit() {
		Wrap<String> pageTitleWrap = new Wrap<String>().var("pageTitle").o(pageTitle);
		if(pageTitle == null) {
			_pageTitle(pageTitleWrap);
			setPageTitle(pageTitleWrap.o);
		}
		pageTitleWrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrPageTitle(siteRequest_, PageLayout.staticSolrPageTitle(siteRequest_, PageLayout.staticSetPageTitle(siteRequest_, o)));
	}

	public String solrPageTitle() {
		return PageLayout.staticSolrPageTitle(siteRequest_, pageTitle);
	}

	public String strPageTitle() {
		return pageTitle == null ? "" : pageTitle;
	}

	public String sqlPageTitle() {
		return pageTitle;
	}

	public String jsonPageTitle() {
		return pageTitle == null ? "" : pageTitle;
	}

	///////////
	// roles //
	///////////

	/**	 The entity roles
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> roles = new ArrayList<String>();

	/**	<br/> The entity roles
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:roles">Find the entity roles in Solr</a>
	 * <br/>
	 * @param roles is the entity already constructed. 
	 **/
	protected abstract void _roles(List<String> l);

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public static String staticSetRoles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public PageLayout addRoles(String...objets) {
		for(String o : objets) {
			addRoles(o);
		}
		return (PageLayout)this;
	}
	public PageLayout addRoles(String o) {
		if(o != null && !roles.contains(o))
			this.roles.add(o);
		return (PageLayout)this;
	}
	@JsonIgnore
	public void setRoles(JsonArray objets) {
		roles.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addRoles(o);
		}
	}
	protected PageLayout rolesInit() {
		_roles(roles);
		return (PageLayout)this;
	}

	public static String staticSolrRoles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRoles(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRoles(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrRoles(siteRequest_, PageLayout.staticSolrRoles(siteRequest_, PageLayout.staticSetRoles(siteRequest_, o)));
	}

	public List<String> solrRoles() {
		List<String> l = new ArrayList<String>();
		for(String o : roles) {
			l.add(PageLayout.staticSolrRoles(siteRequest_, o));
		}
		return l;
	}

	public String strRoles() {
		return roles == null ? "" : roles.toString();
	}

	public List<String> sqlRoles() {
		return roles;
	}

	public String jsonRoles() {
		return roles == null ? "" : roles.toString();
	}

	///////////////////
	// rolesRequired //
	///////////////////

	/**	 The entity rolesRequired
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> rolesRequired = new ArrayList<String>();

	/**	<br/> The entity rolesRequired
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:rolesRequired">Find the entity rolesRequired in Solr</a>
	 * <br/>
	 * @param rolesRequired is the entity already constructed. 
	 **/
	protected abstract void _rolesRequired(List<String> l);

	public List<String> getRolesRequired() {
		return rolesRequired;
	}

	public void setRolesRequired(List<String> rolesRequired) {
		this.rolesRequired = rolesRequired;
	}
	public static String staticSetRolesRequired(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public PageLayout addRolesRequired(String...objets) {
		for(String o : objets) {
			addRolesRequired(o);
		}
		return (PageLayout)this;
	}
	public PageLayout addRolesRequired(String o) {
		if(o != null && !rolesRequired.contains(o))
			this.rolesRequired.add(o);
		return (PageLayout)this;
	}
	@JsonIgnore
	public void setRolesRequired(JsonArray objets) {
		rolesRequired.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addRolesRequired(o);
		}
	}
	protected PageLayout rolesRequiredInit() {
		_rolesRequired(rolesRequired);
		return (PageLayout)this;
	}

	public static String staticSolrRolesRequired(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRolesRequired(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRolesRequired(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrRolesRequired(siteRequest_, PageLayout.staticSolrRolesRequired(siteRequest_, PageLayout.staticSetRolesRequired(siteRequest_, o)));
	}

	public List<String> solrRolesRequired() {
		List<String> l = new ArrayList<String>();
		for(String o : rolesRequired) {
			l.add(PageLayout.staticSolrRolesRequired(siteRequest_, o));
		}
		return l;
	}

	public String strRolesRequired() {
		return rolesRequired == null ? "" : rolesRequired.toString();
	}

	public List<String> sqlRolesRequired() {
		return rolesRequired;
	}

	public String jsonRolesRequired() {
		return rolesRequired == null ? "" : rolesRequired.toString();
	}

	////////////////////
	// authRolesAdmin //
	////////////////////

	/**	 The entity authRolesAdmin
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> authRolesAdmin = new ArrayList<String>();

	/**	<br/> The entity authRolesAdmin
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:authRolesAdmin">Find the entity authRolesAdmin in Solr</a>
	 * <br/>
	 * @param authRolesAdmin is the entity already constructed. 
	 **/
	protected abstract void _authRolesAdmin(List<String> l);

	public List<String> getAuthRolesAdmin() {
		return authRolesAdmin;
	}

	public void setAuthRolesAdmin(List<String> authRolesAdmin) {
		this.authRolesAdmin = authRolesAdmin;
	}
	public static String staticSetAuthRolesAdmin(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public PageLayout addAuthRolesAdmin(String...objets) {
		for(String o : objets) {
			addAuthRolesAdmin(o);
		}
		return (PageLayout)this;
	}
	public PageLayout addAuthRolesAdmin(String o) {
		if(o != null && !authRolesAdmin.contains(o))
			this.authRolesAdmin.add(o);
		return (PageLayout)this;
	}
	@JsonIgnore
	public void setAuthRolesAdmin(JsonArray objets) {
		authRolesAdmin.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addAuthRolesAdmin(o);
		}
	}
	protected PageLayout authRolesAdminInit() {
		_authRolesAdmin(authRolesAdmin);
		return (PageLayout)this;
	}

	public static String staticSolrAuthRolesAdmin(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrAuthRolesAdmin(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAuthRolesAdmin(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrAuthRolesAdmin(siteRequest_, PageLayout.staticSolrAuthRolesAdmin(siteRequest_, PageLayout.staticSetAuthRolesAdmin(siteRequest_, o)));
	}

	public List<String> solrAuthRolesAdmin() {
		List<String> l = new ArrayList<String>();
		for(String o : authRolesAdmin) {
			l.add(PageLayout.staticSolrAuthRolesAdmin(siteRequest_, o));
		}
		return l;
	}

	public String strAuthRolesAdmin() {
		return authRolesAdmin == null ? "" : authRolesAdmin.toString();
	}

	public List<String> sqlAuthRolesAdmin() {
		return authRolesAdmin;
	}

	public String jsonAuthRolesAdmin() {
		return authRolesAdmin == null ? "" : authRolesAdmin.toString();
	}

	////////////////
	// pagination //
	////////////////

	/**	 The entity pagination
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject pagination = new JsonObject();

	/**	<br/> The entity pagination
	 *  It is constructed before being initialized with the constructor by default JsonObject(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pagination">Find the entity pagination in Solr</a>
	 * <br/>
	 * @param pagination is the entity already constructed. 
	 **/
	protected abstract void _pagination(JsonObject pagination);

	public JsonObject getPagination() {
		return pagination;
	}

	public void setPagination(JsonObject pagination) {
		this.pagination = pagination;
	}
	public static JsonObject staticSetPagination(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected PageLayout paginationInit() {
		_pagination(pagination);
		return (PageLayout)this;
	}

	///////////
	// query //
	///////////

	/**	 The entity query
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject query = new JsonObject();

	/**	<br/> The entity query
	 *  It is constructed before being initialized with the constructor by default JsonObject(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:query">Find the entity query in Solr</a>
	 * <br/>
	 * @param query is the entity already constructed. 
	 **/
	protected abstract void _query(JsonObject query);

	public JsonObject getQuery() {
		return query;
	}

	public void setQuery(JsonObject query) {
		this.query = query;
	}
	public static JsonObject staticSetQuery(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected PageLayout queryInit() {
		_query(query);
		return (PageLayout)this;
	}

	//////////////////
	// promiseAfter //
	//////////////////

	/**	 The entity promiseAfter
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseAfter;

	/**	<br/> The entity promiseAfter
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseAfter(Promise<Void> promise);

	public Void getPromiseAfter() {
		return promiseAfter;
	}

	public void setPromiseAfter(Void promiseAfter) {
		this.promiseAfter = promiseAfter;
	}
	public static Void staticSetPromiseAfter(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseAfterPromise() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		_promiseAfter(promise2);
		promise2.future().onSuccess(o -> {
			setPromiseAfter(o);
			promise.complete(o);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	//////////////////
	// pageImageUri //
	//////////////////

	/**	 The entity pageImageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageImageUri;

	/**	<br/> The entity pageImageUri
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> c);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = PageLayout.staticSetPageImageUri(siteRequest_, o);
	}
	public static String staticSetPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout pageImageUriInit() {
		Wrap<String> pageImageUriWrap = new Wrap<String>().var("pageImageUri").o(pageImageUri);
		if(pageImageUri == null) {
			_pageImageUri(pageImageUriWrap);
			setPageImageUri(pageImageUriWrap.o);
		}
		pageImageUriWrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrPageImageUri(siteRequest_, PageLayout.staticSolrPageImageUri(siteRequest_, PageLayout.staticSetPageImageUri(siteRequest_, o)));
	}

	public String solrPageImageUri() {
		return PageLayout.staticSolrPageImageUri(siteRequest_, pageImageUri);
	}

	public String strPageImageUri() {
		return pageImageUri == null ? "" : pageImageUri;
	}

	public String sqlPageImageUri() {
		return pageImageUri;
	}

	public String jsonPageImageUri() {
		return pageImageUri == null ? "" : pageImageUri;
	}

	//////////////////////
	// contextIconGroup //
	//////////////////////

	/**	 The entity contextIconGroup
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String contextIconGroup;

	/**	<br/> The entity contextIconGroup
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconGroup">Find the entity contextIconGroup in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconGroup(Wrap<String> c);

	public String getContextIconGroup() {
		return contextIconGroup;
	}
	public void setContextIconGroup(String o) {
		this.contextIconGroup = PageLayout.staticSetContextIconGroup(siteRequest_, o);
	}
	public static String staticSetContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout contextIconGroupInit() {
		Wrap<String> contextIconGroupWrap = new Wrap<String>().var("contextIconGroup").o(contextIconGroup);
		if(contextIconGroup == null) {
			_contextIconGroup(contextIconGroupWrap);
			setContextIconGroup(contextIconGroupWrap.o);
		}
		contextIconGroupWrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrContextIconGroup(siteRequest_, PageLayout.staticSolrContextIconGroup(siteRequest_, PageLayout.staticSetContextIconGroup(siteRequest_, o)));
	}

	public String solrContextIconGroup() {
		return PageLayout.staticSolrContextIconGroup(siteRequest_, contextIconGroup);
	}

	public String strContextIconGroup() {
		return contextIconGroup == null ? "" : contextIconGroup;
	}

	public String sqlContextIconGroup() {
		return contextIconGroup;
	}

	public String jsonContextIconGroup() {
		return contextIconGroup == null ? "" : contextIconGroup;
	}

	/////////////////////
	// contextIconName //
	/////////////////////

	/**	 The entity contextIconName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String contextIconName;

	/**	<br/> The entity contextIconName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.page.PageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconName">Find the entity contextIconName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconName(Wrap<String> c);

	public String getContextIconName() {
		return contextIconName;
	}
	public void setContextIconName(String o) {
		this.contextIconName = PageLayout.staticSetContextIconName(siteRequest_, o);
	}
	public static String staticSetContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PageLayout contextIconNameInit() {
		Wrap<String> contextIconNameWrap = new Wrap<String>().var("contextIconName").o(contextIconName);
		if(contextIconName == null) {
			_contextIconName(contextIconNameWrap);
			setContextIconName(contextIconNameWrap.o);
		}
		contextIconNameWrap.o(null);
		return (PageLayout)this;
	}

	public static String staticSolrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return PageLayout.staticSolrStrContextIconName(siteRequest_, PageLayout.staticSolrContextIconName(siteRequest_, PageLayout.staticSetContextIconName(siteRequest_, o)));
	}

	public String solrContextIconName() {
		return PageLayout.staticSolrContextIconName(siteRequest_, contextIconName);
	}

	public String strContextIconName() {
		return contextIconName == null ? "" : contextIconName;
	}

	public String sqlContextIconName() {
		return contextIconName;
	}

	public String jsonContextIconName() {
		return contextIconName == null ? "" : contextIconName;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepPageLayout(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepPageLayout();
	}

	public Future<Void> promiseDeepPageLayout() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promisePageLayout(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promisePageLayout(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				serviceRequestInit();
				staticBaseUrlInit();
				pageUriInit();
				pageMethodInit();
				long0Init();
				long1Init();
				int0Init();
				int1Init();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			promiseBeforePromise().onSuccess(promiseBefore -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				pageH1Init();
				pageH2Init();
				pageH3Init();
				pageTitleInit();
				rolesInit();
				rolesRequiredInit();
				authRolesAdminInit();
				paginationInit();
				queryInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			promiseAfterPromise().onSuccess(promiseAfter -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				pageImageUriInit();
				contextIconGroupInit();
				contextIconNameInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepPageLayout(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestPageLayout(SiteRequestEnUS siteRequest_) {
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestPageLayout(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainPageLayout(v);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.obtainForClass(v);
			}
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainPageLayout(String var) {
		PageLayout oPageLayout = (PageLayout)this;
		switch(var) {
			case "siteRequest_":
				return oPageLayout.siteRequest_;
			case "serviceRequest":
				return oPageLayout.serviceRequest;
			case "staticBaseUrl":
				return oPageLayout.staticBaseUrl;
			case "pageUri":
				return oPageLayout.pageUri;
			case "pageMethod":
				return oPageLayout.pageMethod;
			case "long0":
				return oPageLayout.long0;
			case "long1":
				return oPageLayout.long1;
			case "int0":
				return oPageLayout.int0;
			case "int1":
				return oPageLayout.int1;
			case "promiseBefore":
				return oPageLayout.promiseBefore;
			case "pageH1":
				return oPageLayout.pageH1;
			case "pageH2":
				return oPageLayout.pageH2;
			case "pageH3":
				return oPageLayout.pageH3;
			case "pageTitle":
				return oPageLayout.pageTitle;
			case "roles":
				return oPageLayout.roles;
			case "rolesRequired":
				return oPageLayout.rolesRequired;
			case "authRolesAdmin":
				return oPageLayout.authRolesAdmin;
			case "pagination":
				return oPageLayout.pagination;
			case "query":
				return oPageLayout.query;
			case "promiseAfter":
				return oPageLayout.promiseAfter;
			case "pageImageUri":
				return oPageLayout.pageImageUri;
			case "contextIconGroup":
				return oPageLayout.contextIconGroup;
			case "contextIconName":
				return oPageLayout.contextIconName;
			default:
				return null;
		}
	}

	///////////////
	// attribute //
	///////////////

	public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributePageLayout(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributePageLayout(String var, Object val) {
		PageLayout oPageLayout = (PageLayout)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetPageLayout(entityVar,  siteRequest_, o);
	}
	public static Object staticSetPageLayout(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "staticBaseUrl":
			return PageLayout.staticSetStaticBaseUrl(siteRequest_, o);
		case "pageUri":
			return PageLayout.staticSetPageUri(siteRequest_, o);
		case "pageMethod":
			return PageLayout.staticSetPageMethod(siteRequest_, o);
		case "long0":
			return PageLayout.staticSetLong0(siteRequest_, o);
		case "long1":
			return PageLayout.staticSetLong1(siteRequest_, o);
		case "int0":
			return PageLayout.staticSetInt0(siteRequest_, o);
		case "int1":
			return PageLayout.staticSetInt1(siteRequest_, o);
		case "pageH1":
			return PageLayout.staticSetPageH1(siteRequest_, o);
		case "pageH2":
			return PageLayout.staticSetPageH2(siteRequest_, o);
		case "pageH3":
			return PageLayout.staticSetPageH3(siteRequest_, o);
		case "pageTitle":
			return PageLayout.staticSetPageTitle(siteRequest_, o);
		case "roles":
			return PageLayout.staticSetRoles(siteRequest_, o);
		case "rolesRequired":
			return PageLayout.staticSetRolesRequired(siteRequest_, o);
		case "authRolesAdmin":
			return PageLayout.staticSetAuthRolesAdmin(siteRequest_, o);
		case "pageImageUri":
			return PageLayout.staticSetPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return PageLayout.staticSetContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return PageLayout.staticSetContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrPageLayout(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrPageLayout(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "staticBaseUrl":
			return PageLayout.staticSolrStaticBaseUrl(siteRequest_, (String)o);
		case "pageUri":
			return PageLayout.staticSolrPageUri(siteRequest_, (String)o);
		case "pageMethod":
			return PageLayout.staticSolrPageMethod(siteRequest_, (String)o);
		case "long0":
			return PageLayout.staticSolrLong0(siteRequest_, (Long)o);
		case "long1":
			return PageLayout.staticSolrLong1(siteRequest_, (Long)o);
		case "int0":
			return PageLayout.staticSolrInt0(siteRequest_, (Integer)o);
		case "int1":
			return PageLayout.staticSolrInt1(siteRequest_, (Integer)o);
		case "pageH1":
			return PageLayout.staticSolrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return PageLayout.staticSolrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return PageLayout.staticSolrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return PageLayout.staticSolrPageTitle(siteRequest_, (String)o);
		case "roles":
			return PageLayout.staticSolrRoles(siteRequest_, (String)o);
		case "rolesRequired":
			return PageLayout.staticSolrRolesRequired(siteRequest_, (String)o);
		case "authRolesAdmin":
			return PageLayout.staticSolrAuthRolesAdmin(siteRequest_, (String)o);
		case "pageImageUri":
			return PageLayout.staticSolrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return PageLayout.staticSolrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return PageLayout.staticSolrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrPageLayout(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrPageLayout(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "staticBaseUrl":
			return PageLayout.staticSolrStrStaticBaseUrl(siteRequest_, (String)o);
		case "pageUri":
			return PageLayout.staticSolrStrPageUri(siteRequest_, (String)o);
		case "pageMethod":
			return PageLayout.staticSolrStrPageMethod(siteRequest_, (String)o);
		case "long0":
			return PageLayout.staticSolrStrLong0(siteRequest_, (Long)o);
		case "long1":
			return PageLayout.staticSolrStrLong1(siteRequest_, (Long)o);
		case "int0":
			return PageLayout.staticSolrStrInt0(siteRequest_, (Integer)o);
		case "int1":
			return PageLayout.staticSolrStrInt1(siteRequest_, (Integer)o);
		case "pageH1":
			return PageLayout.staticSolrStrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return PageLayout.staticSolrStrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return PageLayout.staticSolrStrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return PageLayout.staticSolrStrPageTitle(siteRequest_, (String)o);
		case "roles":
			return PageLayout.staticSolrStrRoles(siteRequest_, (String)o);
		case "rolesRequired":
			return PageLayout.staticSolrStrRolesRequired(siteRequest_, (String)o);
		case "authRolesAdmin":
			return PageLayout.staticSolrStrAuthRolesAdmin(siteRequest_, (String)o);
		case "pageImageUri":
			return PageLayout.staticSolrStrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return PageLayout.staticSolrStrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return PageLayout.staticSolrStrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqPageLayout(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqPageLayout(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "staticBaseUrl":
			return PageLayout.staticSolrFqStaticBaseUrl(siteRequest_, o);
		case "pageUri":
			return PageLayout.staticSolrFqPageUri(siteRequest_, o);
		case "pageMethod":
			return PageLayout.staticSolrFqPageMethod(siteRequest_, o);
		case "long0":
			return PageLayout.staticSolrFqLong0(siteRequest_, o);
		case "long1":
			return PageLayout.staticSolrFqLong1(siteRequest_, o);
		case "int0":
			return PageLayout.staticSolrFqInt0(siteRequest_, o);
		case "int1":
			return PageLayout.staticSolrFqInt1(siteRequest_, o);
		case "pageH1":
			return PageLayout.staticSolrFqPageH1(siteRequest_, o);
		case "pageH2":
			return PageLayout.staticSolrFqPageH2(siteRequest_, o);
		case "pageH3":
			return PageLayout.staticSolrFqPageH3(siteRequest_, o);
		case "pageTitle":
			return PageLayout.staticSolrFqPageTitle(siteRequest_, o);
		case "roles":
			return PageLayout.staticSolrFqRoles(siteRequest_, o);
		case "rolesRequired":
			return PageLayout.staticSolrFqRolesRequired(siteRequest_, o);
		case "authRolesAdmin":
			return PageLayout.staticSolrFqAuthRolesAdmin(siteRequest_, o);
		case "pageImageUri":
			return PageLayout.staticSolrFqPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return PageLayout.staticSolrFqContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return PageLayout.staticSolrFqContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definePageLayout(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definePageLayout(String var, String val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definePageLayout(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definePageLayout(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestPageLayout() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof PageLayout) {
			PageLayout original = (PageLayout)o;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash();
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof PageLayout))
			return false;
		PageLayout that = (PageLayout)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PageLayout { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_serviceRequest = "serviceRequest";
	public static final String VAR_staticBaseUrl = "staticBaseUrl";
	public static final String VAR_pageUri = "pageUri";
	public static final String VAR_pageMethod = "pageMethod";
	public static final String VAR_long0 = "long0";
	public static final String VAR_long1 = "long1";
	public static final String VAR_int0 = "int0";
	public static final String VAR_int1 = "int1";
	public static final String VAR_promiseBefore = "promiseBefore";
	public static final String VAR_pageH1 = "pageH1";
	public static final String VAR_pageH2 = "pageH2";
	public static final String VAR_pageH3 = "pageH3";
	public static final String VAR_pageTitle = "pageTitle";
	public static final String VAR_roles = "roles";
	public static final String VAR_rolesRequired = "rolesRequired";
	public static final String VAR_authRolesAdmin = "authRolesAdmin";
	public static final String VAR_pagination = "pagination";
	public static final String VAR_query = "query";
	public static final String VAR_promiseAfter = "promiseAfter";
	public static final String VAR_pageImageUri = "pageImageUri";
	public static final String VAR_contextIconGroup = "contextIconGroup";
	public static final String VAR_contextIconName = "contextIconName";
}
