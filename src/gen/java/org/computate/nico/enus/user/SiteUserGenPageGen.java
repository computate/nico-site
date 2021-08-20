package org.computate.nico.enus.user;

import org.computate.nico.enus.java.ZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import org.computate.nico.enus.java.ZonedDateTimeDeserializer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.computate.nico.enus.user.SiteUser;
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
import org.computate.nico.enus.search.SearchList;
import io.vertx.core.Future;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteUserGenPageGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteUserGenPage.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SiteRequestEnUS siteRequest_;
	@JsonIgnore
	public Wrap<SiteRequestEnUS> siteRequest_Wrap = new Wrap<SiteRequestEnUS>().var("siteRequest_").o(siteRequest_);

	/**	<br/> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<SiteRequestEnUS> c);

	public SiteRequestEnUS getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(SiteRequestEnUS siteRequest_) {
		this.siteRequest_ = siteRequest_;
		this.siteRequest_Wrap.alreadyInitialized = true;
	}
	public static SiteRequestEnUS staticSetSiteRequest_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteUserGenPage siteRequest_Init() {
		if(!siteRequest_Wrap.alreadyInitialized) {
			_siteRequest_(siteRequest_Wrap);
			if(siteRequest_ == null)
				setSiteRequest_(siteRequest_Wrap.o);
			siteRequest_Wrap.o(null);
		}
		siteRequest_Wrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	///////////////////
	// listSiteUser_ //
	///////////////////

	/**	 The entity listSiteUser_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteUser> listSiteUser_;
	@JsonIgnore
	public Wrap<SearchList<SiteUser>> listSiteUser_Wrap = new Wrap<SearchList<SiteUser>>().var("listSiteUser_").o(listSiteUser_);

	/**	<br/> The entity listSiteUser_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSiteUser_">Find the entity listSiteUser_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listSiteUser_(Wrap<SearchList<SiteUser>> c);

	public SearchList<SiteUser> getListSiteUser_() {
		return listSiteUser_;
	}

	public void setListSiteUser_(SearchList<SiteUser> listSiteUser_) {
		this.listSiteUser_ = listSiteUser_;
		this.listSiteUser_Wrap.alreadyInitialized = true;
	}
	public static SearchList<SiteUser> staticSetListSiteUser_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteUserGenPage listSiteUser_Init() {
		if(!listSiteUser_Wrap.alreadyInitialized) {
			_listSiteUser_(listSiteUser_Wrap);
			if(listSiteUser_ == null)
				setListSiteUser_(listSiteUser_Wrap.o);
			listSiteUser_Wrap.o(null);
		}
		listSiteUser_Wrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	///////////////
	// siteUser_ //
	///////////////

	/**	 The entity siteUser_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SiteUser siteUser_;
	@JsonIgnore
	public Wrap<SiteUser> siteUser_Wrap = new Wrap<SiteUser>().var("siteUser_").o(siteUser_);

	/**	<br/> The entity siteUser_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteUser_">Find the entity siteUser_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteUser_(Wrap<SiteUser> c);

	public SiteUser getSiteUser_() {
		return siteUser_;
	}

	public void setSiteUser_(SiteUser siteUser_) {
		this.siteUser_ = siteUser_;
		this.siteUser_Wrap.alreadyInitialized = true;
	}
	public static SiteUser staticSetSiteUser_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteUserGenPage siteUser_Init() {
		if(!siteUser_Wrap.alreadyInitialized) {
			_siteUser_(siteUser_Wrap);
			if(siteUser_ == null)
				setSiteUser_(siteUser_Wrap.o);
			siteUser_Wrap.o(null);
		}
		siteUser_Wrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
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
	@JsonIgnore
	public Wrap<Void> promiseBeforeWrap = new Wrap<Void>().var("promiseBefore").o(promiseBefore);

	/**	<br/> The entity promiseBefore
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseBefore(Promise<Void> promise);

	public Void getPromiseBefore() {
		return promiseBefore;
	}

	public void setPromiseBefore(Void promiseBefore) {
		this.promiseBefore = promiseBefore;
		this.promiseBeforeWrap.alreadyInitialized = true;
	}
	public static Void staticSetPromiseBefore(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseBeforePromise() {
		Promise<Void> promise = Promise.promise();
		if(!promiseBeforeWrap.alreadyInitialized) {
			Promise<Void> promise2 = Promise.promise();
			_promiseBefore(promise2);
			promise2.future().onSuccess(o -> {
				setPromiseBefore(o);
				promiseBeforeWrap.alreadyInitialized(true);
				promise.complete(o);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
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
	@JsonIgnore
	public Wrap<String> pageH1Wrap = new Wrap<String>().var("pageH1").o(pageH1);

	/**	<br/> The entity pageH1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Find the entity pageH1 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}
	public void setPageH1(String o) {
		this.pageH1 = SiteUserGenPage.staticSetPageH1(siteRequest_, o);
		this.pageH1Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage pageH1Init() {
		if(!pageH1Wrap.alreadyInitialized) {
			_pageH1(pageH1Wrap);
			if(pageH1 == null)
				setPageH1(pageH1Wrap.o);
			pageH1Wrap.o(null);
		}
		pageH1Wrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH1(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrPageH1(siteRequest_, SiteUserGenPage.staticSolrPageH1(siteRequest_, SiteUserGenPage.staticSetPageH1(siteRequest_, o)));
	}

	public String solrPageH1() {
		return SiteUserGenPage.staticSolrPageH1(siteRequest_, pageH1);
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
	@JsonIgnore
	public Wrap<String> pageH2Wrap = new Wrap<String>().var("pageH2").o(pageH2);

	/**	<br/> The entity pageH2
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH2">Find the entity pageH2 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH2(Wrap<String> c);

	public String getPageH2() {
		return pageH2;
	}
	public void setPageH2(String o) {
		this.pageH2 = SiteUserGenPage.staticSetPageH2(siteRequest_, o);
		this.pageH2Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage pageH2Init() {
		if(!pageH2Wrap.alreadyInitialized) {
			_pageH2(pageH2Wrap);
			if(pageH2 == null)
				setPageH2(pageH2Wrap.o);
			pageH2Wrap.o(null);
		}
		pageH2Wrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH2(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrPageH2(siteRequest_, SiteUserGenPage.staticSolrPageH2(siteRequest_, SiteUserGenPage.staticSetPageH2(siteRequest_, o)));
	}

	public String solrPageH2() {
		return SiteUserGenPage.staticSolrPageH2(siteRequest_, pageH2);
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
	@JsonIgnore
	public Wrap<String> pageH3Wrap = new Wrap<String>().var("pageH3").o(pageH3);

	/**	<br/> The entity pageH3
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH3">Find the entity pageH3 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH3(Wrap<String> c);

	public String getPageH3() {
		return pageH3;
	}
	public void setPageH3(String o) {
		this.pageH3 = SiteUserGenPage.staticSetPageH3(siteRequest_, o);
		this.pageH3Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage pageH3Init() {
		if(!pageH3Wrap.alreadyInitialized) {
			_pageH3(pageH3Wrap);
			if(pageH3 == null)
				setPageH3(pageH3Wrap.o);
			pageH3Wrap.o(null);
		}
		pageH3Wrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH3(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrPageH3(siteRequest_, SiteUserGenPage.staticSolrPageH3(siteRequest_, SiteUserGenPage.staticSetPageH3(siteRequest_, o)));
	}

	public String solrPageH3() {
		return SiteUserGenPage.staticSolrPageH3(siteRequest_, pageH3);
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
	@JsonIgnore
	public Wrap<String> pageTitleWrap = new Wrap<String>().var("pageTitle").o(pageTitle);

	/**	<br/> The entity pageTitle
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> c);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = SiteUserGenPage.staticSetPageTitle(siteRequest_, o);
		this.pageTitleWrap.alreadyInitialized = true;
	}
	public static String staticSetPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage pageTitleInit() {
		if(!pageTitleWrap.alreadyInitialized) {
			_pageTitle(pageTitleWrap);
			if(pageTitle == null)
				setPageTitle(pageTitleWrap.o);
			pageTitleWrap.o(null);
		}
		pageTitleWrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrPageTitle(siteRequest_, SiteUserGenPage.staticSolrPageTitle(siteRequest_, SiteUserGenPage.staticSetPageTitle(siteRequest_, o)));
	}

	public String solrPageTitle() {
		return SiteUserGenPage.staticSolrPageTitle(siteRequest_, pageTitle);
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

	/////////////
	// pageUri //
	/////////////

	/**	 The entity pageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUri;
	@JsonIgnore
	public Wrap<String> pageUriWrap = new Wrap<String>().var("pageUri").o(pageUri);

	/**	<br/> The entity pageUri
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> c);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = SiteUserGenPage.staticSetPageUri(siteRequest_, o);
		this.pageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage pageUriInit() {
		if(!pageUriWrap.alreadyInitialized) {
			_pageUri(pageUriWrap);
			if(pageUri == null)
				setPageUri(pageUriWrap.o);
			pageUriWrap.o(null);
		}
		pageUriWrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUri(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrPageUri(siteRequest_, SiteUserGenPage.staticSolrPageUri(siteRequest_, SiteUserGenPage.staticSetPageUri(siteRequest_, o)));
	}

	public String solrPageUri() {
		return SiteUserGenPage.staticSolrPageUri(siteRequest_, pageUri);
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

	//////////////////
	// promiseAfter //
	//////////////////

	/**	 The entity promiseAfter
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseAfter;
	@JsonIgnore
	public Wrap<Void> promiseAfterWrap = new Wrap<Void>().var("promiseAfter").o(promiseAfter);

	/**	<br/> The entity promiseAfter
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseAfter(Promise<Void> promise);

	public Void getPromiseAfter() {
		return promiseAfter;
	}

	public void setPromiseAfter(Void promiseAfter) {
		this.promiseAfter = promiseAfter;
		this.promiseAfterWrap.alreadyInitialized = true;
	}
	public static Void staticSetPromiseAfter(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseAfterPromise() {
		Promise<Void> promise = Promise.promise();
		if(!promiseAfterWrap.alreadyInitialized) {
			Promise<Void> promise2 = Promise.promise();
			_promiseAfter(promise2);
			promise2.future().onSuccess(o -> {
				setPromiseAfter(o);
				promiseAfterWrap.alreadyInitialized(true);
				promise.complete(o);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
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
	@JsonIgnore
	public Wrap<String> pageImageUriWrap = new Wrap<String>().var("pageImageUri").o(pageImageUri);

	/**	<br/> The entity pageImageUri
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> c);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = SiteUserGenPage.staticSetPageImageUri(siteRequest_, o);
		this.pageImageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage pageImageUriInit() {
		if(!pageImageUriWrap.alreadyInitialized) {
			_pageImageUri(pageImageUriWrap);
			if(pageImageUri == null)
				setPageImageUri(pageImageUriWrap.o);
			pageImageUriWrap.o(null);
		}
		pageImageUriWrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrPageImageUri(siteRequest_, SiteUserGenPage.staticSolrPageImageUri(siteRequest_, SiteUserGenPage.staticSetPageImageUri(siteRequest_, o)));
	}

	public String solrPageImageUri() {
		return SiteUserGenPage.staticSolrPageImageUri(siteRequest_, pageImageUri);
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
	@JsonIgnore
	public Wrap<String> contextIconGroupWrap = new Wrap<String>().var("contextIconGroup").o(contextIconGroup);

	/**	<br/> The entity contextIconGroup
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconGroup">Find the entity contextIconGroup in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconGroup(Wrap<String> c);

	public String getContextIconGroup() {
		return contextIconGroup;
	}
	public void setContextIconGroup(String o) {
		this.contextIconGroup = SiteUserGenPage.staticSetContextIconGroup(siteRequest_, o);
		this.contextIconGroupWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage contextIconGroupInit() {
		if(!contextIconGroupWrap.alreadyInitialized) {
			_contextIconGroup(contextIconGroupWrap);
			if(contextIconGroup == null)
				setContextIconGroup(contextIconGroupWrap.o);
			contextIconGroupWrap.o(null);
		}
		contextIconGroupWrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrContextIconGroup(siteRequest_, SiteUserGenPage.staticSolrContextIconGroup(siteRequest_, SiteUserGenPage.staticSetContextIconGroup(siteRequest_, o)));
	}

	public String solrContextIconGroup() {
		return SiteUserGenPage.staticSolrContextIconGroup(siteRequest_, contextIconGroup);
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
	@JsonIgnore
	public Wrap<String> contextIconNameWrap = new Wrap<String>().var("contextIconName").o(contextIconName);

	/**	<br/> The entity contextIconName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconName">Find the entity contextIconName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconName(Wrap<String> c);

	public String getContextIconName() {
		return contextIconName;
	}
	public void setContextIconName(String o) {
		this.contextIconName = SiteUserGenPage.staticSetContextIconName(siteRequest_, o);
		this.contextIconNameWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUserGenPage contextIconNameInit() {
		if(!contextIconNameWrap.alreadyInitialized) {
			_contextIconName(contextIconNameWrap);
			if(contextIconName == null)
				setContextIconName(contextIconNameWrap.o);
			contextIconNameWrap.o(null);
		}
		contextIconNameWrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static String staticSolrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrContextIconName(siteRequest_, SiteUserGenPage.staticSolrContextIconName(siteRequest_, SiteUserGenPage.staticSetContextIconName(siteRequest_, o)));
	}

	public String solrContextIconName() {
		return SiteUserGenPage.staticSolrContextIconName(siteRequest_, contextIconName);
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

	protected boolean alreadyInitializedSiteUserGenPage = false;

	public Future<Void> promiseDeepSiteUserGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteUserGenPage) {
			alreadyInitializedSiteUserGenPage = true;
			return promiseDeepSiteUserGenPage();
		} else {
			return Future.succeededFuture();
		}
	}

	public Future<Void> promiseDeepSiteUserGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSiteUserGenPage(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSiteUserGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				listSiteUser_Init();
				siteUser_Init();
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
				pageUriInit();
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
		return promiseDeepSiteUserGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteUserGenPage(SiteRequestEnUS siteRequest_) {
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteUserGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteUserGenPage(v);
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
	public Object obtainSiteUserGenPage(String var) {
		SiteUserGenPage oSiteUserGenPage = (SiteUserGenPage)this;
		switch(var) {
			case "siteRequest_":
				return oSiteUserGenPage.siteRequest_;
			case "listSiteUser_":
				return oSiteUserGenPage.listSiteUser_;
			case "siteUser_":
				return oSiteUserGenPage.siteUser_;
			case "promiseBefore":
				return oSiteUserGenPage.promiseBefore;
			case "pageH1":
				return oSiteUserGenPage.pageH1;
			case "pageH2":
				return oSiteUserGenPage.pageH2;
			case "pageH3":
				return oSiteUserGenPage.pageH3;
			case "pageTitle":
				return oSiteUserGenPage.pageTitle;
			case "pageUri":
				return oSiteUserGenPage.pageUri;
			case "promiseAfter":
				return oSiteUserGenPage.promiseAfter;
			case "pageImageUri":
				return oSiteUserGenPage.pageImageUri;
			case "contextIconGroup":
				return oSiteUserGenPage.contextIconGroup;
			case "contextIconName":
				return oSiteUserGenPage.contextIconName;
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
				o = attributeSiteUserGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteUserGenPage(String var, Object val) {
		SiteUserGenPage oSiteUserGenPage = (SiteUserGenPage)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSiteUserGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return SiteUserGenPage.staticSetPageH1(siteRequest_, o);
		case "pageH2":
			return SiteUserGenPage.staticSetPageH2(siteRequest_, o);
		case "pageH3":
			return SiteUserGenPage.staticSetPageH3(siteRequest_, o);
		case "pageTitle":
			return SiteUserGenPage.staticSetPageTitle(siteRequest_, o);
		case "pageUri":
			return SiteUserGenPage.staticSetPageUri(siteRequest_, o);
		case "pageImageUri":
			return SiteUserGenPage.staticSetPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return SiteUserGenPage.staticSetContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return SiteUserGenPage.staticSetContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSiteUserGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return SiteUserGenPage.staticSolrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return SiteUserGenPage.staticSolrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return SiteUserGenPage.staticSolrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return SiteUserGenPage.staticSolrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return SiteUserGenPage.staticSolrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return SiteUserGenPage.staticSolrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return SiteUserGenPage.staticSolrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return SiteUserGenPage.staticSolrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSiteUserGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return SiteUserGenPage.staticSolrStrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return SiteUserGenPage.staticSolrStrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return SiteUserGenPage.staticSolrStrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return SiteUserGenPage.staticSolrStrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return SiteUserGenPage.staticSolrStrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return SiteUserGenPage.staticSolrStrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return SiteUserGenPage.staticSolrStrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return SiteUserGenPage.staticSolrStrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSiteUserGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return SiteUserGenPage.staticSolrFqPageH1(siteRequest_, o);
		case "pageH2":
			return SiteUserGenPage.staticSolrFqPageH2(siteRequest_, o);
		case "pageH3":
			return SiteUserGenPage.staticSolrFqPageH3(siteRequest_, o);
		case "pageTitle":
			return SiteUserGenPage.staticSolrFqPageTitle(siteRequest_, o);
		case "pageUri":
			return SiteUserGenPage.staticSolrFqPageUri(siteRequest_, o);
		case "pageImageUri":
			return SiteUserGenPage.staticSolrFqPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return SiteUserGenPage.staticSolrFqContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return SiteUserGenPage.staticSolrFqContextIconName(siteRequest_, o);
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
					o = defineSiteUserGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteUserGenPage(String var, String val) {
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
					o = defineSiteUserGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteUserGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteUserGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteUserGenPage) {
			SiteUserGenPage original = (SiteUserGenPage)o;
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
		if(!(o instanceof SiteUserGenPage))
			return false;
		SiteUserGenPage that = (SiteUserGenPage)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SiteUserGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_listSiteUser_ = "listSiteUser_";
	public static final String VAR_siteUser_ = "siteUser_";
	public static final String VAR_promiseBefore = "promiseBefore";
	public static final String VAR_pageH1 = "pageH1";
	public static final String VAR_pageH2 = "pageH2";
	public static final String VAR_pageH3 = "pageH3";
	public static final String VAR_pageTitle = "pageTitle";
	public static final String VAR_pageUri = "pageUri";
	public static final String VAR_promiseAfter = "promiseAfter";
	public static final String VAR_pageImageUri = "pageImageUri";
	public static final String VAR_contextIconGroup = "contextIconGroup";
	public static final String VAR_contextIconName = "contextIconName";
}
