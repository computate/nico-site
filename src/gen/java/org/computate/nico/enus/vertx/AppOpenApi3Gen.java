package org.computate.nico.enus.vertx;

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
import org.computate.nico.enus.vertx.AppSwagger2;
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
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.vertx.AppOpenApi3&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class AppOpenApi3Gen<DEV> extends AppSwagger2 {
	protected static final Logger LOG = LoggerFactory.getLogger(AppOpenApi3.class);

	//////////////
	// initDeep //
	//////////////

	public AppOpenApi3 initDeepAppOpenApi3(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepAppOpenApi3();
		return (AppOpenApi3)this;
	}

	public void initDeepAppOpenApi3() {
		initAppOpenApi3();
		super.initDeepAppSwagger2(siteRequest_);
	}

	public void initAppOpenApi3() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepAppOpenApi3(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestAppOpenApi3(SiteRequestEnUS siteRequest_) {
			super.siteRequestAppSwagger2(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestAppOpenApi3(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainAppOpenApi3(v);
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
	public Object obtainAppOpenApi3(String var) {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
		switch(var) {
			default:
				return super.obtainAppSwagger2(var);
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
				o = relateAppOpenApi3(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateAppOpenApi3(String var, Object val) {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
		switch(var) {
			default:
				return super.relateAppSwagger2(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static Object staticSetAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return AppSwagger2.staticSetAppSwagger2(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return AppSwagger2.staticSolrAppSwagger2(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return AppSwagger2.staticSolrStrAppSwagger2(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return AppSwagger2.staticSolrFqAppSwagger2(entityVar,  siteRequest_, o);
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
					o = defineAppOpenApi3(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineAppOpenApi3(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineAppSwagger2(var, val);
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestAppOpenApi3() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof AppOpenApi3) {
			AppOpenApi3 original = (AppOpenApi3)o;
			super.apiRequestAppSwagger2();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AppOpenApi3 { ");
		sb.append(" }");
		return sb.toString();
	}

}
