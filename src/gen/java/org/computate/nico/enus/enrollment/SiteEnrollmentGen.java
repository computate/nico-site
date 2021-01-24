package org.computate.nico.enus.enrollment;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import java.util.HashMap;
import org.computate.nico.enus.context.SiteContextEnUS;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.nico.enus.wrap.Wrap;
import java.math.RoundingMode;
import org.computate.nico.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.request.api.ApiRequest;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteEnrollmentGen<DEV> extends Cluster {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteEnrollment.class);

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	public static final String SiteEnrollment_AName = "an enrollment";
	public static final String SiteEnrollment_This = "this ";
	public static final String SiteEnrollment_ThisName = "this enrollment";
	public static final String SiteEnrollment_A = "a ";
	public static final String SiteEnrollment_TheName = "theenrollment";
	public static final String SiteEnrollment_NameSingular = "enrollment";
	public static final String SiteEnrollment_NamePlural = "enrollments";
	public static final String SiteEnrollment_NameActual = "current enrollment";
	public static final String SiteEnrollment_AllName = "all the enrollments";
	public static final String SiteEnrollment_SearchAllNameBy = "search enrollments by ";
	public static final String SiteEnrollment_Title = "enrollments";
	public static final String SiteEnrollment_ThePluralName = "the enrollments";
	public static final String SiteEnrollment_NoNameFound = "no enrollment found";
	public static final String SiteEnrollment_NameVar = "reportCard";
	public static final String SiteEnrollment_OfName = "of enrollment";
	public static final String SiteEnrollment_ANameAdjective = "an enrollment";
	public static final String SiteEnrollment_NameAdjectiveSingular = "enrollment";
	public static final String SiteEnrollment_NameAdjectivePlural = "enrollments";
	public static final String SiteEnrollment_Color = "pale-green";
	public static final String SiteEnrollment_IconGroup = "regular";
	public static final String SiteEnrollment_IconName = "edit";
	public static final Integer SiteEnrollment_Rows = 100;

	///////////////////
	// enrollmentKey //
	///////////////////

	/**	 The entity enrollmentKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long enrollmentKey;
	@JsonIgnore
	public Wrap<Long> enrollmentKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("enrollmentKey").o(enrollmentKey);

	/**	<br/> The entity enrollmentKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentKey">Find the entity enrollmentKey in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _enrollmentKey(Wrap<Long> c);

	public Long getEnrollmentKey() {
		return enrollmentKey;
	}

	public void setEnrollmentKey(Long enrollmentKey) {
		this.enrollmentKey = enrollmentKey;
		this.enrollmentKeyWrap.alreadyInitialized = true;
	}
	public void setEnrollmentKey(String o) {
		this.enrollmentKey = SiteEnrollment.staticSetEnrollmentKey(siteRequest_, o);
		this.enrollmentKeyWrap.alreadyInitialized = true;
	}
	public static Long staticSetEnrollmentKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SiteEnrollment enrollmentKeyInit() {
		if(!enrollmentKeyWrap.alreadyInitialized) {
			_enrollmentKey(enrollmentKeyWrap);
			if(enrollmentKey == null)
				setEnrollmentKey(enrollmentKeyWrap.o);
		}
		enrollmentKeyWrap.alreadyInitialized(true);
		return (SiteEnrollment)this;
	}

	public static Long staticSolrEnrollmentKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrEnrollmentKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEnrollmentKey(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollment.staticSolrStrEnrollmentKey(siteRequest_, SiteEnrollment.staticSolrEnrollmentKey(siteRequest_, SiteEnrollment.staticSetEnrollmentKey(siteRequest_, o)));
	}

	public Long solrEnrollmentKey() {
		return SiteEnrollment.staticSolrEnrollmentKey(siteRequest_, enrollmentKey);
	}

	public String strEnrollmentKey() {
		return enrollmentKey == null ? "" : enrollmentKey.toString();
	}

	public String jsonEnrollmentKey() {
		return enrollmentKey == null ? "" : enrollmentKey.toString();
	}

	public String nomAffichageEnrollmentKey() {
		return null;
	}

	public String htmTooltipEnrollmentKey() {
		return null;
	}

	public String htmEnrollmentKey() {
		return enrollmentKey == null ? "" : StringEscapeUtils.escapeHtml4(strEnrollmentKey());
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSiteEnrollment = false;

	public SiteEnrollment initDeepSiteEnrollment(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteEnrollment) {
			alreadyInitializedSiteEnrollment = true;
			initDeepSiteEnrollment();
		}
		return (SiteEnrollment)this;
	}

	public void initDeepSiteEnrollment() {
		initSiteEnrollment();
		super.initDeepCluster(siteRequest_);
	}

	public void initSiteEnrollment() {
		enrollmentKeyInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSiteEnrollment(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteEnrollment(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteEnrollment(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteEnrollment(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainSiteEnrollment(String var) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;
		switch(var) {
			case "enrollmentKey":
				return oSiteEnrollment.enrollmentKey;
			default:
				return super.obtainCluster(var);
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
				o = attributeSiteEnrollment(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteEnrollment(String var, Object val) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;
		switch(var) {
			default:
				return super.attributeCluster(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSetEnrollmentKey(siteRequest_, o);
			default:
				return Cluster.staticSetCluster(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSolrEnrollmentKey(siteRequest_, (Long)o);
			default:
				return Cluster.staticSolrCluster(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSolrStrEnrollmentKey(siteRequest_, (Long)o);
			default:
				return Cluster.staticSolrStrCluster(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSolrFqEnrollmentKey(siteRequest_, o);
			default:
				return Cluster.staticSolrFqCluster(entityVar,  siteRequest_, o);
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
					o = defineSiteEnrollment(v, val);
				else if(o instanceof Cluster) {
					Cluster oCluster = (Cluster)o;
					o = oCluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollment(String var, String val) {
		switch(var) {
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateSiteEnrollment(solrDocument);
	}
	public void populateSiteEnrollment(SolrDocument solrDocument) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;
		saves = (List<String>)solrDocument.get("saves_stored_strings");
		if(saves != null) {

			if(saves.contains("enrollmentKey")) {
				Long enrollmentKey = (Long)solrDocument.get("enrollmentKey_stored_long");
				if(enrollmentKey != null)
					oSiteEnrollment.setEnrollmentKey(enrollmentKey);
			}
		}

		super.populateCluster(solrDocument);
	}

	/////////////
	// index //
	/////////////

	public static void index() {
		try {
			SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.getSiteConfig().setConfigPath("/usr/local/src/nico-site/config/nico-site.config");
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			SolrQuery solrQuery = new SolrQuery();
			solrQuery.setQuery("*:*");
			solrQuery.setRows(1);
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.nico.enus.enrollment.SiteEnrollment"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			SiteEnrollment o = new SiteEnrollment();
			o.siteRequestSiteEnrollment(siteRequest);
			o.initDeepSiteEnrollment(siteRequest);
			o.indexSiteEnrollment();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexSiteEnrollment();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexSiteEnrollment(document);
	}

	public void indexSiteEnrollment(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteEnrollment(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSiteEnrollment() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteEnrollment(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSiteEnrollment(SolrInputDocument document) {
		if(enrollmentKey != null) {
			document.addField("enrollmentKey_indexed_long", enrollmentKey);
			document.addField("enrollmentKey_stored_long", enrollmentKey);
		}
		super.indexCluster(document);

	}

	public void unindexSiteEnrollment() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepSiteEnrollment(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedSiteEnrollment(String entityVar) {
		switch(entityVar) {
			case "enrollmentKey":
				return "enrollmentKey_indexed_long";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchSiteEnrollment(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestedSiteEnrollment(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSuggestedCluster(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeSiteEnrollment(solrDocument);
	}
	public void storeSiteEnrollment(SolrDocument solrDocument) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;

		Long enrollmentKey = (Long)solrDocument.get("enrollmentKey_stored_long");
		if(enrollmentKey != null)
			oSiteEnrollment.setEnrollmentKey(enrollmentKey);

		super.storeCluster(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteEnrollment() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteEnrollment) {
			SiteEnrollment original = (SiteEnrollment)o;
			if(!Objects.equals(enrollmentKey, original.getEnrollmentKey()))
				apiRequest.addVars("enrollmentKey");
			super.apiRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), enrollmentKey);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SiteEnrollment))
			return false;
		SiteEnrollment that = (SiteEnrollment)o;
		return super.equals(o)
				&& Objects.equals( enrollmentKey, that.enrollmentKey );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteEnrollment { ");
		sb.append( "enrollmentKey: " ).append(enrollmentKey);
		sb.append(" }");
		return sb.toString();
	}
}
