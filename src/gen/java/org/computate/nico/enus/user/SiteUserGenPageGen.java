package org.computate.nico.enus.user;

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
import org.computate.nico.enus.user.SiteUser;
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
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteUserGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteUserGenPage.class);

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

	///////////////////
	// siteUserCount //
	///////////////////

	/**	 The entity siteUserCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer siteUserCount;
	@JsonIgnore
	public Wrap<Integer> siteUserCountWrap = new Wrap<Integer>().var("siteUserCount").o(siteUserCount);

	/**	<br/> The entity siteUserCount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteUserCount">Find the entity siteUserCount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteUserCount(Wrap<Integer> w);

	public Integer getSiteUserCount() {
		return siteUserCount;
	}

	public void setSiteUserCount(Integer siteUserCount) {
		this.siteUserCount = siteUserCount;
		this.siteUserCountWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setSiteUserCount(String o) {
		this.siteUserCount = SiteUserGenPage.staticSetSiteUserCount(siteRequest_, o);
		this.siteUserCountWrap.alreadyInitialized = true;
	}
	public static Integer staticSetSiteUserCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SiteUserGenPage siteUserCountInit() {
		if(!siteUserCountWrap.alreadyInitialized) {
			_siteUserCount(siteUserCountWrap);
			if(siteUserCount == null)
				setSiteUserCount(siteUserCountWrap.o);
			siteUserCountWrap.o(null);
		}
		siteUserCountWrap.alreadyInitialized(true);
		return (SiteUserGenPage)this;
	}

	public static Integer staticSolrSiteUserCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrSiteUserCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSiteUserCount(SiteRequestEnUS siteRequest_, String o) {
		return SiteUserGenPage.staticSolrStrSiteUserCount(siteRequest_, SiteUserGenPage.staticSolrSiteUserCount(siteRequest_, SiteUserGenPage.staticSetSiteUserCount(siteRequest_, o)));
	}

	public Integer solrSiteUserCount() {
		return SiteUserGenPage.staticSolrSiteUserCount(siteRequest_, siteUserCount);
	}

	public String strSiteUserCount() {
		return siteUserCount == null ? "" : siteUserCount.toString();
	}

	public Integer sqlSiteUserCount() {
		return siteUserCount;
	}

	public String jsonSiteUserCount() {
		return siteUserCount == null ? "" : siteUserCount.toString();
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

	public Future<Void> promiseSiteUserGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				listSiteUser_Init();
				siteUserCountInit();
				siteUser_Init();
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
		return promiseDeepSiteUserGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteUserGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteUserGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
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
			case "listSiteUser_":
				return oSiteUserGenPage.listSiteUser_;
			case "siteUserCount":
				return oSiteUserGenPage.siteUserCount;
			case "siteUser_":
				return oSiteUserGenPage.siteUser_;
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
				return super.attributePageLayout(var, val);
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
		case "siteUserCount":
			return SiteUserGenPage.staticSetSiteUserCount(siteRequest_, o);
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
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
		case "siteUserCount":
			return SiteUserGenPage.staticSolrSiteUserCount(siteRequest_, (Integer)o);
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
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
		case "siteUserCount":
			return SiteUserGenPage.staticSolrStrSiteUserCount(siteRequest_, (Integer)o);
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
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
		case "siteUserCount":
			return SiteUserGenPage.staticSolrFqSiteUserCount(siteRequest_, o);
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
				return super.definePageLayout(var, val);
		}
	}

	@Override public boolean defineForClass(String var, Object val) {
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
				return super.definePageLayout(var, val);
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
		if(!(o instanceof SiteUserGenPage))
			return false;
		SiteUserGenPage that = (SiteUserGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteUserGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_listSiteUser_ = "listSiteUser_";
	public static final String VAR_siteUserCount = "siteUserCount";
	public static final String VAR_siteUser_ = "siteUser_";
}
