package org.computate.nico.enus.pet;

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
import org.computate.nico.enus.pet.SitePet;
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
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.PetGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class PetGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOGGER = LoggerFactory.getLogger(PetGenPage.class);

	/////////////////
	// listSitePet //
	/////////////////

	/**	 The entity listSitePet
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SitePet> listSitePet;
	@JsonIgnore
	public Wrap<SearchList<SitePet>> listSitePetWrap = new Wrap<SearchList<SitePet>>().p(this).c(SearchList.class).var("listSitePet").o(listSitePet);

	/**	<br/> The entity listSitePet
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.PetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSitePet">Find the entity listSitePet in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listSitePet(Wrap<SearchList<SitePet>> c);

	public SearchList<SitePet> getListSitePet() {
		return listSitePet;
	}

	public void setListSitePet(SearchList<SitePet> listSitePet) {
		this.listSitePet = listSitePet;
		this.listSitePetWrap.alreadyInitialized = true;
	}
	public static SearchList<SitePet> staticSetListSitePet(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected PetGenPage listSitePetInit() {
		if(!listSitePetWrap.alreadyInitialized) {
			_listSitePet(listSitePetWrap);
			if(listSitePet == null)
				setListSitePet(listSitePetWrap.o);
		}
		if(listSitePet != null)
			listSitePet.initDeepForClass(siteRequest_);
		listSitePetWrap.alreadyInitialized(true);
		return (PetGenPage)this;
	}

	//////////////
	// sitePet_ //
	//////////////

	/**	 The entity sitePet_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SitePet sitePet_;
	@JsonIgnore
	public Wrap<SitePet> sitePet_Wrap = new Wrap<SitePet>().p(this).c(SitePet.class).var("sitePet_").o(sitePet_);

	/**	<br/> The entity sitePet_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.PetGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sitePet_">Find the entity sitePet_ in Solr</a>
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
	protected PetGenPage sitePet_Init() {
		if(!sitePet_Wrap.alreadyInitialized) {
			_sitePet_(sitePet_Wrap);
			if(sitePet_ == null)
				setSitePet_(sitePet_Wrap.o);
		}
		sitePet_Wrap.alreadyInitialized(true);
		return (PetGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedPetGenPage = false;

	public PetGenPage initDeepPetGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedPetGenPage) {
			alreadyInitializedPetGenPage = true;
			initDeepPetGenPage();
		}
		return (PetGenPage)this;
	}

	public void initDeepPetGenPage() {
		initPetGenPage();
		super.initDeepPageLayout(siteRequest_);
	}

	public void initPetGenPage() {
		listSitePetInit();
		sitePet_Init();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepPetGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestPetGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
		if(listSitePet != null)
			listSitePet.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestPetGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainPetGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainPetGenPage(String var) {
		PetGenPage oPetGenPage = (PetGenPage)this;
		switch(var) {
			case "listSitePet":
				return oPetGenPage.listSitePet;
			case "sitePet_":
				return oPetGenPage.sitePet_;
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
				o = attributePetGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributePetGenPage(String var, Object val) {
		PetGenPage oPetGenPage = (PetGenPage)this;
		switch(var) {
			default:
				return super.attributePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetPetGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetPetGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrPetGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrPetGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrPetGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrPetGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqPetGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqPetGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
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
					o = definePetGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster oCluster = (Cluster)o;
					o = oCluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definePetGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsPetGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsPetGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptPetGenPage();
		super.htmlScript();
	}

	public void htmlScriptPetGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyPetGenPage();
		super.htmlBody();
	}

	public void htmlBodyPetGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlPetGenPage();
		super.html();
	}

	public void htmlPetGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaPetGenPage();
		super.htmlMeta();
	}

	public void htmlMetaPetGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesPetGenPage();
		super.htmlStyles();
	}

	public void htmlStylesPetGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStylePetGenPage();
		super.htmlStyle();
	}

	public void htmlStylePetGenPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestPetGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof PetGenPage) {
			PetGenPage original = (PetGenPage)o;
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
		if(!(o instanceof PetGenPage))
			return false;
		PetGenPage that = (PetGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("PetGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
