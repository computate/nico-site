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
	@JsonIgnore
	public Wrap<Integer> sitePetCountWrap = new Wrap<Integer>().var("sitePetCount").o(sitePetCount);

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
		this.sitePetCountWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setSitePetCount(String o) {
		this.sitePetCount = SitePetGenPage.staticSetSitePetCount(siteRequest_, o);
		this.sitePetCountWrap.alreadyInitialized = true;
	}
	public static Integer staticSetSitePetCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SitePetGenPage sitePetCountInit() {
		if(!sitePetCountWrap.alreadyInitialized) {
			_sitePetCount(sitePetCountWrap);
			if(sitePetCount == null)
				setSitePetCount(sitePetCountWrap.o);
			sitePetCountWrap.o(null);
		}
		sitePetCountWrap.alreadyInitialized(true);
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

	public Integer solrSitePetCount() {
		return SitePetGenPage.staticSolrSitePetCount(siteRequest_, sitePetCount);
	}

	public String strSitePetCount() {
		return sitePetCount == null ? "" : sitePetCount.toString();
	}

	public Integer sqlSitePetCount() {
		return sitePetCount;
	}

	public String jsonSitePetCount() {
		return sitePetCount == null ? "" : sitePetCount.toString();
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
				listSitePet_Init();
				sitePetCountInit();
				sitePet_Init();
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
			case "listSitePet_":
				return oSitePetGenPage.listSitePet_;
			case "sitePetCount":
				return oSitePetGenPage.sitePetCount;
			case "sitePet_":
				return oSitePetGenPage.sitePet_;
			default:
				return super.obtainBaseModelPage(var);
		}
	}

	///////////////
	// attribute //
	///////////////

	@Override public boolean attributeForClass(String var, Object val) {
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
				return super.attributeBaseModelPage(var, val);
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
			default:
				return BaseModelPage.staticSolrFqBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, String val) {
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
				return super.defineBaseModelPage(var, val);
		}
	}

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
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
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
		return super.equals(o);
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

	public static final String VAR_listSitePet_ = "listSitePet_";
	public static final String VAR_sitePetCount = "sitePetCount";
	public static final String VAR_sitePet_ = "sitePet_";
}
