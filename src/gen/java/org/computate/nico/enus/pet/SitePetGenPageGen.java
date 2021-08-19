package org.computate.nico.enus.pet;

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
import java.lang.String;
import org.computate.nico.enus.base.BaseModel;
import org.computate.nico.enus.wrap.Wrap;
import java.math.RoundingMode;
import org.computate.nico.enus.java.LocalDateSerializer;
import java.lang.Void;
import org.computate.nico.enus.pet.SitePet;
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
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SitePetGenPageGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(SitePetGenPage.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SiteRequestEnUS siteRequest_;
	@JsonIgnore
	public Wrap<SiteRequestEnUS> siteRequest_Wrap = new Wrap<SiteRequestEnUS>().var("siteRequest_").o(siteRequest_);

	/**	<br/> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	protected SitePetGenPage siteRequest_Init() {
		if(!siteRequest_Wrap.alreadyInitialized) {
			_siteRequest_(siteRequest_Wrap);
			if(siteRequest_ == null)
				setSiteRequest_(siteRequest_Wrap.o);
			siteRequest_Wrap.o(null);
		}
		siteRequest_Wrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	//////////////////
	// listSitePet_ //
	//////////////////

	/**	 The entity listSitePet_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SitePet> listSitePet_;
	@JsonIgnore
	public Wrap<SearchList<SitePet>> listSitePet_Wrap = new Wrap<SearchList<SitePet>>().var("listSitePet_").o(listSitePet_);

	/**	<br/> The entity listSitePet_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSitePet_">Find the entity listSitePet_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listSitePet_(Wrap<SearchList<SitePet>> c);

	public SearchList<SitePet> getListSitePet_() {
		return listSitePet_;
	}

	public void setListSitePet_(SearchList<SitePet> listSitePet_) {
		this.listSitePet_ = listSitePet_;
		this.listSitePet_Wrap.alreadyInitialized = true;
	}
	public static SearchList<SitePet> staticSetListSitePet_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SitePetGenPage listSitePet_Init() {
		if(!listSitePet_Wrap.alreadyInitialized) {
			_listSitePet_(listSitePet_Wrap);
			if(listSitePet_ == null)
				setListSitePet_(listSitePet_Wrap.o);
			listSitePet_Wrap.o(null);
		}
		listSitePet_Wrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	//////////////
	// sitePet_ //
	//////////////

	/**	 The entity sitePet_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SitePet sitePet_;
	@JsonIgnore
	public Wrap<SitePet> sitePet_Wrap = new Wrap<SitePet>().var("sitePet_").o(sitePet_);

	/**	<br/> The entity sitePet_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sitePet_">Find the entity sitePet_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sitePet_(Wrap<SitePet> c);

	public SitePet getSitePet_() {
		return sitePet_;
	}

	public void setSitePet_(SitePet sitePet_) {
		this.sitePet_ = sitePet_;
		this.sitePet_Wrap.alreadyInitialized = true;
	}
	public static SitePet staticSetSitePet_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SitePetGenPage sitePet_Init() {
		if(!sitePet_Wrap.alreadyInitialized) {
			_sitePet_(sitePet_Wrap);
			if(sitePet_ == null)
				setSitePet_(sitePet_Wrap.o);
			sitePet_Wrap.o(null);
		}
		sitePet_Wrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	///////////////////
	// promiseBefore //
	///////////////////

	/**	 The entity promiseBefore
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Void promiseBefore;
	@JsonIgnore
	public Wrap<Void> promiseBeforeWrap = new Wrap<Void>().var("promiseBefore").o(promiseBefore);

	/**	<br/> The entity promiseBefore
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Find the entity pageH1 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}
	public void setPageH1(String o) {
		this.pageH1 = SitePetGenPage.staticSetPageH1(siteRequest_, o);
		this.pageH1Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage pageH1Init() {
		if(!pageH1Wrap.alreadyInitialized) {
			_pageH1(pageH1Wrap);
			if(pageH1 == null)
				setPageH1(pageH1Wrap.o);
			pageH1Wrap.o(null);
		}
		pageH1Wrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH1(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrPageH1(siteRequest_, SitePetGenPage.staticSolrPageH1(siteRequest_, SitePetGenPage.staticSetPageH1(siteRequest_, o)));
	}

	public String solrPageH1() {
		return SitePetGenPage.staticSolrPageH1(siteRequest_, pageH1);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH2">Find the entity pageH2 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH2(Wrap<String> c);

	public String getPageH2() {
		return pageH2;
	}
	public void setPageH2(String o) {
		this.pageH2 = SitePetGenPage.staticSetPageH2(siteRequest_, o);
		this.pageH2Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage pageH2Init() {
		if(!pageH2Wrap.alreadyInitialized) {
			_pageH2(pageH2Wrap);
			if(pageH2 == null)
				setPageH2(pageH2Wrap.o);
			pageH2Wrap.o(null);
		}
		pageH2Wrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH2(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrPageH2(siteRequest_, SitePetGenPage.staticSolrPageH2(siteRequest_, SitePetGenPage.staticSetPageH2(siteRequest_, o)));
	}

	public String solrPageH2() {
		return SitePetGenPage.staticSolrPageH2(siteRequest_, pageH2);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH3">Find the entity pageH3 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH3(Wrap<String> c);

	public String getPageH3() {
		return pageH3;
	}
	public void setPageH3(String o) {
		this.pageH3 = SitePetGenPage.staticSetPageH3(siteRequest_, o);
		this.pageH3Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage pageH3Init() {
		if(!pageH3Wrap.alreadyInitialized) {
			_pageH3(pageH3Wrap);
			if(pageH3 == null)
				setPageH3(pageH3Wrap.o);
			pageH3Wrap.o(null);
		}
		pageH3Wrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH3(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrPageH3(siteRequest_, SitePetGenPage.staticSolrPageH3(siteRequest_, SitePetGenPage.staticSetPageH3(siteRequest_, o)));
	}

	public String solrPageH3() {
		return SitePetGenPage.staticSolrPageH3(siteRequest_, pageH3);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> c);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = SitePetGenPage.staticSetPageTitle(siteRequest_, o);
		this.pageTitleWrap.alreadyInitialized = true;
	}
	public static String staticSetPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage pageTitleInit() {
		if(!pageTitleWrap.alreadyInitialized) {
			_pageTitle(pageTitleWrap);
			if(pageTitle == null)
				setPageTitle(pageTitleWrap.o);
			pageTitleWrap.o(null);
		}
		pageTitleWrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrPageTitle(siteRequest_, SitePetGenPage.staticSolrPageTitle(siteRequest_, SitePetGenPage.staticSetPageTitle(siteRequest_, o)));
	}

	public String solrPageTitle() {
		return SitePetGenPage.staticSolrPageTitle(siteRequest_, pageTitle);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> c);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = SitePetGenPage.staticSetPageUri(siteRequest_, o);
		this.pageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage pageUriInit() {
		if(!pageUriWrap.alreadyInitialized) {
			_pageUri(pageUriWrap);
			if(pageUri == null)
				setPageUri(pageUriWrap.o);
			pageUriWrap.o(null);
		}
		pageUriWrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUri(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrPageUri(siteRequest_, SitePetGenPage.staticSolrPageUri(siteRequest_, SitePetGenPage.staticSetPageUri(siteRequest_, o)));
	}

	public String solrPageUri() {
		return SitePetGenPage.staticSolrPageUri(siteRequest_, pageUri);
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
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Void promiseAfter;
	@JsonIgnore
	public Wrap<Void> promiseAfterWrap = new Wrap<Void>().var("promiseAfter").o(promiseAfter);

	/**	<br/> The entity promiseAfter
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> c);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = SitePetGenPage.staticSetPageImageUri(siteRequest_, o);
		this.pageImageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage pageImageUriInit() {
		if(!pageImageUriWrap.alreadyInitialized) {
			_pageImageUri(pageImageUriWrap);
			if(pageImageUri == null)
				setPageImageUri(pageImageUriWrap.o);
			pageImageUriWrap.o(null);
		}
		pageImageUriWrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrPageImageUri(siteRequest_, SitePetGenPage.staticSolrPageImageUri(siteRequest_, SitePetGenPage.staticSetPageImageUri(siteRequest_, o)));
	}

	public String solrPageImageUri() {
		return SitePetGenPage.staticSolrPageImageUri(siteRequest_, pageImageUri);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconGroup">Find the entity contextIconGroup in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconGroup(Wrap<String> c);

	public String getContextIconGroup() {
		return contextIconGroup;
	}
	public void setContextIconGroup(String o) {
		this.contextIconGroup = SitePetGenPage.staticSetContextIconGroup(siteRequest_, o);
		this.contextIconGroupWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage contextIconGroupInit() {
		if(!contextIconGroupWrap.alreadyInitialized) {
			_contextIconGroup(contextIconGroupWrap);
			if(contextIconGroup == null)
				setContextIconGroup(contextIconGroupWrap.o);
			contextIconGroupWrap.o(null);
		}
		contextIconGroupWrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrContextIconGroup(siteRequest_, SitePetGenPage.staticSolrContextIconGroup(siteRequest_, SitePetGenPage.staticSetContextIconGroup(siteRequest_, o)));
	}

	public String solrContextIconGroup() {
		return SitePetGenPage.staticSolrContextIconGroup(siteRequest_, contextIconGroup);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconName">Find the entity contextIconName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconName(Wrap<String> c);

	public String getContextIconName() {
		return contextIconName;
	}
	public void setContextIconName(String o) {
		this.contextIconName = SitePetGenPage.staticSetContextIconName(siteRequest_, o);
		this.contextIconNameWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePetGenPage contextIconNameInit() {
		if(!contextIconNameWrap.alreadyInitialized) {
			_contextIconName(contextIconNameWrap);
			if(contextIconName == null)
				setContextIconName(contextIconNameWrap.o);
			contextIconNameWrap.o(null);
		}
		contextIconNameWrap.alreadyInitialized(true);
		return (SitePetGenPage)this;
	}

	public static String staticSolrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrContextIconName(siteRequest_, SitePetGenPage.staticSolrContextIconName(siteRequest_, SitePetGenPage.staticSetContextIconName(siteRequest_, o)));
	}

	public String solrContextIconName() {
		return SitePetGenPage.staticSolrContextIconName(siteRequest_, contextIconName);
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

	protected boolean alreadyInitializedSitePetGenPage = false;

	public Future<Void> promiseDeepSitePetGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSitePetGenPage) {
			alreadyInitializedSitePetGenPage = true;
			return promiseDeepSitePetGenPage();
		} else {
			return Future.succeededFuture();
		}
	}

	public Future<Void> promiseDeepSitePetGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSitePetGenPage(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSitePetGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				listSitePet_Init();
				sitePet_Init();
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
		return promiseDeepSitePetGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSitePetGenPage(SiteRequestEnUS siteRequest_) {
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSitePetGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSitePetGenPage(v);
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
	public Object obtainSitePetGenPage(String var) {
		SitePetGenPage oSitePetGenPage = (SitePetGenPage)this;
		switch(var) {
			case "siteRequest_":
				return oSitePetGenPage.siteRequest_;
			case "listSitePet_":
				return oSitePetGenPage.listSitePet_;
			case "sitePet_":
				return oSitePetGenPage.sitePet_;
			case "promiseBefore":
				return oSitePetGenPage.promiseBefore;
			case "pageH1":
				return oSitePetGenPage.pageH1;
			case "pageH2":
				return oSitePetGenPage.pageH2;
			case "pageH3":
				return oSitePetGenPage.pageH3;
			case "pageTitle":
				return oSitePetGenPage.pageTitle;
			case "pageUri":
				return oSitePetGenPage.pageUri;
			case "promiseAfter":
				return oSitePetGenPage.promiseAfter;
			case "pageImageUri":
				return oSitePetGenPage.pageImageUri;
			case "contextIconGroup":
				return oSitePetGenPage.contextIconGroup;
			case "contextIconName":
				return oSitePetGenPage.contextIconName;
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
				o = attributeSitePetGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSitePetGenPage(String var, Object val) {
		SitePetGenPage oSitePetGenPage = (SitePetGenPage)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSitePetGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSitePetGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return SitePetGenPage.staticSetPageH1(siteRequest_, o);
		case "pageH2":
			return SitePetGenPage.staticSetPageH2(siteRequest_, o);
		case "pageH3":
			return SitePetGenPage.staticSetPageH3(siteRequest_, o);
		case "pageTitle":
			return SitePetGenPage.staticSetPageTitle(siteRequest_, o);
		case "pageUri":
			return SitePetGenPage.staticSetPageUri(siteRequest_, o);
		case "pageImageUri":
			return SitePetGenPage.staticSetPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return SitePetGenPage.staticSetContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return SitePetGenPage.staticSetContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSitePetGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSitePetGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return SitePetGenPage.staticSolrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return SitePetGenPage.staticSolrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return SitePetGenPage.staticSolrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return SitePetGenPage.staticSolrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return SitePetGenPage.staticSolrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return SitePetGenPage.staticSolrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return SitePetGenPage.staticSolrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return SitePetGenPage.staticSolrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSitePetGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSitePetGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return SitePetGenPage.staticSolrStrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return SitePetGenPage.staticSolrStrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return SitePetGenPage.staticSolrStrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return SitePetGenPage.staticSolrStrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return SitePetGenPage.staticSolrStrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return SitePetGenPage.staticSolrStrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return SitePetGenPage.staticSolrStrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return SitePetGenPage.staticSolrStrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSitePetGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSitePetGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return SitePetGenPage.staticSolrFqPageH1(siteRequest_, o);
		case "pageH2":
			return SitePetGenPage.staticSolrFqPageH2(siteRequest_, o);
		case "pageH3":
			return SitePetGenPage.staticSolrFqPageH3(siteRequest_, o);
		case "pageTitle":
			return SitePetGenPage.staticSolrFqPageTitle(siteRequest_, o);
		case "pageUri":
			return SitePetGenPage.staticSolrFqPageUri(siteRequest_, o);
		case "pageImageUri":
			return SitePetGenPage.staticSolrFqPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return SitePetGenPage.staticSolrFqContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return SitePetGenPage.staticSolrFqContextIconName(siteRequest_, o);
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
					o = defineSitePetGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSitePetGenPage(String var, String val) {
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
					o = defineSitePetGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSitePetGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSitePetGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SitePetGenPage) {
			SitePetGenPage original = (SitePetGenPage)o;
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
		if(!(o instanceof SitePetGenPage))
			return false;
		SitePetGenPage that = (SitePetGenPage)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SitePetGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_listSitePet_ = "listSitePet_";
	public static final String VAR_sitePet_ = "sitePet_";
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
