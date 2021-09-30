package org.computate.nico.enus.enrollment;

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
import org.computate.nico.enus.page.PageLayout;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.nico.enus.enrollment.SiteEnrollment;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteEnrollmentGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteEnrollmentGenPage.class);

	///////////////////////////////
	// searchListSiteEnrollment_ //
	///////////////////////////////

	/**	 The entity searchListSiteEnrollment_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteEnrollment> searchListSiteEnrollment_;

	/**	<br/> The entity searchListSiteEnrollment_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListSiteEnrollment_">Find the entity searchListSiteEnrollment_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListSiteEnrollment_(Wrap<SearchList<SiteEnrollment>> w);

	public SearchList<SiteEnrollment> getSearchListSiteEnrollment_() {
		return searchListSiteEnrollment_;
	}

	public void setSearchListSiteEnrollment_(SearchList<SiteEnrollment> searchListSiteEnrollment_) {
		this.searchListSiteEnrollment_ = searchListSiteEnrollment_;
	}
	public static SearchList<SiteEnrollment> staticSetSearchListSiteEnrollment_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteEnrollmentGenPage searchListSiteEnrollment_Init() {
		Wrap<SearchList<SiteEnrollment>> searchListSiteEnrollment_Wrap = new Wrap<SearchList<SiteEnrollment>>().var("searchListSiteEnrollment_");
		if(searchListSiteEnrollment_ == null) {
			_searchListSiteEnrollment_(searchListSiteEnrollment_Wrap);
			setSearchListSiteEnrollment_(searchListSiteEnrollment_Wrap.o);
		}
		return (SiteEnrollmentGenPage)this;
	}

	////////////////////////
	// listSiteEnrollment //
	////////////////////////

	/**	 The entity listSiteEnrollment
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonArray(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listSiteEnrollment = new JsonArray();

	/**	<br/> The entity listSiteEnrollment
	 *  It is constructed before being initialized with the constructor by default JsonArray(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSiteEnrollment">Find the entity listSiteEnrollment in Solr</a>
	 * <br/>
	 * @param listSiteEnrollment is the entity already constructed. 
	 **/
	protected abstract void _listSiteEnrollment(JsonArray l);

	public JsonArray getListSiteEnrollment() {
		return listSiteEnrollment;
	}

	public void setListSiteEnrollment(JsonArray listSiteEnrollment) {
		this.listSiteEnrollment = listSiteEnrollment;
	}
	public static JsonArray staticSetListSiteEnrollment(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteEnrollmentGenPage listSiteEnrollmentInit() {
		_listSiteEnrollment(listSiteEnrollment);
		return (SiteEnrollmentGenPage)this;
	}

	/////////////////////////
	// siteEnrollmentCount //
	/////////////////////////

	/**	 The entity siteEnrollmentCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer siteEnrollmentCount;

	/**	<br/> The entity siteEnrollmentCount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteEnrollmentCount">Find the entity siteEnrollmentCount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteEnrollmentCount(Wrap<Integer> w);

	public Integer getSiteEnrollmentCount() {
		return siteEnrollmentCount;
	}

	public void setSiteEnrollmentCount(Integer siteEnrollmentCount) {
		this.siteEnrollmentCount = siteEnrollmentCount;
	}
	@JsonIgnore
	public void setSiteEnrollmentCount(String o) {
		this.siteEnrollmentCount = SiteEnrollmentGenPage.staticSetSiteEnrollmentCount(siteRequest_, o);
	}
	public static Integer staticSetSiteEnrollmentCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SiteEnrollmentGenPage siteEnrollmentCountInit() {
		Wrap<Integer> siteEnrollmentCountWrap = new Wrap<Integer>().var("siteEnrollmentCount");
		if(siteEnrollmentCount == null) {
			_siteEnrollmentCount(siteEnrollmentCountWrap);
			setSiteEnrollmentCount(siteEnrollmentCountWrap.o);
		}
		return (SiteEnrollmentGenPage)this;
	}

	public static Integer staticSolrSiteEnrollmentCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrSiteEnrollmentCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSiteEnrollmentCount(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrSiteEnrollmentCount(siteRequest_, SiteEnrollmentGenPage.staticSolrSiteEnrollmentCount(siteRequest_, SiteEnrollmentGenPage.staticSetSiteEnrollmentCount(siteRequest_, o)));
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

	/**	<br/> The entity siteEnrollment_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteEnrollment_">Find the entity siteEnrollment_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteEnrollment_(Wrap<SiteEnrollment> w);

	public SiteEnrollment getSiteEnrollment_() {
		return siteEnrollment_;
	}

	public void setSiteEnrollment_(SiteEnrollment siteEnrollment_) {
		this.siteEnrollment_ = siteEnrollment_;
	}
	public static SiteEnrollment staticSetSiteEnrollment_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteEnrollmentGenPage siteEnrollment_Init() {
		Wrap<SiteEnrollment> siteEnrollment_Wrap = new Wrap<SiteEnrollment>().var("siteEnrollment_");
		if(siteEnrollment_ == null) {
			_siteEnrollment_(siteEnrollment_Wrap);
			setSiteEnrollment_(siteEnrollment_Wrap.o);
		}
		return (SiteEnrollmentGenPage)this;
	}

	////////
	// pk //
	////////

	/**	 The entity pk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long pk;

	/**	<br/> The entity pk
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pk(Wrap<Long> w);

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}
	@JsonIgnore
	public void setPk(String o) {
		this.pk = SiteEnrollmentGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SiteEnrollmentGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (SiteEnrollmentGenPage)this;
	}

	public static Long staticSolrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollmentGenPage.staticSolrStrPk(siteRequest_, SiteEnrollmentGenPage.staticSolrPk(siteRequest_, SiteEnrollmentGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepSiteEnrollmentGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSiteEnrollmentGenPage();
	}

	public Future<Void> promiseDeepSiteEnrollmentGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSiteEnrollmentGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepPageLayout(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSiteEnrollmentGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListSiteEnrollment_Init();
				listSiteEnrollmentInit();
				siteEnrollmentCountInit();
				siteEnrollment_Init();
				pkInit();
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

	@Override public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepSiteEnrollmentGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteEnrollmentGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteEnrollmentGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
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
			case "searchListSiteEnrollment_":
				return oSiteEnrollmentGenPage.searchListSiteEnrollment_;
			case "listSiteEnrollment":
				return oSiteEnrollmentGenPage.listSiteEnrollment;
			case "siteEnrollmentCount":
				return oSiteEnrollmentGenPage.siteEnrollmentCount;
			case "siteEnrollment_":
				return oSiteEnrollmentGenPage.siteEnrollment_;
			case "pk":
				return oSiteEnrollmentGenPage.pk;
			default:
				return super.obtainPageLayout(var);
		}
	}

	///////////////
	// relate //
	///////////////

	@Override public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateSiteEnrollmentGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateSiteEnrollmentGenPage(String var, Object val) {
		SiteEnrollmentGenPage oSiteEnrollmentGenPage = (SiteEnrollmentGenPage)this;
		switch(var) {
			default:
				return super.relatePageLayout(var, val);
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
		case "siteEnrollmentCount":
			return SiteEnrollmentGenPage.staticSetSiteEnrollmentCount(siteRequest_, o);
		case "pk":
			return SiteEnrollmentGenPage.staticSetPk(siteRequest_, o);
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
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
		case "siteEnrollmentCount":
			return SiteEnrollmentGenPage.staticSolrSiteEnrollmentCount(siteRequest_, (Integer)o);
		case "pk":
			return SiteEnrollmentGenPage.staticSolrPk(siteRequest_, (Long)o);
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
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
		case "siteEnrollmentCount":
			return SiteEnrollmentGenPage.staticSolrStrSiteEnrollmentCount(siteRequest_, (Integer)o);
		case "pk":
			return SiteEnrollmentGenPage.staticSolrStrPk(siteRequest_, (Long)o);
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
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
		case "siteEnrollmentCount":
			return SiteEnrollmentGenPage.staticSolrFqSiteEnrollmentCount(siteRequest_, o);
		case "pk":
			return SiteEnrollmentGenPage.staticSolrFqPk(siteRequest_, o);
			default:
				return PageLayout.staticSolrFqPageLayout(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, Object val) {
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
				return super.definePageLayout(var, val);
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteEnrollmentGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteEnrollmentGenPage) {
			SiteEnrollmentGenPage original = (SiteEnrollmentGenPage)o;
			super.apiRequestPageLayout();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteEnrollmentGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_searchListSiteEnrollment_ = "searchListSiteEnrollment_";
	public static final String VAR_listSiteEnrollment = "listSiteEnrollment";
	public static final String VAR_siteEnrollmentCount = "siteEnrollmentCount";
	public static final String VAR_siteEnrollment_ = "siteEnrollment_";
	public static final String VAR_pk = "pk";
}
