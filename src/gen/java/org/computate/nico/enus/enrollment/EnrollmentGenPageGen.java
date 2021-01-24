package org.computate.nico.enus.enrollment;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.logging.Logger;
import org.computate.nico.enus.wrap.Wrap;
import java.math.RoundingMode;
import org.computate.nico.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.request.api.ApiRequest;
import org.computate.nico.enus.search.SearchList;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.computate.nico.enus.page.PageLayout;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.nico.enus.enrollment.SiteEnrollment;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.EnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class EnrollmentGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentGenPage.class);

	////////////////////////
	// listSiteEnrollment //
	////////////////////////

	/**	 The entity listSiteEnrollment
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteEnrollment> listSiteEnrollment;
	@JsonIgnore
	public Wrap<SearchList<SiteEnrollment>> listSiteEnrollmentWrap = new Wrap<SearchList<SiteEnrollment>>().p(this).c(SearchList.class).var("listSiteEnrollment").o(listSiteEnrollment);

	/**	<br/> The entity listSiteEnrollment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.EnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSiteEnrollment">Find the entity listSiteEnrollment in Solr</a>
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
	protected EnrollmentGenPage listSiteEnrollmentInit() {
		if(!listSiteEnrollmentWrap.alreadyInitialized) {
			_listSiteEnrollment(listSiteEnrollmentWrap);
			if(listSiteEnrollment == null)
				setListSiteEnrollment(listSiteEnrollmentWrap.o);
		}
		if(listSiteEnrollment != null)
			listSiteEnrollment.initDeepForClass(siteRequest_);
		listSiteEnrollmentWrap.alreadyInitialized(true);
		return (EnrollmentGenPage)this;
	}

	/////////////////////
	// siteEnrollment_ //
	/////////////////////

	/**	 The entity siteEnrollment_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteEnrollment siteEnrollment_;
	@JsonIgnore
	public Wrap<SiteEnrollment> siteEnrollment_Wrap = new Wrap<SiteEnrollment>().p(this).c(SiteEnrollment.class).var("siteEnrollment_").o(siteEnrollment_);

	/**	<br/> The entity siteEnrollment_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.EnrollmentGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteEnrollment_">Find the entity siteEnrollment_ in Solr</a>
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
	protected EnrollmentGenPage siteEnrollment_Init() {
		if(!siteEnrollment_Wrap.alreadyInitialized) {
			_siteEnrollment_(siteEnrollment_Wrap);
			if(siteEnrollment_ == null)
				setSiteEnrollment_(siteEnrollment_Wrap.o);
		}
		siteEnrollment_Wrap.alreadyInitialized(true);
		return (EnrollmentGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedEnrollmentGenPage = false;

	public EnrollmentGenPage initDeepEnrollmentGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedEnrollmentGenPage) {
			alreadyInitializedEnrollmentGenPage = true;
			initDeepEnrollmentGenPage();
		}
		return (EnrollmentGenPage)this;
	}

	public void initDeepEnrollmentGenPage() {
		initEnrollmentGenPage();
		super.initDeepPageLayout(siteRequest_);
	}

	public void initEnrollmentGenPage() {
		listSiteEnrollmentInit();
		siteEnrollment_Init();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepEnrollmentGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestEnrollmentGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
		if(listSiteEnrollment != null)
			listSiteEnrollment.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestEnrollmentGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainEnrollmentGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainEnrollmentGenPage(String var) {
		EnrollmentGenPage oEnrollmentGenPage = (EnrollmentGenPage)this;
		switch(var) {
			case "listSiteEnrollment":
				return oEnrollmentGenPage.listSiteEnrollment;
			case "siteEnrollment_":
				return oEnrollmentGenPage.siteEnrollment_;
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
				o = attributeEnrollmentGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeEnrollmentGenPage(String var, Object val) {
		EnrollmentGenPage oEnrollmentGenPage = (EnrollmentGenPage)this;
		switch(var) {
			default:
				return super.attributePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqEnrollmentGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqEnrollmentGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
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
					o = defineEnrollmentGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster oCluster = (Cluster)o;
					o = oCluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineEnrollmentGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsEnrollmentGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsEnrollmentGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptEnrollmentGenPage();
		super.htmlScript();
	}

	public void htmlScriptEnrollmentGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyEnrollmentGenPage();
		super.htmlBody();
	}

	public void htmlBodyEnrollmentGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlEnrollmentGenPage();
		super.html();
	}

	public void htmlEnrollmentGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaEnrollmentGenPage();
		super.htmlMeta();
	}

	public void htmlMetaEnrollmentGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesEnrollmentGenPage();
		super.htmlStyles();
	}

	public void htmlStylesEnrollmentGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleEnrollmentGenPage();
		super.htmlStyle();
	}

	public void htmlStyleEnrollmentGenPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestEnrollmentGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof EnrollmentGenPage) {
			EnrollmentGenPage original = (EnrollmentGenPage)o;
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
		if(!(o instanceof EnrollmentGenPage))
			return false;
		EnrollmentGenPage that = (EnrollmentGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("EnrollmentGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
