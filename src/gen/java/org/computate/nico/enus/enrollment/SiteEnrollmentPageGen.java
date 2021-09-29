package org.computate.nico.enus.enrollment;

import org.computate.nico.enus.java.ZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.computate.nico.enus.enrollment.SiteEnrollmentGenPage;
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
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.request.api.ApiRequest;
import io.vertx.core.Future;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.nico.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollmentPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteEnrollmentPageGen<DEV> extends SiteEnrollmentGenPage {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteEnrollmentPage.class);

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepSiteEnrollmentPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSiteEnrollmentPage();
	}

	public Future<Void> promiseDeepSiteEnrollmentPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSiteEnrollmentPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepSiteEnrollmentGenPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSiteEnrollmentPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
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
		return promiseDeepSiteEnrollmentPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteEnrollmentPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestSiteEnrollmentGenPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteEnrollmentPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteEnrollmentPage(v);
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
	public Object obtainSiteEnrollmentPage(String var) {
		SiteEnrollmentPage oSiteEnrollmentPage = (SiteEnrollmentPage)this;
		switch(var) {
			default:
				return super.obtainSiteEnrollmentGenPage(var);
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
				o = attributeSiteEnrollmentPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteEnrollmentPage(String var, Object val) {
		SiteEnrollmentPage oSiteEnrollmentPage = (SiteEnrollmentPage)this;
		switch(var) {
			default:
				return super.attributeSiteEnrollmentGenPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSiteEnrollmentPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSiteEnrollmentPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return SiteEnrollmentGenPage.staticSetSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSiteEnrollmentPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSiteEnrollmentPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return SiteEnrollmentGenPage.staticSolrSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSiteEnrollmentPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSiteEnrollmentPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return SiteEnrollmentGenPage.staticSolrStrSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSiteEnrollmentPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSiteEnrollmentPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return SiteEnrollmentGenPage.staticSolrFqSiteEnrollmentGenPage(entityVar,  siteRequest_, o);
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
					o = defineSiteEnrollmentPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollmentPage(String var, String val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineSiteEnrollmentGenPage(var, val);
		}
	}

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineSiteEnrollmentPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollmentPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineSiteEnrollmentGenPage(var, val);
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteEnrollmentPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteEnrollmentPage) {
			SiteEnrollmentPage original = (SiteEnrollmentPage)o;
			super.apiRequestSiteEnrollmentGenPage();
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
		if(!(o instanceof SiteEnrollmentPage))
			return false;
		SiteEnrollmentPage that = (SiteEnrollmentPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteEnrollmentPage { ");
		sb.append(" }");
		return sb.toString();
	}

}
