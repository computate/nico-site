package org.computate.nico.enus.pet;

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
import org.computate.nico.enus.base.BaseModelPage;
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
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SitePetGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(SitePetGenPage.class);

	////////////////////////
	// searchListSitePet_ //
	////////////////////////

	/**	 The entity searchListSitePet_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SitePet> searchListSitePet_;

	/**	<br/> The entity searchListSitePet_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListSitePet_">Find the entity searchListSitePet_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListSitePet_(Wrap<SearchList<SitePet>> w);

	public SearchList<SitePet> getSearchListSitePet_() {
		return searchListSitePet_;
	}

	public void setSearchListSitePet_(SearchList<SitePet> searchListSitePet_) {
		this.searchListSitePet_ = searchListSitePet_;
	}
	public static SearchList<SitePet> staticSetSearchListSitePet_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SitePetGenPage searchListSitePet_Init() {
		Wrap<SearchList<SitePet>> searchListSitePet_Wrap = new Wrap<SearchList<SitePet>>().var("searchListSitePet_");
		if(searchListSitePet_ == null) {
			_searchListSitePet_(searchListSitePet_Wrap);
			setSearchListSitePet_(searchListSitePet_Wrap.o);
		}
		return (SitePetGenPage)this;
	}

	/////////////////
	// listSitePet //
	/////////////////

	/**	 The entity listSitePet
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonArray(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listSitePet = new JsonArray();

	/**	<br/> The entity listSitePet
	 *  It is constructed before being initialized with the constructor by default JsonArray(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSitePet">Find the entity listSitePet in Solr</a>
	 * <br/>
	 * @param listSitePet is the entity already constructed. 
	 **/
	protected abstract void _listSitePet(JsonArray l);

	public JsonArray getListSitePet() {
		return listSitePet;
	}

	public void setListSitePet(JsonArray listSitePet) {
		this.listSitePet = listSitePet;
	}
	public static JsonArray staticSetListSitePet(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SitePetGenPage listSitePetInit() {
		_listSitePet(listSitePet);
		return (SitePetGenPage)this;
	}

	//////////////////
	// sitePetCount //
	//////////////////

	/**	 The entity sitePetCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer sitePetCount;

	/**	<br/> The entity sitePetCount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sitePetCount">Find the entity sitePetCount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sitePetCount(Wrap<Integer> w);

	public Integer getSitePetCount() {
		return sitePetCount;
	}

	public void setSitePetCount(Integer sitePetCount) {
		this.sitePetCount = sitePetCount;
	}
	@JsonIgnore
	public void setSitePetCount(String o) {
		this.sitePetCount = SitePetGenPage.staticSetSitePetCount(siteRequest_, o);
	}
	public static Integer staticSetSitePetCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SitePetGenPage sitePetCountInit() {
		Wrap<Integer> sitePetCountWrap = new Wrap<Integer>().var("sitePetCount");
		if(sitePetCount == null) {
			_sitePetCount(sitePetCountWrap);
			setSitePetCount(sitePetCountWrap.o);
		}
		return (SitePetGenPage)this;
	}

	public static Integer staticSolrSitePetCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrSitePetCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSitePetCount(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrSitePetCount(siteRequest_, SitePetGenPage.staticSolrSitePetCount(siteRequest_, SitePetGenPage.staticSetSitePetCount(siteRequest_, o)));
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

	/**	<br/> The entity sitePet_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sitePet_">Find the entity sitePet_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sitePet_(Wrap<SitePet> w);

	public SitePet getSitePet_() {
		return sitePet_;
	}

	public void setSitePet_(SitePet sitePet_) {
		this.sitePet_ = sitePet_;
	}
	public static SitePet staticSetSitePet_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SitePetGenPage sitePet_Init() {
		Wrap<SitePet> sitePet_Wrap = new Wrap<SitePet>().var("sitePet_");
		if(sitePet_ == null) {
			_sitePet_(sitePet_Wrap);
			setSitePet_(sitePet_Wrap.o);
		}
		return (SitePetGenPage)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = SitePetGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SitePetGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (SitePetGenPage)this;
	}

	public static Long staticSolrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(SiteRequestEnUS siteRequest_, String o) {
		return SitePetGenPage.staticSolrStrPk(siteRequest_, SitePetGenPage.staticSolrPk(siteRequest_, SitePetGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepSitePetGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSitePetGenPage();
	}

	public Future<Void> promiseDeepSitePetGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSitePetGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModelPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSitePetGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListSitePet_Init();
				listSitePetInit();
				sitePetCountInit();
				sitePet_Init();
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
		return promiseDeepSitePetGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSitePetGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSitePetGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
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
			case "searchListSitePet_":
				return oSitePetGenPage.searchListSitePet_;
			case "listSitePet":
				return oSitePetGenPage.listSitePet;
			case "sitePetCount":
				return oSitePetGenPage.sitePetCount;
			case "sitePet_":
				return oSitePetGenPage.sitePet_;
			case "pk":
				return oSitePetGenPage.pk;
			default:
				return super.obtainBaseModelPage(var);
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
				o = relateSitePetGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateSitePetGenPage(String var, Object val) {
		SitePetGenPage oSitePetGenPage = (SitePetGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
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
		case "sitePetCount":
			return SitePetGenPage.staticSetSitePetCount(siteRequest_, o);
		case "pk":
			return SitePetGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
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
		case "sitePetCount":
			return SitePetGenPage.staticSolrSitePetCount(siteRequest_, (Integer)o);
		case "pk":
			return SitePetGenPage.staticSolrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSolrBaseModelPage(entityVar,  siteRequest_, o);
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
		case "sitePetCount":
			return SitePetGenPage.staticSolrStrSitePetCount(siteRequest_, (Integer)o);
		case "pk":
			return SitePetGenPage.staticSolrStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSolrStrBaseModelPage(entityVar,  siteRequest_, o);
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
		case "sitePetCount":
			return SitePetGenPage.staticSolrFqSitePetCount(siteRequest_, o);
		case "pk":
			return SitePetGenPage.staticSolrFqPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSolrFqBaseModelPage(entityVar,  siteRequest_, o);
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
				return super.defineBaseModelPage(var, val);
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
			super.apiRequestBaseModelPage();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SitePetGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_searchListSitePet_ = "searchListSitePet_";
	public static final String VAR_listSitePet = "listSitePet";
	public static final String VAR_sitePetCount = "sitePetCount";
	public static final String VAR_sitePet_ = "sitePet_";
	public static final String VAR_pk = "pk";
}
