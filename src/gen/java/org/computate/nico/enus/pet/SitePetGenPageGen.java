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
import org.computate.nico.enus.page.PageLayout;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePetGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SitePetGenPageGen<DEV> extends PageLayout {
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

	public Future<Void> promiseSitePetGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				listSitePet_Init();
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
			super.siteRequestPageLayout(siteRequest_);
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
			case "sitePet_":
				return oSitePetGenPage.sitePet_;
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
				return super.attributePageLayout(var, val);
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
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
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
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
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
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
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
				return super.definePageLayout(var, val);
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
				return super.definePageLayout(var, val);
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
	public static final String VAR_sitePet_ = "sitePet_";
}
