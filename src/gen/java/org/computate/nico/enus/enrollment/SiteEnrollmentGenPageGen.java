package org.computate.nico.enus.enrollment;

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
import org.computate.nico.enus.enrollment.SiteEnrollment;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteEnrollmentGenPageGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteEnrollmentGenPage.class);

	////////////////////////
	// listSiteEnrollment //
	////////////////////////

	/**	 The entity listSiteEnrollment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteEnrollment> listSiteEnrollment;
	@JsonIgnore
	public Wrap<SearchList<SiteEnrollment>> listSiteEnrollmentWrap = new Wrap<SearchList<SiteEnrollment>>().var("listSiteEnrollment").o(listSiteEnrollment);

	/**	<br/> The entity listSiteEnrollment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSiteEnrollment">Find the entity listSiteEnrollment in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listSiteEnrollment(Wrap<SearchList<SiteEnrollment>> c);

	public SearchList<SiteEnrollment> getListSiteEnrollment() {
		return listSiteEnrollment;
	}

	public void setListSiteEnrollment(SearchList<SiteEnrollment> listSiteEnrollment) {
		this.listSiteEnrollment = listSiteEnrollment;
		this.listSiteEnrollmentWrap.alreadyInitialized = true;
	}
	public static SearchList<SiteEnrollment> staticSetListSiteEnrollment(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteEnrollmentGenPage listSiteEnrollmentInit() {
		if(!listSiteEnrollmentWrap.alreadyInitialized) {
			_listSiteEnrollment(listSiteEnrollmentWrap);
			if(listSiteEnrollment == null)
				setListSiteEnrollment(listSiteEnrollmentWrap.o);
			listSiteEnrollmentWrap.o(null);
		}
		if(listSiteEnrollment != null)
			listSiteEnrollment.initDeepForClass(null);
		listSiteEnrollmentWrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	/////////////////////
	// siteEnrollment_ //
	/////////////////////

	/**	 The entity siteEnrollment_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SiteEnrollment siteEnrollment_;
	@JsonIgnore
	public Wrap<SiteEnrollment> siteEnrollment_Wrap = new Wrap<SiteEnrollment>().var("siteEnrollment_").o(siteEnrollment_);

	/**	<br/> The entity siteEnrollment_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteEnrollment_">Find the entity siteEnrollment_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteEnrollment_(Wrap<SiteEnrollment> c);

	public SiteEnrollment getSiteEnrollment_() {
		return siteEnrollment_;
	}

	public void setSiteEnrollment_(SiteEnrollment siteEnrollment_) {
		this.siteEnrollment_ = siteEnrollment_;
		this.siteEnrollment_Wrap.alreadyInitialized = true;
	}
	public static SiteEnrollment staticSetSiteEnrollment_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteEnrollmentGenPage siteEnrollment_Init() {
		if(!siteEnrollment_Wrap.alreadyInitialized) {
			_siteEnrollment_(siteEnrollment_Wrap);
			if(siteEnrollment_ == null)
				setSiteEnrollment_(siteEnrollment_Wrap.o);
			siteEnrollment_Wrap.o(null);
		}
		siteEnrollment_Wrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Find the entity pageH1 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}
	public void setPageH1(String o) {
		this.pageH1 = SiteEnrollmentGenPage.staticSetPageH1(null, o);
		this.pageH1Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage pageH1Init() {
		if(!pageH1Wrap.alreadyInitialized) {
			_pageH1(pageH1Wrap);
			if(pageH1 == null)
				setPageH1(pageH1Wrap.o);
			pageH1Wrap.o(null);
		}
		pageH1Wrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrPageH1(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqPageH1(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrPageH1(siteRequest_, SiteEnrollmentGenPage.staticSolrPageH1(siteRequest_, SiteEnrollmentGenPage.staticSetPageH1(siteRequest_, o)));
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH2">Find the entity pageH2 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH2(Wrap<String> c);

	public String getPageH2() {
		return pageH2;
	}
	public void setPageH2(String o) {
		this.pageH2 = SiteEnrollmentGenPage.staticSetPageH2(null, o);
		this.pageH2Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage pageH2Init() {
		if(!pageH2Wrap.alreadyInitialized) {
			_pageH2(pageH2Wrap);
			if(pageH2 == null)
				setPageH2(pageH2Wrap.o);
			pageH2Wrap.o(null);
		}
		pageH2Wrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrPageH2(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqPageH2(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrPageH2(siteRequest_, SiteEnrollmentGenPage.staticSolrPageH2(siteRequest_, SiteEnrollmentGenPage.staticSetPageH2(siteRequest_, o)));
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH3">Find the entity pageH3 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH3(Wrap<String> c);

	public String getPageH3() {
		return pageH3;
	}
	public void setPageH3(String o) {
		this.pageH3 = SiteEnrollmentGenPage.staticSetPageH3(null, o);
		this.pageH3Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage pageH3Init() {
		if(!pageH3Wrap.alreadyInitialized) {
			_pageH3(pageH3Wrap);
			if(pageH3 == null)
				setPageH3(pageH3Wrap.o);
			pageH3Wrap.o(null);
		}
		pageH3Wrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrPageH3(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqPageH3(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrPageH3(siteRequest_, SiteEnrollmentGenPage.staticSolrPageH3(siteRequest_, SiteEnrollmentGenPage.staticSetPageH3(siteRequest_, o)));
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> c);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = SiteEnrollmentGenPage.staticSetPageTitle(null, o);
		this.pageTitleWrap.alreadyInitialized = true;
	}
	public static String staticSetPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage pageTitleInit() {
		if(!pageTitleWrap.alreadyInitialized) {
			_pageTitle(pageTitleWrap);
			if(pageTitle == null)
				setPageTitle(pageTitleWrap.o);
			pageTitleWrap.o(null);
		}
		pageTitleWrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrPageTitle(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrPageTitle(siteRequest_, SiteEnrollmentGenPage.staticSolrPageTitle(siteRequest_, SiteEnrollmentGenPage.staticSetPageTitle(siteRequest_, o)));
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> c);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = SiteEnrollmentGenPage.staticSetPageUri(null, o);
		this.pageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage pageUriInit() {
		if(!pageUriWrap.alreadyInitialized) {
			_pageUri(pageUriWrap);
			if(pageUri == null)
				setPageUri(pageUriWrap.o);
			pageUriWrap.o(null);
		}
		pageUriWrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrPageUri(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqPageUri(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrPageUri(siteRequest_, SiteEnrollmentGenPage.staticSolrPageUri(siteRequest_, SiteEnrollmentGenPage.staticSetPageUri(siteRequest_, o)));
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> c);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = SiteEnrollmentGenPage.staticSetPageImageUri(null, o);
		this.pageImageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage pageImageUriInit() {
		if(!pageImageUriWrap.alreadyInitialized) {
			_pageImageUri(pageImageUriWrap);
			if(pageImageUri == null)
				setPageImageUri(pageImageUriWrap.o);
			pageImageUriWrap.o(null);
		}
		pageImageUriWrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrPageImageUri(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrPageImageUri(siteRequest_, SiteEnrollmentGenPage.staticSolrPageImageUri(siteRequest_, SiteEnrollmentGenPage.staticSetPageImageUri(siteRequest_, o)));
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconGroup">Find the entity contextIconGroup in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconGroup(Wrap<String> c);

	public String getContextIconGroup() {
		return contextIconGroup;
	}
	public void setContextIconGroup(String o) {
		this.contextIconGroup = SiteEnrollmentGenPage.staticSetContextIconGroup(null, o);
		this.contextIconGroupWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage contextIconGroupInit() {
		if(!contextIconGroupWrap.alreadyInitialized) {
			_contextIconGroup(contextIconGroupWrap);
			if(contextIconGroup == null)
				setContextIconGroup(contextIconGroupWrap.o);
			contextIconGroupWrap.o(null);
		}
		contextIconGroupWrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrContextIconGroup(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrContextIconGroup(siteRequest_, SiteEnrollmentGenPage.staticSolrContextIconGroup(siteRequest_, SiteEnrollmentGenPage.staticSetContextIconGroup(siteRequest_, o)));
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconName">Find the entity contextIconName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconName(Wrap<String> c);

	public String getContextIconName() {
		return contextIconName;
	}
	public void setContextIconName(String o) {
		this.contextIconName = SiteEnrollmentGenPage.staticSetContextIconName(null, o);
		this.contextIconNameWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteEnrollmentGenPage contextIconNameInit() {
		if(!contextIconNameWrap.alreadyInitialized) {
			_contextIconName(contextIconNameWrap);
			if(contextIconName == null)
				setContextIconName(contextIconNameWrap.o);
			contextIconNameWrap.o(null);
		}
		contextIconNameWrap.alreadyInitialized(true);
		return (SiteEnrollmentGenPage)this;
	}

	public static Object staticSolrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}

	public static String staticSolrStrContextIconName(SiteRequestEnUS siteRequest_, Object o) {
		return null;
	}

	public static String staticSolrFqContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrContextIconName(siteRequest_, SiteEnrollmentGenPage.staticSolrContextIconName(siteRequest_, SiteEnrollmentGenPage.staticSetContextIconName(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSiteEnrollmentGenPage = false;

	public SiteEnrollmentGenPage initDeepSiteEnrollmentGenPage(SiteRequestEnUS siteRequest_) {
		if(!alreadyInitializedSiteEnrollmentGenPage) {
			alreadyInitializedSiteEnrollmentGenPage = true;
			initDeepSiteEnrollmentGenPage();
		}
		return (SiteEnrollmentGenPage)this;
	}

	public void initDeepSiteEnrollmentGenPage() {
		initSiteEnrollmentGenPage();
	}

	public void initSiteEnrollmentGenPage() {
				listSiteEnrollmentInit();
				siteEnrollment_Init();
				pageH1Init();
				pageH2Init();
				pageH3Init();
				pageTitleInit();
				pageUriInit();
				pageImageUriInit();
				contextIconGroupInit();
				contextIconNameInit();
	}

	public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSiteEnrollmentGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteEnrollmentGenPage(v);
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
	public Object obtainSiteEnrollmentGenPage(String var) {
		SiteEnrollmentGenPage oSiteEnrollmentGenPage = (SiteEnrollmentGenPage)this;
		switch(var) {
			case "listSiteEnrollment":
				return oSiteEnrollmentGenPage.listSiteEnrollment;
			case "siteEnrollment_":
				return oSiteEnrollmentGenPage.siteEnrollment_;
			case "pageH1":
				return oSiteEnrollmentGenPage.pageH1;
			case "pageH2":
				return oSiteEnrollmentGenPage.pageH2;
			case "pageH3":
				return oSiteEnrollmentGenPage.pageH3;
			case "pageTitle":
				return oSiteEnrollmentGenPage.pageTitle;
			case "pageUri":
				return oSiteEnrollmentGenPage.pageUri;
			case "pageImageUri":
				return oSiteEnrollmentGenPage.pageImageUri;
			case "contextIconGroup":
				return oSiteEnrollmentGenPage.contextIconGroup;
			case "contextIconName":
				return oSiteEnrollmentGenPage.contextIconName;
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
				o = attributeSiteEnrollmentGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteEnrollmentGenPage(String var, Object val) {
		SiteEnrollmentGenPage oSiteEnrollmentGenPage = (SiteEnrollmentGenPage)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSiteEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return SiteEnrollmentGenPage.staticSetPageH1(siteRequest_, o);
		case "pageH2":
			return SiteEnrollmentGenPage.staticSetPageH2(siteRequest_, o);
		case "pageH3":
			return SiteEnrollmentGenPage.staticSetPageH3(siteRequest_, o);
		case "pageTitle":
			return SiteEnrollmentGenPage.staticSetPageTitle(siteRequest_, o);
		case "pageUri":
			return SiteEnrollmentGenPage.staticSetPageUri(siteRequest_, o);
		case "pageImageUri":
			return SiteEnrollmentGenPage.staticSetPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return SiteEnrollmentGenPage.staticSetContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return SiteEnrollmentGenPage.staticSetContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSiteEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return SiteEnrollmentGenPage.staticSolrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return SiteEnrollmentGenPage.staticSolrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return SiteEnrollmentGenPage.staticSolrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return SiteEnrollmentGenPage.staticSolrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return SiteEnrollmentGenPage.staticSolrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return SiteEnrollmentGenPage.staticSolrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return SiteEnrollmentGenPage.staticSolrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return SiteEnrollmentGenPage.staticSolrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSiteEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return SiteEnrollmentGenPage.staticSolrStrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return SiteEnrollmentGenPage.staticSolrStrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return SiteEnrollmentGenPage.staticSolrStrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return SiteEnrollmentGenPage.staticSolrStrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return SiteEnrollmentGenPage.staticSolrStrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return SiteEnrollmentGenPage.staticSolrStrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return SiteEnrollmentGenPage.staticSolrStrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return SiteEnrollmentGenPage.staticSolrStrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSiteEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return SiteEnrollmentGenPage.staticSolrFqPageH1(siteRequest_, o);
		case "pageH2":
			return SiteEnrollmentGenPage.staticSolrFqPageH2(siteRequest_, o);
		case "pageH3":
			return SiteEnrollmentGenPage.staticSolrFqPageH3(siteRequest_, o);
		case "pageTitle":
			return SiteEnrollmentGenPage.staticSolrFqPageTitle(siteRequest_, o);
		case "pageUri":
			return SiteEnrollmentGenPage.staticSolrFqPageUri(siteRequest_, o);
		case "pageImageUri":
			return SiteEnrollmentGenPage.staticSolrFqPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return SiteEnrollmentGenPage.staticSolrFqContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return SiteEnrollmentGenPage.staticSolrFqContextIconName(siteRequest_, o);
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
					o = defineSiteEnrollmentGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollmentGenPage(String var, String val) {
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
					o = defineSiteEnrollmentGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollmentGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
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
		if(!(o instanceof SiteEnrollmentGenPage))
			return false;
		SiteEnrollmentGenPage that = (SiteEnrollmentGenPage)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SiteEnrollmentGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_listSiteEnrollment = "listSiteEnrollment";
	public static final String VAR_siteEnrollment_ = "siteEnrollment_";
	public static final String VAR_pageH1 = "pageH1";
	public static final String VAR_pageH2 = "pageH2";
	public static final String VAR_pageH3 = "pageH3";
	public static final String VAR_pageTitle = "pageTitle";
	public static final String VAR_pageUri = "pageUri";
	public static final String VAR_pageImageUri = "pageImageUri";
	public static final String VAR_contextIconGroup = "contextIconGroup";
	public static final String VAR_contextIconName = "contextIconName";
}
