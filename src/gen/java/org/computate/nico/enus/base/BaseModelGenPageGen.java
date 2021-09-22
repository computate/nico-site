package org.computate.nico.enus.base;

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
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class BaseModelGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(BaseModelGenPage.class);

	////////////////////
	// listBaseModel_ //
	////////////////////

	/**	 The entity listBaseModel_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected SearchList<BaseModel> listBaseModel_;
	@JsonIgnore
	public Wrap<SearchList<BaseModel>> listBaseModel_Wrap = new Wrap<SearchList<BaseModel>>().var("listBaseModel_").o(listBaseModel_);

	/**	<br/> The entity listBaseModel_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listBaseModel_">Find the entity listBaseModel_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listBaseModel_(Wrap<SearchList<BaseModel>> c);

	public SearchList<BaseModel> getListBaseModel_() {
		return listBaseModel_;
	}

	public void setListBaseModel_(SearchList<BaseModel> listBaseModel_) {
		this.listBaseModel_ = listBaseModel_;
		this.listBaseModel_Wrap.alreadyInitialized = true;
	}
	public static SearchList<BaseModel> staticSetListBaseModel_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected BaseModelGenPage listBaseModel_Init() {
		if(!listBaseModel_Wrap.alreadyInitialized) {
			_listBaseModel_(listBaseModel_Wrap);
			if(listBaseModel_ == null)
				setListBaseModel_(listBaseModel_Wrap.o);
			listBaseModel_Wrap.o(null);
		}
		listBaseModel_Wrap.alreadyInitialized(true);
		return (BaseModelGenPage)this;
	}

	////////////////////
	// baseModelCount //
	////////////////////

	/**	 The entity baseModelCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer baseModelCount;
	@JsonIgnore
	public Wrap<Integer> baseModelCountWrap = new Wrap<Integer>().var("baseModelCount").o(baseModelCount);

	/**	<br/> The entity baseModelCount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:baseModelCount">Find the entity baseModelCount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _baseModelCount(Wrap<Integer> w);

	public Integer getBaseModelCount() {
		return baseModelCount;
	}

	public void setBaseModelCount(Integer baseModelCount) {
		this.baseModelCount = baseModelCount;
		this.baseModelCountWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setBaseModelCount(String o) {
		this.baseModelCount = BaseModelGenPage.staticSetBaseModelCount(siteRequest_, o);
		this.baseModelCountWrap.alreadyInitialized = true;
	}
	public static Integer staticSetBaseModelCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected BaseModelGenPage baseModelCountInit() {
		if(!baseModelCountWrap.alreadyInitialized) {
			_baseModelCount(baseModelCountWrap);
			if(baseModelCount == null)
				setBaseModelCount(baseModelCountWrap.o);
			baseModelCountWrap.o(null);
		}
		baseModelCountWrap.alreadyInitialized(true);
		return (BaseModelGenPage)this;
	}

	public static Integer staticSolrBaseModelCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrBaseModelCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqBaseModelCount(SiteRequestEnUS siteRequest_, String o) {
		return BaseModelGenPage.staticSolrStrBaseModelCount(siteRequest_, BaseModelGenPage.staticSolrBaseModelCount(siteRequest_, BaseModelGenPage.staticSetBaseModelCount(siteRequest_, o)));
	}

	public Integer solrBaseModelCount() {
		return BaseModelGenPage.staticSolrBaseModelCount(siteRequest_, baseModelCount);
	}

	public String strBaseModelCount() {
		return baseModelCount == null ? "" : baseModelCount.toString();
	}

	public Integer sqlBaseModelCount() {
		return baseModelCount;
	}

	public String jsonBaseModelCount() {
		return baseModelCount == null ? "" : baseModelCount.toString();
	}

	////////////////
	// baseModel_ //
	////////////////

	/**	 The entity baseModel_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected BaseModel baseModel_;
	@JsonIgnore
	public Wrap<BaseModel> baseModel_Wrap = new Wrap<BaseModel>().var("baseModel_").o(baseModel_);

	/**	<br/> The entity baseModel_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:baseModel_">Find the entity baseModel_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _baseModel_(Wrap<BaseModel> c);

	public BaseModel getBaseModel_() {
		return baseModel_;
	}

	public void setBaseModel_(BaseModel baseModel_) {
		this.baseModel_ = baseModel_;
		this.baseModel_Wrap.alreadyInitialized = true;
	}
	public static BaseModel staticSetBaseModel_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected BaseModelGenPage baseModel_Init() {
		if(!baseModel_Wrap.alreadyInitialized) {
			_baseModel_(baseModel_Wrap);
			if(baseModel_ == null)
				setBaseModel_(baseModel_Wrap.o);
			baseModel_Wrap.o(null);
		}
		baseModel_Wrap.alreadyInitialized(true);
		return (BaseModelGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedBaseModelGenPage = false;

	public Future<Void> promiseDeepBaseModelGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedBaseModelGenPage) {
			alreadyInitializedBaseModelGenPage = true;
			return promiseDeepBaseModelGenPage();
		} else {
			return Future.succeededFuture();
		}
	}

	public Future<Void> promiseDeepBaseModelGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseBaseModelGenPage(promise2);
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

	public Future<Void> promiseBaseModelGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				listBaseModel_Init();
				baseModelCountInit();
				baseModel_Init();
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
		return promiseDeepBaseModelGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestBaseModelGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestBaseModelGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainBaseModelGenPage(v);
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
	public Object obtainBaseModelGenPage(String var) {
		BaseModelGenPage oBaseModelGenPage = (BaseModelGenPage)this;
		switch(var) {
			case "listBaseModel_":
				return oBaseModelGenPage.listBaseModel_;
			case "baseModelCount":
				return oBaseModelGenPage.baseModelCount;
			case "baseModel_":
				return oBaseModelGenPage.baseModel_;
			default:
				return super.obtainPageLayout(var);
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
				o = attributeBaseModelGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeBaseModelGenPage(String var, Object val) {
		BaseModelGenPage oBaseModelGenPage = (BaseModelGenPage)this;
		switch(var) {
			default:
				return super.attributePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSetBaseModelCount(siteRequest_, o);
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSolrBaseModelCount(siteRequest_, (Integer)o);
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSolrStrBaseModelCount(siteRequest_, (Integer)o);
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSolrFqBaseModelCount(siteRequest_, o);
			default:
				return PageLayout.staticSolrFqPageLayout(entityVar,  siteRequest_, o);
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
					o = defineBaseModelGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineBaseModelGenPage(String var, String val) {
		switch(var.toLowerCase()) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineBaseModelGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineBaseModelGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestBaseModelGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof BaseModelGenPage) {
			BaseModelGenPage original = (BaseModelGenPage)o;
			super.apiRequestPageLayout();
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
		if(!(o instanceof BaseModelGenPage))
			return false;
		BaseModelGenPage that = (BaseModelGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("BaseModelGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_listBaseModel_ = "listBaseModel_";
	public static final String VAR_baseModelCount = "baseModelCount";
	public static final String VAR_baseModel_ = "baseModel_";
}
